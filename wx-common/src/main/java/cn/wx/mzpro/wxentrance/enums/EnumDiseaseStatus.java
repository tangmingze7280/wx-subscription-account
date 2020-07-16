package cn.wx.mzpro.wxentrance.enums;

public enum EnumDiseaseStatus {
    CHECKPENDING(0,"待审核"),
    EFFECTIVITY(1,"有效"),
    DELETE(-100,"删除");
    private Integer code;
    private String typeName;

    EnumDiseaseStatus(Integer code, String typeName) {
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
        for (EnumDiseaseStatus e : EnumDiseaseStatus.values()) {
            if (e.getCode().equals(code)){
                return e.getTypeName();
            }
        }
        return null;
    }
}
