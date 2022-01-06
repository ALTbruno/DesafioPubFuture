package com.ALTbruno.DesafioPubFuture.repository;

import com.ALTbruno.DesafioPubFuture.model.InstituicaoFinanceira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstituicaoFinanceiraRepository extends JpaRepository<InstituicaoFinanceira, Integer> {

	Optional<InstituicaoFinanceira> findByCodigoInstituicaoFinanceira (String CodigoInstituicaoFinanceira);

	InstituicaoFinanceira getByCodigoInstituicaoFinanceira (String CodigoInstituicaoFinanceira);
}
