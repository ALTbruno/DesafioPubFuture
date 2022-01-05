package com.ALTbruno.DesafioPubFuture.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_INSTITUICOESFINANCEIRAS")
public class InstituicaoFinanceira {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInstituicaoFinanceira;

	@NotNull
	@Size(min = 3, max = 3)
	private String codigoInstituicaoFinanceira;

	@NotNull
	@Size(max = 75)
	private String nomeInstituicaoFinanceira;


	public Integer getIdInstituicaoFinanceira() {
		return idInstituicaoFinanceira;
	}

	public void setIdInstituicaoFinanceira(Integer idInstituicaoFinanceira) {
		this.idInstituicaoFinanceira = idInstituicaoFinanceira;
	}

	public String getNomeInstituicaoFinanceira() {
		return nomeInstituicaoFinanceira;
	}

	public void setNomeInstituicaoFinanceira(String nomeInstituicaoFinanceira) {
		this.nomeInstituicaoFinanceira = nomeInstituicaoFinanceira;
	}

	public String getCodigoInstituicaoFinanceira() {
		return codigoInstituicaoFinanceira;
	}

	public void setCodigoInstituicaoFinanceira(String codigoInstituicaoFinanceira) {
		this.codigoInstituicaoFinanceira = codigoInstituicaoFinanceira;
	}
}
