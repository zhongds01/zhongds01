package com.zds.redis;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import redis.clients.jedis.Jedis;
/**
 * 
 * @author ZDS
 *
 */
public class RedisTest {

	@Test
	public void testJedisSingle(){
		//配置ip与端口
		Jedis jedis = new Jedis("192.168.245.128",6379);
		//设置密码
		jedis.auth("123123");
		//设置一个String类型
		jedis.set("str", "zds");
		//设置str的生命时长
		jedis.expire("str", 60);
		//取消生命时长限制
		jedis.persist("str");
		//打印输出
		System.out.println("name:"+jedis.get("str"));
		//将指定str键删除
		//jedis.del("str");
		//打印输出
		System.out.println("name:"+jedis.get("str"));
		//设置HashMap类型
		Map<String,String> map = new HashMap<String,String>();
		map.put("name","zds");
		map.put("sex", "male");
		map.put("age", "22");
		jedis.hmset("hm", map);
		//通过map输出
		System.out.println("name:"+map.get("name")+'\n'+"sex:"+map.get("sex")+'\n'+"age:"+map.get("age"));
		//通过取出redis值输出
		//判断hm是否存在
		if(jedis.exists("hm")){
			System.out.println("name:"+jedis.hget("hm", "name")+'\n'+"sex:"+jedis.hget("hm", "sex")+'\n'+"age:"+jedis.hget("hm", "age"));
		}
		else{
			System.out.println("error");
		}
		
		//设置LIST类型
		jedis.rpush("list", "this","is","a","list");
		System.out.println(jedis.lrange("list", 0, -1));
		
		//设置set集合类型
		jedis.sadd("set", "this","is","a","set");
		System.out.println(jedis.smembers("set"));
		
		//设置有序集合类型(zsort)
 		jedis.zadd("zsort",1,"this");
 		jedis.zadd("zsort",2,"is");
 		jedis.zadd("zsort",3,"a");
 		jedis.zadd("zsort",4,"zsort");
 		System.out.println(jedis.zrange("zsort", 0, -1));
 		
		//获取所有的key
		System.out.println(jedis.keys("*"));
		//将键全部删除
		//jedis.flushDB();
		jedis.close();
		
	}
	
	
}
