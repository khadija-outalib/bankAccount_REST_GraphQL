package enset.bankAccount.web;

import enset.bankAccount.Service.AcountService;
import enset.bankAccount.dto.AccountRequestDTO;
import enset.bankAccount.dto.AccountResponnseDTO;
import enset.bankAccount.entitis.Account;
import enset.bankAccount.mappers.AccountMapper;
import enset.bankAccount.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ap1")
public class AccountRestController {

    private AccountRepository  accountRepository;

    @Autowired
    private AcountService acountService;
    @Autowired
    private AccountMapper accountMapper;
    public AccountRestController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;}

    @GetMapping("/Accounts")
    public List<Account> ListAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/Account/{id}")
    public Account AccountId(@PathVariable String id) {
        return accountRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("Account not found "+id)
                );
    }

    @PostMapping("/Account")
    public AccountResponnseDTO save(@RequestBody AccountRequestDTO AccountDTO) {
        return acountService.addAccount(AccountDTO);
    }

    @PutMapping("/Account/{id}")
    public Account update(@RequestBody Account newAccount , @PathVariable String id) {
        Account account =accountRepository.findById(id).orElseThrow();
        if(newAccount.getBalance()!=null) account.setBalance(newAccount.getBalance());
        if(newAccount.getCreateAt()!= null)account.setCurrency(newAccount.getCurrency());
        if(newAccount.getCreateAt()!= null) account.setCreateAt(newAccount.getCreateAt());
        if(newAccount.getType()!= null)account.setType(newAccount.getType());

        return accountRepository.save(account);
    }


    @DeleteMapping("/Account/{id}")
    public void DeletAccount(@PathVariable String id) {
        accountRepository.deleteById(id);
    }

}

