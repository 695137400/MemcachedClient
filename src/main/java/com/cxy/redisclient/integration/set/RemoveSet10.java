package com.cxy.redisclient.integration.set;

import com.cxy.redisclient.domain.RedisVersion;

import java.util.Set;

public class RemoveSet10 extends RemoveSet {

    public RemoveSet10(int id, int db, String key, Set<String> values) {
        super(id, db, key, values);
    }

    @Override
    protected void command() {
        jedis.select(db);
        for (String value : values)
            jedis.srem(key, value);
    }

    @Override
    public RedisVersion getSupportVersion() {
        return RedisVersion.REDIS_1_0;
    }

}
