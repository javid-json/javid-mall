package pers.javid.mall.service;

/**
 * @author ：javid
 * @date ：Created in 2019-8-20
 * @description：redis操作接口，以json和数组形式存储
 * @version: 1.0
 */
public interface RedisService {
    void set(String key,String value);

    String get(String key);

    void remove(String key);

    /**
     * 自增操作
     * @param delta 自增步长
     */
    Long increment(String key, long delta);
}
