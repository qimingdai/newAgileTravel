package agiletravel.dai.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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

}
