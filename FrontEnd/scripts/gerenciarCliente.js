let clients = [
    { nome: "Lucas Almeida Moura", cpf: "000.000.000-00", email: "lucas@exemplo.com", ativo: true },
    { nome: "Maria Aparecida Silva", cpf: "111.111.111-11", email: "maria@exemplo.com", ativo: false },
    { nome: "João Gomes Pereira", cpf: "222.222.222-22", email: "joao@exemplo.com", ativo: true },
    { nome: "Lucas Almeida Moura", cpf: "333.333.333-33", email: "lucas2@exemplo.com", ativo: true },
    { nome: "Maria Aparecida Silva", cpf: "444.444.444-44", email: "maria2@exemplo.com", ativo: false },
    { nome: "João Gomes Pereira", cpf: "555.555.555-55", email: "joao2@exemplo.com", ativo: true }

];

let clientToDeleteIndex = null;

function populateTable() {
    const tableBody = document.getElementById('client-table-body');
    tableBody.innerHTML = '';

    clients.forEach((client, index) => {
        const row = document.createElement('tr');
        const switchChecked = client.ativo ? 'checked' : '';

        row.innerHTML = `
            <td>${client.nome}</td>
            <td>${client.cpf}</td>
            <td>${client.email}</td>
            <td>
                <label class="switch">
                    <input type="checkbox" class="toggle-status" data-index="${index}" ${switchChecked}>
                    <span class="slider round"></span>
                </label>
            </td>
            <td>
                <a href="atualizarCliente.html" class="btn-edit"><i class="fas fa-pencil-alt"></i></a>
                <button class="btn-delete" data-index="${index}"><i class="fas fa-trash"></i></button>
            </td>
        `;

        tableBody.appendChild(row);
    });

    // Adicionar eventos de clique
    document.querySelectorAll('.btn-delete').forEach(button => {
        button.addEventListener('click', openDeleteModal);
    });

    document.querySelectorAll('.toggle-status').forEach(switchElement => {
        switchElement.addEventListener('change', toggleStatus);
    });
}

function openDeleteModal(event) {
    clientToDeleteIndex = event.target.closest('button').getAttribute('data-index');
    $('#confirmDeleteModal').modal('show');
}

function deleteClient() {
    if (clientToDeleteIndex !== null) {
        clients.splice(clientToDeleteIndex, 1);
        populateTable();
        clientToDeleteIndex = null;
    }
}




function toggleStatus(event) {
    const clientIndex = event.target.getAttribute('data-index');
    clients[clientIndex].ativo = event.target.checked;
}

// Ação ao confirmar exclusão
document.getElementById('confirmDeleteButton').addEventListener('click', () => {
    deleteClient();
    $('#confirmDeleteModal').modal('hide');
});

// Inicializar a tabela
populateTable();
