package com.insurance.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.insurance.dao.ClientDao;
import com.insurance.dao.InsurancePolicyDao;
import com.insurance.dto.ApiResponse;
import com.insurance.dto.Client;
import com.insurance.dto.InsurancePolicy;

@Service
public class ClientService {

	@Autowired
	private InsurancePolicyDao insurancePolicyDao;

	@Autowired
	private ApiResponse<Client> clientResponse;

	@Autowired
	private ClientDao clientDao;

	@Autowired
	private ApiResponse<List<Client>> findAllclientResponse;

	public ApiResponse<Client> inserClient(Client client, int policyId) {

		InsurancePolicy insurancePolicy = insurancePolicyDao.getByInsurancePolicyId(policyId);

		if (Objects.isNull(insurancePolicy)) {
			clientResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			clientResponse.setMsg("Data is not saved.");
			clientResponse.setData(null);
		} else {
			client.setInsurancePolicy(insurancePolicy);
			clientDao.insertClinet(client);
			clientResponse.setStatusCode(HttpStatus.ACCEPTED.value());
			clientResponse.setMsg("C  successfully done.");
			clientResponse.setData(client);
		}
		return clientResponse;

	}

	public ApiResponse<Client> getByClientId(int clientId) {

		Client client = clientDao.getByClinetId(clientId);

		if (Objects.isNull(client)) {

			throw new RuntimeException("Cleint Details not found");
		}

		clientResponse.setStatusCode(HttpStatus.ACCEPTED.value());
		clientResponse.setMsg("Client exist.");
		clientResponse.setData(client);

		return clientResponse;

	}

	public ApiResponse<Client> deleteClient(int clientId) {

		Client client = clientDao.deleteClinetId(clientId);

		if (Objects.isNull(client)) {

			throw new RuntimeException("Client Details not found");
		}

		clientResponse.setStatusCode(HttpStatus.FOUND.value());
		clientResponse.setMsg("Client Deleted successfully.");
		clientResponse.setData(client);

		return clientResponse;

	}

	public ApiResponse<Client> updateClient(Client client) {

		Client updateClient = clientDao.getByClinetId(client.getClientId());

		if (Objects.isNull(updateClient)) {

			throw new RuntimeException("Client Details not found");
		}
		updateClient.setClientName(client.getClientName());
		updateClient.setClientAddress(client.getClientAddress());
		updateClient.setClientContactInformation(client.getClientContactInformation());
		updateClient.setClientDateOfBirth(client.getClientDateOfBirth());

		clientResponse.setStatusCode(HttpStatus.ACCEPTED.value());
		clientResponse.setMsg("Client Updated successfully.");
		clientResponse.setData(updateClient);

		return clientResponse;

	}

	public ApiResponse<List<Client>> displayAllClient() {

		List<Client> clients = clientDao.displayAllClinet();
		if (Objects.isNull(clients)) {
			findAllclientResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
			findAllclientResponse.setMsg("Client Details are not avalible.");
			findAllclientResponse.setData(null);
		} else {
			findAllclientResponse.setStatusCode(HttpStatus.FOUND.value());
			findAllclientResponse.setMsg("Client Details avalible.");
			findAllclientResponse.setData(clients);
		}

		return findAllclientResponse;
	}

}
