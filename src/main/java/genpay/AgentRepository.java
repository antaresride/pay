package genpay;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

record AgentDTO(Long id, String name, String role) {}

interface AgentRepository extends JpaRepository<Agent, Long> {
    List<AgentDTO> findAllBy();
}
