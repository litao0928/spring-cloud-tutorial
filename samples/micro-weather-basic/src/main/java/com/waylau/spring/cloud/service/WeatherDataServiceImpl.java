/**
 * 
 */
package com.waylau.spring.cloud.service;

import java.io.IOException;

import com.waylau.spring.cloud.vo.SeniverseWeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waylau.spring.cloud.vo.WeatherResponse;

/**
 * 天气数据服务.
 * 
 * @since 1.0.0 2017年9月2日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

	@Autowired
	private RestTemplate restTemplate;

	private final String WEATHER_API = "https://api.seniverse.com/v3/weather/daily.json";
	//https://api.seniverse.com/v3/weather/daily.json?key=【你的_api_key】&location=beijing&language=zh-Hans&unit=c&start=-1&days=5
    private final String API_KEY = "S8ZWSnNNjXmY3gnqD";

	public SeniverseWeatherResponse getSeniverseDataByCityName(String cityName){
		String uri = WEATHER_API + "?key=" + API_KEY + "&location=" + cityName + "&language=zh-Hans&unit=c&start=-1&days=5";
		return this.doGetSeniverseWeatherData(uri);
	}

	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		String uri = WEATHER_API + "?citykey=" + cityId;
		return this.doGetWeatherData(uri);
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {
		String uri = WEATHER_API + "?key=" + API_KEY + "&location=" + cityName + "&language=zh-Hans&unit=c&start=-1&days=5";
		return this.doGetWeatherData(uri);
	}

	private WeatherResponse doGetWeatherData(String uri) {
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		String strBody = null;

		if (response.getStatusCodeValue() == 200) {
			strBody = response.getBody();
		}

		ObjectMapper mapper = new ObjectMapper();
		WeatherResponse weather = null;

		try {
			weather = mapper.readValue(strBody, WeatherResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return weather;
	}

	private SeniverseWeatherResponse doGetSeniverseWeatherData(String uri) {
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		String strBody = null;

		if (response.getStatusCodeValue() == 200) {
			strBody = response.getBody();
		}

		ObjectMapper mapper = new ObjectMapper();
		SeniverseWeatherResponse weather = null;

		try {
			weather = mapper.readValue(strBody, SeniverseWeatherResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return weather;
	}

}
