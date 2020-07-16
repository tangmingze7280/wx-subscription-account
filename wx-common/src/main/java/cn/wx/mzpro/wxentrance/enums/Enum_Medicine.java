package cn.wx.mzpro.wxentrance.enums;

/**
 * @Classname Enum_Medicine
 * @Description TODO
 * @Date 2020/5/8 17:08
 * @Created by Tim
 */
public enum Enum_Medicine {

    LIAOXIAO(1, "药品疗效"), LEIBIE(2, "药品类别");

    private Integer id;
    private String name;

    private Enum_Medicine(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * 获取类型名称
     *
     * @param id 类型id
     * @return
     */
    public static String getName(Integer id) {
        for (Enum_Medicine enum_Medicine : Enum_Medicine.values()) {
            if (enum_Medicine.getId() == id) {
                return enum_Medicine.getName();
            }
        }
        return "";
    }
}
