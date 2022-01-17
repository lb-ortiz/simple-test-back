package com.simpletestapi.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simpletestapi.model.Client;
import com.simpletestapi.repository.ClientRepository;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("api/client")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping
	public List<Client> list() {
		return clientRepository.findAll();
	}
}
