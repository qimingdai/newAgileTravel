package agiletravel.dai.form;

import lombok.Data;

@Data
public class reDetailActivity {
    private String travelid;
    private String city;
    private String startTime;
    private String endTime;
    private String travelName;
    private String description;
    private String kind;
    private int cost;
    private int totalNumber;
    private int restNumber;

    public reDetailActivity(String travelid, String city, String startTime, String endTime, String travelName, String description, String kind, int cost, int totalNumber, int restNumber) {
        this.travelid = travelid;
        this.city = city;
        this.startTime = startTime;
        this.endTime = endTime;
        this.travelName = travelName;
        this.description = description;
        this.kind = kind;
        this.cost = cost;
        this.totalNumber = totalNumber;
        this.restNumber = restNumber;
    }
}
