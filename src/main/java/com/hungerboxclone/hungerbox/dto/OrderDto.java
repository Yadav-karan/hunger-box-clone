package com.hungerboxclone.hungerbox.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDto {

	@JsonProperty("customer_id")
	private int customerId;
	@JsonProperty("cart_id")
	private int cartId;
}
