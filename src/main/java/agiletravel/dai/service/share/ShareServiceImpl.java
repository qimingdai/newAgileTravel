package agiletravel.dai.service.share;

import agiletravel.dai.dao.share.ShareDao;
import agiletravel.dai.entity.Shares;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("shareService")
@Slf4j
public class ShareServiceImpl implements ShareService {
    @Autowired
    ShareDao shareDao;

    @Override
    public void addShare(Shares shares) {
        shareDao.addShare(shares);
    }
}
