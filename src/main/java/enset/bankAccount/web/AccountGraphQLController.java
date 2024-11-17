package enset.bankAccount.web;

import enset.bankAccount.Service.AcountService;
import enset.bankAccount.dto.AccountRequestDTO;
import enset.bankAccount.dto.AccountResponnseDTO;
import enset.bankAccount.entitis.Account;
import enset.bankAccount.entitis.Customer;
import enset.bankAccount.repositories.AccountRepository;
import enset.bankAccount.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountGraphQLController {
    @Autowired
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    @Autowired
    private AcountService accountService;

    @QueryMapping
    public List<Account> accountslist () {
        return accountRepository.findAll();
    }
    @QueryMapping
    public Account accountsById(@Argument String id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @MutationMapping
    public AccountResponnseDTO addAccounts(@Argument AccountRequestDTO account) {
        return accountService.addAccount(account);
    }

    @MutationMapping
    public AccountResponnseDTO updateAccounts(@Argument String id ,@Argument AccountRequestDTO account) {
        return accountService.updateAccount(id,account);
    }

    @MutationMapping
    public Boolean deleteAccounts(@Argument String id ) {
        try {
            accountRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @QueryMapping
    public List<Customer> customersList() {
        return customerRepository.findAll();

    }















}
