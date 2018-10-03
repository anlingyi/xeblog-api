package cn.xeblog.xeblogapi;

import cn.xeblog.xeblogapi.domain.request.UpdateWebsiteInfo;
import cn.xeblog.xeblogapi.service.WebsiteInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebsiteInfoTests {

    @Resource
    private WebsiteInfoService websiteInfoService;

    @Test
    public void get() throws Exception {
        Assert.assertNotNull(websiteInfoService.getWebsiteInfo());
    }

    @Test
    public void update() throws Exception {
        Assert.assertTrue(websiteInfoService.updateWebsite(new UpdateWebsiteInfo("title", "copyright",
                "subtitle")));
    }

}
