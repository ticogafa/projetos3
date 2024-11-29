const API_BASE = "/api/usuarios";

function obterUsuarioPorId() {
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');
    return fetch(`${API_BASE}/${id}`).then(response => response.json());
}

