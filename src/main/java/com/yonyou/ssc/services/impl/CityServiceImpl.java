package com.yonyou.ssc.services.impl;

import com.yonyou.ssc.entry.City;
import com.yonyou.ssc.entry.Hotel;
import com.yonyou.ssc.mapper.CityMapper;
import com.yonyou.ssc.mapper.HotelMapper;
import com.yonyou.ssc.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/3/1.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public City selectByCityId(long city_id)throws Exception {
        return cityMapper.selectCityById(city_id);
    }

    /**
     * 测试下事物 通过
     * @param city
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public int saveCity(City city) throws Exception {
        Hotel hotel=new Hotel();
        hotel.setName("=====222");
        hotel.setAddress("yyyyyy222");
        hotel.setZip("iiiiiiiiii222");
        hotelMapper.saveHotel(hotel);
        Long.parseLong("ttt");
        return cityMapper.saveCity(city);
    }
}
