package com.stone.tree.web.log.controller;

import com.stone.tree.response.PageResult;
import com.stone.tree.response.RetResponse;
import com.stone.tree.response.RetResult;
import com.stone.tree.web.log.bean.ExceptionLog;
import com.stone.tree.web.log.service.ExceptionLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ExceptionLog)控制层
 *
 * @author makejava
 * @since 2021-01-09 14:09:16
 */
@RestController
@RequestMapping("/exceptionLog")
public class ExceptionLogController {
    /**
     * 服务对象
     */
    @Resource
    private ExceptionLogService exceptionLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param exceptionLog 参数对象
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RetResult<ExceptionLog> selectOne(ExceptionLog exceptionLog) {
        ExceptionLog result = exceptionLogService.selectById(exceptionLog.getId());
        if(result != null){
           return RetResponse.makeOKRsp(result);
        }
        return RetResponse.makeErrRsp("查询失败");
    }
    
    /**
     * 新增一条数据
     *
     * @param exceptionLog 实体类
     * @return Response对象
     */
    @PostMapping("insert")
    public RetResult<ExceptionLog> insert(@RequestBody ExceptionLog exceptionLog) {
        int result = exceptionLogService.insert(exceptionLog);
        if (result > 0) {
           return RetResponse.makeOKRsp(exceptionLog);
        }
        return RetResponse.makeErrRsp("新增失败");
    }

    /**
     * 修改一条数据
     *
     * @param exceptionLog 实体类
     * @return Response对象
     */
    @PostMapping("update")
    public RetResult<ExceptionLog> update(@RequestBody ExceptionLog exceptionLog) {
        ExceptionLog result = exceptionLogService.update(exceptionLog);
        if (result != null) {
           return RetResponse.makeOKRsp(result);
        }
        return RetResponse.makeErrRsp("修改失败");
    }

    /**
     * 删除一条数据
     *
     * @param exceptionLog 参数对象
     * @return Response对象
     */
    @GetMapping("delete")
    public RetResult<ExceptionLog> delete(ExceptionLog exceptionLog) {
        int result = exceptionLogService.deleteById(exceptionLog.getId());
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
    public RetResult<List<ExceptionLog>> selectAll() {
        List<ExceptionLog> exceptionLogs = exceptionLogService.selectAll();
        if (exceptionLogs != null) {
           return RetResponse.makeOKRsp(exceptionLogs);
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
        PageResult pageResult= exceptionLogService.selectPage(start, limit);
        if (pageResult != null) {
           return RetResponse.makeOKRsp(pageResult);
        }
        return RetResponse.makeErrRsp("查询失败");
    }
    
}