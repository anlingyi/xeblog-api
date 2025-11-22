package cn.xeblog.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xeblog.api.dao.StatMapper;
import cn.xeblog.api.domain.model.Stat;
import cn.xeblog.api.service.StatService;
import org.springframework.stereotype.Service;

/**
 * 统计(Stat)表服务实现类
 *
 * @author anlingyi
 * @since 2025-11-22 18:56:23
 */
@Service("statService")
public class StatServiceImpl extends ServiceImpl<StatMapper, Stat> implements StatService {

}

