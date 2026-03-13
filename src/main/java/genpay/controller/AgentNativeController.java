package genpay.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import genpay.repository.AgentDTO;
import genpay.service.AgentApiService;

@RestController
public class AgentNativeController {

	private static final Logger log = LoggerFactory.getLogger(AgentNativeController.class);
	private final AgentApiService agentNativeApiService;

	AgentNativeController(AgentApiService agentNativeApiService) {
		this.agentNativeApiService = agentNativeApiService;
	}

	@GetMapping("/agents/native")
	List<AgentDTO> all() {
		return agentNativeApiService.nativeAgents();
	}
}
