package agiletravel.dai.utils;

public class MiniProgramConst {
    public static final String appid="wxa89e570c6e28bda4";
    public static final String appsecret="b5f1181746df30a4e60453f2c35654c5";
    public static final String getAccessToken_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&";

    //接下来的请求发送消息模板的参数，详见微信小程序sendTemplateMessage这个API.
    public static final String sendTemplateMessage_RUL = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=";
    //该消息模板为参加活动的通知
    public static final String template_id = "lMt5mqkCi83hCBBabwnvrX4fQmWSSzPymmo0I-35pmU";
    public static final String form_id="111";       //提交的表单事件携带的submit_id

    //该消息模板为活动更新通知
    public static final String updateTemplate_id="";
    public static final String updateForm_id = "";

    //该消息模板为取消活动的通知
    public static final String cancleTemplate_id="";
    public static final String cancleForm_id="";

    //缓存的有效时间
    public static final long ACCESS_TOKEN_LAST_TIME=5400;

}
