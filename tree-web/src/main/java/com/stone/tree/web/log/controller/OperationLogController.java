package com.stone.tree.web.log.controller;

import com.stone.tree.response.PageResult;
import com.stone.tree.response.RetResponse;
import com.stone.tree.response.RetResult;
import com.stone.tree.web.log.bean.OperationLog;
import com.stone.tree.web.log.service.OperationLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OperationLog)控制层
 *
 * @author makejava
 * @since 2021-01-09 14:13:47
 */
@RestController
@RequestMapping("/operationLog")
public class OperationLogController {
    /**
     * 服务对象
     */
    @Resource
    private OperationLogService operationLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param operationLog 参数对象
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RetResult<OperationLog> selectOne(OperationLog operationLog) {
        OperationLog result = operationLogService.selectById(operationLog.getId());
        if(result != null){
           return RetResponse.makeOKRsp(result);
        }
        return RetResponse.makeErrRsp("查询失败");
    }
    
    /**
     * 新增一条数据
     *
     * @param operationLog 实体类
     * @return Response对象
     */
    @PostMapping("insert")
    public RetResult<OperationLog> insert(@RequestBody OperationLog operationLog) {
        int result = operationLogService.insert(operationLog);
        if (result > 0) {
           return RetResponse.makeOKRsp(operationLog);
        }
        return RetResponse.makeErrRsp("新增失败");
    }

    /**
     * 修改一条数据
     *
     * @param operationLog 实体类
     * @return Response对象
     */
    @PostMapping("update")
    public RetResult<OperationLog> update(@RequestBody OperationLog operationLog) {
        OperationLog result = operationLogService.update(operationLog);
        if (result != null) {
           return RetResponse.makeOKRsp(result);
        }
        return RetResponse.makeErrRsp("修改失败");
    }

    /**
     * 删除一条数据
     *
     * @param operationLog 参数对象
     * @return Response对象
     */
    @GetMapping("delete")
    public RetResult<OperationLog> delete(OperationLog operationLog) {
        int result = operationLogService.deleteById(operationLog.getId());
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
    public RetResult<List<OperationLog>> selectAll() {
        List<OperationLog> operationLogs = operationLogService.selectAll();
        if (operationLogs != null) {
           return RetResponse.makeOKRsp(operationLogs);
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
        PageResult pageResult= operationLogService.selectPage(start, limit);
        if (pageResult != null) {
           return RetResponse.makeOKRsp(pageResult);
        }
        return RetResponse.makeErrRsp("查询失败");
    }
    
}