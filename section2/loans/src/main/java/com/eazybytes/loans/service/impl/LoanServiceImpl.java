package com.eazybytes.loans.service.impl;

import com.eazybytes.loans.service.ILoanService;
import com.eazybytes.loans.dto.LoanDto;
import com.eazybytes.loans.entity.Loan;
import com.eazybytes.loans.exception.LoanAlreadyExistsException;
import com.eazybytes.loans.exception.ResourceNotFoundException;
import com.eazybytes.loans.mapper.LoanMapper;
import com.eazybytes.loans.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements ILoanService {
    private LoanRepository loanRepository;

    @Override
    public void createLoan(LoanDto loanDto) {
        Loan loan = LoanMapper.mapToLoan(loanDto, new Loan());
        Optional<Loan> optionalLoan = loanRepository.findByMobileNumber(loanDto.getMobileNumber());
        if (optionalLoan.isPresent()) {
            throw new LoanAlreadyExistsException("Loan already exists with given mobile number "
                    + loanDto.getMobileNumber());
        }
        Loan savedLoan = loanRepository.save(loan);
    }

    @Override
    public LoanDto fetchLoan(String mobileNumber) {
        Loan loan = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        return LoanMapper.mapToLoanDto(
                loan,
                new LoanDto()
        );
    }

    /**
     * @param loansDto - LoansDto Object
     * @return boolean indicating if the update of loan details is successful or not
     */
    @Override
    public boolean updateLoan(LoanDto loansDto) {
        Loan loans = loanRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "LoanNumber", loansDto.getLoanNumber()));
        LoanMapper.mapToLoan(loansDto, loans);
        loanRepository.save(loans);
        return true;
    }

    /**
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of Loan details is successful or not
     */
    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loan loan = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        loanRepository.deleteById(loan.getLoanId());
        return true;
    }

}
