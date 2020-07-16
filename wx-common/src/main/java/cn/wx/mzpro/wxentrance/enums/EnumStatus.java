package cn.wx.mzpro.wxentrance.enums;

/**
 * @Classname Enum_Medicine
 * @Description TODO
 * @Date 2020/5/8 17:08
 * @Created by Tim
 */
public enum EnumStatus {
    CHECKPENDING(0,"待审核"),
    PASS(1,"审核通过"),
    NOPASS(-1,"未通过"),
    DELETE(-100,"审核删除");
    private Integer code;
    private String typeName;

    EnumStatus(Integer code, String typeName) {
        this.code = code;
        this.typeName = typeName;
    }

    public Integer getCode() {
        return code;
    }

    public String getTypeName() {
        return typeName;
    }

    public static String getNameByCode(Integer code){
        for (EnumStatus e : EnumStatus.values()) {
            if (e.getCode().equals(code)){
                return e.getTypeName();
            }
        }
        return null;
    }
}
