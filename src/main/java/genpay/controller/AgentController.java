package genpay.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import genpay.component.Recovery;
import genpay.entity.Agent;
import genpay.repository.AgentDTO;
import genpay.repository.AgentRepository;

@RestController
public class AgentController {

	private static final Logger log = LoggerFactory.getLogger(AgentController.class);
	private final AgentRepository repository;
	private final Recovery recovery;

	AgentController(AgentRepository repository, Recovery recovery) {
		this.repository = repository;
		this.recovery = recovery;
	}

	@GetMapping("/agents")
	List<AgentDTO> all() {
		log.info(recovery.recovery());
		return repository.findAllBy();
	}

	@GetMapping("/agents/{id}")
	Agent one(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent not found"));
	}

	@DeleteMapping("/agents/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
