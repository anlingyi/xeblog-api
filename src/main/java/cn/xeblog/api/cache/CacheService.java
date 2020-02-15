package cn.xeblog.api.cache;

/**
 * 缓存
 *
 * @author anlingyi
 * @date 2020/2/15
 */
public interface CacheService<K, V> {

    /**
     * 获取缓存
     *
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 添加缓存
     *
     * @param key
     * @param value
     * @return
     */
    V add(K key, V value);

    /**
     * 移除缓存
     *
     * @param key
     * @return
     */
    V remove(K key);

    /**
     * 是否存在这个缓存
     *
     * @param key
     * @return
     */
    boolean containKey(K key);
}
