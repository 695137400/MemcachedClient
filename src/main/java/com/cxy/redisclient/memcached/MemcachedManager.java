package com.cxy.redisclient.memcached;

/**
 * Created with IntelliJ IDEA.<br/>
 * User: <br/>
 * Date: 2018-9-21-0021<br/>
 * Time: 2:28:32<br/>
 * Description: <span style="color:#63D3E9"></span><br/>
 */
public interface MemcachedManager {
    Object get(String var1);

    boolean add(String var1, Object var2);

    boolean add(String var1, Object var2, long var3);

    boolean delete(String var1);

    boolean replace(String var1, Object var2);

    boolean replace(String var1, Object var2, long var3);

    boolean flushAll();

    boolean flushAll(String[] var1);

    void close();

}
