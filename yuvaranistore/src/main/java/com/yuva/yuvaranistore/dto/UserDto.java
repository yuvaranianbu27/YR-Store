package com.yuva.yuvaranistore.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long userId;
    private String name;
    private String email;
    private String mobileNumber;
    private String roles;
    private AddressDto address;
}
