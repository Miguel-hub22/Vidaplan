package org.generation.vidaplan.repository;


import java.math.BigDecimal;
import java.util.List;

import org.generation.vidaplan.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
	public List<Produtos> findAllByNomeContainingIgnoreCase(String nome);
	public List<Produtos> findAllByPreco(BigDecimal preco);
	public List<Produtos> findAllByRegiaoContainingIgnoreCase (String regiao);
}
