package com.stone.tree.enums;

/**
 * @author dbw
 * @date 2021/01/04/3:03 下午
 * @Description
 */
public enum BooleanE {

    yes(1, "正常"),
    no(0, "删除");



    BooleanE(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static BooleanE getById(Integer id){
        if(id == null){
            return null;
        }
        for(BooleanE e : BooleanE.values()){
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
        for(BooleanE enums : BooleanE.values())
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
