package com.ALTbruno.DesafioPubFuture.controller;

import com.ALTbruno.DesafioPubFuture.model.Receita;
import com.ALTbruno.DesafioPubFuture.model.TipoReceita;
import com.ALTbruno.DesafioPubFuture.repository.ContaRepository;
import com.ALTbruno.DesafioPubFuture.repository.ReceitaRepository;
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
@RequestMapping("/receitas")
public class ReceitaController {

	private ReceitaRepository receitaRepository;
	private ContaRepository contaRepository;

	@Autowired
	private ReceitaController(ReceitaRepository receitaRepository, ContaRepository contaRepository) {
		this.receitaRepository = receitaRepository;
		this.contaRepository = contaRepository;
	}

	@PostMapping
	public ResponseEntity<Receita> adicionarReceita(@RequestBody Receita receita) {

		ResponseEntity<Receita> response;
		if(contaRepository.findById(receita.getConta().getIdConta()).isPresent()){
			response = ResponseEntity.ok(receitaRepository.save(receita));
		} else {
			response =ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return response;
	}

	@PutMapping("/{idReceita}")
	public ResponseEntity<Receita> editarReceita(@PathVariable Integer idReceita, @RequestBody Receita receita) {

		ResponseEntity<Receita> response;
		if (receitaRepository.findById(idReceita).isPresent()) {
			receita.setIdReceita(idReceita);
			response = ResponseEntity.ok(receitaRepository.save(receita));
		} else {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return response;
	}

	@GetMapping
	public ResponseEntity<List<Receita>> listarReceitas() {
		return ResponseEntity.ok(receitaRepository.findAll());
	}

	@GetMapping("/{idReceita}")
	public   ResponseEntity<Optional<Receita>> buscarReceitaPeloId(@PathVariable Integer idReceita) {
		return ResponseEntity.ok(receitaRepository.findById(idReceita));
	}

	@GetMapping("/tipo/{tipoReceita}")
	public ResponseEntity<List<Receita>> listarReceitasPeloTipo(@PathVariable TipoReceita tipoReceita) {
		return ResponseEntity.ok(receitaRepository.findByTipoReceita(tipoReceita));
	}

	@DeleteMapping("/{idReceita}")
	public void removerReceitaPeloId(@PathVariable Integer idReceita) {
		receitaRepository.deleteById(idReceita);
	}

	@GetMapping("total")
	public BigDecimal totalReceitas() {
		return receitaRepository.totalReceitas();
	}

	@GetMapping("/conta/{idConta}/total")
	private BigDecimal totalReceitasPorConta(@PathVariable Integer idConta) {
		return receitaRepository.getTotalReceitasPorConta(idConta);
	}

	//	@GetMapping("/datainicial={dataInicial}&datafinal={dataFinal}")
	@GetMapping("/data-recebimento/{dataInicial}/{dataFinal}")
	public List<Receita> findByDataRecebimento(
				@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
				@PathVariable LocalDate dataInicial,
				@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
				@PathVariable LocalDate dataFinal){
			return receitaRepository.findAllByDataRecebimentoBetween(dataInicial, dataFinal);
		}

	@GetMapping("/data-recebimento-esperado/{dataInicial}/{dataFinal}")
	public List<Receita> findByDataRecebimentoEsperado(
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			@PathVariable LocalDate dataInicial,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			@PathVariable LocalDate dataFinal){
		return receitaRepository.findAllByDataRecebimentoEsperadoBetween(dataInicial, dataFinal);
	}
}
