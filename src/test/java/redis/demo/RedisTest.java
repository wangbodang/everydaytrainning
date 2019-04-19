package redis.demo;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedisTest {

    @Test
    public void demoTest(){
        // 连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接本地的 Redis 服务成功！");
        // 查看服务是否运行
        System.out.println("服务 正在运行: " + jedis.ping());
    }
}
