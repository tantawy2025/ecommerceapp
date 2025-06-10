package com.eg.ecommerce_v1.model;

import com.eg.ecommerce_v1.entity.Address;
import com.eg.ecommerce_v1.entity.Customer;
import com.eg.ecommerce_v1.entity.Order;
import com.eg.ecommerce_v1.entity.OrderItem;
import lombok.Data;

import java.util.Set;


public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

    public Purchase() {
    }

    public Purchase(Set<OrderItem> orderItems, Order order, Address billingAddress, Address shippingAddress, Customer customer) {
        this.orderItems = orderItems;
        this.order = order;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}