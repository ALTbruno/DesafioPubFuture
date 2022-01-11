package com.ALTbruno.DesafioPubFuture.repository;

import com.ALTbruno.DesafioPubFuture.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer> {

	List<Receita> findByTipoReceita(String tipoReceita);

}
