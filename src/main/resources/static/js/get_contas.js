const url = 'http://localhost:8080/contas';
const boasVindas = document.querySelector('.boas-vindas');
const listaContas = document.getElementById('listaContas');
const adicionarContaForm = document.querySelector('.adicionar-conta-form');
let agenciaValue = document.getElementById('agenciaValue');
let contaValue = document.getElementById('contaValue');
let tipoValue = document.getElementById('tipoValue');
let saldoValue = document.getElementById('saldoValue');
let codigoValue = document.getElementById('codigoValue');
let bancoValue = document.getElementById('bancoValue');

let cardConta = '';
let home = '';

const renderContas = (contas) => {

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
							<button class="btn btn-danger" id="apagaConta" data-bs-toggle="modal" data-bs-target="#apagarContaModal" >Apagar</button>
						</div>
					</div>
					`;
	});
	listaContas.innerHTML = cardConta;
};

const renderHome = () => {

	home +=
			`
			<div class="card text-center card border-info mb-3">
				<div class="card-header">
					Olá!
				</div>
				<div class="card-body">
					<h5 class="card-title">Seja bem-vindo ao seu Gerenciador Financeiro.</h5>
					<p class="card-text">Não identifiquei contas cadastradas. Para começar o organizar suas finanças é necessário que cadastre pelo menos uma conta clicando no botão abaixo.</p>
					<a href="#" class="btn btn-primary btn-lg btnAdicionarConta" data-bs-target="#adicionarContaModal" data-bs-toggle="modal">Adicionar Conta</a>
				</div>
			</div>
			`;
			boasVindas.innerHTML = home;
};

// GET
async function getContas() {
	try {

		const response = await fetch(url);
		const data = await response.json();
		
		if(data.length > 0) {
			renderContas(data);
		} else {
			renderHome();
		}
		
	} catch (error) {
		console.log(error);
	}
}
getContas();

// POST
adicionarContaForm.addEventListener('submit', (e) => {

	e.preventDefault();

	fetch(url, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({
			agenciaConta: agenciaValue.value,
			numeroConta: contaValue.value,
			tipoConta: tipoValue.value,
			saldoConta: saldoValue.value,
			instituicaoFinanceira: {
				codigoInstituicaoFinanceira: codigoValue.value,
				nomeInstituicaoFinanceira: bancoValue.value
			}
		})
	})
		.then(res => res.json())
		.then(data => {
			const dataArr = [];
			dataArr.push(data);
			renderContas(dataArr);
		});
		boasVindas.classList.toggle('d-none');
});

// DELETE
listaContas.addEventListener('click', (e) => {

	e.preventDefault();

	let btnApagarClicado = e.target.id == 'apagaConta'; //colocar esse id no botao apagar

	let idConta = e.target.parentElement.parentElement.dataset.id;

	if(btnApagarClicado) {
		try {		
			fetch(`${url}/${idConta}`, {
				method: 'DELETE',
			})
				.then(res => res)
				.then(() => location.reload());
			
			} catch (error) {
				console.log(error)
			};
	}
});
