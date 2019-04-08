package agiletravel.dai.MyException;


import agiletravel.dai.utils.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(UserException.class)
    @ResponseBody
    public Response handlerUserException(HttpServletRequest request, UserException ue){
        return new Response(ue.getResponse().getCode(),ue.getResponse().getData());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ActivityException.class)
    @ResponseBody
    public Response handlerActivityException(HttpServletRequest request, ActivityException ae){
        return new Response(ae.getResponse().getCode(),ae.getResponse().getData());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(AttendListException.class)
    @ResponseBody
    public Response handlerAttendListException(HttpServletRequest request, AttendListException ae){
        return new Response(ae.getResponse().getCode(),ae.getResponse().getData());
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(SharesException.class)
    @ResponseBody
    public Response handlerSharesException(HttpServletRequest request, SharesException se){
        return new Response(se.getResponse().getCode(),se.getResponse().getData());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NoticeException.class)
    @ResponseBody
    public Response handlerNoticeException(HttpServletRequest request, NoticeException ne){
        return new Response(ne.getResponse().getCode(),ne.getResponse().getData());
    }

    public Response handlerDiaryException(HttpServletRequest request, DiaryException de){
        return new Response(de.getResponse().getCode(),de.getResponse().getData());
    }
}
