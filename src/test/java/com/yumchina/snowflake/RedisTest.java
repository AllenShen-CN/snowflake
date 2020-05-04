package com.yumchina.snowflake;

import com.yumchina.snowflake.RedisHelp;

public class RedisTest {
    public static void main(String[] args) {
        RedisHelp redis = new RedisHelp("127.0.0.1", 6379, "");
        SnowflakeIDGenImpl idGen = new SnowflakeIDGenImpl(redis.getMachineId());
        System.out.println(idGen.nextId());
    }
}