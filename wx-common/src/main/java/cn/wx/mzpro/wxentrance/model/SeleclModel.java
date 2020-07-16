package cn.wx.mzpro.wxentrance.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: mcn-video
 * @description:
 * @author: tmz
 * @create: 2020-06-03 17:37
 */
@Data
@AllArgsConstructor
public class SeleclModel implements Serializable {
    private String value;
    private Integer code;
    private String importNum;

    public SeleclModel(String value, Integer code) {
        this.value = value;
        this.code = code;
    }

    public SeleclModel(String value, String importNum) {
        this.value = value;
        this.importNum = importNum;
    }
}
