package com.cxy.redisclient.integration.zset;

import com.cxy.redisclient.domain.RedisVersion;

import java.util.Map;

public class AddZSet12 extends AddZSet {

    public AddZSet12(int id, int db, String key, Map<String, Double> values) {
        super(id, db, key, values);
    }

    @Override
    public RedisVersion getSupportVersion() {
        return RedisVersion.REDIS_1_2;
    }

    protected void addZSet() {
        for (Map.Entry<String, Double> value : values.entrySet())
            jedis.zadd(key, value.getValue(), value.getKey());
    }

}
