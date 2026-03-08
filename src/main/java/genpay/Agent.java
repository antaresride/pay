package genpay;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Agent {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;
    private String role;

    Agent() {}

    Agent(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @OneToMany(
        mappedBy = "agent",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Permission> permissions = new ArrayList<>();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Agent)) {
            return false;
        }
        Agent agent = (Agent) o;
        return (
            Objects.equals(this.id, agent.id) &&
            Objects.equals(this.name, agent.name) &&
            Objects.equals(this.role, agent.role)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.role);
    }

    @Override
    public String toString() {
        return (
            "Agent{" +
            "id=" +
            this.id +
            ", name='" +
            this.name +
            '\'' +
            ", role='" +
            this.role +
            '\'' +
            '}'
        );
    }
}
