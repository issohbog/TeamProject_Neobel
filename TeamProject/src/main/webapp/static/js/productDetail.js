window.onload = function () {
  let quantity = 1;
  const unitPrice = Number(document.getElementById('product3').dataset.price);
  const quantityDisplay = document.getElementById('quantity3');
  const totalPriceDisplay = document.getElementById('total-price3');

  // 숨겨진 input 엘리먼트
  const cartQuantityInput = document.getElementById('cartQuantity');
  const buyQuantityInput = document.getElementById('buyQuantity');

  function updateTotal() {
    totalPriceDisplay.textContent = (unitPrice * quantity).toLocaleString();
    cartQuantityInput.value = quantity;
    buyQuantityInput.value = quantity;
  }

  window.increaseQuantity = function () {
    quantity++;
    quantityDisplay.textContent = quantity;
    updateTotal();
  };

  window.decreaseQuantity = function () {
    if (quantity > 1) {
      quantity--;
      quantityDisplay.textContent = quantity;
      updateTotal();
    }
  };

  updateTotal();
};


