package edu.team.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Created by ljl on 2017/11/2.
 * 数据格式封装类
 * 主要用于规范后台返回数据以及浏览器请求的数据格式
 */
public class Message {
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";
    // 状态码
    private int ret;
    // 内容体
    private Object data;
    // 携带信息
    private String msg;

    public Message() {
    }

    public Message(Object data) {
        this.ret = 200;
        this.data = data;
        this.msg = SUCCESS;
    }

    public Message(int ret, String msg){
        this.ret = ret;
        this.msg = msg;
    }

    public Message(int ret, Object data, String msg) {
        this.ret = ret;
        this.data = data;
        this.msg = msg;
    }

    // 返回错误对象
    public static Message errorMessage(){
        return new Message(500,ERROR);
    }

    public static Message errorMessage(String msg){
        return new Message(500,msg);
    }

    // 返回成功对象
    public static Message successMessage(Object object){
        return new Message(200, object, SUCCESS);
    }

    public static Message successMessageEx(Object object) {
        return successMessage(object, false);
    }

    public static Message successMessage(Object object, Boolean deepOutputSwitch){
        JSONArray jsonArray= (JSONArray) JSONArray.fromObject(object);
        JSONArray outJsonArray = new JSONArray();

        if (deepOutputSwitch) {
            return successMessage(object);
        } else {
            for (int i = 0; i < jsonArray.size(); i++) {
                System.out.println(jsonArray.get(i));
                JSONObject jsonData = (JSONObject) jsonArray.get(i);//得到对象中的第i条记录
                jsonData.remove("primaryKey");
                jsonData.remove("properties");
                jsonData.remove("tableName");

                outJsonArray.add(jsonData);
            }
            return successMessage(outJsonArray);
        }
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "{" +
                "ret=" + ret +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
