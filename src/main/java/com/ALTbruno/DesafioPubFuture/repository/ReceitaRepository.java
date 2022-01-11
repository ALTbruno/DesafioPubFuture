package com.ALTbruno.DesafioPubFuture.repository;

import com.ALTbruno.DesafioPubFuture.model.Conta;
import com.ALTbruno.DesafioPubFuture.model.Receita;
import com.ALTbruno.DesafioPubFuture.model.TipoReceita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer> {

	List<Receita> findByTipoReceita(TipoReceita tipoReceita);

	@Query("SELECT SUM(r.valorReceita) FROM Receita r")
	BigDecimal totalReceitas();

//	@Query("SELECT SUM(r.valorReceita) FROM Receita r WHERE r.idConta = ?1")
//	BigDecimal totalReceitasPorConta(Integer idConta);

	@Query(value = "SELECT SUM(valor_receita) FROM tb_receitas WHERE id_conta = ?1", nativeQuery = true)
	BigDecimal getTotalReceitasPorConta(Integer idConta);

}
