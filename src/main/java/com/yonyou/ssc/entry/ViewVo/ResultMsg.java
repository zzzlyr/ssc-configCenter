package com.yonyou.ssc.entry.ViewVo;

/**
 * Created by Administrator on 2017/3/3.
 */
public class ResultMsg {

    private boolean flag;

    private Object data;

    private  String desc;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
