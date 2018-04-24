package com.xingong.bishe.commonutils;

//@XmlRootElement(
//        name = "BaseResponse"
//)
//@XmlAccessorType(XmlAccessType.NONE)
public class BaseResponse {
//    @XmlElement
    protected String status = "OK";
//    @XmlElement
    protected String message = "";


    protected Object data;

    public BaseResponse() {
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
