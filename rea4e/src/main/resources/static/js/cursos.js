import { carregarObjetoRecurso } from "./recursos.js";
// URLs das APIs
const API_BASE = '/api/cursos';
const API_RECURSOS = '/api/recurso-educacional-aberto';

// Função principal de inicialização
window.onload = async () => {
  //await carregarObjetoRecurso();          // Carrega os recursos
  await carregarCategorias();            // Preenche categorias no formulário
  await carregarCategoriasFiltradas();   // Preenche categorias no filtro
  carregarCursos();
  window.showAddCursoForm = showAddCursoForm;
  window.filtrarCursos = filtrarCursos;
                     // Exibe todos os cursos
};

// Funções para manipulação de cursos
function obterCursoPorUrl() {
  const urlParams = new URLSearchParams(window.location.search);
  const id =urlParams.get('id');
  return fetch(`${API_BASE}/${id}`).then(response => response.json());
}

function obterCursos() {
    return fetch(API_BASE).then(response => response.json());
}
async function carregarCursos(filtroCategoria = '') {
    try {
      // Obtém os cursos
      const cursos = await obterCursos();
      
      // Seletor para o contêiner onde os cards de cursos serão adicionados
      const container = document.querySelector("#cursosContainer");
      
      // Limpa o container antes de preenchê-lo
      container.innerHTML = '';
  
      // Filtra os cursos com base na categoria, se necessário
      const cursosFiltrados = cursos.filter(curso =>
        filtroCategoria ? curso.categoria === filtroCategoria : true
      );
  
      // Cria um card para cada curso
      cursosFiltrados.forEach((curso, index) => {
        // Cria o elemento do card
        const card = document.createElement("div");
        card.classList.add("course-card");
        card.id = `curso${index + 1}`; // Atribui um ID único ao card (curso1, curso2, etc.)
        card.onclick = () => window.location.href = `/view/curso?id=${curso.id}`; // Redireciona ao clicar
        // Preenche o conteúdo do card
        card.innerHTML = `
          <img src="/images/curso-logo.png" alt="Imagem do curso">
          <div class="course-title">${curso.titulo}</div>
          <div class="course-description">${curso.descricao}</div>
          <div class="course-category">${curso.categoria}</div>
        `;
  
        // Adiciona o card ao contêiner
        container.appendChild(card);
      });
    } catch (error) {
      console.error("Erro ao carregar os cursos:", error);
    }
  }
  
/**
 * Deleta um curso pelo ID.
 * @param {number} id - ID do curso a ser deletado.
 */
async function deletarCurso(id) {
  if (confirm("Tem certeza que deseja deletar este curso?")) {
    try {
      await fetch(`${API_BASE}/${id}`, { method: "DELETE" });
      carregarCursos(); // Atualiza a tabela após a exclusão
    } catch (error) {
      console.error("Erro ao deletar curso:", error);
    }
  }
}

/**
 * Preenche o formulário com os dados de um curso para edição.
 * @param {number} id - ID do curso a ser editado.
 */
async function editarCurso(id) {
  try {
    const response = await fetch(`${API_BASE}/${id}`);
    const curso = await response.json();

    document.querySelector("#cursoId").value = curso.id;
    document.querySelector("#titulo").value = curso.titulo;
    document.querySelector("#descricao").value = curso.descricao;
    document.querySelector("#categoria").value = curso.categoria;
    document.querySelector("#url").value = curso.url;

    const selectRecursos = document.querySelector("#recursos");
    Array.from(selectRecursos.options).forEach(option => {
      option.selected = curso.recursos.includes(option.value);
    });

    document.querySelector("#addCursoForm").style.display = "block"; // Exibe o formulário
  } catch (error) {
    console.error("Erro ao carregar dados do curso para edição:", error);
  }
}

/**
 * Salva (cria ou edita) um curso usando os dados do formulário.
 */
async function salvarCurso(e) {
  e.preventDefault();

  const id = document.querySelector("#cursoId").value;
  const titulo = document.querySelector("#titulo").value;
  const descricao = document.querySelector("#descricao").value;
  const categoria = document.querySelector("#categoria").value;
  const url = document.querySelector("#url").value;
  const recursosSelecionados = Array.from(
    document.querySelector("#recursos").selectedOptions
  ).map(option => option.value);

  const metodo = id ? "PUT" : "POST";
  const fetchUrl = id ? `${API_BASE}/${id}` : API_BASE;

  const curso = { titulo, descricao, categoria, url, recursos: recursosSelecionados };

  try {
    await fetch(fetchUrl, {
      method: metodo,
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(curso),
    });

    document.querySelector("#cursoForm").reset();
    document.querySelector("#cursoId").value = '';
    carregarCursos(); // Atualiza a lista de cursos
    document.querySelector("#addCursoForm").style.display = "none"; // Esconde o formulário
  } catch (error) {
    console.error("Erro ao salvar o curso:", error);
  }
}

// Funções para manipulação de categorias

/**
 * Obtém a lista de categorias disponíveis.
 * @returns {Promise<string[]>} - Lista de categorias.
 */
async function obterCategorias() {
  try {
    const response = await fetch(`${API_RECURSOS}/listar-categorias`);
    return await response.json();
  } catch (error) {
    console.error("Erro ao obter categorias:", error);
    return [];
  }
}

/**
 * Carrega categorias no formulário de cursos.
 */
async function carregarCategorias() {
  try {
    const categorias = await obterCategorias();
    const select = document.querySelector("#categoria");
    select.innerHTML = ''; // Limpa antes de preencher

    categorias.forEach(categoria => {
      const option = document.createElement("option");
      option.value = categoria;
      option.innerText = categoria;
      select.appendChild(option);
    });
  } catch (error) {
    console.error("Erro ao carregar categorias no formulário:", error);
  }
}

/**
 * Carrega categorias no filtro de cursos.
 */
async function carregarCategoriasFiltradas() {
    try {
      const categorias = await obterCategorias();
      const filtroCategoria = document.querySelector("#filtroCategoria");
      filtroCategoria.innerHTML = ''; // Limpa antes de preencher
  
      // Adiciona a opção "Todas as Categorias" no início
      const optionTodas = document.createElement("option");
      optionTodas.value = '';
      optionTodas.textContent = 'Todas as Categorias';
      filtroCategoria.appendChild(optionTodas);
  
      // Adiciona as categorias normais
      categorias.forEach(categoria => {
        const option = document.createElement("option");
        option.value = categoria;
        option.textContent = categoria;
        filtroCategoria.appendChild(option);
      });
    } catch (error) {
      console.error("Erro ao carregar categorias no filtro:", error);
    }
  }
/**
 * Filtra cursos pela categoria selecionada no filtro.
 */
function filtrarCursos() {
  const categoriaSelecionada = document.querySelector("#filtroCategoria").value;
  carregarCursos(categoriaSelecionada);
}

// Funções auxiliares

/**
 * Exibe o formulário para adicionar novo curso.
 */

function showAddCursoForm() {
  document.querySelector("#addCursoForm").style.display = "block"; // Exibe o formulário
}

// Garantir que a função esteja no escopo global

document.querySelector("#cursoForm").addEventListener("submit", salvarCurso);
document.querySelector("#filtroCategoria").addEventListener("change", filtrarCursos);


