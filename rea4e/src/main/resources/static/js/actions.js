const apiUrl = '/api'; // Altere para o URL da sua API

// Função para cadastrar usuário
document.getElementById('form-usuario').addEventListener('submit', function(event) {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const name = document.getElementById('name').value;
    const password = document.getElementById('password').value;

    fetch(`${apiUrl}/usuario/`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email, name, password })
    })
    .then(response => response.json())
    .then(data => {
        alert('Usuário cadastrado com sucesso!');
        document.getElementById('form-usuario').reset();
    })
    .catch(error => console.error('Erro:', error));
});

// Função para cadastrar curso
document.getElementById('form-curso').addEventListener('submit', function(event) {
    event.preventDefault();

    const titulo = document.getElementById('curso-titulo').value;
    const descricao = document.getElementById('curso-descricao').value;
    const imagemUrl = document.getElementById('curso-imagem').value;

    fetch(`${apiUrl}/cursos/`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ titulo, descricao, imagemUrl })
    })
    .then(response => response.json())
    .then(data => {
        alert('Curso cadastrado com sucesso!');
        document.getElementById('form-curso').reset();
    })
    .catch(error => console.error('Erro:', error));
});

// Função para cadastrar REA
document.getElementById('form-rea').addEventListener('submit', function(event) {
    event.preventDefault();

    const titulo = document.getElementById('rea-titulo').value;
    const descricao = document.getElementById('rea-descricao').value;
    const url = document.getElementById('rea-url').value;

    fetch(`${apiUrl}/recurso-educacional-aberto/`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ titulo, descricao, url })
    })
    .then(response => response.json())
    .then(data => {
        alert('Recurso educacional cadastrado com sucesso!');
        document.getElementById('form-rea').reset();
    })
    .catch(error => console.error('Erro:', error));
});

// Função para listar avaliações
function listarAvaliacoes(recursold) {
    fetch(`${apiUrl}/avaliacao/listar-avaliacoes/${recursold}`)
        .then(response => response.json())
        .then(data => {
            const lista = document.getElementById('avaliacao-list');
            lista.innerHTML = '';
            data.forEach(avaliacao => {
                const div = document.createElement('div');
                div.innerHTML = `<p>${avaliacao.comentario} - Nota: ${avaliacao.nota}</p>`;
                lista.appendChild(div);
            });
        })
        .catch(error => console.error('Erro ao listar avaliações:', error));
}

// Função para listar comentários
function listarComentarios(recursold) {
    fetch(`${apiUrl}/comentarios/recurso/${recursold}`)
        .then(response => response.json())
        .then(data => {
            const lista = document.getElementById('comentario-list');
            lista.innerHTML = '';
            data.forEach(comentario => {
                const div = document.createElement('div');
                div.innerHTML = `<p>${comentario.pergunta} - Usuário ID: ${comentario.usuario_id}</p>`;
                lista.appendChild(div);
            });
        })
        .catch(error => console.error('Erro ao listar comentários:', error));
}

// Chamar funções de listagem de avaliações e comentários
// Chame estas funções com um ID de recurso específico quando necessário
// listarAvaliacoes('1'); // Exemplo de uso
// listarComentarios('1'); // Exemplo de uso
