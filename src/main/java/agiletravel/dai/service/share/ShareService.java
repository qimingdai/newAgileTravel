package agiletravel.dai.service.share;

import agiletravel.dai.entity.Shares;

import java.util.List;

public interface ShareService {
    /**
     * 分享游记
     * @param shares
     */
    void addShare(Shares shares);

    /**
     * 查看“我”的分享
     * @param openid
     * @return
     */
    List<Shares> viewMyShares(String openid);
}
