package com.ALTbruno.DesafioPubFuture.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public enum InstituicaoFinanceira {

	ITAU,
	BRADESCO,
	SANTANDER,
	BANCO_DO_BRASIL,
	CAIXA,
	NUBANK,
	INTER,
	PAGBANK,
	BARI,
	C6

}
