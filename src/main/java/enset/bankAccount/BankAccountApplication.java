package enset.bankAccount;

import enset.bankAccount.entitis.Account;
import enset.bankAccount.entitis.Customer;
import enset.bankAccount.enums.TypeAccount;
import enset.bankAccount.repositories.AccountRepository;
import enset.bankAccount.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountApplication {

	public static void main(String[] args) {

		SpringApplication.run(BankAccountApplication.class, args);

	}
	@Bean
	CommandLineRunner start (AccountRepository bankAccountService , CustomerRepository customerRepository) {

		return args -> {
			Stream.of("Khadlid","sara","aya").forEach(c->{
				Customer customer = Customer.builder()
						.firstName(c)
						.build();
				customerRepository.save(customer);
			});
			customerRepository.findAll().forEach(customer -> {

				for (int i=0;i<3;i++){
					Account account = Account.builder()
							.id(UUID.randomUUID().toString())
							.type(Math.random()>0.5? TypeAccount.CREATED_ACCOUNT:TypeAccount.SAVING_ACCOUNT)
							.balance(10000+Math.random()*90000)
							.createAt(new Date(System.currentTimeMillis()))
							.currency("MAD")
							.customer(customer)
							.build();
					bankAccountService.save(account);

				}
			});


		};

	}

}
