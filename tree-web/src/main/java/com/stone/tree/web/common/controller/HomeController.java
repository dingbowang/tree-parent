package com.stone.tree.web.common.controller;

import com.stone.tree.response.RetResponse;
import com.stone.tree.response.RetResult;
import com.stone.tree.web.common.bean.HomeInfoVO;
import com.stone.tree.web.common.service.HomeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;


    //@OperLog(operModule = USERTYPE,operType = ADD,operDesc = "用户注册")
    @ApiOperation(value = "主页数据")
    @GetMapping("base")
    public RetResult<HomeInfoVO> selectOne() {

        HomeInfoVO homeInfo = homeService.getHomeInfo();
        return RetResponse.makeOKRsp(homeInfo);
    }
}
