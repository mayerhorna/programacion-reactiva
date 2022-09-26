package com.example.reactiveservice;


public class Product {

    private Long tb_product_id;

    private String code;
    
    private String name;

    private String encriptedCode;

	public Long getTb_product_id() {
		return tb_product_id;
	}

	public void setTb_product_id(Long tb_product_id) {
		this.tb_product_id = tb_product_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEncriptedCode() {
		return encriptedCode;
	}

	public void setEncriptedCode(String encriptedCode) {
		this.encriptedCode = encriptedCode;
	}

}
