package com.stone.tree.web.mood.controller;

import com.stone.tree.response.PageResult;
import com.stone.tree.response.RetResponse;
import com.stone.tree.response.RetResult;
import com.stone.tree.web.mood.bean.Mood;
import com.stone.tree.web.mood.service.MoodService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Mood)控制层
 *
 * @author makejava
 * @since 2021-01-10 13:49:42
 */
@RestController
@RequestMapping("/mood")
public class MoodController {
    /**
     * 服务对象
     */
    @Resource
    private MoodService moodService;

    /**
     * 通过主键查询单条数据
     *
     * @param mood 参数对象
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RetResult<Mood> selectOne(Mood mood) {
        Mood result = moodService.selectById(mood.getId());
        if(result != null){
           return RetResponse.makeOKRsp(result);
        }
        return RetResponse.makeErrRsp("查询失败");
    }
    
    /**
     * 新增一条数据
     *
     * @param mood 实体类
     * @return Response对象
     */
    @PostMapping("insert")
    public RetResult<Mood> insert(@RequestBody Mood mood) {
        int result = moodService.insert(mood);
        if (result > 0) {
           return RetResponse.makeOKRsp(mood);
        }
        return RetResponse.makeErrRsp("新增失败");
    }

    /**
     * 修改一条数据
     *
     * @param mood 实体类
     * @return Response对象
     */
    @PostMapping("update")
    public RetResult<Mood> update(@RequestBody Mood mood) {
        Mood result = moodService.update(mood);
        if (result != null) {
           return RetResponse.makeOKRsp(result);
        }
        return RetResponse.makeErrRsp("修改失败");
    }

    /**
     * 删除一条数据
     *
     * @param mood 参数对象
     * @return Response对象
     */
    @GetMapping("delete")
    public RetResult<Mood> delete(Mood mood) {
        int result = moodService.deleteById(mood.getId());
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
    public RetResult<List<Mood>> selectAll() {
        List<Mood> moods = moodService.selectAll();
        if (moods != null) {
           return RetResponse.makeOKRsp(moods);
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
    public RetResult<PageResult> selectPage(Integer start, Integer limit) {
        PageResult pageResult= moodService.selectPage(start, limit);
        if (pageResult != null) {
           return RetResponse.makeOKRsp(pageResult);
        }
        return RetResponse.makeErrRsp("查询失败");
    }
    
}