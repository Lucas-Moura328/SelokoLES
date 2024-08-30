let addresses = [
    { endereco: "Rua Exemplo, 000", tipo: "Entrega" },
    { endereco: "Praça da Matriz, 33", tipo: "Cobrança" }
];

function populateAddressTable() {
    const tableBody = document.getElementById('address-table-body');
    tableBody.innerHTML = '';

    addresses.forEach((address, index) => {
        const row = document.createElement('tr');

        row.innerHTML = `
            <td>${address.endereco}</td>
            <td>${address.tipo}</td>
            <td class="table-actions">
                <button class="btn-edit-address" data-index="${index}"><i class="fas fa-pencil-alt"></i></button>
                <button class="btn-delete-address" data-index="${index}"><i class="fas fa-trash"></i></button>
            </td>
        `;

        tableBody.appendChild(row);
    });

    // Adicionar eventos de clique
    document.querySelectorAll('.btn-delete-address').forEach(button => {
        button.addEventListener('click', deleteAddress);
    });

    document.querySelectorAll('.btn-edit-address').forEach(button => {
        button.addEventListener('click', editAddress);
    });
}

function deleteAddress(event) {
    const addressIndex = event.target.closest('button').getAttribute('data-index');
    addresses.splice(addressIndex, 1); // Remove o endereço da lista
    populateAddressTable(); // Repopula a tabela
}

function editAddress(event) {
    const addressIndex = event.target.closest('button').getAttribute('data-index');
    window.location.href = `CadastroEndereco.html?id=${addressIndex}`;
}

// Inicializar a tabela
populateAddressTable();

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
