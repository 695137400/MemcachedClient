package com.cxy.redisclient.service;

import com.cxy.redisclient.integration.pubsub.Publish;
import com.cxy.redisclient.integration.pubsub.Subscribe;
import redis.clients.jedis.JedisPubSub;

public class PubSubService {
    public void publish(int id, String channel, String message) {
        Publish command = new Publish(id, channel, message);
        command.execute();
    }

    public void subscribe(int id, JedisPubSub callback, String channels) {
        Subscribe command = new Subscribe(id, callback, channels);
        command.execute();
    }
}
