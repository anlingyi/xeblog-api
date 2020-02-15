package cn.xeblog.api.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anlingyi
 * @date 2020/2/15
 */
public class VerifyCodeUtilsTest {

    @Test
    public void generate() {
        for (int i = 0; i < 100; i++) {
            System.out.println(VerifyCodeUtils.generate());
        }
    }
}