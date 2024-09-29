package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.dto.ApiResponse;
import com.insurance.dto.Client;
import com.insurance.service.ClientService;

@RestController
@RequestMapping("/api")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@PostMapping("/saveClient/{policyId}")
	public ApiResponse<Client> saveClient(@RequestBody Client client, @PathVariable int policyId) {
		return clientService.inserClient(client, policyId);
	}

	@GetMapping("/getByClientId/{clientId}")
	public ApiResponse<Client> getByClientId(@PathVariable int clientId) {
		return clientService.getByClientId(clientId);
	}

	@DeleteMapping("/deleteClient/{clientId}")
	public ApiResponse<Client> deleteClient(@PathVariable int clientId) {
		return clientService.deleteClient(clientId);
	}

	@PutMapping("/updateClient/{clientId}")
	public ApiResponse<Client> updateClient(@RequestBody Client client) {
		return clientService.updateClient(client);
	}

	@GetMapping("/displayAllClient")
	public ApiResponse<List<Client>> displayAllClient() {
		return clientService.displayAllClient();
	}

}
