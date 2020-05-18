package com.sxlg.goblet.store.deserialization;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSONTransform  {
    private static final Logger logger = LoggerFactory.getLogger(JSONTransform.class);

    /**
     * 将Json字符串转化为 JavaObject
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T StringToObject(String json, Class<T> clazz) {
        if (json == null) throw new NullPointerException("json is null");
        if (clazz == null) throw new NullPointerException("clazz is null");
        JSONObject jsonObject = null;
        jsonObject = JSONObject.parseObject(json);

       try{
           return JSON.toJavaObject(jsonObject, clazz);
       }catch (IllegalArgumentException e){
           logger.error("Json string conversion Java Object failed", e);
       }
        return null;
    }
}
