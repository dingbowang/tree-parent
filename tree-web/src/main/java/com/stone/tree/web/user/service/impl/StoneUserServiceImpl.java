package com.stone.tree.web.user.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stone.tree.aop.ServiceException;
import com.stone.tree.enums.BooleanE;
import com.stone.tree.response.PageResult;
import com.stone.tree.util.Md5Util;
import com.stone.tree.util.PageUtil;
import com.stone.tree.util.RedisUtil;
import com.stone.tree.util.UUIDUtil;
import com.stone.tree.web.user.bean.StoneUser;
import com.stone.tree.web.user.bean.StoneUserVO;
import com.stone.tree.web.user.mapper.StoneUserMapper;
import com.stone.tree.web.user.service.StoneUserService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

import static com.stone.tree.constant.TokenConstant.*;

/**
 * 用户(StoneUser表)服务实现类
 *
 * @author dbw
 * @since 2021-01-03 12:50:40
 */
@Service("stoneUserService")
public class StoneUserServiceImpl implements StoneUserService {
    private static final Logger logger = LoggerFactory.getLogger(StoneUserServiceImpl.class);

    @Resource
    private StoneUserMapper stoneUserMapper;

    @Resource
    private RedisUtil redisUtil;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StoneUser selectById(String id) {
        return this.stoneUserMapper.selectById(id);
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
        List<StoneUser> stoneUsers = this.stoneUserMapper.selectPage();
        PageInfo<StoneUser> pageInfo = new PageInfo<>(stoneUsers);
        return PageUtil.pageReturn(pageInfo);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<StoneUser> selectAll() {
        return this.stoneUserMapper.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<StoneUser> selectList(StoneUser stoneUser) {
        return this.stoneUserMapper.selectList(stoneUser);
    }
    
    /**
     * 新增数据
     *
     * @param stoneUser 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(StoneUser stoneUser) {
        if(StringUtils.isBlank(stoneUser.getPassword())){
            throw new ServiceException("用户密码不能为空");
        }
        if(StringUtils.isBlank(stoneUser.getMobile())){
            throw new ServiceException("用户手机号不能为空");
        }
        List<StoneUser> stoneUsers = stoneUserMapper.QueryUserSelective(stoneUser);
        if(CollectionUtils.isNotEmpty(stoneUsers)){
            throw new ServiceException("用户已存在");
        }
        String newPassword = Md5Util.EncoderByMd5(stoneUser.getPassword());
        stoneUser.setId(UUIDUtil.getUUID());
        stoneUser.setPassword(newPassword);
        return this.stoneUserMapper.insertSelective(stoneUser);
    }

    /**
     * 批量新增
     *
     * @param stoneUsers 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<StoneUser> stoneUsers) {
        return this.stoneUserMapper.batchInsert(stoneUsers);
    }

    /**
     * 修改数据
     *
     * @param stoneUser 实例对象
     * @return 实例对象
     */
    @Override
    public StoneUser update(StoneUser stoneUser) {
        this.stoneUserMapper.update(stoneUser);
        return this.selectById(stoneUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(String id) {
        return this.stoneUserMapper.deleteById(id);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.stoneUserMapper.count();
     }

    @Override
    public StoneUserVO queryUserForLogin(StoneUser user) {
        if(StringUtils.isBlank(user.getMobile())){
            throw new ServiceException("手机号为空");
        }
        if(StringUtils.isBlank(user.getPassword())){
            throw new ServiceException("密码为空");
        }
        String password = Md5Util.EncoderByMd5(user.getPassword());
        StoneUser stoneUser = stoneUserMapper.QueryLoginUser(password, user.getMobile());
        if(Objects.isNull(stoneUser)){
            throw new ServiceException("用户名密码不正确");
        }
        if(BooleanE.no.getId().toString().equals(stoneUser.getDelFlag())){
            throw new ServiceException("用户不存在");
        }
        String token = createToken(stoneUser);
        StoneUserVO userVO = new StoneUserVO();
        BeanUtils.copyProperties(stoneUser, userVO);
        userVO.setToken(token);
        return userVO;
    }

    private String createToken(StoneUser stoneUser) {
        logger.info("com.stone.tree.web.user.service.impl-->createToken::stoneUser = [{}]",stoneUser);
        //header信息
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("alg","HS256");
        headerMap.put("typ","JWT");
        JWTCreator.Builder builder = JWT.create();
        builder.withHeader(headerMap);
        //自定义信息
        Map<String, String> payLoadMap = new HashMap<>();
        payLoadMap.put("userId",stoneUser.getId());
        payLoadMap.forEach((x,y)->builder.withClaim(x, y));
        //设置过期时间
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,JWT_TOKEN_TIME);
        Date nowTime = calendar.getTime();
        builder.withExpiresAt(nowTime);
        //设置生效触发时间
        builder.withIssuedAt(new Date());
        //利用密钥生成token
        String token = builder.sign(Algorithm.HMAC256(SECRET_KEY));
        if(StringUtils.isNotBlank(token)){
            redisUtil.set(stoneUser.getId(),token,TOKEN_TIME);
        }
        return token;
    }

    @Override
    public void loginOUt(String token) {
        //根据token拿到userId
        DecodedJWT decode = JWT.decode(token);
        Map<String, Claim> claims = decode.getClaims();
        String userId = claims.get("userId").asString();
        redisUtil.del(userId);
    }
}