package agiletravel.dai.reconst;

public enum activityEnum {
    RELEASE_FAILED(0001,"发布出游活动失败"),
    UPDATE_ACTIVITY_FAILED(0002,"修改出游信息失败"),
    CANCLE_ACTIVITY_FAILED(0003,"取消出游活动失败"),
    ACTIVITY_NOT_EXIST(0004,"无相关活动"),
    NO_ACTIVITY(0005,"暂时还没有人创建活动"),
    INCLUDE_BAD_WORDS(0006,"您的描述中存在敏感词汇，请重新发布活动"),
    NO_RELEASE_ACTIVITIES(0007,"您还没有发布过任何活动"),
    ACTIVITY_IS_FULL(8,"很抱歉，本次活动已达人数上限，请关注下次活动")
    ;
    private int code;
    private String data;

    activityEnum(int code, String data){
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
