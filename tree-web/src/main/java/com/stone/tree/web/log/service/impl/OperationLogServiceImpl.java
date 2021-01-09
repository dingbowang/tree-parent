package com.stone.tree.web.log.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stone.tree.response.PageResult;
import com.stone.tree.util.PageUtil;
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
 * @since 2021-01-09 14:13:47
 */
@Service("operationLogService")
public class OperationLogServiceImpl implements OperationLogService {
    @Resource
    private OperationLogMapper operationLogMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OperationLog selectById(String id) {
        return this.operationLogMapper.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public PageResult selectPage(int start, int limit) {
        PageHelper.startPage(start,limit);
        List<OperationLog> list =this.operationLogMapper.selectPage();
        PageInfo<OperationLog> pageInfo = new PageInfo<>(list);
        return PageUtil.pageReturn(pageInfo);
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
        return this.operationLogMapper.insertSelective(operationLog);
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
        return this.selectById(operationLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(String id) {
        return this.operationLogMapper.deleteById(id);
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