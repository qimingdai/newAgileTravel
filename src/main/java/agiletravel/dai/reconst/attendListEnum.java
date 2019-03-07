package agiletravel.dai.reconst;

public enum attendListEnum {
    ADD_ACTIVITY_FAILED(0001,"加入出游活动失败"),
    QUIT_ACTIVITY_FAILED(0002,"退出出游活动失败"),
    NO_ATTEND_ACTIVITY_HISTORY(0003,"无出游记录"),
    COMMENT_ACTIVITY_FAILED(0004,"评价活动失败"),
    FULL_PEOPLE_ERROR(0005,"人数已达上限，请关注下次活动");

    private int code;
    private String data;
    attendListEnum(int code, String data){
        this.code=code;
        this.data=data;
    }

    public int getCode() {
        return code;
    }

    public String getData() {
        return data;
    }
}
