package com.hungerboxclone.hungerbox.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderUpdateDto {

	@JsonProperty("order_id")
	private int orderId;
	@JsonProperty("status")
	private String status;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
