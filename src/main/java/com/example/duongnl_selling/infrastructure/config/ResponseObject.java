package com.example.duongnl_selling.infrastructure.config;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseObject {

    private Object data;

    public ResponseObject(Object data) {
        if(data != null){
            this.data = data;
        }
    }
}
