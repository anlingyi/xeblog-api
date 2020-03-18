package cn.xeblog.api.cache.impl;

import cn.xeblog.api.cache.CacheService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anlingyi
 * @date 2020/3/18
 */
@Service("defaultCacheServiceImpl")
public class DefaultCacheServiceImpl<T, V> implements CacheService<T, V> {

    private final ConcurrentHashMap<T, V> map = new ConcurrentHashMap(32);

    @Override
    public V get(T key) {
        return map.get(key);
    }

    @Override
    public V add(T key, V value) {
        return map.put(key, value);
    }

    @Override
    public V remove(T key) {
        return map.remove(key);
    }

    @Override
    public boolean containKey(T key) {
        return map.containsKey(key);
    }

}
