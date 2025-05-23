/**
 * 
 */

window.onload = function () {
  let quantity = 1;
  const unitPrice = Number(document.getElementById('product').dataset.price);
  const quantityDisplay = document.getElementById('quantity');
  const totalPriceDisplay = document.getElementById('total-price');

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
