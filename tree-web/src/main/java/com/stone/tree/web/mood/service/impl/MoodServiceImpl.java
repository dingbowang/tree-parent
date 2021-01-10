package com.stone.tree.web.mood.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stone.tree.response.PageResult;
import com.stone.tree.util.PageUtil;
import com.stone.tree.web.mood.bean.Mood;
import com.stone.tree.web.mood.mapper.MoodMapper;
import com.stone.tree.web.mood.service.MoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Mood表)服务实现类
 *
 * @author makejava
 * @since 2021-01-10 13:49:42
 */
@Service("moodService")
public class MoodServiceImpl implements MoodService {
    @Resource
    private MoodMapper moodMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Mood selectById(String id) {
        return this.moodMapper.selectById(id);
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
        List<Mood> list =this.moodMapper.selectPage();
        PageInfo<Mood> pageInfo = new PageInfo<>(list);
        return PageUtil.pageReturn(pageInfo);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<Mood> selectAll() {
        return this.moodMapper.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Mood> selectList(Mood mood) {
        return this.moodMapper.selectList(mood);
    }
    
    /**
     * 新增数据
     *
     * @param mood 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Mood mood) {
        return this.moodMapper.insertSelective(mood);
    }

    /**
     * 批量新增
     *
     * @param moods 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Mood> moods) {
        return this.moodMapper.batchInsert(moods);
    }

    /**
     * 修改数据
     *
     * @param mood 实例对象
     * @return 实例对象
     */
    @Override
    public Mood update(Mood mood) {
        this.moodMapper.update(mood);
        return this.selectById(mood.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(String id) {
        return this.moodMapper.deleteById(id);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.moodMapper.count();
     }
}