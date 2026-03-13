package genpay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import genpay.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
	List<PermissiontDTO> findAllBy();
}
