package com.ALTbruno.DesafioPubFuture.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_DESPESAS")
public class Despesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDespesa;

	@NotNull
	@DecimalMin(value = "0")
	private BigDecimal valorDespesa;

	@NotNull
	private LocalDate dataPagamento;

	@NotNull
	private LocalDate dataPagamentoEsperado;

	@NotNull
	@Enumerated(value = EnumType.STRING)
	private TipoDespesa tipoDespesa;

	@ManyToOne
	@JoinColumn(name = "id_conta")
	private Conta conta;


	public Integer getIdDespesa() {
		return idDespesa;
	}

	public void setIdDespesa(Integer idDespesa) {
		this.idDespesa = idDespesa;
	}

	public BigDecimal getValorDespesa() {
		return valorDespesa;
	}

	public void setValorDespesa(BigDecimal valorDespesa) {
		this.valorDespesa = valorDespesa;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public LocalDate getDataPagamentoEsperado() {
		return dataPagamentoEsperado;
	}

	public void setDataPagamentoEsperado(LocalDate dataPagamentoEsperado) {
		this.dataPagamentoEsperado = dataPagamentoEsperado;
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
