package com.scaler.bank.dto;

import lombok.Data;

@Data
public class AccountRequestDTO {
    private String accountNumber;
    private String accountHolderName;
    private int amount;

}
