package enset.bankAccount.Service;

import enset.bankAccount.dto.AccountRequestDTO;
import enset.bankAccount.dto.AccountResponnseDTO;
import enset.bankAccount.entitis.Account;
import enset.bankAccount.enums.TypeAccount;
import enset.bankAccount.mappers.AccountMapper;
import enset.bankAccount.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.UUID;

@Service
@Transactional
public class AcountServiceImpl implements AcountService {
   @Autowired
   private  AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public AccountResponnseDTO addAccount(AccountRequestDTO account) {
        Account account1 = Account.builder()
                .id(UUID.randomUUID().toString())
                .type(Math.random()>0.5? TypeAccount.CREATED_ACCOUNT:TypeAccount.SAVING_ACCOUNT)
                .balance(10000+Math.random()*90000)
                .createAt(new Date(System.currentTimeMillis()))
                .currency("MAD")
                .build();
        Account saveAccount = accountRepository.save(account1);
        AccountResponnseDTO   accountResponnseDTO= accountMapper.fromAccount(saveAccount);

        return accountResponnseDTO;
    }


    @Override
    public AccountResponnseDTO updateAccount(String id, AccountRequestDTO account) {
        Account account1 = Account.builder()
                .id(id)
                .type(Math.random()>0.5? TypeAccount.CREATED_ACCOUNT:TypeAccount.SAVING_ACCOUNT)
                .balance(10000+Math.random()*90000)
                .createAt(new Date(System.currentTimeMillis()))
                .currency("MAD")
                .build();
        Account saveAccount = accountRepository.save(account1);
        AccountResponnseDTO   accountResponnseDTO= accountMapper.fromAccount(saveAccount);

        return accountResponnseDTO;
    }
}
