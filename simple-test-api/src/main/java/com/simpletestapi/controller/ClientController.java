package com.simpletestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpletestapi.model.Client;
import com.simpletestapi.repository.ClientRepository;
import com.simpletestapi.repository.EmailRepository;

@RestController
@RequestMapping("api/client")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private EmailRepository emailRepository;

	@GetMapping
	public List<Client> list() {
		return clientRepository.findAll();
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Client> client = clientRepository.findById(id);
		emailRepository.deleteAll(client.get().getEmails());

		clientRepository.delete(client.get());
	}
}
