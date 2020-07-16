package cn.wx.mzpro.wxentrance.util;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页实体（封装信息）
 */
@Data
public class PageResult<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long total;//总记录数
    private List<T> rows;//每页数据列表

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

}
