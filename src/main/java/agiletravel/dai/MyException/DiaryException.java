package agiletravel.dai.MyException;

import agiletravel.dai.reconst.diaryEnum;


public class DiaryException extends RuntimeException {
    private diaryEnum response;
    public DiaryException(diaryEnum response){
        this.response=response;
    }

    public diaryEnum getResponse() {
        return response;
    }

}
