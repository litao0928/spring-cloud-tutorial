package com.waylau.spring.cloud.controller;

import com.waylau.spring.cloud.vo.SeniverseWeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waylau.spring.cloud.service.WeatherDataService;
import com.waylau.spring.cloud.vo.WeatherResponse;

/**
 * 天气控制器.
 * 
 * @since 1.0.0 2017年9月2日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@RestController
@RequestMapping("/weather")	
public class WeatherController {

	@Autowired
	private WeatherDataService weatherDataService;
	
	@GetMapping("/cityId/{cityId}")
	public WeatherResponse getReportByCityId(@PathVariable("cityId") String cityId) {
		return weatherDataService.getDataByCityId(cityId);
	}
	
	@GetMapping("/cityName/{cityName}")
	public WeatherResponse getReportByCityName(@PathVariable("cityName") String cityName) {
		return weatherDataService.getDataByCityName(cityName);
	}

	@GetMapping("/scityName/{cityName}")
	public SeniverseWeatherResponse getSeniverseReportByCityName(@PathVariable("cityName") String cityName) {
		return weatherDataService.getSeniverseDataByCityName(cityName);
	}

}
