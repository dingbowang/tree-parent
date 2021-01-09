package com.stone.tree.web.log.service;

import com.stone.tree.response.PageResult;
import com.stone.tree.web.log.bean.OperationLog;

import java.util.List;

/**
 * (OperationLog)表服务接口
 *
 * @author makejava
 * @since 2021-01-03 14:34:13
 */
public interface OperationLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param operId 主键
     * @return 实例对象
     */
    OperationLog selectById(String operId);

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageResult selectPage(int start, int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<OperationLog> selectAll();
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param operationLog 实例对象
     * @return 对象列表
     */
    List<OperationLog> selectList(OperationLog operationLog);

    /**
     * 新增数据
     *
     * @param operationLog 实例对象
     * @return 影响行数
     */
    int insert(OperationLog operationLog);
	
	/**
     * 批量新增
     *
     * @param operationLogs 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<OperationLog> operationLogs);
	
    /**
     * 修改数据
     *
     * @param operationLog 实例对象
     * @return 修改
     */
    OperationLog update(OperationLog operationLog);

    /**
     * 通过主键删除数据
     *
     * @param operId 主键
     * @return 影响行数
     */
    int deleteById(String operId);
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}