// Remover o array de mockup
// let addresses = [
//     { endereco: "Rua Exemplo, 000", tipo: "Entrega" },
//     { endereco: "Praça da Matriz, 33", tipo: "Cobrança" }
// ];

let addresses = [];

// Função para buscar endereços da API pelo ID do cliente
async function fetchAddresses(clientId) {
    try {
        const response = await fetch(`http://localhost:8080/Enderecos/idCliente/${clientId}`);
        if (!response.ok) {
            throw new Error('Erro ao buscar endereços');
        }
        addresses = await response.json(); // Atualiza a lista de endereços
        populateAddressTable(); // Popula a tabela com os dados da API
    } catch (error) {
        console.error('Erro ao buscar endereços:', error);
    }
}

// Função para popular a tabela com os endereços vindos da API
function populateAddressTable() {
    const tableBody = document.getElementById('address-table-body');
    tableBody.innerHTML = '';

    addresses.forEach((address, index) => {
        const row = document.createElement('tr');

        row.innerHTML = `
            <td>${address.logradouro}, ${address.numero} - ${address.bairro}, ${address.municipio}, ${address.estado}</td>
            <td>${address.entrega ? 'Entrega' : 'Cobrança'}</td>
            <td class="table-actions">
                <button class="btn-edit-address" data-index="${index}"><i class="fas fa-pencil-alt"></i></button>
                <button class="btn-delete-address" data-index="${index}"><i class="fas fa-trash"></i></button>
            </td>
        `;

        tableBody.appendChild(row);
    });

    // Adicionar eventos de clique para os botões de editar e deletar
    document.querySelectorAll('.btn-delete-address').forEach(button => {
        button.addEventListener('click', deleteAddress);
    });

    document.querySelectorAll('.btn-edit-address').forEach(button => {
        button.addEventListener('click', editAddress);
    });
}

// Função para deletar um endereço (mock local por enquanto)
async function deleteAddress(event) {
    const addressIndex = event.target.closest('button').getAttribute('data-index');
    const addressId = addresses[addressIndex].idEndereco; // Pegue o ID do endereço a ser deletado

    const confirmed = confirm('Tem certeza que deseja deletar este endereço?'); // Confirmar antes de deletar
    if (!confirmed) return;

    try {
        const response = await fetch(`http://localhost:8080/Enderecos/${addressId}`, {
            method: 'DELETE',
        });

        if (!response.ok) {
            throw new Error('Erro ao deletar endereço');
        }

        // Remove o endereço da lista local após deletar com sucesso
        addresses.splice(addressIndex, 1);
        populateAddressTable(); // Atualiza a tabela

        alert('Endereço deletado com sucesso!');
    } catch (error) {
        console.error('Erro ao deletar o endereço:', error);
        alert('Erro ao deletar o endereço.');
    }
}

// Função para editar um endereço
function editAddress(event) {
    const addressIndex = event.target.closest('button').getAttribute('data-index');
    window.location.href = `CadastroEndereco.html?id=${addressIndex}`;
}

// Chamada ao carregar a página para buscar os endereços do cliente
document.addEventListener('DOMContentLoaded', () => {
    const clientId = getClientIdFromURL(); // Função que já existe no seu código para pegar o idCliente da URL
    if (clientId) {
        fetchAddresses(clientId); // Busca os endereços do cliente e preenche a tabela
    }
});



let cards = [
    { numero: "**** **** **** 1234", tipo: "Crédito" },
    { numero: "**** **** **** 5678", tipo: "Débito" }
];

function populateCardTable() {
    const tableBody = document.getElementById('card-table-body');
    tableBody.innerHTML = '';

    cards.forEach((card, index) => {
        const row = document.createElement('tr');

        row.innerHTML = `
            <td>${card.numero}</td>
            <td>${card.tipo}</td>
            <td class="table-actions">
                <button class="btn-edit-cards" data-index="${index}"><i class="fas fa-pencil-alt"></i></button>
                <button class="btn-delete-cards" data-index="${index}"><i class="fas fa-trash"></i></button>
            </td>
        `;

        tableBody.appendChild(row);
    });

    // Adicionar eventos de clique
    document.querySelectorAll('.btn-delete-cards').forEach(button => {
        button.addEventListener('click', deleteCard);
    });

    document.querySelectorAll('.btn-edit-cards').forEach(button => {
        button.addEventListener('click', editCard);
    });
}

function deleteCard(event) {
    const cardIndex = event.target.closest('button').getAttribute('data-index');
    cards.splice(cardIndex, 1); // Remove o cartão da lista
    populateCardTable(); // Repopula a tabela
}

function editCard(event) {
    const cardIndex = event.target.closest('button').getAttribute('data-index');
    window.location.href = `CadastrarCartao.html?id=${cardIndex}`;
}

// Inicializar a tabela
populateCardTable();

document.getElementById('submit-client').addEventListener('click', function(event) {
    const addressTableBody = document.querySelector('.table-addresses tbody');
    const cardTableBody = document.querySelector('.table-cards tbody');

    const isAddressTableEmpty = addressTableBody ? addressTableBody.children.length === 0 : true;
    const isCardTableEmpty = cardTableBody ? cardTableBody.children.length === 0 : true;

    if (isAddressTableEmpty || isCardTableEmpty) {
        event.preventDefault();
        event.stopPropagation();

        // Aqui você pode adicionar a lógica para mostrar a modal ou alertar o usuário
        alert('Por favor, adicione pelo menos um endereço e um cartão.');
    } else {
        // Verifica a validade do formulário usando o método de validação padrão
        const form = document.getElementById('create-address');
        if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
        }
        form.classList.add('was-validated');
    }
});



// Função para obter o idCliente da URL
function getClientIdFromURL() {
    const params = new URLSearchParams(window.location.search);
    return params.get("idCliente");  // Isso vai pegar o idCliente da URL
}

// Função para buscar os dados do cliente da API e preencher o formulário
async function fetchClientData(idCliente) {
    const url = `http://localhost:8080/clientes/${idCliente}`;
    
    try {
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error('Erro ao buscar dados do cliente');
        }
        const clientData = await response.json();
        populateForm(clientData);  // Preenche o formulário com os dados retornados
    } catch (error) {
        console.error('Erro ao buscar os dados do cliente:', error);
    }
}

// Função para preencher o formulário com os dados do cliente
function populateForm(clientData) {
    document.getElementById('pnome').value = clientData.nome;
    document.getElementById('email').value = clientData.email.email;
    document.getElementById('cpf').value = clientData.cpf;
    document.getElementById('dtNasc').value = clientData.dataNascimento;
    
    // Se telefone e ddd existirem
    if (clientData.telefone) {
        document.getElementById('ddd').value = clientData.telefone.ddd;
        document.getElementById('phone').value = clientData.telefone.telefone;
    }

    const genero = clientData.genero.toLowerCase(); // Converter para minúsculas para evitar problemas com case-sensitive

    if (genero === 'masculino') {
        document.getElementById('male').checked = true;
    } else if (genero === 'feminino') {
        document.getElementById('female').checked = true;
    } else if (genero === 'outros') {
        document.getElementById('other').checked = true;
    } else if (genero === 'prefiro não responder') {
        document.getElementById('noRespond').checked = true;
}
}

// Executar ao carregar a página
document.addEventListener('DOMContentLoaded', () => {
    const idCliente = getClientIdFromURL();
    if (idCliente) {
        fetchClientData(idCliente);
    }
});

