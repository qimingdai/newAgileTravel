package agiletravel.dai.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class MiniProgramUtils {
    public static String getAccessToken(){
        HttpURLConnection conn = null;
        String AccessToken=null;
        try{
            String strUrl = MiniProgramConst.getAccessToken_URL+"appid="+MiniProgramConst.appid+"&secret="+MiniProgramConst.appsecret;
//            String strUrl = "http://www.kuaidi100.com/query?type=yunda"+"&postid=3897481690723";
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if(HttpURLConnection.HTTP_OK == conn.getResponseCode()){
                String responseBody = IOUtils.readResponse(conn.getInputStream());
                JSONObject jsonObject = JSONObject.parseObject(responseBody);
                AccessToken = jsonObject.getString("data");
                System.out.println(AccessToken);

            }
        }catch (Exception e){
            throw new RuntimeException("没有返回值");
        }finally {
            conn.disconnect();
        }
        return AccessToken;
    }

    public static String sendTemplateMessage(String access_token, String params){
        HttpURLConnection conn = null;
        String errcode="40010";
        try{
//            String strUrl = MiniProgramConst.sendTemplateMessage_RUL+access_token;
            String strUrl = "https://api.weixin.qq.com/cgi-bin/wxopen/template/add?access_token="+access_token;
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type","application/json;charset=utr-8");
            //添加参数
            OutputStream out = conn.getOutputStream();
            out.write(params.getBytes());
            //刷新缓存
            out.flush();
            out.close();
            if(HttpURLConnection.HTTP_OK == conn.getResponseCode()){
                String responseBody = IOUtils.readResponse(conn.getInputStream());
                JSONObject jsonObject = JSONObject.parseObject(responseBody);
                errcode = jsonObject.getString("errcode");

            }
        }catch (Exception e){
            throw new RuntimeException("没有返回值");
        }finally {
            conn.disconnect();
        }
        return errcode;
    }

//
//    public static void main(String[] args){
//        Map inMap = new HashMap();
//        inMap.put("id","AT0002");
//        inMap.put("keyword_id_list","[2,3,4]");
//        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(inMap);
//        String access_token="19_9Bx5SnLhKlWnm_CLQAG-RUL3HcxGl-QA2UidhMzzOfwjGdC_naZJkR8CRyQEKa86cwfK2w3ZCpiw17ekuvdgnU0nUZCpViQOW50UgNWDM31Ldb8vkUENN8VbWKQZNKiAJAESP";
//        String result = sendTemplateMessage(access_token,jsonObject.toString());
//        System.out.println(result);
//    }
}
