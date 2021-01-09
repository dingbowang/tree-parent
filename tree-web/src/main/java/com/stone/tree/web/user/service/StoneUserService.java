package com.stone.tree.web.user.service;

import com.stone.tree.response.PageResult;
import com.stone.tree.web.user.bean.StoneUser;

import java.util.List;

/**
 * 用户(StoneUser)表服务接口
 *
 * @author makejava
 * @since 2021-01-03 12:50:40
 */
public interface StoneUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StoneUser selectById(String id);

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
    List<StoneUser> selectAll();
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param stoneUser 实例对象
     * @return 对象列表
     */
    List<StoneUser> selectList(StoneUser stoneUser);

    /**
     * 新增数据
     *
     * @param stoneUser 实例对象
     * @return 影响行数
     */
    int insert(StoneUser stoneUser);
	
	/**
     * 批量新增
     *
     * @param stoneUsers 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<StoneUser> stoneUsers);
	
    /**
     * 修改数据
     *
     * @param stoneUser 实例对象
     * @return 修改
     */
    StoneUser update(StoneUser stoneUser);

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

    /**
     * 查询用户
     * @param user
     * @return
     */
    StoneUser queryUser(StoneUser user);
}