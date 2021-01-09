package com.stone.tree.web.comment.controller;

import com.stone.tree.response.RetResponse;
import com.stone.tree.response.RetResult;
import com.stone.tree.web.comment.bean.Comment;
import com.stone.tree.web.comment.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Comment)控制层
 *
 * @author makejava
 * @since 2021-01-09 09:57:25
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    /**
     * 服务对象
     */
    @Resource
    private CommentService commentService;

    /**
     * 通过主键查询单条数据
     *
     * @param comment 参数对象
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RetResult<Comment> selectOne(Comment comment) {
        Comment result = commentService.selectById(comment.getId());
        if(result != null){
           return RetResponse.makeOKRsp(result);
        }
        return RetResponse.makeErrRsp("查询失败");
    }
    
    /**
     * 新增一条数据
     *
     * @param comment 实体类
     * @return Response对象
     */
    @PostMapping("insert")
    public RetResult<Comment> insert(@RequestBody Comment comment) {
        int result = commentService.insert(comment);
        if (result > 0) {
           return RetResponse.makeOKRsp(comment);
        }
        return RetResponse.makeErrRsp("新增失败");
    }

    /**
     * 修改一条数据
     *
     * @param comment 实体类
     * @return Response对象
     */
    @PostMapping("update")
    public RetResult<Comment> update(@RequestBody Comment comment) {
        Comment result = commentService.update(comment);
        if (result != null) {
           return RetResponse.makeOKRsp(result);
        }
        return RetResponse.makeErrRsp("修改失败");
    }

    /**
     * 删除一条数据
     *
     * @param comment 参数对象
     * @return Response对象
     */
    @GetMapping("delete")
    public RetResult<Comment> delete(Comment comment) {
        int result = commentService.deleteById(comment.getId());
        if (result > 0) {
           return RetResponse.makeOKRsp(null);
        }
        return RetResponse.makeErrRsp("删除失败");
    }

    /**
     * 查询全部
     *
     * @return Response对象
     */
    @GetMapping("selectAll")
    public RetResult<List<Comment>> selectAll() {
        List<Comment> comments = commentService.selectAll();
        if (comments != null) {
           return RetResponse.makeOKRsp(comments);
        }
        return RetResponse.makeErrRsp("查询失败");
    }

    /**
     * 分页查询
     *
     * @param start 偏移
     * @param limit 条数
     * @return Response对象
     */
    @GetMapping("selectPage")
    public RetResult<List<Comment>> selectPage(Integer start, Integer limit) {
        List<Comment> comments = commentService.selectPage(start, limit);
        if (comments != null) {
           return RetResponse.makeOKRsp(comments);
        }
        return RetResponse.makeErrRsp("查询失败");
    }
    
}