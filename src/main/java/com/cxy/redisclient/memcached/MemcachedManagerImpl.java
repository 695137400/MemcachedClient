package com.cxy.redisclient.memcached;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.<br/>
 * User: <br/>
 * Date: 2018-9-21-0021<br/>
 * Time: 2:29:27<br/>
 * Author:<br/>
 * Description: <span style="color:#63D3E9"></span><br/>
 */
public class MemcachedManagerImpl implements MemcachedManager {
    private static final Logger logger = Logger.getLogger(MemcachedManagerImpl.class);
    private MemCachedClient memCachedClient = new MemCachedClient();
    private String servers;
    private SockIOPool pool;

    public MemcachedManagerImpl(String servers, String port) {
        this.servers = servers + ":" + port;
        initialize();
    }


    private void initialize() {
        pool = SockIOPool.getInstance();
        pool.setServers(new String[]{servers});

        pool.initialize();

        logger.info("Memcached客户端初始化成功  ");
    }

    public boolean add(String key, Object value, long expireInMilliSeconds) {
        Date d = new Date(expireInMilliSeconds);
        return this.memCachedClient.add(key, value, d);
    }

    public boolean add(String key, Object value) {
        return this.memCachedClient.add(key, value);
    }

    public boolean delete(String key) {
        return this.memCachedClient.delete(key);
    }

    public boolean replace(String key, Object value) {
        return this.memCachedClient.replace(key, value);
    }

    public boolean replace(String key, Object value, long expireInMilliSeconds) {
        Date d = new Date(expireInMilliSeconds);
        return this.memCachedClient.replace(key, value, d);
    }

    public Object get(String key) {
        return this.memCachedClient.get(key);
    }

    public boolean flushAll() {
        return this.memCachedClient.flushAll();
    }

    public void close() {
        if (pool != null) {
            pool.shutDown();
            logger.info("shut down memcache pool");
        }

    }

    public boolean flushAll(String[] arg0) {
        return false;
    }
}
