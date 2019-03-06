package agiletravel.dai.MyException;

import agiletravel.dai.reconst.attendListEnum;

public class AttendListException extends RuntimeException {
    private final attendListEnum response;

    public AttendListException(attendListEnum response){
        this.response=response;
    }

    public attendListEnum getResponse() {
        return response;
    }
}
