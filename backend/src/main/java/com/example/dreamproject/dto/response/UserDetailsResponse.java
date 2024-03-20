package com.example.dreamproject.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserDetailsResponse {
    String userId;
    String username;
    String emailId;
    String image;
    String phonenumber;
    String address;
}
