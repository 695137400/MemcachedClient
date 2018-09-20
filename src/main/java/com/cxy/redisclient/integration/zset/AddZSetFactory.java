package com.cxy.redisclient.integration.zset;

import com.cxy.redisclient.integration.JedisCommandFactory;

import java.util.Map;

public class AddZSetFactory extends JedisCommandFactory {

    public AddZSetFactory(int id, int db, String key, Map<String, Double> values) {
        super(id);
        commands.add(new AddZSet12(id, db, key, values));
        commands.add(new AddZSet24(id, db, key, values));
    }

}
