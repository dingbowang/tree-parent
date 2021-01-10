package com.stone.tree.web.common.mapper;

import com.stone.tree.web.common.bean.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Picture)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-10 13:50:03
 */
@Mapper
public interface PictureMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Picture selectById(String id);
	
    /**
     * 分页查询
     *
     * @return 对象列表
     */
    List<Picture> selectPage();

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Picture> selectAll();
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param picture 实例对象
     * @return 对象列表
     */
    List<Picture> selectList(Picture picture);

    /**
     * 新增数据
     *
     * @param picture 实例对象
     * @return 影响行数
     */
    int insert(Picture picture);
    
     /**
     * 必填项新增数据
     *
     * @param picture 实例对象
     * @return 影响行数
     */
    int insertSelective(Picture picture);
	
	/**
     * 批量新增
     *
     * @param pictures 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Picture> pictures);
	
    /**
     * 修改数据
     *
     * @param picture 实例对象
     * @return 影响行数
     */
    int update(Picture picture);

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