package cn.xeblog.api.service;

import cn.xeblog.api.domain.dto.FootprintListInfoDTO;
import cn.xeblog.api.domain.model.Footprint;
import cn.xeblog.api.domain.request.AddFootprint;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author anlingyi
 * @date 2020/11/12
 */
public interface FootprintService extends IService<Footprint> {

    boolean addFootprint(AddFootprint addFootprint);

    FootprintListInfoDTO getFootprintListInfo(Double longitude, Double latitude);

}
