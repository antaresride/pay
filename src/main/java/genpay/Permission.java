package genpay;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Permission {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;

    Permission() {}

    Permission(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.LAZY) // Best practice for Virtual Threads
    @JoinColumn(name = "agent_id") // The Foreign Key column in PostgreSQL
    private Agent agent;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Permission)) {
            return false;
        }
        Permission permission = (Permission) o;
        return (
            Objects.equals(this.id, permission.id) &&
            Objects.equals(this.name, permission.name)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
        return (
            "Permission{" +
            "id=" +
            this.id +
            ", name='" +
            this.name +
            '\'' +
            '}'
        );
    }
}
