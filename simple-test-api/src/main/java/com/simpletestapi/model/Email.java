package com.simpletestapi.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "OCUPATION")
	private String occupation;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "idClient")
	private Long idClient;
	
	public Email() {}

	public Email(Long id, String occupation, String name, String email, Long idClient) {
		super();
		this.id = id;
		this.occupation = occupation;
		this.name = name;
		this.email = email;
		this.idClient = idClient;
	}

	public Email(String occupation, String name, String email, Long idClient) {
		this.occupation = occupation;
		this.name = name;
		this.email = email;
		this.idClient = idClient;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idCLient) {
		this.idClient = idCLient;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, idClient, name, occupation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(idClient, other.idClient) && Objects.equals(name, other.name)
				&& Objects.equals(occupation, other.occupation);
	}

}
