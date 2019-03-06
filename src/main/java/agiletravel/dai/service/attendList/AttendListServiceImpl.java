package agiletravel.dai.service.attendList;

import agiletravel.dai.dao.attendList.AttendListDao;
import agiletravel.dai.entity.Activity;
import agiletravel.dai.entity.AttendList;
import agiletravel.dai.entity.User;
import agiletravel.dai.form.reViewHistory;
import agiletravel.dai.form.reViewUser;
import agiletravel.dai.service.activity.ActivityService;
import agiletravel.dai.utils.MiniProgramConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("attendListService")
@Transactional
@Slf4j
public class AttendListServiceImpl implements AttendListService {
    @Autowired
    private AttendListDao attendListDao;

    @Autowired
    private ActivityService activityService;

    @Override
    public void attendActivity(AttendList attendList) {
        attendListDao.addAttendList(attendList.getTravelid(),attendList.getOpenid());
        Activity activity = activityService.viewDetail(attendList.getTravelid());
        log.info("开始给参加活动成功的人发送参加活动成功的通知");
        activityService.alertActivity(attendList.getOpenid(),activity.getTravelName(),activity.getCity(),
                activity.getEndTime(), MiniProgramConst.template_id,MiniProgramConst.form_id);
        log.info("给参加活动的人发送成功参加通知完毕");
    }

    @Override
    public void quitActivity(AttendList attendList) {
        attendListDao.deleteAttendList(attendList.getTravelid(),attendList.getOpenid());
    }

    @Override
    public List<reViewHistory> attendHistory(String openid) {
        log.info("执行查看历史纪录操作");
        List<reViewHistory> list = attendListDao.findByOpenid(openid);
        log.info("操作执行完毕");
        return list;
    }


    @Override
    public List<reViewUser> listAttendUsers(String travelid) {
        List<reViewUser> list = attendListDao.findByTravelid(travelid);
        return list;
    }

    @Override
    public void commentActivity(AttendList attendList) {

        attendListDao.updateComment(attendList.getComment(),attendList.getTravelid(),attendList.getOpenid());
    }
}
