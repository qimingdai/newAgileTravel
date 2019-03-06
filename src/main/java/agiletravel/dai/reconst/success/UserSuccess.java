package agiletravel.dai.reconst.success;

public enum UserSuccess {
    RESIGTER_SUCCESS("注册成功"),
    UPDATE_INFO_SUCCESS("修改信息成功"),
    LOGIN_SUCCESS("登录成功");

    private String descrip;

    private UserSuccess(String descrip){
        this.descrip=descrip;
    }
}
