package genpay.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import genpay.repository.AgentDTO;
import genpay.repository.AgentRepository;

@Service
public class AgentApiService {

	private final AgentRepository agentRepository;

	private static final Logger log = LoggerFactory.getLogger(AgentApiService.class);
	private final RestClient restClient;

	public AgentApiService(RestClient restClient, AgentRepository agentRepository) {
		this.restClient = restClient;
		this.agentRepository = agentRepository;
	}

	public List<AgentDTO> nativeAgents() {
		return agentRepository.findAllBy();
	}
}
