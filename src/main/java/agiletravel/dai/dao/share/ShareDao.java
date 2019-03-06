package agiletravel.dai.dao.share;

import agiletravel.dai.entity.Shares;

/**
 * 数据库设计不对，需要重新设计
 */
public interface ShareDao {
    void addShare(Shares shares);
    void viewCommentHistory(String openid);
}
