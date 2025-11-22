package cn.xeblog.api.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import cn.xeblog.api.domain.model.Stat;

/**
 * 统计(Stat)表数据库访问层
 *
 * @author anlingyi
 * @since 2025-11-22 18:57:11
 */
public interface StatMapper extends BaseMapper<Stat> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Stat> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Stat> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Stat> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Stat> entities);

}

