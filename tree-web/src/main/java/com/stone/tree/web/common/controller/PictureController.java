package com.stone.tree.web.common.controller;

import com.stone.tree.response.PageResult;
import com.stone.tree.response.RetResponse;
import com.stone.tree.response.RetResult;
import com.stone.tree.web.common.bean.Picture;
import com.stone.tree.web.common.service.PictureService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Picture)控制层
 *
 * @author makejava
 * @since 2021-01-10 13:50:03
 */
@RestController
@RequestMapping("/picture")
public class PictureController {
    /**
     * 服务对象
     */
    @Resource
    private PictureService pictureService;

    /**
     * 通过主键查询单条数据
     *
     * @param picture 参数对象
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RetResult<Picture> selectOne(Picture picture) {
        Picture result = pictureService.selectById(picture.getId());
        if(result != null){
           return RetResponse.makeOKRsp(result);
        }
        return RetResponse.makeErrRsp("查询失败");
    }
    
    /**
     * 新增一条数据
     *
     * @param picture 实体类
     * @return Response对象
     */
    @PostMapping("insert")
    public RetResult<Picture> insert(@RequestBody Picture picture) {
        int result = pictureService.insert(picture);
        if (result > 0) {
           return RetResponse.makeOKRsp(picture);
        }
        return RetResponse.makeErrRsp("新增失败");
    }

    /**
     * 修改一条数据
     *
     * @param picture 实体类
     * @return Response对象
     */
    @PostMapping("update")
    public RetResult<Picture> update(@RequestBody Picture picture) {
        Picture result = pictureService.update(picture);
        if (result != null) {
           return RetResponse.makeOKRsp(result);
        }
        return RetResponse.makeErrRsp("修改失败");
    }

    /**
     * 删除一条数据
     *
     * @param picture 参数对象
     * @return Response对象
     */
    @GetMapping("delete")
    public RetResult<Picture> delete(Picture picture) {
        int result = pictureService.deleteById(picture.getId());
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
    public RetResult<List<Picture>> selectAll() {
        List<Picture> pictures = pictureService.selectAll();
        if (pictures != null) {
           return RetResponse.makeOKRsp(pictures);
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
        PageResult pageResult= pictureService.selectPage(start, limit);
        if (pageResult != null) {
           return RetResponse.makeOKRsp(pageResult);
        }
        return RetResponse.makeErrRsp("查询失败");
    }
    
}