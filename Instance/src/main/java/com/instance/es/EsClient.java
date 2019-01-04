package com.instance.es;


import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetRequestBuilder;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;


/**
 * ESclient 工具类
 */
public class EsClient
{
	// 远程传输客户端
	public static TransportClient client;
	// 集群名称
	static final String clusterName = "my-application";
	// 集群连接节点的IP地址
	static final String host = "127.0.0.1";
	// 节点的端口为9300，不是集群端口
	static final Integer port = 9300;

	/**
	 * 构造函数，创建客户端
	 */
	public EsClient()
	{
		try
		{
			/**
			 * 1. 通过Setting对象来指定集群配置信息
			 * */
			Settings settings = Settings.builder()
					.put("cluster.name", clusterName)//指定集群名称
					.put("client.transport.sniff", true)//启动嗅探功能，允许它动态地添加新主机并删除旧主机。
					.build();
			/**
			 * 2.创建客户端
			 * 通过setting来创建，若不指定则默认链接的集群名为elasticsearch
			 * 链接使用TCP协议即9300
			 * */
			/* 6.4.2版本
			client = new PreBuiltTransportClient(settings)
					.addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));
			*/
			// 5.6.9版本
			client = new PreBuiltTransportClient(settings)
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
			/**
			 * 3：查看集群信息
			 * */
			List<DiscoveryNode> connectedNodes = client.connectedNodes();
			for (DiscoveryNode node : connectedNodes)
			{
				System.out.println(node.getHostAddress());
			}
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
			System.out.println("unknownHost=" + host);
		}
	}

	/**
	 * 析构函数，关闭客户端
	 */
	protected void finalize()
	{
		client.close();
	}

