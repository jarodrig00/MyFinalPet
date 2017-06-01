package com.softnopal.myfinalpet.restApi;

/**
 * Created by jarodrig00 on 29/05/17.
 */

public final class RestApiConstant {
    public final static String VERSION = "/v1/";
    public final static  String ROOT_URL = "https://api.instagram.com" + VERSION;
    public final static  String ACCESS_TOKEN = "5518916073.eb42f98.b2b27f4ef61a4b919f06c8d5187e58b1";
    public final static  String KEY_ACCESS_TOKEN = "acces_token";
    //public final static  String KEY_GET_INFORMATION_USER = "/search";
    public final static String KEY_USER_SEARCH = "q";
    public final static  String KEY_USER = "users/search/";
    public final static  String KEY_MEDIA = "/media/recent/";
    public final static String URL_USER = ROOT_URL + KEY_USER /* + KEY_GET_INFORMATION_USER + "{user}" +
                                          "&" + KEY_ACCESS_TOKEN + ACCESS_TOKEN*/;
    public final static String KEY_USERM = "users/self";
    public final static String USER_ID = "5518916073";
    public final static String URL_MEDIA =  KEY_USERM  + KEY_MEDIA + "?" + KEY_ACCESS_TOKEN + "=" +
            ACCESS_TOKEN;
}
