let cart = [];

// Função para adicionar item ao carrinho
function addToCart(itemName, itemPrice, itemImage) {
    let item = cart.find(product => product.name === itemName);
    
    if (item) {
        item.quantity += 1;
    } else {
        cart.push({ name: itemName, price: itemPrice, quantity: 1, image: itemImage });
    }
    
    updateCart();
    openCart();
}

// Função para remover item do carrinho
function removeFromCart(itemName) {
    cart = cart.filter(item => item.name !== itemName);
    updateCart();
}

// Função para alterar a quantidade de um item no carrinho
function updateQuantity(itemName, newQuantity) {
    let item = cart.find(product => product.name === itemName);
    if (item) {
        item.quantity = parseInt(newQuantity);
        if (item.quantity <= 0) {
            removeFromCart(itemName);
        } else {
            updateCart();
        }
    }
}

// Função para atualizar o total do carrinho
function updateCart() {
    let cartItemsContainer = document.getElementById("cart-items");
    let totalPriceContainer = document.getElementById("total-price");
    
    cartItemsContainer.innerHTML = "";
    let total = 0;
    
    cart.forEach(item => {
        let itemElement = document.createElement("div");
        itemElement.classList.add("cart-item");
        itemElement.innerHTML = `
            <img src="${item.image}" class="cart-item-image" alt="${item.name}">
            <div class="cart-item-details">
                <p class="cart-item-name">${item.name}</p>
                <p class="cart-item-price">R$${item.price.toFixed(2)}</p>
                <div class="cart-item-controls">
                    <div class="cart-quantity">
                        <button onclick='updateQuantity("${item.name}", ${item.quantity - 1})'>-</button>
                        <input type='number' value='${item.quantity}' min='1' onchange='updateQuantity("${item.name}", this.value)'>
                        <button onclick='updateQuantity("${item.name}", ${item.quantity + 1})'>+</button>
                    </div>
                    <button class="remove-item" onclick='removeFromCart("${item.name}")'>Remover</button>
                </div>

            </div>`;
        cartItemsContainer.appendChild(itemElement);
        
        total += item.price * item.quantity;
    });
    
    totalPriceContainer.textContent = `Total: R$${total.toFixed(2)}`;
}

// Abrir o carrinho ao adicionar item
function openCart() {
    document.getElementById("cart-container").classList.add("active");
}

// Fechar o carrinho
function closeCart() {
    document.getElementById("cart-container").classList.remove("active");
}

// Event Listener para botões de compra
document.addEventListener("DOMContentLoaded", () => {
    let buttons = document.querySelectorAll(".add-to-cart");
    buttons.forEach(button => {
        button.addEventListener("click", (event) => {
            let itemName = event.target.getAttribute("data-name");
            let itemPrice = parseFloat(event.target.getAttribute("data-price"));
            let itemImage = event.target.getAttribute("data-image");
            addToCart(itemName, itemPrice, itemImage);
        });
    });

    // Event listener para abrir e fechar o carrinho
    document.getElementById("toggle-cart").addEventListener("click", openCart);
    document.getElementById("close-cart").addEventListener("click", closeCart);
});

document.addEventListener("DOMContentLoaded", () => {
    const cart = document.getElementById("cart-container");
    const openCart = document.querySelector("a[href='#carrinho']");
    const closeCart = document.getElementById("close-cart");

    openCart.addEventListener("click", (e) => {
        e.preventDefault();
        cart.classList.add("active");
    });

    closeCart.addEventListener("click", () => {
        cart.classList.remove("active");
    });
});
