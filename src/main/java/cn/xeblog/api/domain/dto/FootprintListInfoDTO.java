package cn.xeblog.api.domain.dto;

import lombok.Data;

import java.util.List;

/**
 * @author anlingyi
 * @date 2020/11/21
 */
@Data
public class FootprintListInfoDTO {

    private List<FootprintListDTO> footprintList;

    private int total;

    private int currentTotal;

}
