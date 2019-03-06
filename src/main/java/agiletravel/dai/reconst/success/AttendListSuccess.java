package agiletravel.dai.reconst.success;

public enum AttendListSuccess {
    ATTEND_ACTIVITY_SUCCESS("加入活动成功"),
    QUIT_ACTIVITY_SUCCESS("退出活动成功"),
    COMMENT_ACTIVITY_SUCCESS("评论活动成功")
    ;
    private String descrip;
    AttendListSuccess(String descrip){
        this.descrip=descrip;
    }
}
