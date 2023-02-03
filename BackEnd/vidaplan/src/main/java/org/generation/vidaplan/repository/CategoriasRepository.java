package org.generation.vidaplan.repository;

import java.util.List;


import org.generation.vidaplan.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
	public List<Categorias> findAllByTipoContainingIgnoreCase(String tipo);
}
