const container = document.getElementById('container');
const registerBtn = document.getElementById('register');
const loginBtn = document.getElementById('login');


const formTriagem = document.getElementById('form-triagem');

formTriagem.addEventListener('submit', (event)=> {
    event.preventDefault(); 
    const idCliente = 1;
    const nmVideogame = document.getElementById('nmVideogame').value;
    const dsProblema = document.getElementById('dsProblema').value;
    const tpServico = document.getElementById('tpServico').value; 


    fetch('http://localhost:8887/triagem/novo', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({idCliente, nmVideogame,dsProblema,tpServico }) 
        
    }).then(response => {
        console.log(response)
        if (response.status == 200) {
             window.location.href = 'index.html';
         } else {
             errorMessage.textContent = data.message || 'Erro ao fazer login.';
         }
    }).catch(error => {
        errorMessage.textContent = 'Erro ao conectar com o servidor.';
        console.error('Erro:', error);
    });

});


const errorMessage = document.getElementById('error-message'); 


