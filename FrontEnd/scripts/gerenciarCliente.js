const url = "http://localhost:8080/clientes";

let clients = [];

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
            <td>${client.email.email}</td>
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

async function deleteClient() {
    if (clientToDeleteIndex !== null) {
        const clientId = clients[clientToDeleteIndex].idCliente; // Obtém o ID do cliente a ser excluído
        try {
            const response = await fetch(`${url}/${clientId}`, {
                method: 'DELETE',
            });

            if (!response.ok) {
                throw new Error('Erro ao excluir cliente');
            }

            // Se a exclusão for bem-sucedida, remove o cliente da lista local
            clients.splice(clientToDeleteIndex, 1);
            populateTable(); // Repopula a tabela
            clientToDeleteIndex = null; // Reseta o índice do cliente a ser deletado
        } catch (error) {
            console.error('Erro ao excluir o cliente:', error);
        }
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

async function getApi(url) {
    try {
        const response = await fetch(url, {method: "GET"});
        if (!response.ok) {
            throw new Error('Erro ao buscar dados da API');
        }
        clients = await response.json(); // Atualiza a lista de clientes com os dados da API
        populateTable(); // Repopula a tabela com os novos dados
    } catch (error) {
        console.error('Erro ao buscar os dados:', error);
    }
}

// Inicializar a tabela com dados da API
getApi(url);
