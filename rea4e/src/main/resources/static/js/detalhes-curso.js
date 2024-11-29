const API_BASE = '/api/cursos';
const API_USUARIO = '/api/usuario';
const API_RECURSOS = '/api/recurso-educacional-aberto';

const urlParams = new URLSearchParams(window.location.search);
const cursoId = urlParams.get('id');
window.onload = function() {
    carregarCurso();
}

function obterCursoPorUrl() {
    const urlParams = new URLSearchParams(window.location.search);
    const id =urlParams.get('id');
    try {
        return fetch(`${API_BASE}/${id}`).then(response => response.json());
    }
    catch(error) {
        console.error('Erro ao obter o curso:', error);
    }
}


function carregarCurso() {
    obterCursoPorUrl().then(curso => {
        document.querySelector("#titulo").textContent = curso.titulo;
        document.querySelector("#descricao").textContent = curso.descricao;
        document.querySelector("#categoria").textContent = curso.categoria;
        //document.querySelector("#autor").textContent = curso.autor;
    }).catch(error => {
        console.error('Erro ao carregar o curso:', error);
    });
}

function obterProgressoCurso() {
    console.log(cursoId);
    try {
        return fetch(`${API_USUARIO}/1/${cursoId}/progresso`).then(response => response.json());
    }
    catch(error) {
        console.error('Erro ao obter o progresso do curso:', error);
    }
}

function carregarProgresso() {
    obterProgressoCurso().then(progresso => {
        document.querySelector("#progresso").textContent = progresso+"%";
    }).catch(error => {
        console.error('Erro ao carregar o progresso do curso:', error);
    });
}

function redirectAulas() {
    const botao = document.querySelector("#botao-aula");
    botao.onclick = () => {window.location.href = `/view/aulas?id=${cursoId}`}; // Redireciona ao clicar
}
