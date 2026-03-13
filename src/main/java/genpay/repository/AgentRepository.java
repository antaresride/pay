package genpay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import genpay.entity.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {
	List<AgentDTO> findAllBy();
}
