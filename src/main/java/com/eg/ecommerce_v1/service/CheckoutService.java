package com.eg.ecommerce_v1.service;

import com.eg.ecommerce_v1.model.Purchase;
import com.eg.ecommerce_v1.model.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);

}
