package com.vg.ckp.bean.net;


public class RequestBean {


    /**
     * code : 0
     * msg : 登录成功
     * data : {"uid":359056,"username":"12315284512","avatar":"/assets/img/avatar.png","nickname_code":"8XLNIZ","nickname":"肝榷算","is_ever":0,"end_time":1539253380,"is_end":1,"token":"7aeb2ccf3994b2ccb3ff95987c24cf63"}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RequestBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
