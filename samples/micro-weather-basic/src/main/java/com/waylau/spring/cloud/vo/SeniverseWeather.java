package com.waylau.spring.cloud.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
/**
 * 天气信息.
 * 
 * @since 1.0.0 2017年4月29日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public class SeniverseWeather implements Serializable {
	 
	private static final long serialVersionUID = 1L;

	private SeniverseLocation location;
	private List<SeniverseForecast> daily;
	private Date last_update;
	public void setLocation(SeniverseLocation location) {
		this.location = location;
	}
	public SeniverseLocation getLocation() {
		return location;
	}

	public void setDaily(List<SeniverseForecast> daily) {
		this.daily = daily;
	}
	public List<SeniverseForecast> getDaily() {
		return daily;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
	public Date getLast_update() {
		return last_update;
	}
}
