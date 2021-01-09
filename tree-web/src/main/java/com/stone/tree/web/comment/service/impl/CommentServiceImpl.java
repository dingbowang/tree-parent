package com.stone.tree.web.comment.service.impl;

import com.stone.tree.web.comment.bean.Comment;
import com.stone.tree.web.comment.mapper.CommentMapper;
import com.stone.tree.web.comment.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Comment表)服务实现类
 *
 * @author makejava
 * @since 2021-01-09 09:57:25
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Comment selectById(String id) {
        return this.commentMapper.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Comment> selectPage(int start, int limit) {
        return this.commentMapper.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<Comment> selectAll() {
        return this.commentMapper.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Comment> selectList(Comment comment) {
        return this.commentMapper.selectList(comment);
    }
    
    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Comment comment) {
        return this.commentMapper.insertSelective(comment);
    }

    /**
     * 批量新增
     *
     * @param comments 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Comment> comments) {
        return this.commentMapper.batchInsert(comments);
    }

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment update(Comment comment) {
        this.commentMapper.update(comment);
        return this.selectById(comment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(String id) {
        return this.commentMapper.deleteById(id);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.commentMapper.count();
     }
}