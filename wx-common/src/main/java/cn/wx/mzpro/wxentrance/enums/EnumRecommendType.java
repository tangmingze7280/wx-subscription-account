package cn.wx.mzpro.wxentrance.enums;

public enum EnumRecommendType {
       HOSPITAL(1,"医院"),
    DEPARTMENTS(2,"科室"),
    DOCTOR(3,"医生"),
    DISEASE(4,"疾病"),
    MEDICINE(5,"药品"),
    INSTRUMENT(6,"器械"),
    SYMPTOM(7,"症状"),
    PHARMACEUTICALENTERPRISES(8,"药企"),
    DRUGSTORE(9,"药店"),
    CHINESEMEDICINE(10,"中药"),
    HEALTHPRODUCTS(13,"保健品"),
    OUTPUTLINK(20,"外链")
    ;
    private Integer value;

    private String name;

    EnumRecommendType(Integer type, String desc) {
        this.value = type;
        this.name = desc;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    /**
     * 根据value值获取枚举对象
     * @param value
     * @return
     */
    public static EnumRecommendType getOperateType(Integer value){
        EnumRecommendType[] instances = EnumRecommendType.values();
        for(EnumRecommendType instance : instances){
            if(instance.getValue() == value){
                return instance;
            }
        }
        return null;
    }
}
