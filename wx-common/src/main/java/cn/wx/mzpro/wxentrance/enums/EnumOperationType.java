package cn.wx.mzpro.wxentrance.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author tmz
 * @description 操作类型
 * @date 11:07 2020/6/3
 */
@AllArgsConstructor
@NoArgsConstructor
public enum EnumOperationType {
    EXPORT("导出", 0),
    PUSH("推发", 1),
    IMPORT("导入", 2),
    DOWNLOAD("下载", 3),
    PUSTASK("发布到ASK", 4),
    TEST("测试", 5),
    CHECK("审核", 6),
    DELETE("删除",7);
    private String name;
    private Integer code;

    public String getName() {
        return name;
    }

    public EnumOperationType setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public EnumOperationType setCode(Integer code) {
        this.code = code;
        return this;
    }

    public static EnumOperationType getOperationTypeByCode(Integer code) {
        EnumOperationType[] instances = EnumOperationType.values();
        for (EnumOperationType instance : instances) {
            if (instance.getCode().equals(code)) {
                return instance;
            }
        }
        return null;
    }
    public static EnumOperationType getEnum(String name){
        EnumOperationType[] instances = EnumOperationType.values();
        for (EnumOperationType instance : instances) {
            if (instance.getName().equals(name)) {
                return instance;
            }
        }
        return null;
    }
}
