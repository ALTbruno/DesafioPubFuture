package com.ALTbruno.DesafioPubFuture.controller;

import com.ALTbruno.DesafioPubFuture.model.Despesa;
import com.ALTbruno.DesafioPubFuture.model.TipoDespesa;
import com.ALTbruno.DesafioPubFuture.repository.ContaRepository;
import com.ALTbruno.DesafioPubFuture.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
@RequestMapping("/despesas")
public class DespesaController {


	private DespesaRepository despesaRepository;
	private ContaRepository contaRepository;

	@Autowired
	private DespesaController(DespesaRepository despesaRepository, ContaRepository contaRepository) {
		this.despesaRepository = despesaRepository;
		this.contaRepository = contaRepository;
	}

	@PostMapping
	public ResponseEntity<Despesa> adicionarDespesa(@RequestBody Despesa despesa) {

		ResponseEntity<Despesa> response;
		if(contaRepository.findById(despesa.getConta().getIdConta()).isPresent()){
			response = ResponseEntity.ok(despesaRepository.save(despesa));
		} else {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return response;
	}

	@PutMapping("/{idDespesa}")
	public ResponseEntity<Despesa> editarDespesa(@PathVariable Integer idDespesa, @RequestBody Despesa despesa) {

		ResponseEntity<Despesa> response;
		if (despesaRepository.findById(idDespesa).isPresent()) {
			despesa.setIdDespesa(idDespesa);
			response = ResponseEntity.ok(despesaRepository.save(despesa));
		} else {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return response;
	}

	@GetMapping
	public ResponseEntity<List<Despesa>> listarDespesas() {
		return ResponseEntity.ok(despesaRepository.findAll());
	}

	@GetMapping("/{idDespesa}")
	public   ResponseEntity<Optional<Despesa>> listarDespesaPeloId(@PathVariable Integer idDespesa) {
		return ResponseEntity.ok(despesaRepository.findById(idDespesa));
	}

	@GetMapping("/tipo/{tipoDespesa}")
	public ResponseEntity<List<Despesa>> listarDespesasPeloTipo(@PathVariable TipoDespesa tipoDespesa) {
		return ResponseEntity.ok(despesaRepository.findByTipoDespesa(tipoDespesa));
	}

	@DeleteMapping("/{idDespesa}")
	public void removerDespesaPeloId(@PathVariable Integer idDespesa) {
		despesaRepository.deleteById(idDespesa);
	}

	@GetMapping("total")
	public BigDecimal totalDespesas() {
		return despesaRepository.totalDespesas();
	}

	@GetMapping("/conta/{idConta}/total")
	public BigDecimal totalDespesasPorConta(@PathVariable Integer idConta) {
		return despesaRepository.getTotalDespesasPorConta(idConta);
	}

	@GetMapping("/data-pagamento/{dataInicial}/{dataFinal}")
	public List<Despesa> findByDataPagamento(
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			@PathVariable LocalDate dataInicial,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			@PathVariable LocalDate dataFinal){
		return despesaRepository.findAllByDataPagamentoBetween(dataInicial, dataFinal);
	}

	@GetMapping("/data-pagamento-esperado/{dataInicial}/{dataFinal}")
	public List<Despesa> findByDataPagamentoEsperado(
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			@PathVariable LocalDate dataInicial,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			@PathVariable LocalDate dataFinal){
		return despesaRepository.findAllByDataPagamentoEsperadoBetween(dataInicial, dataFinal);
	}
}
