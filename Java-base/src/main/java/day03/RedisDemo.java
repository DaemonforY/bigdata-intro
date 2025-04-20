package day03;

import redis.clients.jedis.Jedis;

public class RedisDemo {
    public static void main(String[] args) {
        RedisDemo redisDemo = new RedisDemo();
        redisDemo.testLocalRedis();
    }

    private void testLocalRedis() {
        //连接本地的 Redis 服务
        try (Jedis jedis = new Jedis("localhost", 6379)) {
            // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
            // jedis.auth("123456");
            System.out.println("连接成功");
            //查看服务是否运行
            System.out.println("服务正在运行: " + jedis.ping());
        } catch (Exception e) {
            System.out.println(" exception: " + e);
        }
    }
}
