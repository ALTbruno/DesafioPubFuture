package com.ALTbruno.DesafioPubFuture.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_CONTAS")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConta;

	@NotNull
	@Size(max = 5)
	private String agenciaConta;

	@Size(min = 5, max = 15)
	private String numeroConta;

	@NotNull
	@Enumerated(value = EnumType.STRING)
	private TipoConta tipoConta;

	@NotNull
	private BigDecimal saldoConta;

	@NotNull
	@Enumerated(value = EnumType.STRING)
	private InstituicaoFinanceira instituicaoFinanceira;

	public Integer getIdConta() {
		return idConta;
	}

	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}

	public String getAgenciaConta() {
		return agenciaConta;
	}

	public void setAgenciaConta(String agenciaConta) {
		this.agenciaConta = agenciaConta;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public BigDecimal getSaldoConta() {
		return saldoConta;
	}

	public void setSaldoConta(BigDecimal saldoConta) {
		this.saldoConta = saldoConta;
	}

	public InstituicaoFinanceira getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}

	public void setInstituicaoFinanceira(InstituicaoFinanceira instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}
}
