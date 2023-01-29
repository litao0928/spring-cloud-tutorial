package com.waylau.spring.cloud.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 返回消息对象.
 * 
 * @since 1.0.0 2017年9月2日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class SeniverseWeatherResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<SeniverseWeather> results; // 消息数据


	public List<SeniverseWeather> getResults() {
		return results;
	}
	//getResults 不能写成getdata

	public void setResults(List<SeniverseWeather> results) {
		this.results = results;
	}

}
