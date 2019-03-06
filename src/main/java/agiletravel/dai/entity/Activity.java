package agiletravel.dai.entity;


import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;

import java.io.Serializable;

@Data
public class Activity implements Serializable {
    private String travelid;
    private String openid;
    private String city;
//    private Date startTime;
//    private Date endTime;
    private String startTime;
    private String endTime;
    private String travelName;
    private String description;
    private int flag=1;
    private String kind;
    private String cost;
    private String totalNumber;


}
