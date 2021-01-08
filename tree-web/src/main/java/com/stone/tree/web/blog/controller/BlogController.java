package com.stone.tree.web.blog.controller;

import com.stone.tree.response.RetResponse;
import com.stone.tree.response.RetResult;
import com.stone.tree.web.blog.bean.Blog;
import com.stone.tree.web.blog.service.BlogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Blog)控制层
 *
 * @author makejava
 * @since 2021-01-08 16:35:09
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    /**
     * 服务对象
     */
    @Resource
    private BlogService blogService;

    /**
     * 通过主键查询单条数据
     *
     * @param blog 参数对象
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RetResult<Blog> selectOne(Blog blog) {
        Blog result = blogService.selectById(blog.getId());
        if(result != null){
           return RetResponse.makeOKRsp(result);
        }
        return RetResponse.makeErrRsp("查询失败");
    }
    
    /**
     * 新增一条数据
     *
     * @param blog 实体类
     * @return Response对象
     */
    @PostMapping("insert")
    public RetResult<Blog> insert(@RequestBody Blog blog) {
        int result = blogService.insert(blog);
        if (result > 0) {
           return RetResponse.makeOKRsp(blog);
        }
        return RetResponse.makeErrRsp("新增失败");
    }

    /**
     * 修改一条数据
     *
     * @param blog 实体类
     * @return Response对象
     */
    @PostMapping("update")
    public RetResult<Blog> update(@RequestBody Blog blog) {
        Blog result = blogService.update(blog);
        if (result != null) {
           return RetResponse.makeOKRsp(result);
        }
        return RetResponse.makeErrRsp("修改失败");
    }

    /**
     * 删除一条数据
     *
     * @param blog 参数对象
     * @return Response对象
     */
    @GetMapping("delete")
    public RetResult<Blog> delete(Blog blog) {
        int result = blogService.deleteById(blog.getId());
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
    public RetResult<List<Blog>> selectAll() {
        List<Blog> blogs = blogService.selectAll();
        if (blogs != null) {
           return RetResponse.makeOKRsp(blogs);
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
    public RetResult<List<Blog>> selectPage(Integer start, Integer limit) {
        List<Blog> blogs = blogService.selectPage(start, limit);
        if (blogs != null) {
           return RetResponse.makeOKRsp(blogs);
        }
        return RetResponse.makeErrRsp("查询失败");
    }
    
}