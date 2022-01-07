const listaContas = document.getElementById('listaContas');

const url = 'http://localhost:8080/contas';

let output = '';

var renderContas = (contas) => {

	contas.forEach(conta =>{
		output += 
					`
					<div class="card" data-id=${conta.idConta} style="width: 18rem;">
						<div class="card-header">Conta ${conta.instituicaoFinanceira.nomeInstituicaoFinanceira}</div>
						<ul class="list-group list-group-flush">
							<li class="list-group-item">Agência: ${conta.agenciaConta}</li>
							<li class="list-group-item">Número: ${conta.numeroConta}</li>
							<li class="list-group-item">Tipo: ${conta.tipoConta}</li>
							<li class="list-group-item">Saldo: ${conta.saldoConta}</li>
						</ul>
						<div class="btn-group" role="group" aria-label="Caixa com botões editar e apagar">
							<button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editarContaModal">Editar</button>
							<button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#apagarContaModal">Apagar</button>
						</div>
					</div>
					`;
	});
	listaContas.innerHTML = output;
}

async function getContas() {
	try {
		const response = await fetch(url);
		
		const data = await response.json();

		renderContas(data);

	} catch (error) {
		console.log(error);
	}
}

getContas();
