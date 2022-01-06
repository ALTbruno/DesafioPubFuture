package com.ALTbruno.DesafioPubFuture.controller;

import com.ALTbruno.DesafioPubFuture.model.Conta;
import com.ALTbruno.DesafioPubFuture.model.InstituicaoFinanceira;
import com.ALTbruno.DesafioPubFuture.repository.ContaRepository;
import com.ALTbruno.DesafioPubFuture.repository.InstituicaoFinanceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contas")
public class ContaController {

	private ContaRepository contaRepository;
	private InstituicaoFinanceiraRepository instituicaoFinanceiraRepository;

	@Autowired
	private ContaController(ContaRepository contaRepository, InstituicaoFinanceiraRepository instituicaoFinanceiraRepository) {
		this.contaRepository = contaRepository;
		this.instituicaoFinanceiraRepository = instituicaoFinanceiraRepository;
	}

	@PostMapping
	private ResponseEntity<Conta> adicionarConta(@RequestBody Conta conta) {
		if(instituicaoFinanceiraRepository.findByCodigoInstituicaoFinanceira(conta.getInstituicaoFinanceira().getCodigoInstituicaoFinanceira()).isPresent()) {

			InstituicaoFinanceira i = instituicaoFinanceiraRepository.getByCodigoInstituicaoFinanceira(conta.getInstituicaoFinanceira().getCodigoInstituicaoFinanceira());

			conta.setInstituicaoFinanceira(i);
			return ResponseEntity.status(HttpStatus.CREATED).body(contaRepository.save(conta));
		} else
		return ResponseEntity.status(HttpStatus.CREATED).body(contaRepository.save(conta));
	}

	@PutMapping("/{idConta}")
	private ResponseEntity<Conta> editarConta(@PathVariable Integer idConta, @RequestBody Conta conta) {

		conta.setIdConta(idConta);

//		DEVIDO AS PROPRIEDADES DA CONTA NÃO ACEITAREM VALORES NULOS ERA NECESSÁRIO
//		INFORMAR TODOS OS CAMPOS NO MOMENTO DE ATUALIZAR
//		conta.setAgenciaConta(conta.getAgenciaConta());
//		conta.setNumeroConta(conta.getNumeroConta());
//		conta.setTipoConta(conta.getTipoConta());
//		conta.setSaldoConta(conta.getSaldoConta());
//		conta.setInstituicaoFinanceira(conta.getInstituicaoFinanceira());

		if(conta.getAgenciaConta() == null){
			conta.setAgenciaConta(contaRepository.findById(idConta).get().getAgenciaConta());
		}
		if(conta.getNumeroConta() == null){
			conta.setNumeroConta(contaRepository.findById(idConta).get().getNumeroConta());
		}
		if(conta.getTipoConta() == null){
			conta.setTipoConta(contaRepository.findById(idConta).get().getTipoConta());
		}
		if(conta.getSaldoConta() == null){
			conta.setSaldoConta(contaRepository.findById(idConta).get().getSaldoConta());
		}
		if(conta.getInstituicaoFinanceira() == null){
			conta.setInstituicaoFinanceira(contaRepository.findById(idConta).get().getInstituicaoFinanceira());
		}

		return ResponseEntity.ok(contaRepository.save(conta));
	}

	@GetMapping("/{idConta}")
	private  ResponseEntity<Optional<Conta>> listarContaPeloId(@PathVariable Integer idConta) {
		return ResponseEntity.ok(contaRepository.findById(idConta));
	}

	@GetMapping
	private ResponseEntity<List<Conta>> listarContas() {
		return ResponseEntity.ok(contaRepository.findAll());
	}

	@DeleteMapping("/{idConta}")
	private void removerContaPeloId(@PathVariable Integer idConta) {
		contaRepository.deleteById(idConta);
	}
}
