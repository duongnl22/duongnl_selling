package com.example.duongnl_selling.infrastructure.constant;

public enum RoleAccount {

    USER(0) ,
    ADMIN(1);

    private final int role;

    RoleAccount(int role) {
        this.role = role;
    }

    public int getRole() {
        return role;
    }
}