	/**
	 * 使用Elasticsearch提供内置对象来生成JSON内容。不推荐
	 *
	 * @return
	 */
	public XContentBuilder buildJson(String userId)
	{
		XContentBuilder builder = null;
		try
		{
			builder = jsonBuilder()
					.startObject()
					.field("userId", userId)
					.field("happentime", new Date())
					.field("type", "msg")
					.field("data", "trying out Elasticsearch")
					.endObject();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		// 5.6.9版本不可使用
//		String json = Strings.toString(builder);
//		System.out.println(json);
		return builder;
	}

	/**
	 * 将一个JSON document 添加到 index 的 type 中，并赋予id，id类似于主键，使用内置对象生成的JSON
	 *
	 * @param json
	 * @param index
	 * @param type
	 * @param id
	 * @return
	 */
	public IndexResponse indexDocWithId(XContentBuilder json, String index, String type, String id)
	{
		IndexResponse response = client.prepareIndex(index, type, id).setSource(json).get();
		return response;
	}

	/**
	 * 将一个JSON document 添加到 index 的 type 中，并赋予id，使用JSON字符串
	 *
	 * @param json
	 * @param index
	 * @param type
	 * @param id
	 * @return
	 */
	public IndexResponse indexDocWithIdUsingStr(String json, String index, String type, String id)
	{
		IndexResponse response = client.prepareIndex(index, type, id)
				.setSource(json, XContentType.JSON)// 使用非内置对象JSON（JSON的String字符串）时，要加第二个参数
				.get();
		return response;
	}

	/**
	 * 将一个JSON document 添加到 index 的 type 中，并自动生成id，使用内置对象生成的JSON
	 *
	 * @param json
	 * @param index
	 * @param type
	 * @return
	 */
	public IndexResponse indexDoc(XContentBuilder json, String index, String type)
	{
		IndexResponse response = client.prepareIndex(index, type).setSource(json).get();
		return response;
	}

	/**
	 * 将一个JSON document 添加到 index 的 type 中，使用JSON字符串
	 *
	 * @param json
	 * @param index
	 * @param type
	 * @return
	 */
	public IndexResponse indexDocUsingStr(String json, String index, String type)
	{
		IndexResponse response = client.prepareIndex(index, type)
				.setSource(json, XContentType.JSON)
				.get();
		return response;
	}

	/**
	 * 批量添加 使用内置对象生成的JSON
	 *
	 * @param jsons
	 * @param index
	 * @param type
	 * @param ids
	 */
	public void batchIndexDoc(XContentBuilder[] jsons, String index, String type, String[] ids)
	{
		BulkRequestBuilder bulkRequest = client.prepareBulk();

		int len = ids.length;
		for (int i = 0; i < len; i++)
		{
			bulkRequest.add(client.prepareIndex(index, type, ids[i]).setSource(jsons[i]));
		}

		BulkResponse bulkResponse = bulkRequest.get();
		if (bulkResponse.hasFailures())
		{
			// process failures by iterating through each bulk response item
		}
	}

	/**
	 * 批量添加 使用JSON字符串
	 *
	 * @param jsons
	 * @param index
	 * @param type
	 */
	public void batchIndexDoc(String[] jsons, String index, String type)
	{
		BulkRequestBuilder bulkRequest = client.prepareBulk();

		int len = jsons.length;
		for (int i = 0; i < len; i++)
		{
			bulkRequest.add(client.prepareIndex(index, type).setSource(jsons[i], XContentType.JSON));
		}

		BulkResponse bulkResponse = bulkRequest.get();
		if (bulkResponse.hasFailures())
		{
			// process failures by iterating through each bulk response item
		}
	}

	/**
	 * 根据id获取相应document
	 *
	 * @param index
	 * @param type
	 * @param id
	 * @return
	 */
	public GetResponse getDocById(String index, String type, String id)
	{
		GetResponse response = client.prepareGet(index, type, id).get();
		String json = response.getSourceAsString();
		System.out.println(json);
		return response;
	}

	/**
	 * 根据id批量获取
	 *
	 * @param index
	 * @param type
	 * @param ids
	 */
	public void multiGetDoc(String index, String type, String[] ids)
	{
		MultiGetRequestBuilder multiGetRequestBuilder = client.prepareMultiGet();
		for (String id : ids)
		{
			multiGetRequestBuilder.add(index, type, id);
		}
		MultiGetResponse multiGetItemResponses = multiGetRequestBuilder.get();

		for (MultiGetItemResponse itemResponse : multiGetItemResponses)
		{
			GetResponse response = itemResponse.getResponse();
			if (response.isExists())
			{
				String json = response.getSourceAsString();
				System.out.println(json);
			}
		}
	}

	/**
	 * 搜索
	 *
	 * @param index
	 * @param name
	 * @param value
	 * @return
	 */
	public SearchResponse QueryDoc(String index, String name, String value)
	{
		SearchResponse response = client.prepareSearch(index)//可输入多个index
				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
				.setQuery(termQuery(name, value))           // Query
				//.setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))     // Filter
				//.setFrom(0).//起始位置
				// setSize(60).//每次次数
				// setExplain(true)
				.get();
		return response;
	}

	/**
	 * 查询排序分页显示Doc
	 *
	 * @param index
	 * @param name
	 * @param value
	 * @param sortField
	 * @param pageNo
	 * @param pageSize
	 * @param beginTime
	 * @return
	 */
	public List<JSONObject> roll(String index, String name, String value, String sortField,
	                             int pageNo, int pageSize, String beginTime)
	{
		List<JSONObject> jsons = new ArrayList<JSONObject>();
		QueryBuilder qb = termQuery(name, value);

		SearchResponse scrollResp = client.prepareSearch(index)
				.setQuery(qb)   //  设置查询
				.addSort(sortField, SortOrder.DESC) //  根据happentime字段降序序排序
				.setPostFilter(QueryBuilders.rangeQuery("happentime").lt(beginTime))    // 过滤后，只有小于(早于)开始时间的Doc
				.setFrom((pageNo - 1) * pageSize)   //分页起始位置
				.setSize(pageSize)  // 每页数量
				.get();

		// 存入JSON
		SearchHits hits = scrollResp.getHits();
		for (SearchHit hit : hits)
		{
			jsons.add(JSONObject.parseObject(hit.getSourceAsString()));
		}

		return jsons;
	}


	/**
	 * 根据id删除相应document
	 *
	 * @param index
	 * @param type
	 * @param id
	 * @return
	 */
	public DeleteResponse delDocById(String index, String type, String id)
	{
		DeleteResponse response = client.prepareDelete(index, type, id).get();
		return response;
	}

	/**
	 * 批量删除
	 *
	 * @param index
	 * @param type
	 * @param ids
	 */
	public void batchDelDoc(String index, String type, String[] ids)
	{
		BulkRequestBuilder bulkRequest = client.prepareBulk();

		for (String id : ids)
		{
			bulkRequest.add(client.prepareDelete(index, type, id));
		}

		BulkResponse bulkResponse = bulkRequest.get();
		if (bulkResponse.hasFailures())
		{
			// process failures by iterating through each bulk response item
		}
	}

	/**
	 * 根据查询删除相应document，操作时间较长
	 *
	 * @param field
	 * @param value
	 * @param index
	 * @return
	 */
	public BulkByScrollResponse delDocByQuery(String field, String value, String index)
	{
		BulkByScrollResponse response = DeleteByQueryAction.INSTANCE.newRequestBuilder(client)
				.filter(QueryBuilders.matchQuery(field, value)) // 查询
				.source(index)  // 索引
				.get();   // 执行操作
		long deleted = response.getDeleted(); // 被删除Doc的数量
		System.out.println("Number of deleted : " + deleted);
		return response;
	}

	/**
	 * 根据查询删除相应document，异步执行
	 *
	 * @param field
	 * @param value
	 * @param index
	 */
	public void delDocByQueryAsynchronously(String field, String value, String index)
	{
		DeleteByQueryAction.INSTANCE.newRequestBuilder(client)
				.filter(QueryBuilders.matchQuery(field, value)) // 查询
				.source(index) // 索引
				.execute(new ActionListener<BulkByScrollResponse>()
				{   // 执行操作
					public void onResponse(BulkByScrollResponse response)
					{
						long deleted = response.getDeleted(); // 被删除Doc的数量
						System.out.println("Number of deleted : " + deleted);
					}

					public void onFailure(Exception e)
					{
						// 异常处理
						e.printStackTrace();
					}
				});
//		return response;
	}

	/**
	 * 更新 document ，只更改传入json所有的字段
	 *
	 * @param json
	 * @param index
	 * @param type
	 * @param id
	 * @return
	 */
	public UpdateRequest updateDoc(XContentBuilder json, String index, String type, String id)
	{
		UpdateRequest updateRequest = new UpdateRequest();
		updateRequest.index(index);
		updateRequest.type(type);
		updateRequest.id(id);
		updateRequest.doc(json);
		try
		{
			client.update(updateRequest).get();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		} catch (ExecutionException e)
		{
			e.printStackTrace();
		}
		return updateRequest;
	}


	public static void main(String[] args) throws IOException
	{
		EsClient esClient = new EsClient();
		esClient.buildJson("2");
	}
}