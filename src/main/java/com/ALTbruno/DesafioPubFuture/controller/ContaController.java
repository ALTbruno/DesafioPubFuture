package com.ALTbruno.DesafioPubFuture.controller;

import com.ALTbruno.DesafioPubFuture.model.Conta;
import com.ALTbruno.DesafioPubFuture.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
@RequestMapping("/contas")
public class ContaController {

	private ContaRepository contaRepository;

	@Autowired
	private ContaController(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}

	@PostMapping
	public ResponseEntity<Conta> adicionarConta(@RequestBody Conta conta) {
		return ResponseEntity.status(HttpStatus.CREATED).body(contaRepository.save(conta));
	}

	@PutMapping("/{idConta}")
	public ResponseEntity<Conta> editarConta(@PathVariable Integer idConta, @RequestBody Conta conta) {
		ResponseEntity<Conta> response;
		if (contaRepository.findById(idConta).isPresent()) {
			conta.setIdConta(idConta);
			response = ResponseEntity.ok(contaRepository.save(conta));
		} else {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return response;
	}

	@GetMapping("/{idConta}")
	public   ResponseEntity<Optional<Conta>> buscarContaPeloId(@PathVariable Integer idConta) {
		return ResponseEntity.ok(contaRepository.findById(idConta));
	}

	@GetMapping
	public ResponseEntity<List<Conta>> listarContas() {
		return ResponseEntity.ok(contaRepository.findAll());
	}

	@DeleteMapping("/{idConta}")
	public void removerContaPeloId(@PathVariable Integer idConta) {
		contaRepository.deleteById(idConta);
	}
}
