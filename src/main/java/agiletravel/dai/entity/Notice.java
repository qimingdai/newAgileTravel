package agiletravel.dai.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Notice {
    private int noticeid;
    private String travelId;
    private String openId;
    private String content;
    private Date noticeTime;
}
