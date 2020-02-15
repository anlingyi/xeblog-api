package cn.xeblog.api.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author anlingyi
 * @date 2020/2/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckUtilsTest {

    @Test
    public void checkEmail() {
        CheckUtils.checkEmail("1090172196@qq.com");
        CheckUtils.checkEmail("1090172196");
        CheckUtils.checkEmail("1090172196@qq");
        CheckUtils.checkEmail("1090172196@qq.");
        CheckUtils.checkEmail("...@.com");
        CheckUtils.checkEmail("哈哈哈@qq.com");
        CheckUtils.checkEmail("xeblog@qq.com");
        CheckUtils.checkEmail("xeblog.cn@163.com");
        CheckUtils.checkEmail("abc123@a12.com");
        CheckUtils.checkEmail("admin@xeblog.cn");
    }
}