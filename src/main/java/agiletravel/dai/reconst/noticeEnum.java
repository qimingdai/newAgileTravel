package agiletravel.dai.reconst;

import lombok.Getter;

@Getter
public enum noticeEnum {
    NO_NOTICE_NOW(0001,"当前活动暂无通知")
    ;
    private int code;
    private String data;

    noticeEnum(int code, String data) {
        this.code = code;
        this.data = data;
    }


}
