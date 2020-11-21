package cn.xeblog.api.dao;

import cn.xeblog.api.domain.dto.FootprintListDTO;
import cn.xeblog.api.domain.model.Footprint;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author anlingyi
 * @date 2020/11/12
 */
@Service
public interface FootprintMapper extends BaseMapper<Footprint> {

    List<FootprintListDTO> listFootprint(@Param("aroundGeoHash") String aroundGeoHash, @Param("lng") double lng,
                                         @Param("lat") double lat, @Param("range") int range);

}
