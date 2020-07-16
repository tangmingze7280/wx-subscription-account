package cn.wx.mzpro.wxentrance.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public enum EnumPushType {
    baidu("0","百度")
    ,toutiao("1","头条")
    ,tengxun("2","腾讯")
    ,sougou("3","搜狗")
    ,shenma("4","神马")
    ;
    private String value;
    private String name;

    public String getValue() {
        return value;
    }

    public EnumPushType setValue(String value) {
        this.value = value;
        return this;
    }

    public String getName() {
        return name;
    }

    public EnumPushType setName(String name) {
        this.name = name;
        return this;
    }

    public static EnumPushType getTypeByCode(String code) {
        EnumPushType[] instances = EnumPushType.values();
        for (EnumPushType instance : instances) {
            if (instance.getValue().equals(code)) {
                return instance;
            }
        }
        return null;
    }
    public static EnumPushType getEnum(String name){
        EnumPushType[] instances = EnumPushType.values();
        for (EnumPushType instance : instances) {
            if (instance.getName().equals(name)) {
                return instance;
            }
        }
        return null;
    }
}
