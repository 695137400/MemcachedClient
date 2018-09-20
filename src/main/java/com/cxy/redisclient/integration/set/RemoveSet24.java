package com.cxy.redisclient.integration.set;

import com.cxy.redisclient.domain.RedisVersion;

import java.util.Set;

public class RemoveSet24 extends RemoveSet {

    public RemoveSet24(int id, int db, String key, Set<String> values) {
        super(id, db, key, values);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void command() {
        jedis.select(db);
        jedis.srem(key, values);
    }

    @Override
    public RedisVersion getSupportVersion() {
        return RedisVersion.REDIS_2_4;
    }

}
