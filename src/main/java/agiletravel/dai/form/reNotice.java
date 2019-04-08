package agiletravel.dai.form;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class reNotice {
    private int noticeid;
    private String openId;
    private String nickname;
    private String content;
    private Timestamp noticeTime;
}
