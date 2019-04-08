package agiletravel.dai.utils;

import agiletravel.dai.MyException.SharesException;
import agiletravel.dai.entity.Shares;
import agiletravel.dai.reconst.sharesEnum;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IOUtils {
    public static String readResponse(InputStream in){
        StringBuffer buffer = new StringBuffer();
        String temp="";
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(in,"utf-8"));
            while((temp=br.readLine())!=null){
                buffer.append(temp);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return buffer.toString();
    }

    public static String uploadImage(MultipartFile file){

        if(file.isEmpty()){
//            log.info("发布游记失败");
            throw new SharesException(sharesEnum.FILE_UPLOAD_FAILED);
        }
        //获取文件名
        String fileName = file.getOriginalFilename();

        //获取文件后缀名
        String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
//        log.info("文件后缀名为"+suffix);
        if(!"jpg".equals(suffix) && !"png".equals(suffix) ){
            throw new SharesException(sharesEnum.FILE_FORMAT_ERROR);
        }
        //可以加上时间戳防止文件重名
        fileName = new SimpleDateFormat("YYYY.MM.dd.mm.ss").format(new Date())+fileName;

        String rootPath = "C:/img/";
        String path = rootPath+fileName;
        File dest = new File(path);
        //假如父目录不存在则创建指定文件
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        String url;
        try{
            file.transferTo(dest);
//            url = "http://wwww.yangdeyu.cn/"+fileName;
            url="http://www.yangdeyu.cn/"+fileName;
//            log.info("上传成功");
//            shareService.addShare(new Shares(openid,comment,url));
        }catch (Exception e){
            throw new SharesException(sharesEnum.FILE_UPLOAD_FAILED);
        }
        return url;
    }

}
