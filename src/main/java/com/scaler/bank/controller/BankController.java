package com.scaler.bank.controller;

import com.scaler.bank.dto.AccountRequestDTO;
import com.scaler.bank.dto.AccountResponseDTO;
import com.scaler.bank.service.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankController {
    BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("account")
    public ResponseEntity createAccount(@RequestBody AccountRequestDTO accountRequestDTO){

        bankService.createAccount(accountRequestDTO);
        return  ResponseEntity.ok(accountRequestDTO);
    }

    @GetMapping("account/{id}")
    public ResponseEntity getAccountById(@PathVariable("id") Long id){
        AccountResponseDTO accountResponseDTO = bankService.getAccountById(id);
        return ResponseEntity.ok(accountResponseDTO);
    }
    @GetMapping("accounts")
    public ResponseEntity getAllAccount(){
        List<AccountResponseDTO> accountResponseDTOList = bankService.getAllAccount();
        return ResponseEntity.ok(accountResponseDTOList);
    }

    @PatchMapping("account/{id}")
    public ResponseEntity updateAccount(@PathVariable("id") Long id, @RequestBody AccountRequestDTO accountRequestDTO){
        boolean flag = bankService.updateAmount(id,accountRequestDTO);
        return ResponseEntity.ok(flag);
    }

    @DeleteMapping("account/{id}")
    public ResponseEntity deleteAccountById(@PathVariable("id") Long id){
        boolean flag= bankService.deleteAccountById(id);
        return ResponseEntity.ok(flag);
    }



}
