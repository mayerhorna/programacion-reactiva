package rxjava3_pruebas.data;

public class ProductType {
    private Long tb_product_type_id;

    private String code;
    
    private String name;
    
    public ProductType() {
	}
	
	public ProductType(Long tb_product_type_id,  String name) {
		this.tb_product_type_id = tb_product_type_id;
		this.name = name;
	}

	public Long getTb_product_type_id() {
		return tb_product_type_id;
	}

	public void setTb_product_type_id(Long tb_product_type_id) {
		this.tb_product_type_id = tb_product_type_id;
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

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(((ProductType)obj).getTb_product_type_id().equals(this.getTb_product_type_id())){
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return tb_product_type_id.intValue();
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	
}