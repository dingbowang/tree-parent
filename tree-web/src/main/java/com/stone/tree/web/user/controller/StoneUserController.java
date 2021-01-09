package com.stone.tree.web.user.controller;

import com.stone.tree.annotate.OperLog;
import com.stone.tree.response.PageResult;
import com.stone.tree.response.RetResponse;
import com.stone.tree.response.RetResult;
import com.stone.tree.util.FastDFSUtil;
import com.stone.tree.web.user.bean.StoneUser;
import com.stone.tree.web.user.service.StoneUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

import static com.stone.tree.constant.OperTypeConstant.*;

/**
 * 用户(StoneUser)控制层
 *
 * @author dbw
 * @since 2021-01-03 12:50:40
 * @ApiImplicitParams({
 *             @ApiImplicitParam(paramType = "query",name = "userName",value = "用户名",required =true,dataType = "String"),
 *             @ApiImplicitParam(paramType = "query",name = "password",value = "密码",required =true,dataType = "String")
 *
 *     })
 */
@RestController
@RequestMapping("/stoneUser")
@Api(value = "用户管理",description = "用户信息的增删改查")
public class StoneUserController {
    private static final Logger logger = LoggerFactory.getLogger(StoneUserController.class);
    /**
     * 服务对象
     */
    @Resource
    private StoneUserService stoneUserService;

    @Autowired
    private FastDFSUtil fastDFSUtil;


    @GetMapping("test")
    public RetResult<StoneUser> selectOne() {
        return RetResponse.makeRsp(200,"Hello World");
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("register")
    @OperLog(operModule = USERTYPE,operType = ADD,operDesc = "用户注册")
    @ApiOperation(value = "用户注册", notes="姓名，手机号，密码必填")
    public RetResult<StoneUser> register(StoneUser user){
        int insert = stoneUserService.insert(user);
        if(insert == 1){
            return RetResponse.makeOKRsp();
        }
        return RetResponse.makeErrRsp("新增失败");
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping("login")
    @OperLog(operModule = USERTYPE,operType = QUERY,operDesc = "用户登录")
    public RetResult<StoneUser> login(StoneUser user){
        StoneUser stoneUser = stoneUserService.queryUser(user);
        if(stoneUser != null){
            return RetResponse.makeOKRsp(stoneUser);
        }
        return RetResponse.makeErrRsp("查询失败");
    }


    /**
     * 通过主键查询单条数据
     *
     * @param stoneUser 参数对象
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RetResult<StoneUser> selectOne(StoneUser stoneUser) {
        StoneUser result = stoneUserService.selectById(stoneUser.getId());
        if(result != null){
           return RetResponse.makeOKRsp(result);
        }
        return RetResponse.makeErrRsp("查询失败");
    }
    
    /**
     * 新增一条数据
     *
     * @param stoneUser 实体类
     * @return Response对象
     */
   /* @PostMapping("insert")
    public RetResult<StoneUser> insert(@RequestBody StoneUser stoneUser) {
        int result = stoneUserService.insert(stoneUser);
        if (result > 0) {
           return RetResponse.makeOKRsp(stoneUser);
        }
        return RetResponse.makeErrRsp("新增失败");
    }*/

    /**
     * 修改一条数据
     *
     * @param stoneUser 实体类
     * @return Response对象
     */
    @PostMapping("update")
    public RetResult<StoneUser> update(@RequestBody StoneUser stoneUser) {
        StoneUser result = stoneUserService.update(stoneUser);
        if (result != null) {
           return RetResponse.makeOKRsp(result);
        }
        return RetResponse.makeErrRsp("修改失败");
    }

    /**
     * 删除一条数据
     *
     * @param stoneUser 参数对象
     * @return Response对象
     */
    @GetMapping("delete")
    public RetResult<StoneUser> delete(StoneUser stoneUser) {
        int result = stoneUserService.deleteById(stoneUser.getId());
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
    public RetResult<List<StoneUser>> selectAll() {
        List<StoneUser> stoneUsers = stoneUserService.selectAll();
        if (stoneUsers != null) {
           return RetResponse.makeOKRsp(stoneUsers);
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
        PageResult pageResult = stoneUserService.selectPage(start, limit);
        if (pageResult != null) {
           return RetResponse.makeOKRsp(pageResult);
        }
        return RetResponse.makeErrRsp("查询失败");
    }

    @PostMapping("uploadPic")
    public RetResult<StoneUser>  uploadPic(MultipartFile file) throws IOException {
        String upload = fastDFSUtil.upload(file);
        logger.info("地址："+upload);
        return RetResponse.makeOKRsp();
    }

    @GetMapping("deleteFile")
    public RetResult<StoneUser>  deleteFile(String uri) throws IOException {
        fastDFSUtil.deleteFile(uri);
        return RetResponse.makeOKRsp();
    }

}