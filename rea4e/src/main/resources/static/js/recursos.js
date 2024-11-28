const API_RECURSOS = 'api/recurso-educacional-aberto';

// Lista todos os recursos
async function carregarRecursos() {
    const response = await fetch(API_RECURSOS);
    const recursos = await response.json();
    return recursos;
}


// Função para carregar os recursos em um select
export function carregarObjetoRecurso() {
    const selectRecursos = document.querySelector("#recursos");
    selectRecursos.innerHTML = ""; // Limpa a lista de recursos antes de preencher
    carregarRecursos().then(recursos => {
        recursos.forEach(recurso => {
            const option = document.createElement("option");
            option.value = recurso.id;
            option.textContent = recurso.titulo;
            selectRecursos.appendChild(option);
        });
    }).catch(error => {
        console.error('Erro ao carregar os recursos:', error);
    });
}

// Nova função para carregar recursos por autor
export async function carregarRecursosPorAutor(autorId) {
    const response = await fetch(`${API_RECURSOS}/autor/${autorId}`);
    const recursos = await response.json();
    return recursos;
}

// Função para carregar os recursos por autor em um select
export function carregarRecursosPorAutorSelect(autorId) {
    const selectRecursos = document.querySelector("#recursos");
    selectRecursos.innerHTML = ""; // Limpa a lista de recursos antes de preencher
    carregarRecursosPorAutor(autorId).then(recursos => {
        recursos.forEach(recurso => {
            const option = document.createElement("option");
            option.value = recurso.id;
            option.textContent = recurso.titulo;
            selectRecursos.appendChild(option);
        });
    }).catch(error => {
        console.error('Erro ao carregar os recursos por autor:', error);
    });
}

// Nova função para carregar recursos por categoria
export async function carregarRecursosPorCategoria(categoria) {
    const response = await fetch(`${API_RECURSOS}/categoria/${categoria}`);
    const recursos = await response.json();
    return recursos;
}

// Função para carregar os recursos por categoria em um select
export function carregarRecursosPorCategoriaSelect(categoria) {
    const selectRecursos = document.querySelector("#recursos");
    selectRecursos.innerHTML = ""; // Limpa a lista de recursos antes de preencher
    carregarRecursosPorCategoria(categoria).then(recursos => {
        recursos.forEach(recurso => {
            const option = document.createElement("option");
            option.value = recurso.id;
            option.textContent = recurso.titulo;
            selectRecursos.appendChild(option);
        });
    }).catch(error => {
        console.error('Erro ao carregar os recursos por categoria:', error);
    });
}

// Nova função para buscar um recurso por ID
export async function carregarRecursoPorId(id) {
    const response = await fetch(`${API_RECURSOS}/${id}`);
    const recurso = await response.json();
    return recurso;
}

// Função para exibir os detalhes de um recurso (por exemplo, em uma página de detalhes)
export function exibirDetalhesRecurso(id) {
    carregarRecursoPorId(id).then(recurso => {
        const detalhes = document.querySelector("#detalhesRecurso");
        detalhes.innerHTML = `
            <h2>${recurso.titulo}</h2>
            <p>${recurso.descricao}</p>
            <p>Categoria: ${recurso.categoria}</p>
            <p>Autor: ${recurso.autor}</p>
        `;
    }).catch(error => {
        console.error('Erro ao carregar o recurso por ID:', error);
    });
}

// Função para salvar um novo recurso
export async function salvarRecurso(recurso) {
    const response = await fetch(API_RECURSOS, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(recurso)
    });
    const novoRecurso = await response.json();
    return novoRecurso;
}

// Função para salvar um novo recurso (exemplo de uso em um formulário)
export function salvarRecursoFormulario() {
    const recurso = {
        titulo: document.querySelector("#titulo").value,
        descricao: document.querySelector("#descricao").value,
        categoria: document.querySelector("#categoria").value,
        autorId: document.querySelector("#autorId").value
    };

    salvarRecurso(recurso).then(novoRecurso => {
        console.log('Novo recurso salvo:', novoRecurso);
    }).catch(error => {
        console.error('Erro ao salvar o recurso:', error);
    });
}

// Nova função para atualizar um recurso
export async function atualizarRecurso(id, recurso) {
    const response = await fetch(`${API_RECURSOS}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(recurso)
    });
    const recursoAtualizado = await response.json();
    return recursoAtualizado;
}

// Função para atualizar um recurso (exemplo de uso em um formulário)
export function atualizarRecursoFormulario(id) {
    const recurso = {
        titulo: document.querySelector("#titulo").value,
        descricao: document.querySelector("#descricao").value,
        categoria: document.querySelector("#categoria").value,
        autorId: document.querySelector("#autorId").value
    };

    atualizarRecurso(id, recurso).then(recursoAtualizado => {
        console.log('Recurso atualizado:', recursoAtualizado);
    }).catch(error => {
        console.error('Erro ao atualizar o recurso:', error);
    });
}

// Função para deletar um recurso
export async function deletarRecurso(id) {
    const response = await fetch(`${API_RECURSOS}/${id}`, {
        method: 'DELETE'
    });
    return response.ok;
}

// Função para deletar um recurso (exemplo de uso)
export function deletarRecursoFormulario(id) {
    deletarRecurso(id).then(success => {
        if (success) {
            console.log('Recurso deletado com sucesso');
        } else {
            console.error('Erro ao deletar o recurso');
        }
    }).catch(error => {
        console.error('Erro ao deletar o recurso:', error);
    });
}

// Nova função para carregar recursos por curso
export async function carregarRecursosPorCurso(cursoId) {
    const response = await fetch(`${API_RECURSOS}/${cursoId}/recursos`);
    const recursos = await response.json();
    return recursos;
}

// Função para carregar os recursos por curso em um select
export function carregarRecursosPorCursoSelect(cursoId) {
    const selectRecursos = document.querySelector("#recursos");
    selectRecursos.innerHTML = ""; // Limpa a lista de recursos antes de preencher
    carregarRecursosPorCurso(cursoId).then(recursos => {
        recursos.forEach(recurso => {
            const option = document.createElement("option");
            option.value = recurso.id;
            option.textContent = recurso.titulo;
            selectRecursos.appendChild(option);
        });
    }).catch(error => {
        console.error('Erro ao carregar os recursos por curso:', error);
    });
}

// Nova função para listar todas as categorias
export async function listarCategorias() {
    const response = await fetch(`${API_RECURSOS}/listar-categorias`);
    const categorias = await response.json();
    return categorias;
}

// Função para carregar categorias em um select
export function carregarCategoriasSelect() {
    const selectCategorias = document.querySelector("#categorias");
    selectCategorias.innerHTML = ""; // Limpa a lista de categorias antes de preencher
    listarCategorias().then(categorias => {
        categorias.forEach(categoria => {
            const option = document.createElement("option");
            option.value = categoria;
            option.textContent = categoria;
            selectCategorias.appendChild(option);
        });
    }).catch(error => {
        console.error('Erro ao carregar as categorias:', error);
    });
}
