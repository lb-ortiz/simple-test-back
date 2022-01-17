package com.simpletestapi.model;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.simpletestapi.enums.StatusClientEnum;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NICKNAME")
	private String nickname;

	@Column(name = "INSCRIPTION")
	private String inscription;

	@Column(name = "NAME")
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private StatusClientEnum status;
	
	@OneToMany(mappedBy="idCLient")
    private Set<Email> emails;

	public Client() {}
	
	public Client(Long id, String nickname, String inscription, String name, StatusClientEnum status) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.inscription = inscription;
		this.name = name;
		this.status = status;
	}

	public Client(String nickname, String inscription, String name, StatusClientEnum status) {
		this.nickname = nickname;
		this.inscription = inscription;
		this.name = name;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getInscription() {
		return inscription;
	}

	public void setInscription(String inscription) {
		this.inscription = inscription;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StatusClientEnum getStatus() {
		return status;
	}

	public void setStatus(StatusClientEnum status) {
		this.status = status;
	}

	public Set<Email> getEmails() {
		return emails;
	}

	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emails, id, inscription, name, nickname, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(emails, other.emails) && Objects.equals(id, other.id)
				&& Objects.equals(inscription, other.inscription) && Objects.equals(name, other.name)
				&& Objects.equals(nickname, other.nickname) && status == other.status;
	}

	


}
