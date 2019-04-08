package agiletravel.dai.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;


@Data
public class Diary {
    private String diaryId;
    private String openId;
    private String content;
    private String pictureName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp time;
    private String title;
    private Integer likes=0;
    private Integer views=0;
}
