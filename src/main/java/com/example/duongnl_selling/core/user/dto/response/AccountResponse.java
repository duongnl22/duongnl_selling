package com.example.duongnl_selling.core.user.dto.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    private Long id;

    private String username;

    private String password;

    private String fullName;
    private String email;
    private String phoneNumber;
    private String avatar;
    private Integer role;

}
