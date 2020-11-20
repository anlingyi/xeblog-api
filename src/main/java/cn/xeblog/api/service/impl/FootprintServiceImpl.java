package cn.xeblog.api.service.impl;

import cn.xeblog.api.dao.FootprintMapper;
import cn.xeblog.api.domain.dto.FootprintListDTO;
import cn.xeblog.api.domain.model.Footprint;
import cn.xeblog.api.domain.request.AddFootprint;
import cn.xeblog.api.service.FootprintService;
import cn.xeblog.api.service.UploadService;
import cn.xeblog.api.util.GeoHashUtils;
import cn.xeblog.api.util.IPUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author anlingyi
 * @date 2020/11/12
 */
@Service
public class FootprintServiceImpl extends ServiceImpl<FootprintMapper, Footprint> implements FootprintService {

    @Resource
    private HttpServletRequest request;
    @Resource(name = "${default.upload.impl}")
    private UploadService uploadService;

    @Override
    public boolean addFootprint(AddFootprint addFootprint) {
        Footprint footprint = new Footprint();
        footprint.setAddress(addFootprint.getAddress());
        footprint.setContent(addFootprint.getContent());
        footprint.setGeohash(GeoHashUtils.getHash(addFootprint.getLongitude(), addFootprint.getLatitude()));
        footprint.setIp(IPUtils.getIp(request));
        footprint.setLatitude(addFootprint.getLatitude());
        footprint.setLongitude(addFootprint.getLongitude());
        footprint.setTag(addFootprint.getTag());
        if (addFootprint.getImage() != null) {
            footprint.setImage(uploadService.uploadImage(addFootprint.getImage(), true));
        }
        return super.save(footprint);
    }

    @Override
    public List<FootprintListDTO> listFootprint(Double longitude, Double latitude) {
        return null;
    }
}
