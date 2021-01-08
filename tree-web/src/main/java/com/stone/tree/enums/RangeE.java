package com.stone.tree.enums;

/**
 * @author dbw
 * @date 2021/01/08/4:36 下午
 * @Description
 */
public enum RangeE {

    pub(1, "公开"),
    fri(2, "好友"),
    pri(3, "隐私");



    RangeE(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static RangeE getById(Integer id){
        if(id == null){
            return null;
        }
        for(RangeE e : RangeE.values()){
            if(e.getId().equals(id)){
                return e;
            }
        }
        return null;
    }

    /**
     * 根据Code获取Value
     *
     * @param code 键
     * @return 值
     */
    public static String getDescByCode(Integer code)
    {
        for(RangeE enums : RangeE.values())
        {
            if(enums.id.equals(code))
            {
                return enums.name;
            }
        }
        return "";
    }
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
