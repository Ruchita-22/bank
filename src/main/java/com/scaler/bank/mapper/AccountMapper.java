package com.scaler.bank.mapper;

import com.scaler.bank.dto.AccountRequestDTO;
import com.scaler.bank.dto.AccountResponseDTO;
import com.scaler.bank.model.Account;


public class AccountMapper {
    public static Account AccountRequestDTOToAccount(AccountRequestDTO accountRequestDTO){
        Account account = new Account();
        account.setAccountNumber(accountRequestDTO.getAccountNumber());
        account.setAccountHolderName(accountRequestDTO.getAccountHolderName());
        account.setAmount(accountRequestDTO.getAmount());
        return account;
    }
    public static AccountResponseDTO AccountToAccountResponseDTO(Account account){
        AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
        accountResponseDTO.setId(account.getId());
        accountResponseDTO.setAccountNumber(account.getAccountNumber());
        accountResponseDTO.setAccountHolderName(account.getAccountHolderName());
        accountResponseDTO.setAmount(account.getAmount());
        return accountResponseDTO;
    }
}
