package com.simpletestapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.simpletestapi.enums.StatusClientEnum;
import com.simpletestapi.model.Client;
import com.simpletestapi.model.Email;
import com.simpletestapi.repository.ClientRepository;
import com.simpletestapi.repository.EmailRepository;

@SpringBootApplication
public class SimpleTestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleTestApiApplication.class, args);

	}

	// executa quando inicia a aplicação
	@Bean
	CommandLineRunner initDataBase(ClientRepository clientRepository, EmailRepository emailRepository) {
		return args -> {
			clientRepository.deleteAll();
			emailRepository.deleteAll();

			List<Client> list = new ArrayList<>();
			list.add(new Client("ze", "11111", "José", StatusClientEnum.ATIVADO));
			list.add(new Client("fon", "11111", "Afonso", StatusClientEnum.ATIVADO));
			list.add(new Client("le", "11111", "Leila", StatusClientEnum.ATIVADO));
			list.add(new Client("ze", "11111", "José", StatusClientEnum.DESATIVADO));
			list.add(new Client("fon", "11111", "Afonso", StatusClientEnum.DESATIVADO));
			list.add(new Client("le", "11111", "Leila", StatusClientEnum.DESATIVADO));
			list.add(new Client("ze", "11111", "José", StatusClientEnum.SUSPENSO));
			list.add(new Client("fon", "11111", "Afonso", StatusClientEnum.SUSPENSO));
			list.add(new Client("le", "11111", "Leila", StatusClientEnum.SUSPENSO));
			for (Client client : list) {
				clientRepository.save(client);
			}
			
			List<Email> listEmail = new ArrayList<>();
			listEmail.add(new Email("Zelador", "zé", "ze@zelador.com.br", Long.parseLong("1")));
			listEmail.add(new Email("Zelador", "zé", "ze@zelador.com.br", Long.parseLong("1")));
			listEmail.add(new Email("Zelador", "zé", "ze@zelador.com.br", Long.parseLong("1")));
			listEmail.add(new Email("Zelador", "zé", "ze@zelador.com.br", Long.parseLong("1")));
			for (Email email : listEmail) {
				 emailRepository.save(email);
			}
		};
	}

}
