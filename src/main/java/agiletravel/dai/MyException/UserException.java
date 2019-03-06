package agiletravel.dai.MyException;

import agiletravel.dai.reconst.userEnum;

public class UserException extends RuntimeException {

    private final userEnum response;

    public UserException(userEnum response){
        this.response = response;
    }

    public userEnum getResponse() {
        return response;
    }
}
