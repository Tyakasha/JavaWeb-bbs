//package ncu.ie.webdesign.dto;
package akm;

/**
 * @author by Wan HaoDong
 * @date 2019-12-12  09:40
 * @description ajax数据回显封装类
 **/
public class AjaxCallBack {

    /**
     * 请求成功表示
     */
    private Boolean successFlag;

    /**
     * 回显数据
     */
    private Object callbackData;


    public AjaxCallBack() {
    }

    public Boolean getSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(Boolean successFlag) {
        this.successFlag = successFlag;
    }

    public Object getCallbackData() {
        return callbackData;
    }

    public void setCallbackData(Object callbackData) {
        this.callbackData = callbackData;
    }
}
