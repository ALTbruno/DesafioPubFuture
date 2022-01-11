package com.ALTbruno.DesafioPubFuture.repository;

import com.ALTbruno.DesafioPubFuture.model.Despesa;
import com.ALTbruno.DesafioPubFuture.model.TipoDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Integer> {

	List<Despesa> findByTipoDespesa(TipoDespesa tipoDespesa);

	@Query("SELECT SUM(d.valorDespesa) FROM Despesa d")
	BigDecimal totalDespesas();

	@Query(value = "SELECT SUM(valor_despesa) FROM tb_despesas WHERE id_conta = ?1", nativeQuery = true)
	BigDecimal getTotalDespesasPorConta(Integer idConta);

}
