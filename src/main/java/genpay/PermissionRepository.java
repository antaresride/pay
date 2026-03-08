package genpay;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

record PermissiontDTO(Long id, String name) {}

interface PermissionRepository extends JpaRepository<Permission, Long> {
    List<PermissiontDTO> findAllBy();
}
