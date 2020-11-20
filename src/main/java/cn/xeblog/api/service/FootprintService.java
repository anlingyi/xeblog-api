package cn.xeblog.api.service;

import cn.xeblog.api.domain.dto.FootprintListDTO;
import cn.xeblog.api.domain.model.Footprint;
import cn.xeblog.api.domain.request.AddFootprint;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author anlingyi
 * @date 2020/11/12
 */
public interface FootprintService extends IService<Footprint> {

    boolean addFootprint(AddFootprint addFootprint);

    List<FootprintListDTO> listFootprint(Double longitude, Double latitude);
}
