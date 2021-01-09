package com.stone.tree.web.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stone.tree.response.PageResult;
import com.stone.tree.util.PageUtil;
import com.stone.tree.web.blog.bean.Blog;
import com.stone.tree.web.blog.mapper.BlogMapper;
import com.stone.tree.web.blog.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Blog表)服务实现类
 *
 * @author makejava
 * @since 2021-01-09 14:04:11
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogMapper blogMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Blog selectById(String id) {
        return this.blogMapper.selectById(id);
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
        List<Blog> list =this.blogMapper.selectPage();
        PageInfo<Blog> pageInfo = new PageInfo<>(list);
        return PageUtil.pageReturn(pageInfo);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<Blog> selectAll() {
        return this.blogMapper.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Blog> selectList(Blog blog) {
        return this.blogMapper.selectList(blog);
    }
    
    /**
     * 新增数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Blog blog) {
        return this.blogMapper.insertSelective(blog);
    }

    /**
     * 批量新增
     *
     * @param blogs 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Blog> blogs) {
        return this.blogMapper.batchInsert(blogs);
    }

    /**
     * 修改数据
     *
     * @param blog 实例对象
     * @return 实例对象
     */
    @Override
    public Blog update(Blog blog) {
        this.blogMapper.update(blog);
        return this.selectById(blog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(String id) {
        return this.blogMapper.deleteById(id);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.blogMapper.count();
     }
}