package com.scaler.bank.repository;

import com.scaler.bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository< Account, Long>{

}
