package enset.bankAccount.Service;

import enset.bankAccount.dto.AccountRequestDTO;
import enset.bankAccount.dto.AccountResponnseDTO;
import enset.bankAccount.dto.AccountResponnseDTO;
import enset.bankAccount.entitis.Account;

public interface AcountService {
    public enset.bankAccount.dto.AccountResponnseDTO addAccount(AccountRequestDTO account);

    AccountResponnseDTO updateAccount(String id, AccountRequestDTO account);
}
