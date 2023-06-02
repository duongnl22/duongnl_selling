package com.example.duongnl_selling.infrastructure.constant;

public enum Delete {

    DELETED(true),
    UNDELETED(false);

    private final boolean delete;

    Delete (boolean delete){
        this.delete = delete;
    }
    public boolean getDelete(){
        return delete;
    }
}
