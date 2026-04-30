/**
 * OrderDetail class - represents payment details.
 * @author Nam Ha Minh
 * @copyright https://codeJava.net
 */
package com.jobportal.model;

public class OrderDetail {
	private String serviceName;
	private float subtotal;
	private float discount;
	private float total;
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(String service, String subtotal, 
			String discount,String total) {
		this.serviceName = service;
		this.subtotal = Float.parseFloat(subtotal);
		this.discount = Float.parseFloat(discount);
		this.total = Float.parseFloat(total);
	}

	public String getServiceName() {
		return serviceName;
	}
	public String getSubtotal() {
		return String.format("%.2f", subtotal);
	}

	public String getDiscount() {
		return String.format("%.2f", discount);
	}
	public String getTotal() {
		return String.format("%.2f", total);
	}

}
