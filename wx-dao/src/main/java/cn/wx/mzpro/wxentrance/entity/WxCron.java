package cn.wx.mzpro.wxentrance.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.*;

/**
 * <p>
    * 
    * </p>
 *
 * @author 
 * @since 2020-07-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@TableName("[wx_cron]")
public class WxCron extends Model<WxCron> {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String cron;

    private Integer cronOrder;

    private Date createDate;

    private Date modityDate;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}