package com.example.duongnl_selling.infrastructure.constant;

public enum BillStatus {
    PAYING(0),
    PAID(1),
    CANCELLED(2);

    private final int status;
    BillStatus(int status) {
        this.status = status;
    }

    public int getBillStatus(){
        return status;
    }
}
