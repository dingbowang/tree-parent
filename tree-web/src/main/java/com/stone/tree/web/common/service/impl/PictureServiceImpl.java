package com.stone.tree.web.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stone.tree.response.PageResult;
import com.stone.tree.util.PageUtil;
import com.stone.tree.web.common.bean.Picture;
import com.stone.tree.web.common.mapper.PictureMapper;
import com.stone.tree.web.common.service.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Picture表)服务实现类
 *
 * @author makejava
 * @since 2021-01-10 13:50:03
 */
@Service("pictureService")
public class PictureServiceImpl implements PictureService {
    @Resource
    private PictureMapper pictureMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Picture selectById(String id) {
        return this.pictureMapper.selectById(id);
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
        List<Picture> list =this.pictureMapper.selectPage();
        PageInfo<Picture> pageInfo = new PageInfo<>(list);
        return PageUtil.pageReturn(pageInfo);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<Picture> selectAll() {
        return this.pictureMapper.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Picture> selectList(Picture picture) {
        return this.pictureMapper.selectList(picture);
    }
    
    /**
     * 新增数据
     *
     * @param picture 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Picture picture) {
        return this.pictureMapper.insertSelective(picture);
    }

    /**
     * 批量新增
     *
     * @param pictures 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Picture> pictures) {
        return this.pictureMapper.batchInsert(pictures);
    }

    /**
     * 修改数据
     *
     * @param picture 实例对象
     * @return 实例对象
     */
    @Override
    public Picture update(Picture picture) {
        this.pictureMapper.update(picture);
        return this.selectById(picture.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(String id) {
        return this.pictureMapper.deleteById(id);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.pictureMapper.count();
     }
}