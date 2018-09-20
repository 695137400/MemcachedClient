package com.cxy.redisclient.integration.zset;

import com.cxy.redisclient.domain.RedisVersion;
import com.cxy.redisclient.integration.JedisCommand;
import redis.clients.jedis.Tuple;

import java.util.Set;

public class ListZSet extends JedisCommand {
    public Set<Tuple> getValues() {
        return values;
    }

    private int db;
    private String key;
    private Set<Tuple> values;

    public ListZSet(int id, int db, String key) {
        super(id);
        this.db = db;
        this.key = key;
    }

    @Override
    protected void command() {
        jedis.select(db);
        values = jedis.zrangeWithScores(key, 0, -1);
    }

    @Override
    public RedisVersion getSupportVersion() {
        return RedisVersion.REDIS_1_2;
    }

}
