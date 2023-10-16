package cn.xeblog.api.service.impl;

import cn.xeblog.api.constant.FileConstant;
import cn.xeblog.api.dao.FootprintMapper;
import cn.xeblog.api.domain.dto.FootprintListInfoDTO;
import cn.xeblog.api.domain.model.Footprint;
import cn.xeblog.api.domain.request.AddFootprint;
import cn.xeblog.api.service.FootprintService;
import cn.xeblog.api.service.UploadService;
import cn.xeblog.api.util.CodeUtils;
import cn.xeblog.api.util.FileUtils;
import cn.xeblog.api.util.GeoHashUtils;
import cn.xeblog.api.util.IPUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

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
        boolean hasImage = addFootprint.getImage() != null;

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
        if (hasImage) {
            footprint.setImage(FileConstant.IMAGE_UPLOADING_URL);
        }
        boolean flag = super.save(footprint);

        if (flag && hasImage) {
            try {
                MultipartFile multipartFile = addFootprint.getImage();
                uploadService.uploadWithAsync(multipartFile.getBytes(), FileUtils.getFileType(multipartFile),
                        true, url -> super.baseMapper.updateImage(url, footprint.getId()));
            } catch (IOException e) {
                log.error("文件上传失败！", e);
            }
        }

        return flag;
    }

    @Override
    public FootprintListInfoDTO getFootprintListInfo(Double longitude, Double latitude) {
        int range = 2000;
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
