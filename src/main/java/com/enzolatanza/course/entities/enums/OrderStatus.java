package com.enzolatanza.course.entities.enums;

public enum OrderStatus {
	//atribuido manualmente os valores numericos das constantes
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4), 
	CANCELED(5);
	
	//campo para o codigo do tipo enumerado
	private int code;
	//construtor private
	private OrderStatus(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value :  OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	
}
