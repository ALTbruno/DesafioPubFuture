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
	ReceitaController(ReceitaRepository receitaRepository, ContaRepository contaRepository) {
		this.receitaRepository = receitaRepository;
		this.contaRepository = contaRepository;
	}

	@PostMapping
	private ResponseEntity<Receita> adicionarReceita(@RequestBody Receita receita) {

		ResponseEntity<Receita> response;
		if(contaRepository.findById(receita.getConta().getIdConta()).isPresent()){
			response = ResponseEntity.ok(receitaRepository.save(receita));
		} else {
			response =ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return response;
	}

	@PutMapping("/{idReceita}")
	private ResponseEntity<Receita> editarReceita(@PathVariable Integer idReceita, @RequestBody Receita receita) {

		receita.setIdReceita(idReceita);

		if(receita.getValorReceita() == null){
			receita.setValorReceita(receitaRepository.findById(idReceita).get().getValorReceita());
		}
		if(receita.getDataRecebimento() == null){
			receita.setDataRecebimento(receitaRepository.findById(idReceita).get().getDataRecebimento());
		}
		if(receita.getDataRecebimentoEsperado() == null){
			receita.setDataRecebimentoEsperado(receitaRepository.findById(idReceita).get().getDataRecebimentoEsperado());
		}
		if(receita.getTipoReceita() == null){
			receita.setTipoReceita(receitaRepository.findById(idReceita).get().getTipoReceita());
		}
		if(receita.getDescricaoReceita() == null){
			receita.setDescricaoReceita(receitaRepository.findById(idReceita).get().getDescricaoReceita());
		}
		if(receita.getConta() == null){
			receita.setConta(receitaRepository.findById(idReceita).get().getConta());
		}

		return ResponseEntity.ok(receitaRepository.save(receita));
	}

	@GetMapping
	private ResponseEntity<List<Receita>> listarReceitas() {
		return ResponseEntity.ok(receitaRepository.findAll());
	}

	@GetMapping("/{idReceita}")
	private  ResponseEntity<Optional<Receita>> listarReceitaPeloId(@PathVariable Integer idReceita) {
		return ResponseEntity.ok(receitaRepository.findById(idReceita));
	}

	@GetMapping("/tipo/{tipoReceita}")
	private ResponseEntity<List<Receita>> listarReceitasPeloTipo(@PathVariable TipoReceita tipoReceita) {
		return ResponseEntity.ok(receitaRepository.findByTipoReceita(tipoReceita));
	}

	@DeleteMapping("/{idReceita}")
	private void removerReceitaPeloId(@PathVariable Integer idReceita) {
		receitaRepository.deleteById(idReceita);
	}

	@GetMapping("total")
	private BigDecimal getTotalReceitas() {
		return receitaRepository.totalReceitas();
	}

	@GetMapping("/conta/{idConta}/total")
	private BigDecimal totalReceitasPorConta(@PathVariable Integer idConta) {
		return receitaRepository.getTotalReceitasPorConta(idConta);
	}

	//	@GetMapping("/datainicial={dataInicial}&datafinal={dataFinal}")
	@GetMapping("/datarecebimento/{dataInicial}/{dataFinal}")
	List<Receita> findByDataRecebimento(
				@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
				@PathVariable LocalDate dataInicial,
				@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
				@PathVariable LocalDate dataFinal){
			return receitaRepository.findAllByDataRecebimentoBetween(dataInicial, dataFinal);
		}

	@GetMapping("/datarecebimentoesperado/{dataInicial}/{dataFinal}")
	List<Receita> findByDataRecebimentoEsperado(
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			@PathVariable LocalDate dataInicial,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			@PathVariable LocalDate dataFinal){
		return receitaRepository.findAllByDataRecebimentoEsperadoBetween(dataInicial, dataFinal);
	}
}
