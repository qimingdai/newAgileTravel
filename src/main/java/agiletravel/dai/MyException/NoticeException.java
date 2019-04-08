package agiletravel.dai.MyException;

import agiletravel.dai.reconst.noticeEnum;
import agiletravel.dai.utils.Response;

public class NoticeException extends RuntimeException {
    private final noticeEnum response;

    public NoticeException(noticeEnum response){
        this.response=response;
    }

    public noticeEnum getResponse() {
        return response;
    }
}
