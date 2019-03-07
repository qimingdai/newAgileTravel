package agiletravel.dai.entity;


import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Activity implements Serializable {
    private String travelid;
    private String openid;
    private String city;
    private Date startTime;
    private Date endTime;
    private String travelName;
    private String description;
    private int flag=1;
    private String kind;
    private int cost;
    private int totalNumber;


}
