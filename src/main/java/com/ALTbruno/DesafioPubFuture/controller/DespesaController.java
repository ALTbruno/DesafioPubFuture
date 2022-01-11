package com.ALTbruno.DesafioPubFuture.controller;

import com.ALTbruno.DesafioPubFuture.model.Despesa;
import com.ALTbruno.DesafioPubFuture.model.TipoDespesa;
import com.ALTbruno.DesafioPubFuture.repository.ContaRepository;
import com.ALTbruno.DesafioPubFuture.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
@RequestMapping("/despesas")
public class DespesaController {


	private DespesaRepository despesaRepository;
	private ContaRepository contaRepository;

	@Autowired
	DespesaController(DespesaRepository despesaRepository, ContaRepository contaRepository) {
		this.despesaRepository = despesaRepository;
		this.contaRepository = contaRepository;
	}

	@PostMapping
	private ResponseEntity<Despesa> adicionarDespesa(@RequestBody Despesa despesa) {

		ResponseEntity<Despesa> response;
		if(contaRepository.findById(despesa.getConta().getIdConta()).isPresent()){
			response = ResponseEntity.ok(despesaRepository.save(despesa));
		} else {
			response =ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return response;
	}

	@PutMapping("/{idDespesa}")
	private ResponseEntity<Despesa> editarDespesa(@PathVariable Integer idDespesa, @RequestBody Despesa despesa) {

		despesa.setIdDespesa(idDespesa);

		if(despesa.getValorDespesa() == null){
			despesa.setValorDespesa(despesaRepository.findById(idDespesa).get().getValorDespesa());
		}
		if(despesa.getDataPagamento() == null){
			despesa.setDataPagamento(despesaRepository.findById(idDespesa).get().getDataPagamento());
		}
		if(despesa.getDataPagamentoEsperado() == null){
			despesa.setDataPagamentoEsperado(despesaRepository.findById(idDespesa).get().getDataPagamentoEsperado());
		}
		if(despesa.getTipoDespesa() == null){
			despesa.setTipoDespesa(despesaRepository.findById(idDespesa).get().getTipoDespesa());
		}
		if(despesa.getConta() == null){
			despesa.setConta(despesaRepository.findById(idDespesa).get().getConta());
		}

		return ResponseEntity.ok(despesaRepository.save(despesa));
	}

	@GetMapping
	private ResponseEntity<List<Despesa>> listarDespesas() {
		return ResponseEntity.ok(despesaRepository.findAll());
	}

	@GetMapping("/{idDespesa}")
	private  ResponseEntity<Optional<Despesa>> listarDespesaPeloId(@PathVariable Integer idDespesa) {
		return ResponseEntity.ok(despesaRepository.findById(idDespesa));
	}

	@GetMapping("/tipo/{tipoDespesa}")
	private ResponseEntity<List<Despesa>> listarDespesasPeloTipo(@PathVariable TipoDespesa tipoDespesa) {
		return ResponseEntity.ok(despesaRepository.findByTipoDespesa(tipoDespesa));
	}

	@DeleteMapping("/{idDespesa}")
	private void removerDespesaPeloId(@PathVariable Integer idDespesa) {
		despesaRepository.deleteById(idDespesa);
	}

	@GetMapping("total")
	private BigDecimal getTotalDespesas() {
		return despesaRepository.totalDespesas();
	}

	@GetMapping("/conta/{idConta}/total")
	private BigDecimal totalDespesasPorConta(@PathVariable Integer idConta) {
		return despesaRepository.getTotalDespesasPorConta(idConta);
	}
}
