package agiletravel.dai.reconst.success;

public enum ActivitySuccess {
    RELEASE_ACTIVITY_SUCCESS("发布活动信息成功"),
    UPDATE_ACTIVITY_INFO_SUCCESS("修改活动信息成功"),
    CANCLE_ACTIVITY_SUCCESS("取消活动成功"),

    ;
    private String descrip;
    ActivitySuccess(String descrip){
        this.descrip=descrip;
    }
}
