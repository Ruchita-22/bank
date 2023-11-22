package com.scaler.bank.service;

import com.scaler.bank.dto.AccountRequestDTO;
import com.scaler.bank.dto.AccountResponseDTO;
import com.scaler.bank.exception.AccountNotFountException;
import com.scaler.bank.mapper.AccountMapper;
import com.scaler.bank.model.Account;
import com.scaler.bank.repository.BankRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankService {
    BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public void createAccount(AccountRequestDTO accountRequestDTO) {
        Account account = AccountMapper.AccountRequestDTOToAccount(accountRequestDTO);
        bankRepository.save(account);
    }
    public AccountResponseDTO getAccountById(Long id) throws AccountNotFountException {

        Optional optionalAccount = bankRepository.findById(id);
        if(optionalAccount == null){
            throw new AccountNotFountException("Account is not found with id:"+id);
        }
        Account account = (Account) optionalAccount.get();
        AccountResponseDTO accountResponseDTO = AccountMapper.AccountToAccountResponseDTO(account);
        return accountResponseDTO;

    }
    public List<AccountResponseDTO> getAllAccount() {
        List<Account> accounts = bankRepository.findAll();

        List<AccountResponseDTO>  accountResponseDTOList = new ArrayList<>();
        for(Account account : accounts){
            AccountResponseDTO accountResponseDTO = AccountMapper.AccountToAccountResponseDTO(account);
            accountResponseDTOList.add(accountResponseDTO);
        }
        return accountResponseDTOList;

    }

    public boolean updateAmount(Long id, AccountRequestDTO accountRequestDTO) {
        Account account = new Account();
        account.setAccountNumber(accountRequestDTO.getAccountNumber());
        account.setAccountHolderName(accountRequestDTO.getAccountHolderName());
        account.setAmount(accountRequestDTO.getAmount());
        account.setId(id);
        bankRepository.save(account);
        return true;
    }

    public boolean deleteAccountById(Long id) {
        bankRepository.deleteById(id);
        return true;
    }
}
