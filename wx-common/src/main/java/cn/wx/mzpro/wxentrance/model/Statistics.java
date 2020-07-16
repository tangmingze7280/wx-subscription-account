package cn.wx.mzpro.wxentrance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Classname Statistics
 * @Description TODO
 * @Date 2020/6/12 11:13
 * @Created by Tim
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistics implements Serializable {

    /**
     * 待审核总数
     */
    private int countAudit;

    /**
     * （审核通过）
     */
    private int countYesAudit;

    /**
     * 待回收（审核不通过）
     */
    private int countNoAudit;

    /**
     * 已发布
     */
    private int countYesPublish;

    /**
     * 待发布
     */
    private int countPublish;

    /**
     * 已删除
     */
    private int countdelete;

    /**
     * 百度累计推送量
     */
    private int countBaidu;

    /**
     * 头条累计推送量
     */
    private int countToutiao;

    /**
     * 神马累计推送量
     */
    private int countShenma;

    /**
     * 腾讯累计推送量
     */
    private int countTencent;

    /**
     * 搜狗累计推送量
     */
    private int countSogou;

    /**
     * 全视频总量
     */
    private int countNum;

    /**
     * 推送总量
     */
    private int countPush;

    private String[] type;

    private int[] num;

    private List<Map<String,Object>> pieList;
}
