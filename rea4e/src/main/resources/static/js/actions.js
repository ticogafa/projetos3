function createUser(){
    
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    // Dados do formulário
    const userData = {
        name: name,
        email: email,
        password: password
    };


    // Fazer a requisição POST
    fetch("/api/usuario/", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(userData) // Converter os dados para JSON
    })
    
