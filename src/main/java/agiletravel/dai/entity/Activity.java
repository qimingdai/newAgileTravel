package agiletravel.dai.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
public class Activity implements Serializable {
    private String travelId;
    private String openId;
    private String place;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp endTime;
    private String title;
    private String description;
    private int flag=1;
    private String types;
    private int cost;
    private int maxNumber;

}
