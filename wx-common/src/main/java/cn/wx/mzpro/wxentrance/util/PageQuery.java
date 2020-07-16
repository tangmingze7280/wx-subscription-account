package cn.wx.mzpro.wxentrance.util;

/**
 * Created by tim on 2020.03.27
 */

import com.google.common.base.Splitter;

import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import java.io.Serializable;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageQuery implements Serializable {
	private static final long serialVersionUID = -1890450930329384339L;
	final Logger logger = LoggerFactory.getLogger(PageQuery.class);
	private int page;
	private int size;
	private String filter;
	private Map map;

	public Map<String, String> convertFilterToMap() {
		if (StringUtils.isEmpty(this.filter)) {
			return new HashMap<>();
		} else {
			try {
				// 解码filter
				String decode = URLDecoder.decode(this.filter, "utf-8");
				List<String> list = Splitter.on(";").omitEmptyStrings().trimResults().splitToList(decode);
				if (CollectionUtils.isEmpty(list)) {
					return new HashMap<>();
				} else {
					HashMap<String, String> map = new HashMap<>();
					Iterator<String> var3 = list.iterator();

					while (var3.hasNext()) {
						String s = (String) var3.next();
						List<String> item = Splitter.on("=").limit(2).omitEmptyStrings().trimResults().splitToList(s);
						if (item.size() == 2) {
							map.put(item.get(0), item.get(1));
						}
					}

					return map;
				}
			} catch (Exception e) {
				logger.error("convertFilterToMap", e);
				return new HashMap<>();
			}
		}
	}

}
