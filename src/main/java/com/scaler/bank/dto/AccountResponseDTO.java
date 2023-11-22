package com.scaler.bank.dto;

import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
public class AccountResponseDTO  {
    private Long id;
    private String accountNumber;
    private String accountHolderName;
    private int amount;
}
