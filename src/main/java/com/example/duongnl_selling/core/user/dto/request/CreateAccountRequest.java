package com.example.duongnl_selling.core.user.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateAccountRequest {

    private String username;

    private String password;

    private String fullName;

    private String email;

    private String phoneNumber;

    private String avatar;

    private Integer role;

}
