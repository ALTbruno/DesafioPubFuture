package com.ALTbruno.DesafioPubFuture.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_RECEITAS")
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReceita;

	@NotNull
	@DecimalMin(value = "0")
	private BigDecimal valorReceita;

	@NotNull
	private LocalDate dataRecebimento;

	@NotNull
	private LocalDate dataRecebimentoEsperado;

	@NotNull
	@Size(max = 10)
	private String tipoReceita;

	@Size(max = 255)
	private String descricaoReceita;

	@ManyToOne
	@JoinColumn(name = "id_conta")
	private Conta conta;


	public Integer getIdReceita() {
		return idReceita;
	}

	public void setIdReceita(Integer idReceita) {
		this.idReceita = idReceita;
	}

	public BigDecimal getValorReceita() {
		return valorReceita;
	}

	public void setValorReceita(BigDecimal valorReceita) {
		this.valorReceita = valorReceita;
	}

	public LocalDate getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(LocalDate dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public LocalDate getDataRecebimentoEsperado() {
		return dataRecebimentoEsperado;
	}

	public void setDataRecebimentoEsperado(LocalDate dataRecebimentoEsperado) {
		this.dataRecebimentoEsperado = dataRecebimentoEsperado;
	}

	public String getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(String tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public String getDescricaoReceita() {
		return descricaoReceita;
	}

	public void setDescricaoReceita(String descricaoReceita) {
		this.descricaoReceita = descricaoReceita;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
