package com.cxy.redisclient.integration.set;

import com.cxy.redisclient.integration.JedisCommandFactory;

import java.util.Set;

public class RemoveSetFactory extends JedisCommandFactory {

    public RemoveSetFactory(int id, int db, String key, Set<String> values) {
        super(id);
        commands.add(new RemoveSet10(id, db, key, values));
        commands.add(new RemoveSet24(id, db, key, values));
    }

}
