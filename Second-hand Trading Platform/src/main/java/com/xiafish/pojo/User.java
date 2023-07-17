package com.xiafish.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private String username;
    private Integer userGender;
    private String userPhoneNum;
    private String userEmail;
    private String userPasswd;
    private Integer userStatus;
    private String userPhoto;
    private String userCampus;
    private String userNickname;
    private String userProfile;
}
