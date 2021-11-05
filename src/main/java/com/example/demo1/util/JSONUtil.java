package com.example.demo1.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class JSONUtil {

    private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    private static final Gson exposeGson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
            .excludeFieldsWithoutExposeAnnotation().create();

    public static Gson getGson() {
        return gson;
    }

    public static <T> T parseObject(String text, Class<T> clazz) {
        return gson.fromJson(text, clazz);
    }

    public static String toJSONString(Object object) {
        return gson.toJson(object);
    }

    public static <T> T exposeParseObject(String text, Class<T> clazz) {
        return gson.fromJson(text, clazz);
    }

    public static String exposeToJSONString(Object object) {
        return gson.toJson(object);
    }

    /**
     * 对比两个json字符串，允许顺序不一致
     * @param s1
     * @param s2
     * @return
     */
    public static boolean compareJsonEqual(String s1, String s2) {
        JsonParser parser = new JsonParser();
        JsonObject obj = (JsonObject) parser.parse(s1);
        JsonParser parser1 = new JsonParser();
        JsonObject obj1 = (JsonObject) parser1.parse(s2);
        return obj.equals(obj1);
    }

}
