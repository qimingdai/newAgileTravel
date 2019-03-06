package agiletravel.dai.MyException;

import agiletravel.dai.reconst.activityEnum;
import agiletravel.dai.utils.Response;

public class ActivityException extends RuntimeException {
    private final activityEnum response;

    public ActivityException(activityEnum response){
        this.response=response;
    }

    public activityEnum getResponse(){
        return response;
    }
}
