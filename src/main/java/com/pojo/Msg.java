package com.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张志强
 * @creat 2022/4/19-15:43
 * @Titile :Msg
 * @ProjectName ssm
 * @Description :TODO
 */


public class   Msg {
   //状态码
    private  int status;
  //提示信息
    private String msg;
   //数据
    private Map<String,Object> extend = new HashMap<>();


    private Msg() {
    }


    public static Msg success(){
        Msg msg = new Msg();
        msg.setStatus(100);
        msg.setMsg("处理成功!");
        return msg;
    }

    public static Msg fail() {
        Msg msg = new Msg();
        msg.setStatus(200);
        msg.setMsg("处理失败!");
        return msg;
    }

    public Msg add(String key,Object obj){
       this.getExtend().put(key,obj);
       return this;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", extend=" + extend +
                '}';
    }
}
