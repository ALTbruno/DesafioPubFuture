const listaContas = document.getElementById('listaContas');

async function getContas() {
	try {
		const response = await fetch('http://localhost:8080/contas');
		
		const data = await response.json();
		console.log(data);

		data.map((conta) => {

			const card = document.createElement('div'); card.classList.add('card'); card.style.width = '18rem';
				const cardHeader = document.createElement('div'); cardHeader.classList.add('card-header'); cardHeader.innerText = `Conta ${conta.instituicaoFinanceira.nomeInstituicaoFinanceira}`; card.append(cardHeader);
				const infosConta = document.createElement('ul'); infosConta.classList.add('list-group','list-group-flush'); card.append(infosConta);
					const agencia = document.createElement('li'); agencia.classList.add('list-group-item'); agencia.innerText = `Agência: ${conta.agenciaConta}`; infosConta.append(agencia);
					const numero = document.createElement('li'); numero.classList.add('list-group-item'); numero.innerText = `Número: ${conta.numeroConta}`; infosConta.append(numero);
					const tipo = document.createElement('li'); tipo.classList.add('list-group-item'); tipo.innerText = `Tipo: ${conta.tipoConta}`; infosConta.append(tipo);
					const saldo = document.createElement('li'); saldo.classList.add('list-group-item'); saldo.innerText = `Saldo: ${conta.saldoConta}`; infosConta.append(saldo);
				const btnDiv = document.createElement('div'); btnDiv.classList.add('btn-group'); btnDiv.setAttribute('role', 'group'); btnDiv.setAttribute('aria-label', 'Basic mixed styles example'); card.append(btnDiv);
					const btnEditar = document.createElement('button'); btnEditar.classList.add('btn', 'btn-primary'); btnEditar.innerText = 'Editar'; btnDiv.append(btnEditar);
					const btnApagar = document.createElement('button'); btnApagar.classList.add('btn', 'btn-danger'); btnApagar.innerText = 'Apagar'; btnDiv.append(btnApagar);

			  listaContas.append(card)
		})
	} catch (error) {
		console.log(error);
	}
}

getContas();
