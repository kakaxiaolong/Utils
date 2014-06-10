package com.lxl.uustock_android_utils;

import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;


/**
 * <strong>HttpRequest</strong><br/>
 * <ul>
 * <strong>Constructor</strong>
 * <li>{@link HttpRequest#HttpRequest(String)}</li>
 * <li>{@link HttpRequest#HttpRequest(String, Map)}</li>
 * </ul>
 * <ul>
 * <strong>Setting</strong>
 * <li>{@link #setConnectTimeout(int)}</li>
 * <li>{@link #setReadTimeout(int)}</li>
 * <li>{@link #setParasMap(Map)}</li>
 * <li>{@link #setUserAgent(String)}</li>
 * <li>{@link #setRequestProperty(String, String)}</li>
 * <li>{@link #setRequestPropertys(Map)}</li>
 * </ul>
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2013-5-12
 */
public class HttpRequest {

    private String              url;
    private int                 connectTimeout;
    private int                 readTimeout;
    private Map<String, String> parasMap;
    private Map<String, String> requestPropertys;

    public HttpRequest(String url){
        this.url = url;
        this.connectTimeout = -1;
        this.readTimeout = -1;
        requestPropertys = new HashMap<String, String>();
    }

    public HttpRequest(String url, Map<String, String> parasMap){
        this.url = url;
        this.parasMap = parasMap;
        this.connectTimeout = -1;
        this.readTimeout = -1;
        requestPropertys = new HashMap<String, String>();
    }

    public String getUrl() {
        return url;
    }

    /**
     * @return
     * @see URLConnection#getConnectTimeout()
     */
    public int getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * @param timeoutMillis
     * @see URLConnection#setConnectTimeout(int)
     */
    public void setConnectTimeout(int timeoutMillis) {
        if (timeoutMillis < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        connectTimeout = timeoutMillis;
    }

    /**
     * @return
     * @see URLConnection#getReadTimeout()
     */
    public int getReadTimeout() {
        return readTimeout;
    }

    /**
     * @param timeoutMillis
     * @see URLConnection#setReadTimeout(int)
     */
    public void setReadTimeout(int timeoutMillis) {
        if (timeoutMillis < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        readTimeout = timeoutMillis;
    }

    /**
     * get paras map
     * 
     * @return
     */
    public Map<String, String> getParasMap() {
        return parasMap;
    }

    /**
     * set paras map
     * 
     * @param parasMap
     */
    public void setParasMap(Map<String, String> parasMap) {
        this.parasMap = parasMap;
    }

    /**
     * @return paras as string
     */
    public String getParas() {
        return HttpUtils.joinParas(parasMap);
    }

    /**
     * @param field
     * @param newValue
     * @see URLConnection#setRequestProperty(String, String)
     */
    public void setRequestProperty(String field, String newValue) {
        requestPropertys.put(field, newValue);
    }

    /**
     * @param field
     * @see URLConnection#getRequestProperty(String)
     */
    public String getRequestProperty(String field) {
        return requestPropertys.get(field);
    }

    /**
     * same to {@link #setRequestProperty(String, String)} filed is User-Agent
     * 
     * @param value
     * @see URLConnection#setRequestProperty(String, String)
     */
    public void setUserAgent(String value) {
        requestPropertys.put("User-Agent", value);
    }

    /**
     * @return
     */
    public Map<String, String> getRequestPropertys() {
        return requestPropertys;
    }

    /**
     * @param requestPropertys
     */
    public void setRequestPropertys(Map<String, String> requestPropertys) {
        this.requestPropertys = requestPropertys;
    }
}
