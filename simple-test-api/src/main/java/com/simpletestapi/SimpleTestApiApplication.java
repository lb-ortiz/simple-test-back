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
			list.add(new Client("ze", "11111", "José", StatusClientEnum.ATIVADO, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"));
			list.add(new Client("fon", "11111", "Afonso", StatusClientEnum.ATIVADO, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"));
			list.add(new Client("le", "11111", "Leila", StatusClientEnum.ATIVADO, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"));
			list.add(new Client("ze", "11111", "José", StatusClientEnum.DESATIVADO, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"));
			list.add(new Client("fon", "11111", "Afonso", StatusClientEnum.DESATIVADO, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"));
			list.add(new Client("le", "11111", "Leila", StatusClientEnum.DESATIVADO, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"));
			list.add(new Client("ze", "11111", "José", StatusClientEnum.SUSPENSO, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"));
			list.add(new Client("fon", "11111", "Afonso", StatusClientEnum.SUSPENSO, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"));
			list.add(new Client("le", "11111", "Leila", StatusClientEnum.SUSPENSO, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"));
			for (Client client : list) {
				clientRepository.save(client);
			}
			
			List<Email> listEmail = new ArrayList<>();
			listEmail.add(new Email("Zelador", "zé", "ze@zelador.com.br", Long.parseLong("1")));
			listEmail.add(new Email("Zelador", "zé", "ze@zelador.com.br", Long.parseLong("1")));
			listEmail.add(new Email("Zelador", "zé", "ze@zelador.com.br", Long.parseLong("1")));
			listEmail.add(new Email("Zelador", "fé", "ze@zelador.com.br", Long.parseLong("1")));
			listEmail.add(new Email("Porteiro", "fé", "ze@zelador.com.br", Long.parseLong("2")));
			listEmail.add(new Email("Porteiro", "fé", "ze@zelador.com.br", Long.parseLong("2")));
			listEmail.add(new Email("Porteiro", "fé", "ze@zelador.com.br", Long.parseLong("2")));
			listEmail.add(new Email("Porteiro", "fé", "ze@zelador.com.br", Long.parseLong("2")));

			for (Email email : listEmail) {
				 emailRepository.save(email);
			}
		};
	}

}
