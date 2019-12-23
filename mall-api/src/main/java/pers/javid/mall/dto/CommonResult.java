package pers.javid.mall.dto;

public class CommonResult {
    private String msg;
    private int code;
    private Object data;

    public CommonResult success(){
        this.code = 200;
        this.msg = "操作成功";
        return this;
    }

    public CommonResult success(Object data){
        this.code = 200;
        this.msg = "操作成功";
        this.data = data;
        return this;
    }

    public CommonResult faild(){
        return faild("操作失败");
    }

    public CommonResult faild(String msg){
        this.code = 500;
        this.msg = msg;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
