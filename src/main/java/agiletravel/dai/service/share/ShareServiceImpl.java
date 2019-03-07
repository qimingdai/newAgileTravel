package agiletravel.dai.service.share;

import agiletravel.dai.MyException.SharesException;
import agiletravel.dai.dao.share.ShareDao;
import agiletravel.dai.entity.Shares;
import agiletravel.dai.reconst.sharesEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shareService")
@Slf4j
public class ShareServiceImpl implements ShareService {
    @Autowired
    ShareDao shareDao;

    @Override
    public List<Shares> viewMyShares(String openid) {
        List<Shares> list = shareDao.viewMyShares(openid);
        if(list==null || list.isEmpty()){
            throw new SharesException(sharesEnum.NO_SHARES);
        }
        return list;
    }

    @Override
    public void addShare(Shares shares) {
        shareDao.addShare(shares);
    }
}
