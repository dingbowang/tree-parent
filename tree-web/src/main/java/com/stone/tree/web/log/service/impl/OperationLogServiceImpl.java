package com.stone.tree.web.log.service.impl;

import com.stone.tree.web.log.bean.OperationLog;
import com.stone.tree.web.log.mapper.OperationLogMapper;
import com.stone.tree.web.log.service.OperationLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OperationLog表)服务实现类
 *
 * @author makejava
 * @since 2021-01-03 14:34:13
 */
@Service("operationLogService")
public class OperationLogServiceImpl implements OperationLogService {
    @Resource
    private OperationLogMapper operationLogMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param operId 主键
     * @return 实例对象
     */
    @Override
    public OperationLog selectById(String operId) {
        return this.operationLogMapper.selectById(operId);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<OperationLog> selectPage(int start, int limit) {
        return this.operationLogMapper.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<OperationLog> selectAll() {
        return this.operationLogMapper.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<OperationLog> selectList(OperationLog operationLog) {
        return this.operationLogMapper.selectList(operationLog);
    }
    
    /**
     * 新增数据
     *
     * @param operationLog 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(OperationLog operationLog) {
        return this.operationLogMapper.insert(operationLog);
    }

    /**
     * 批量新增
     *
     * @param operationLogs 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<OperationLog> operationLogs) {
        return this.operationLogMapper.batchInsert(operationLogs);
    }

    /**
     * 修改数据
     *
     * @param operationLog 实例对象
     * @return 实例对象
     */
    @Override
    public OperationLog update(OperationLog operationLog) {
        this.operationLogMapper.update(operationLog);
        return this.selectById(operationLog.getOperId());
    }

    /**
     * 通过主键删除数据
     *
     * @param operId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(String operId) {
        return this.operationLogMapper.deleteById(operId);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.operationLogMapper.count();
     }
}