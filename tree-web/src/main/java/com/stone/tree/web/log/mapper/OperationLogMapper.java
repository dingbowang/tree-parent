package com.stone.tree.web.log.mapper;

import com.stone.tree.web.log.bean.OperationLog;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (OperationLog)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-09 14:13:47
 */
public interface OperationLogMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OperationLog selectById(String id);
	
    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OperationLog> selectPage();

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
     * 必填项新增数据
     *
     * @param operationLog 实例对象
     * @return 影响行数
     */
    int insertSelective(OperationLog operationLog);
	
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
     * @return 影响行数
     */
    int update(OperationLog operationLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}