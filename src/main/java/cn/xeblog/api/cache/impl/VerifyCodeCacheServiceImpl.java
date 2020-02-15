package cn.xeblog.api.cache.impl;

import cn.xeblog.api.cache.CacheService;
import cn.xeblog.api.domain.model.VerifyCode;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anlingyi
 * @date 2020/2/15
 */
@Service("verifyCodeCacheServiceImpl")
public class VerifyCodeCacheServiceImpl implements CacheService<String, VerifyCode> {

    private static final ConcurrentHashMap<String, VerifyCode> map = new ConcurrentHashMap(32);

    @Override
    public VerifyCode get(String key) {
        return map.get(key);
    }

    @Override
    public VerifyCode add(String key, VerifyCode value) {
        return map.put(key, value);
    }

    @Override
    public VerifyCode remove(String key) {
        return map.remove(key);
    }

    @Override
    public boolean containKey(String key) {
        return map.containsKey(key);
    }
}
