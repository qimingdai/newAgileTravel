package agiletravel.dai.service.notice;

import agiletravel.dai.MyException.NoticeException;
import agiletravel.dai.dao.notice.NoticeDao;
import agiletravel.dai.entity.Notice;
import agiletravel.dai.form.reNotice;
import agiletravel.dai.reconst.noticeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    @Override
    public List<reNotice> viewNotice(String travelid) {
        List<reNotice> list = noticeDao.findByTravelid(travelid);
        if(list==null || list.isEmpty()){
            throw new NoticeException(noticeEnum.NO_NOTICE_NOW);
        }
        return list;
    }

    @Override
    public void insertNotice(Notice notice) {
        noticeDao.InsertNotice(notice);
    }

    @Override
    public void deleteNotice(String noticeid) {
        noticeDao.deleteNotice(noticeid);
    }
}
