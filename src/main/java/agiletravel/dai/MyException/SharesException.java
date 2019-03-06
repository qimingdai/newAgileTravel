package agiletravel.dai.MyException;

import agiletravel.dai.reconst.sharesEnum;

public class SharesException extends RuntimeException {

    private final sharesEnum response;
    public SharesException(sharesEnum response){
        this.response=response;
    }
    public sharesEnum getResponse(){
        return response;
    }

}
