package agiletravel.dai.dao.notice;

import agiletravel.dai.entity.Notice;
import agiletravel.dai.form.reNotice;

import java.util.List;

public interface NoticeDao {
    List<reNotice> findByTravelid(String travelid);
    void InsertNotice(Notice notice);
    void deleteNotice(String noticeId);
}
