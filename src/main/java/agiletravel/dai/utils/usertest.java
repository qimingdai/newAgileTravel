//package agiletravel.dai.utils;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.google.gson.Gson;
//import lombok.extern.slf4j.Slf4j;
//import org.omg.Messaging.SYNC_WITH_TRANSPORT;
//
//import java.util.*;
//
//
//class usertest {
//
//    public usertest(int maker) {
//        System.out.println("usertest"+maker+"初始化完成");
//    }
//
//    public usertest() {
//        System.out.println("usertest的无参构造");
//    }
//}
//
//class user{
//
//    private String user;
//    private usertest usertest1=new usertest(1);
//    {
//        usertest usertest3 = new usertest(3);
//    }
//    public user() {
//        System.out.println("user类初始化完成");
//    }
//    private usertest usertest2=new usertest(2);
//
//}
//
//class test{
//    public static void main(String[] args){
//        user u = new user();
//    }
//}
//
//
