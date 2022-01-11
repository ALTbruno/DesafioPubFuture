package com.ALTbruno.DesafioPubFuture.repository;

import com.ALTbruno.DesafioPubFuture.model.Receita;
import com.ALTbruno.DesafioPubFuture.model.TipoReceita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer> {

	List<Receita> findByTipoReceita(TipoReceita tipoReceita);

}
