package agiletravel.dai.entity;

import lombok.Data;


@Data
public class User {
    private String openId;
    private String nickname;
    private int gender;

    private String country="中国";
    private String province;
    private String city;

    private String phoneNumber="-1";



}
