const listaContas = document.getElementById('listaContas');
const section = document.querySelector('section');

const url = 'http://localhost:8080/contas';

let cardConta = '';
let home = '';

var renderContas = (contas) => {

	contas.forEach(conta =>{
		cardConta += 
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
	listaContas.innerHTML = cardConta;
}

async function getContas() {
	try {
		const response = await fetch(url);
		
		const data = await response.json();

		if(data.length > 0) {
			renderContas(data);
		} else {

			home +=
					`
					<div class="card text-center card border-info mb-3">
						<div class="card-header">
							Olá!
						</div>
						<div class="card-body">
							<h5 class="card-title">Seja bem-vindo ao seu Gerenciador Financeiro.</h5>
							<p class="card-text">Não identifiquei contas cadastradas. Para começar o organizar suas finanças é necessário que cadastre pelo menos uma conta clicando no botão abaixo.</p>
							<a href="#" class="btn btn-primary btn-lg adicionarConta">Adicionar Conta</a>
						</div>
					</div>
					`;
					section.innerHTML = home;
		}

	} catch (error) {
		console.log(error);
	}
}

getContas();
