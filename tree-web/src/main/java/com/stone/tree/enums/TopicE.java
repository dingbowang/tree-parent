package com.stone.tree.enums;

/**
 * @author dbw
 * @date 2021/01/08/4:40 下午
 * @Description
 */
public enum TopicE {

    live(1, "日常"),
    study(2, "学习"),
    fun(3, "娱乐");



    TopicE(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static TopicE getById(Integer id){
        if(id == null){
            return null;
        }
        for(TopicE e : TopicE.values()){
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
        for(TopicE enums : TopicE.values())
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
