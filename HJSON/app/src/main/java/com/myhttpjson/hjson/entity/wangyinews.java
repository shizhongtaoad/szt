package com.myhttpjson.hjson.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/8/26.
 */
public class wangyinews {

    List<wangyinews> data;
    private String message;
    private int status;

    public wangyinews(String message, int status, List<wangyinews> data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }



    @Override
    public String toString() {
        return "News{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", data=" + data +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<wangyinews> getData() {
        return data;
    }

    public void setData(List<wangyinews> data) {
        this.data = data;
    }




    }