package swagger2.constant;

public enum  ResponseCode {

    SUCCESS(0,"SUCCESS"),
    DEFEATED(1,"DEFEATED"),
    UNKNOW(2,"UNKNOW"),
    ILLEGAL_ARGUMENT(3,"ILLEGAL_ARGUMENT"),
    ERROR(4,"ERROR");


    private int code;

    private String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
