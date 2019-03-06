package agiletravel.dai.entity;

import lombok.Data;


/**
 * comment为游记的分享，不需要针对某个具体的出游
 */

@Data
public class Shares {
    private String openid;
    private String comment;
    private String picture1;

    public Shares(String openid, String comment, String picture1) {
        this.openid = openid;
        this.comment = comment;
        this.picture1 = picture1;
    }
}
