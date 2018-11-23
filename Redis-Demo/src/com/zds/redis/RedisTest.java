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
		//����ip��˿�
		Jedis jedis = new Jedis("192.168.245.128",6379);
		//��������
		jedis.auth("123123");
		//����һ��String����
		jedis.set("str", "zds");
		//����str������ʱ��
		jedis.expire("str", 60);
		//ȡ������ʱ������
		jedis.persist("str");
		//��ӡ���
		System.out.println("name:"+jedis.get("str"));
		//��ָ��str��ɾ��
		//jedis.del("str");
		//��ӡ���
		System.out.println("name:"+jedis.get("str"));
		//����HashMap����
		Map<String,String> map = new HashMap<String,String>();
		map.put("name","zds");
		map.put("sex", "male");
		map.put("age", "22");
		jedis.hmset("hm", map);
		//ͨ��map���
		System.out.println("name:"+map.get("name")+'\n'+"sex:"+map.get("sex")+'\n'+"age:"+map.get("age"));
		//ͨ��ȡ��redisֵ���
		//�ж�hm�Ƿ����
		if(jedis.exists("hm")){
			System.out.println("name:"+jedis.hget("hm", "name")+'\n'+"sex:"+jedis.hget("hm", "sex")+'\n'+"age:"+jedis.hget("hm", "age"));
		}
		else{
			System.out.println("error");
		}
		
		//����LIST����
		jedis.rpush("list", "this","is","a","list");
		System.out.println(jedis.lrange("list", 0, -1));
		
		//����set��������
		jedis.sadd("set", "this","is","a","set");
		System.out.println(jedis.smembers("set"));
		
		//�������򼯺�����(zsort)
 		jedis.zadd("zsort",1,"this");
 		jedis.zadd("zsort",2,"is");
 		jedis.zadd("zsort",3,"a");
 		jedis.zadd("zsort",4,"zsort");
 		System.out.println(jedis.zrange("zsort", 0, -1));
 		
		//��ȡ���е�key
		System.out.println(jedis.keys("*"));
		//����ȫ��ɾ��
		//jedis.flushDB();
		jedis.close();
		
	}
	
	
}
