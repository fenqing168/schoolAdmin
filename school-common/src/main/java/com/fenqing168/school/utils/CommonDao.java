package com.fenqing168.school.utils;

import java.util.List;
import java.util.Map;

/**
 * 公共的dao接口，声明一些公共方法
 * @param <T>
 */
public interface CommonDao<T> {

    /**
     * 无参，查询全部
     * @return
     */
    List<T> queryAllList();

    /**
     * 通过javabean做参数查询对象
     * @param t
     * @return
     */
    T queryObjectByBean(T t);

    /**
     * 通过吧数据封装到map查询对象
     * @param map
     * @return
     */
    T queryObjectByMap(Map<String, Object> map);

}
