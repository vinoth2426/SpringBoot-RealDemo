package com.insurance.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.dto.Client;
import com.insurance.repository.ClientRepository;

@Repository
public class ClientDao {

	@Autowired
	private ClientRepository clientRepository;

	public Client insertClinet(Client client) {
		return clientRepository.save(client);
	}

	public Client getByClinetId(int clientId) {

		Optional<Client> optinal = clientRepository.findById(clientId);

		if (optinal.isPresent()) {
			return optinal.get();
		}

		return null;
	}

	public Client deleteClinetId(int clientId) {
		Optional<Client> optinal = clientRepository.findById(clientId);
		if (optinal.isPresent()) {
			clientRepository.deleteById(clientId);
			return optinal.get();
		}
		return null;
	}

	public Client updateClient(Client claim) {
		return clientRepository.save(claim);
	}

	public List<Client> displayAllClinet() {

		return clientRepository.findAll();
	}

}
