package agiletravel.dai.entity;

import lombok.Data;


@Data
public class User {
    private String openid;
    private String nickname;
    private int gender=-1;

    private String country;
    private String province;
    private String city;

    private int age=18;

    private String phoneNumber="-1";



}
