package com.ALTbruno.DesafioPubFuture.repository;

import com.ALTbruno.DesafioPubFuture.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
}
