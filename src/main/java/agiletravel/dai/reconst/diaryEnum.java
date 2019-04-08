package agiletravel.dai.reconst;

import lombok.Getter;

@Getter
public enum diaryEnum {
    NO_DIARY_EXIST(0001,"您暂时还没有发表游记"),
    FOUND_NO_DIARY(0002,"未找到相关游记"),

    ;
    private int code;
    private String data;

    diaryEnum(int code, String data) {
        this.code=code;
        this.data = data;
    }

}
