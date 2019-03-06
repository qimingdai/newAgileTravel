package agiletravel.dai.reconst;

public enum userEnum {
    RESGITER_FAILER(0001,"注册失败"),
    UpdateUserInfo(0002,"修改用户信息失败"),
    LoginError(0003,"登录失败"),
    User_NUMBER_DO_NOT_EXSIT(0004,"用户不存在");

    private int code;
    private String data;

    private userEnum(int code, String data){
        this.code=code;
        this.data=data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getData() {
        return data;
    }
}
