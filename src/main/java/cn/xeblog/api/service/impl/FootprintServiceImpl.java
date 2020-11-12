package cn.xeblog.api.service.impl;

import cn.xeblog.api.dao.FootprintMapper;
import cn.xeblog.api.domain.model.Footprint;
import cn.xeblog.api.domain.request.AddFootprint;
import cn.xeblog.api.service.FootprintService;
import cn.xeblog.api.util.GeoHashUtils;
import cn.xeblog.api.util.IPUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author anlingyi
 * @date 2020/11/12
 */
@Service
public class FootprintServiceImpl extends ServiceImpl<FootprintMapper, Footprint> implements FootprintService {

    @Resource
    private HttpServletRequest request;

    @Override
    public boolean addFootprint(AddFootprint addFootprint) {
        Footprint footprint = new Footprint();
        footprint.setAddress(addFootprint.getAddress());
        footprint.setContent(addFootprint.getContent());
        footprint.setGeohash(GeoHashUtils.getHash(addFootprint.getLongitude(), addFootprint.getLatitude()));
        footprint.setImage(addFootprint.getImage());
        footprint.setIp(IPUtils.getIp(request));
        footprint.setLatitude(addFootprint.getLatitude());
        footprint.setLongitude(addFootprint.getLongitude());
        footprint.setTag(addFootprint.getTag());
        return super.save(footprint);
    }

}
