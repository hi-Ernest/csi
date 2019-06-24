package edu.team.util;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import edu.team.util.JsonDateValueProcessor;

import java.util.Date;

/**
 * Created by sheriff on 2017/11/14.
 * 主要用于构造不同的消息
 */
public class MessageFactory {
    private static JsonConfig jsonConfig = new JsonConfig();
    static {
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
    }

    public static String getMessage(Object obj){
        Message message;
        try{
            message = Message.successMessageEx(obj);
        }catch (Exception e){
            message = Message.errorMessage();
            return JSONObject.fromObject(message).toString();
        }
        return JSONObject.fromObject(message, jsonConfig).toString();
    }

    public static String getMessage(Object obj, Object param){
        Message message = null;
        if (param == null){
            message = Message.errorMessage("参数为空！");
        }else{
            try {
                message = Message.successMessageEx(obj);
            }catch (Exception e){
                message = Message.errorMessage();
                return  JSONObject.fromObject(message, jsonConfig).toString();
            }
        }
        return  JSONObject.fromObject(message, jsonConfig).toString();
    }

    /**
     * 返回对象的的消息
     * @param obj 对象
     * @return
     */
    public static String getMessageObj(Object obj){
        Message message = null;
        try{
            message = Message.successMessage(obj);
        }catch (Exception e){
            message = Message.errorMessage();
            return JSONObject.fromObject(message, jsonConfig).toString();
        }
        return JSONObject.fromObject(message, jsonConfig).toString();
    }


    /**
     * 校验入参的返回对象的消息
     * @param obj 对象
     * @param param 需要校验的入参
     * @return
     */
    public static String getMessageObj(Object obj, Object param){
        Message message = null;
        if (param == null){
            message = Message.errorMessage("参数为空！");
        }else{
            try {
                message = Message.successMessage(obj);
            }catch (Exception e){
                message = Message.errorMessage();
                return  JSONObject.fromObject(message, jsonConfig).toString();
            }
        }
        return  JSONObject.fromObject(message, jsonConfig).toString();
    }
    
    
    public static String getErrorMessage() {
    	return JSONObject.fromObject(Message.errorMessage()).toString();
	}

    /**
     * 返回错误信息的信息对象
     * @param msg 错误信息
     * @return
     */
    public static String getErrorMessage(String msg){
        Message message = Message.errorMessage(msg);
        return  JSONObject.fromObject(message).toString();
    }
}
