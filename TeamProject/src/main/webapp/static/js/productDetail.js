

window.onload = function () {
  let quantity = 1;
  const unitPrice = Number(document.getElementById('product3').dataset.price);
  const quantityDisplay = document.getElementById('quantity3');
  const totalPriceDisplay = document.getElementById('total-price3');

  function updateTotal() {
    totalPriceDisplay.textContent = (unitPrice * quantity).toLocaleString();
  }

  window.increaseQuantity = function () {
    quantity++;
    quantityDisplay.textContent = quantity;
    updateTotal();
  }

  window.decreaseQuantity = function () {
    if (quantity > 0) {
      quantity--;
      quantityDisplay.textContent = quantity;
      updateTotal();
    }
  }

  updateTotal();
};
