package agiletravel.dai.controller.share;

import agiletravel.dai.MyException.SharesException;
import agiletravel.dai.entity.Shares;
import agiletravel.dai.reconst.sharesEnum;
import agiletravel.dai.reconst.success.SharesSuccess;
import agiletravel.dai.reconst.success.UserSuccess;
import agiletravel.dai.service.share.ShareService;
import agiletravel.dai.utils.Response;
import agiletravel.dai.utils.ResponseFactory;
import javafx.scene.input.DataFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@Slf4j
public class ShareController {
    @Autowired
    ShareService shareService;

    @Value("${file.path}")
    private String rootPath;

    @RequestMapping("/shares/upload")
    public Response releaseNotes(@RequestParam String openid, @RequestParam String comment,@RequestParam MultipartFile file){
        if(file.isEmpty()){
            log.info("发布游记失败");
            throw new SharesException(sharesEnum.FILE_UPLOAD_FAILED);
        }
        //获取文件名
        String fileName = file.getOriginalFilename();

        //获取文件后缀名
        String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
        log.info("文件后缀名为"+suffix);
        if(!"jpg".equals(suffix) && !"png".equals(suffix) ){
            throw new SharesException(sharesEnum.FILE_FORMAT_ERROR);
        }
        //可以加上时间戳防止文件重名
//        fileName = new SimpleDateFormat("YYYYMMddmmss").format(new Date())+fileName;

        String path = rootPath+fileName;
        File dest = new File(path);
        //假如父目录不存在则创建指定文件
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        try{
            file.transferTo(dest);
            String url = fileName;
            log.info(url);
            log.info("上传成功");
            shareService.addShare(new Shares(openid,comment,url));
        }catch (Exception e){
            throw new SharesException(sharesEnum.FILE_UPLOAD_FAILED);
        }

        return ResponseFactory.okResponse(SharesSuccess.RELEASE_SUCCESS);
    }

}
