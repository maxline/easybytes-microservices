package com.eazybytes.loans.service;

import com.eazybytes.loans.dto.LoanDto;

public interface ILoanService {

//    void createLoan(LoanDto customerDto);

    void createLoan(String mobileNumber);

    LoanDto fetchLoan(String mobileNumber);

    boolean updateLoan(LoanDto customerDto);

    boolean deleteLoan(String mobileNumber);
}
