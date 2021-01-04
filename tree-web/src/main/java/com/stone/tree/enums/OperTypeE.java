package com.stone.tree.enums;

/**
 * @author dbw
 * @date 2021/01/03/5:47 下午
 * @Description
 */
public enum OperTypeE {

    add(1, "新增"),
    delete(2, "删除"),
    update(3, "更新"),
    query(4, "查询");



    OperTypeE(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static OperTypeE getById(Integer id){
        if(id == null){
            return null;
        }
        for(OperTypeE e : OperTypeE.values()){
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
        for(OperTypeE enums : OperTypeE.values())
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
