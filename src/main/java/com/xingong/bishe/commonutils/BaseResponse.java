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


    protected String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
