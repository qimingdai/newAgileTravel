package agiletravel.dai.service.notice;

import agiletravel.dai.entity.Notice;
import agiletravel.dai.form.reNotice;

import java.util.List;

public interface NoticeService {
    /**
     * 查看当前活动的所有通知
     * @param travelid
     * @return
     */
    List<reNotice> viewNotice(String travelid);

    /**
     * 插入一条通知
     * @param notice
     */
    void insertNotice(Notice notice);

    /**
     * 删除当前通知
     * @param noticeid
     */
    void deleteNotice(String noticeid);
}
