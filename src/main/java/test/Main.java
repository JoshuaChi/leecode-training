package test;

import com.wandoulabs.jodis.JedisResourcePool;
import com.wandoulabs.jodis.RoundRobinJedisPool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

public class Main {

	public static void main(String[] args) {
		 JedisPoolConfig config = new JedisPoolConfig();
	        config.setMaxTotal(60000);//设置最大连接数  
	        config.setMaxIdle(1000); //设置最大空闲数 
	        config.setMaxWaitMillis(3000);//设置超时时间  
	        config.setTestOnBorrow(true);
//		JedisResourcePool jedisPool = new RoundRobinJedisPool("127.0.0.1:2180,127.0.0.1:2182,127.0.0.1:2183", 30000, "/zk/codis/db_push/proxy", new JedisPoolConfig(), 3000);
//		JedisResourcePool jedisPool = new RoundRobinJedisPool("10.95.198.46:2181,10.95.198.46:2182,10.95.198.46:2183", 300000, "/zk/codis/db_push/proxy", new JedisPoolConfig(), 300000);
//		JedisResourcePool jedisPool = new RoundRobinJedisPool("127.0.0.1:18181,127.0.0.1:18182,127.0.0.1:18183", 3000, "/zk/codis/db_push/proxy", config, 3000);
		//JedisResourcePool jedisPool = new RoundRobinJedisPool("10.95.198.47:2181,10.95.198.48:2181,10.95.198.51:2181,10.95.198.74:2181,10.95.198.75:2181,10.95.198.76:2181,10.95.198.77:2181", 300000, "/zk/codis/db_push/proxy", new JedisPoolConfig(), 3000);
		JedisResourcePool jedisPool = new RoundRobinJedisPool(
				"127.0.0.1:22181,127.0.0.1:23181,127.0.0.1:24181,127.0.0.1:25181,127.0.0.1:26181,127.0.0.1:27181,127.0.0.1:28181", 
				3000, 
				"/zk/codis/db_push/proxy", config, 3000);
		Jedis jedis = jedisPool.getResource();
		try {
			
			System.out.println("Jedis: "+jedis);
			jedis.set("foo", "barx");
//			String testValue = "9999999999999988888888888888888888888888888811111111111111111111111111111111111122222222222211111111111111111111111111111111111111111111111111111111111111111111111111111222222222222111111111111111111111111111111111111111111111111111111111111111111111111111112222222222221111111111111111111111111111111111111111111111111111111111111111111111111111122222222222211111111111111111111111111111111111111111111111111111111111111111111111111111222222222222111111111111111111111111111111111111111111111111111111111111111111111111111112222222222221111111111111111111111111111111111111111111111111111111111111111111111111111122222222222211111111111111111111111111111111111111111111111111111111111111111111111111111222222222222111111111111111111111111111111111111111111111111111111111111111111111111111112222222222221111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000";
//			jedis.set("test", testValue);
			String testV = jedis.get("foo");
			System.out.println("foo:"+testV);
			/**String userinfo = "{"
					+ "\"className\":\"com.uucun.msgcenter.entity.UserInfos$UserInfoEntity\","
					+ "\"tableName\":\"\","
					+ "\"docKey\":null,"
					+ "\"uid\":\"0b6772f70cb0921b\","
					+ "\"token\":\"6b962275c9118a650000dd4a70845077\","
					+ "\"apkids\":null,"
					+ "\"pushInfoMap\":{"
						+ "\"0b6772f70cb0921b\":{"
							+ "\"wostore\":{"
								+ "\"appKey\":\"wostore\","
								+ "\"apkId\":\"-624560772\","
								+ "\"lastAirpushTime\":1437109487051,"
								+ "\"lastAirpushState\":\"E\","
								+ "\"pushIdLst\":[],"
								+ "\"excludePushIdLst\":[],"
								+ "\"todaySendCount\":1,"
								+ "\"todayIndex\":16633"
								+ "}"
							+ "}"
						+ "},"
					+ "\"curSdkVersion\":2,"
					+ "\"regtime\":1437111202678,"
					+ "\"addtime\":1437111202678,"
					+ "\"networkType\":16,"
					+ "\"language\":\"zh\","
					+ "\"mmc\":460,\"mnc\":0,"
					+ "\"lac\":10633,"
					+ "\"cid\":5862,"
					+ "\"data\":null,"
					+ "\"imei\":\"862845024598869\","
					+ "\"mac\":\"38:bc:1a:10:eb:1b\","
					+ "\"platform\":\"4.2.1\","
					+ "\"screen\":\"1080*1800\","
					+ "\"sim\":\"460029282644668\","
					+ "\"appsInfo\":["
						+ "{\"appkey\":\"wostore\",\"apkid\":\"-624560772\",\"versionname\":\"4.2.0\",\"versioncode\":\"420\",\"sdkversion\":\"2\","
							+ "\"extmap\":{\"appversion\":\"4.2.0\",\"appname\":\"woStore\"}}],\"appKeys\":\"wostore\"}";
//			String userinfo = "{\"className\":\"com.uucun.msgcenter.entity.UserInfos$UserInfoEntity\",\"tableName\":\"\",\"docKey\":null,\"uid\":\"0b6772f70cb0921b\","
//					+ "\"token\":\"6b962275c9118a650000dd4a70845077\",\"apkids\":null,\"address\":{\"ip\":\"42.236.152.103\",\"port\":3674,\"endpoint\":\"42.236.152.103:3674\"},"
//					+ "\"pushInfoMap\":{\"0b6772f70cb0921b\":{\"wostore\":{\"appKey\":\"wostore\",\"apkId\":\"-624560772\",\"lastAirpushTime\":1437109487051,\"lastAirpushState\":\"E\","
//					+ "\"pushIdLst\":[],"
//					+ "\"excludePushIdLst\":[],\"t	daySendCount\":1,\"todayIndex\":16633}}},\"extMap\":{\"simtype\":\"2\",\"ip\":\"192.168.1.104\"},\"curSdkVersion\":2,"
//					+ "\"regtime\":1437111202678,\"addtime\":1437111202678,\"networkType\":16,\"language\":\"zh\",\"mmc\":460,\"mnc\":0,\"lac\":10633,\"cid\":5862,"
//					+ "\"data\":null,\"imei\":\"862845024598869\",\"mac\":\"38:bc:1a:10:eb:1b\",\"platform\":\"4.2.1\",\"screen\":\"1080*1800\",\"simcardType\":\"中国移动\","
//					+ "\"sim\":\"460029282644668\",\"model\":\"Meizu|M351\",\"versionCode\":null,\"phoneNumber\":null,\"keepalive\":null,\"state\":\"C\",\"agent\":null,"
//					+ "\"appsInfo\":[{\"appkey\":\"wostore\",\"apkid\":\"-624560772\",\"versionname\":\"4.2.0\",\"versioncode\":\"420\",\"sdkversion\":\"2\","
//					+ "\"extmap\":{\"appversion\":\"4.2.0\",\"appname\":\"woStore\"}}],\"appKeys\":\"wostore\"}";
			jedis.set("0b6772f70cb0921b", userinfo);**/
		    jedis.hset("system:se", "s1", "x");
//		    HashMap<String,String> map = new HashMap<String,String>();
//		    map.put("s1", "20145");	
//		    jedis.hmset("system:settings", map);
//		    String value = jedis.get("system:settings");
		    String value = jedis.hget("system:se", "s1");
		    System.out.println("Out:" + value);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			jedis.close();
		}
	}

}
