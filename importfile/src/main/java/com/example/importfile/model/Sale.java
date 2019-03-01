package com.example.importfile.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
  
@Entity
public class Sale {
  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id; 
	
	@Column(name="purchaser_name", nullable=false)
	private String purchaserName; 
	
	@Column(name="item_description", nullable=false)
	private String itemDescription; 
	
	@Column(name="item_price", nullable=false)
	private Double itemPrice;

	@Column(name="purchase_count", nullable=false)
	private int purchaseCount;

	@Column(name="merchant_address", nullable=true)
	private String merchantAddress;

	@Column(name="merchant_name", nullable=true)
	private String merchantName;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPurchaserName() {
		return purchaserName;
	}
	public void setPurchaserName(String purchaserName) {
		this.purchaserName = purchaserName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public Double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getPurchaseCount() {
		return purchaseCount;
	}
	public void setPurchaseCount(int purchaseCount) {
		this.purchaseCount = purchaseCount;
	}
	public String getMerchantAddress() {
		return merchantAddress;
	}
	public void setMerchantAddress(String merchantAddress) {
		this.merchantAddress = merchantAddress;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	
}
