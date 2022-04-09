package cn.xeblog.api.domain.bo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 站点地图
 *
 * @author anlingyi
 * @date 2022/4/9 4:27 下午
 */
@XStreamAlias("urlset")
@Data
public class SitemapBO {

    @XStreamImplicit
    private List<Url> list = new ArrayList<>();

    public void addUrl(Url url) {
        this.list.add(url);
    }

    @XStreamAlias("url")
    @Data
    public static class Url {
        private String loc;

        private String priority;

        private String lastmod;

        private String changefreq;
    }

}
