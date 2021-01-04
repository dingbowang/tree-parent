package com.stone.tree.web.user.mapper;

import com.stone.tree.web.user.bean.StoneUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户(StoneUser)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-03 12:50:40
 */
@Mapper
public interface StoneUserMapper {

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
    List<StoneUser> selectPage(@Param("start") int start, @Param("limit") int limit);

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
     * 新增
     * @param stoneUser
     * @return
     */
    int insertSelective(StoneUser stoneUser);
	
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
     * @return 影响行数
     */
    int update(StoneUser stoneUser);

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
     * 登录核验
     * @param password
     * @param mobile
     * @return
     */
    StoneUser QueryLoginUser(String password, String mobile);

    /**
     * 条件查询用户
     * @param stoneUser
     * @return
     */
    List<StoneUser> QueryUserSelective(StoneUser stoneUser);
}