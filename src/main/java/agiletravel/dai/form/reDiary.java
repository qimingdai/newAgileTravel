package agiletravel.dai.form;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class reDiary {
    private String diaryId;
    private String content;
    private String nickname;
    private Timestamp time;
    private String title;
    /**
     * 服务器中图片存储的路径
     */
    private String pictureName;
    private Integer likes;
    private Integer views;
}
