package com.ALTbruno.DesafioPubFuture.repository;

import com.ALTbruno.DesafioPubFuture.model.Despesa;
import com.ALTbruno.DesafioPubFuture.model.TipoDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Integer> {

	List<Despesa> findByTipoDespesa(TipoDespesa tipoDespesa);

}
