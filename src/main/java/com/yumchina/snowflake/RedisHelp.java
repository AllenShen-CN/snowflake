package com.yumchina.snowflake;

import redis.clients.jedis.Jedis;

public class RedisHelp {
    private String host;
    private int port;
    private String password;

    public RedisHelp(String redisUrl, int redisPort, String redisPwd) {
        this.host = redisUrl;
        this.port = redisPort;
        this.password = redisPwd;
    }

    public long getMachineId() {
        Jedis jedis = new Jedis(this.host, this.port);
        if (this.password != null && !this.password.equals("")) {
            jedis.auth(this.password);
        }
        jedis.select(1);
        String ip = Utils.getIp();
        if (jedis.exists("snowflake:")) {
            jedis.set("snowflake:" + ip, "1");
            jedis.close();
            return 1;
        }
        if (jedis.exists("snowflake:" + ip)) {
            String machineId = jedis.get("snowflake:" + ip);
            jedis.close();
            return Long.valueOf(machineId);
        } else {
            long count = jedis.keys("snowflake:*").size();
            jedis.set("snowflake:" + ip, String.valueOf(count + 1));
            jedis.close();
            return count + 1;
        }
    }
}
package com.yumchina.snowflake;

import redis.clients.jedis.Jedis;

public class RedisHelp {
    private String host;
    private int port;
    private String password;

    public RedisHelp(String redisUrl, int redisPort, String redisPwd) {
        this.host = redisUrl;
        this.port = redisPort;
        this.password = redisPwd;
    }

    public long getMachineId() {
        Jedis jedis = new Jedis(this.host, this.port);
        if (this.password != null && !this.password.equals("")) {
            jedis.auth(this.password);
        }
        jedis.select(1);
        String ip = Utils.getIp();
        if (jedis.exists("snowflake:")) {
            jedis.set("snowflake:" + ip, "1");
            jedis.close();
            return 1;
        }
        if (jedis.exists("snowflake:" + ip)) {
            String machineId = jedis.get("snowflake:" + ip);
            jedis.close();
            return Long.valueOf(machineId);
        } else {
            long count = jedis.keys("snowflake:*").size();
            jedis.set("snowflake:" + ip, String.valueOf(count + 1));
            jedis.close();
            return count + 1;
        }
    }
}
