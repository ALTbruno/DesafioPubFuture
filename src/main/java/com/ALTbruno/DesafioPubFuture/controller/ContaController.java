package com.ALTbruno.DesafioPubFuture.controller;

import com.ALTbruno.DesafioPubFuture.model.Conta;
import com.ALTbruno.DesafioPubFuture.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contas")
public class ContaController {

	ContaRepository contaRepository;

	@Autowired
	public ContaController(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}

	@PostMapping
	private ResponseEntity<Conta> adicionarConta(@RequestBody Conta conta) {
		return ResponseEntity.status(HttpStatus.CREATED).body(contaRepository.save(conta));
	}

	@PutMapping
	private ResponseEntity<Conta> editarConta(@RequestBody Conta conta) {
		return ResponseEntity.status(HttpStatus.OK).body(contaRepository.save(conta));
//		return ResponseEntity.ok(contaRepository.save(conta));

//		ResponseEntity<Conta> response = null;
//
//		if(conta.getIdConta() != null && contaRepository.findById(conta.getIdConta()).isPresent())
//			response = ResponseEntity.ok(contaRepository.save(conta));
//
//		return response;
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
