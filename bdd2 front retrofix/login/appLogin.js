const registerBtn = document.getElementById('register');
const loginBtn = document.getElementById('login'); 

registerBtn.addEventListener('click', () => {
    container.classList.add("active");
});

loginBtn.addEventListener('click', () => {
    container.classList.remove("active");
});

const formCadastro = document.getElementById('form-cadastro'); 

formCadastro.addEventListener('submit', (event) => {
    event.preventDefault();
    const nmCliente = document.getElementById('nmCliente').value; 
    const telefone = document.getElementById('telefone').value; 
    const dataNasc = document.getElementById('dataNasc').value; 
    const email = document.getElementById('email').value; 
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value; 
    
    
    fetch('http://localhost:8887/cliente/novo', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nmCliente,telefone,dataNasc, email,username,password}) 
        
    })
    .then(response => {
        console.log(response)
        if (response.status == 200) {
            console.log("foi")
             window.location.href = 'login.html';
         } else {
             errorMessage.textContent = data.message || 'Erro ao fazer login.';
         }
    })

    .catch(error => {
        errorMessage.textContent = 'Erro ao conectar com o servidor.';
        console.error('Erro:', error);
    });

});

const formLogin = document.getElementById('form-login');



formLogin.addEventListener('submit', (event) => {
    event.preventDefault();

    const username = document.getElementById('user').value;
    const password = document.getElementById('senha').value;

console.log({ username, password })

    fetch('http://localhost:8887/login/cliente', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password }) 
        
    })
    .then(response => {
        console.log(response)
        if (response.status == 200) {
             window.location.href = '../home/index.html';
         } else {
             errorMessage.textContent = data.message || 'Erro ao fazer login.';
         }
    })

    .catch(error => {
        errorMessage.textContent = 'Erro ao conectar com o servidor.';
        console.error('Erro:', error);
    });
});