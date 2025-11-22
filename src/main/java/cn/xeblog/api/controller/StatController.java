package cn.xeblog.api.controller;

import cn.xeblog.api.domain.request.AddStat;
import cn.xeblog.api.util.IPUtils;
import cn.xeblog.api.util.Response;
import cn.xeblog.api.domain.model.Stat;
import cn.xeblog.api.service.StatService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 统计(Stat)表控制层
 *
 * @author anlingyi
 * @since 2025-11-22 18:57:04
 */
@RestController
@RequestMapping("/api/stat")
public class StatController {
    /**
     * 服务对象
     */
    @Resource
    private StatService statService;

    /**
     * 新增数据
     *
     * @param addStat 实体对象
     * @return 新增结果
     */
    @PostMapping
    public Response addStat(@RequestBody AddStat addStat, HttpServletRequest request) {
        Stat stat = new Stat();
        stat.setAddress(addStat.getAddress());
        stat.setUsername(addStat.getUsername());
        stat.setAccessIp(IPUtils.getIp(request));
        this.statService.save(stat);
        return Response.ok();
    }

}

