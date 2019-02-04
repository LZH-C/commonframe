package com.lzh.commonframe.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串。
     *
     * @param data
     * @return
     */
    public static String object2Json(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将json结果集转化为对象
     *
     * @param jsonData json数据
     * @param beanType 对象中的object类型
     * @return
     */
    public static <T> T json2Object(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
