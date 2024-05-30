package com.spring.rabbitmq.model;

public class OrderStatus {

    private Order order;
    private String status; // Progress, Completed
    private String message;
    
    public OrderStatus(Order order, String status, String message) {
        this.order = order;
        this.status = status;
        this.message = message;
    }

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
}
