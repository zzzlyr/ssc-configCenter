package com.yonyou.ssc.mapper;

import com.yonyou.ssc.entry.Hotel;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by zhangzza on 2017/3/2.
 * @Mapper 这个注解 直接去HotelMapper.xml namespace 属性对应 selectByCityId 和接口中
 * 方法相同才能找的到
 */
@Mapper
public interface HotelMapper {

    /**
     *这个方法名要和 mapper.xml文件中相同
     * @return hotel
     * @throws Exception
     */
    public Hotel selectHotelByCityId(long id)throws Exception;

    public  long saveHotel(Hotel hotel)throws Exception;
}
