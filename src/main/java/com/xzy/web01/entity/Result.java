package com.xzy.web01.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;   // 错误码 1-success 0-error
    private String msg;     // 错误信息
    private Object data;    // 实体数据

    // 生成成功的消息
    public static Result success(){
        Result result = new Result();
        result.setCode(1);
        result.setMsg("success");
        return result;
    }

    public static Result success(Object data){
        Result result = success();
        result.setData(data);
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("error");
        return result;
    }

    public static Result error(String msg){
        Result result = new Result();
        result.setCode(0);
        result.setMsg(msg);
        return result;
    }

}
