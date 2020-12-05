package cn.xeblog.api.service.impl;

import cn.xeblog.api.dao.FootprintMapper;
import cn.xeblog.api.domain.dto.FootprintListInfoDTO;
import cn.xeblog.api.domain.model.Footprint;
import cn.xeblog.api.domain.request.AddFootprint;
import cn.xeblog.api.service.FootprintService;
import cn.xeblog.api.service.UploadService;
import cn.xeblog.api.util.CodeUtils;
import cn.xeblog.api.util.GeoHashUtils;
import cn.xeblog.api.util.IPUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
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
    @Resource(name = "${default.upload.impl}")
    private UploadService uploadService;

    @Override
    public boolean addFootprint(AddFootprint addFootprint) {
        Footprint footprint = new Footprint();
        footprint.setCode(CodeUtils.generateCode());
        footprint.setAddress(addFootprint.getAddress());
        footprint.setContent(addFootprint.getContent());
        footprint.setGeohash(GeoHashUtils.getHash(addFootprint.getLongitude(), addFootprint.getLatitude()));
        footprint.setIp(IPUtils.getIp(request));
        footprint.setLatitude(addFootprint.getLatitude());
        footprint.setLongitude(addFootprint.getLongitude());
        footprint.setTag(addFootprint.getTag());
        footprint.setNickname(addFootprint.getNickname());
        if (addFootprint.getImage() != null) {
            footprint.setImage(uploadService.uploadImage(addFootprint.getImage(), true));
        }
        return super.save(footprint);
    }

    @Override
    public FootprintListInfoDTO getFootprintListInfo(Double longitude, Double latitude) {
        int range = 1000;
        FootprintListInfoDTO info = new FootprintListInfoDTO();
        String aroundGeoHash = StringUtils.join(GeoHashUtils.aroundHash(longitude, latitude, 5), "|");
        info.setTotal(super.baseMapper.getTotal());
        info.setCurrentTotal(super.baseMapper.getCurrentTotal(aroundGeoHash, longitude, latitude, range));
        if (info.getCurrentTotal() > 0) {
            info.setFootprintList(super.baseMapper.listFootprint(aroundGeoHash, longitude, latitude, range));
        }
        return info;
    }
}
