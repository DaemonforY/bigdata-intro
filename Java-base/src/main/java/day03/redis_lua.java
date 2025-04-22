package day03;

import redis.clients.jedis.Jedis;

class RedisAdvancedExercise {
    public static void main(String[] args) {
        // 初始化 Jedis 客户端
        try (Jedis jedis = new Jedis("localhost", 6379)) {
            // 设置初始键值
            jedis.set("key1", "1");
            jedis.set("key2", "2");
            jedis.set("key3", "3");

            // Lua 脚本: 将 key1, key2, key3 的值更新，增加新键值 key4
            String luaScript = "local keys = {'key1', 'key2', 'key3'} " +
                    "local new_key = 'key4' " +
                    "local new_value = 'value4' " +
                    "for i=1,#keys do " +
                    "   local current_value = tonumber(redis.call('GET', keys[i])) " +
                    "   if current_value then " +
                    "       redis.call('SET', keys[i], current_value + 1) " +
                    "   else " +
                    "       redis.call('SET', keys[i], 1) " +
                    "   end " +
                    "end " +
                    "redis.call('SET', new_key, new_value) " +
                    "return 'Update complete'";

            // 执行 Lua 脚本
            Object result = jedis.eval(luaScript);
            System.out.println(result);

            // 验证结果
            System.out.println("key1: " + jedis.get("key1"));
            System.out.println("key2: " + jedis.get("key2"));
            System.out.println("key3: " + jedis.get("key3"));
            System.out.println("key4: " + jedis.get("key4"));
        }
    }
}
