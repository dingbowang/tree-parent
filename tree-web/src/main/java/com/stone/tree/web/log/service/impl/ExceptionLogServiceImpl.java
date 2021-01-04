package com.stone.tree.web.log.service.impl;

import com.stone.tree.web.log.bean.ExceptionLog;
import com.stone.tree.web.log.mapper.ExceptionLogMapper;
import com.stone.tree.web.log.service.ExceptionLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ExceptionLog表)服务实现类
 *
 * @author makejava
 * @since 2021-01-03 14:34:13
 */
@Service("exceptionLogService")
public class ExceptionLogServiceImpl implements ExceptionLogService {
    @Resource
    private ExceptionLogMapper exceptionLogMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param excId 主键
     * @return 实例对象
     */
    @Override
    public ExceptionLog selectById(String excId) {
        return this.exceptionLogMapper.selectById(excId);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ExceptionLog> selectPage(int start, int limit) {
        return this.exceptionLogMapper.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<ExceptionLog> selectAll() {
        return this.exceptionLogMapper.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<ExceptionLog> selectList(ExceptionLog exceptionLog) {
        return this.exceptionLogMapper.selectList(exceptionLog);
    }
    
    /**
     * 新增数据
     *
     * @param exceptionLog 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(ExceptionLog exceptionLog) {
        return this.exceptionLogMapper.insert(exceptionLog);
    }

    /**
     * 批量新增
     *
     * @param exceptionLogs 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<ExceptionLog> exceptionLogs) {
        return this.exceptionLogMapper.batchInsert(exceptionLogs);
    }

    /**
     * 修改数据
     *
     * @param exceptionLog 实例对象
     * @return 实例对象
     */
    @Override
    public ExceptionLog update(ExceptionLog exceptionLog) {
        this.exceptionLogMapper.update(exceptionLog);
        return this.selectById(exceptionLog.getExcId());
    }

    /**
     * 通过主键删除数据
     *
     * @param excId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(String excId) {
        return this.exceptionLogMapper.deleteById(excId);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.exceptionLogMapper.count();
     }
}