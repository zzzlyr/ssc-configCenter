
package com.yonyou.ssc.mapper;

import com.yonyou.ssc.entry.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author zhangzza @Mapper
 * 这个mybaits 包名必需是mapper才能扫描到，这是不是约定优于配置啊
 */
@Mapper
public interface CityMapper {

	public City selectCityById(long id) throws Exception;

	public int  saveCity(City city) throws Exception;

}
