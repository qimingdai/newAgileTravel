package agiletravel.dai.form;

import lombok.Data;

@Data
public class reDetailActivity {
    private String travelId;
    private String openId;
    private String place;
    private String startTime;
    private String endTime;
    private String title;
    private String description;
    private String types;
    private int cost;
    private int totalNumber;
    private int restNumber;

    public reDetailActivity(String travelid,String openid, String place, String startTime, String endTime, String title, String description, String type, int cost, int totalNumber, int restNumber) {
        this.travelId = travelid;
        this.openId=openid;
        this.place = place;
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.description = description;
        this.types = type;
        this.cost = cost;
        this.totalNumber = totalNumber;
        this.restNumber = restNumber;
    }
}
