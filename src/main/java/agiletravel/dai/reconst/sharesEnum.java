package agiletravel.dai.reconst;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum sharesEnum {
    RELEASE_SHARES_FAILED(0001,"发表游记失败"),
    UPDATE_SHARES_FAILED(0002,"更新游记失败"),
    DELETE_SHARES_FAILED(003,"删除游记失败"),
    NO_SHARES(0004,"您暂时还没有发表游记"),
    FILE_UPLOAD_FAILED(0005,"文件上传失败"),
    FILE_FORMAT_ERROR(0006,"图片格式不正确，请上传指定格式的文件")
    ;


    private int code;
    private String data;

    sharesEnum(int code,String data){
        this.code=code;
        this.data=data;
    }
}
