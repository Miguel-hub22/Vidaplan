package org.generation.vidaplan.repository;

import java.util.Optional;

import org.generation.vidaplan.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long>{
	
	public Optional<Usuarios> findByUsuarioEmail(String usuarioEmail);
}
