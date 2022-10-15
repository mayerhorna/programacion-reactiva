package rxjava3_pruebas.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Product implements Cloneable{
	private Long rowNum = 1L;
	
    private Long tb_product_id;

    private String code;
    
    private String name;

    private String encriptedCode;
    
    private BigDecimal salesPrice = BigDecimal.ZERO;

    private Integer isActive;
    
    private Date created;
    
    private ProductType productType;
    
    public Product() {
	}
    
	public Product(Long tb_product_id) {
		super();
		this.tb_product_id = tb_product_id;
	}

	public Product(String name) {
		super();
		this.name = name;
	}

	private static List<Product> dummyData = new ArrayList<>();
	static {
		generateData();
	}

	public Product(Long tb_product_id, String code, String name, BigDecimal salesPrice, Integer isActive,
			Date created, ProductType productType) {
		super();
		this.tb_product_id = tb_product_id;
		this.code = code;
		this.name = name;
		this.salesPrice = salesPrice;
		this.isActive = isActive;
		this.created = created;
		this.productType = productType;
	}

	private static void generateData() {
		dummyData.add(new Product(9980L, "F009946","NOVALGINA 500 mg Tableta",new BigDecimal(0.5), 1, new java.util.Date(), new ProductType(1L,"ANTIINFLAMATORIOS")));
		dummyData.add(new Product(15411L, "F015140","LEVOTIROXINA SODICA 100 mcg Tableta",new BigDecimal(0.6), 1, new java.util.Date(), new ProductType(1L,"ANTIINFLAMATORIOS")));
		dummyData.add(new Product(8174L, "F008140","DICLOXACILINA 500 mg Cápsula",new BigDecimal(0.8), 1, new java.util.Date(), new ProductType(1L,"ANTIINFLAMATORIOS")));
		dummyData.add(new Product(3439L, "F003405","GRIPA C JUNIOR  Tableta",new BigDecimal(1.00), 1, new java.util.Date(), new ProductType(1L,"ANTIINFLAMATORIOS")));
		dummyData.add(new Product(1706L, "F001672","ACICLOVIR 200 mg Tableta",new BigDecimal(1.00), 0, new java.util.Date(), new ProductType(1L,"ANTIINFLAMATORIOS")));
		dummyData.add(new Product(24L, "F000001","Paracetamol Jarabe 120 mg x 120 ml",new BigDecimal(1.00), 1, new java.util.Date(), new ProductType(1L,"ANTIINFLAMATORIOS")));
		dummyData.add(new Product(28L, "F000005","Kitadol 500 mg Tabletas Caja con 100",new BigDecimal(1.00), 1, new java.util.Date(), new ProductType(1L,"ANTIINFLAMATORIOS")));
		dummyData.add(new Product(5427L, "F005393","TRAMADOL 50 mg Cápsula",new BigDecimal(1.2), 1, new java.util.Date(), new ProductType(1L,"ANTIINFLAMATORIOS")));
		dummyData.add(new Product(18046L, "F017775","ANTIPRED 20 mg Tableta",new BigDecimal(1.5), 1, new java.util.Date(), new ProductType(1L,"ANTIINFLAMATORIOS")));
		dummyData.add(new Product(7444L, "F007410","CARDIOASPIRINA  100 mg Comprimido",new BigDecimal(1.5), 1, new java.util.Date(), new ProductType(1L,"ANTIINFLAMATORIOS")));
		dummyData.add(new Product(6675L, "F006641","DEFLAZACORT 6 mg Tableta",new BigDecimal(1.5), 1, new java.util.Date(), new ProductType(1L,"ANTIINFLAMATORIOS")));
		dummyData.add(new Product(6618L, "F006584","CARVEDILOL 12.5 mg Tableta",new BigDecimal(2.00), 1, new java.util.Date(), new ProductType(2L,"MUCOLÍTICOS")));
		dummyData.add(new Product(25L, "F000002","Paracetamol Gotas x 10 ml",new BigDecimal(2.9), 1, new java.util.Date(), new ProductType(2L,"MUCOLÍTICOS")));
		dummyData.add(new Product(13371L, "F013100","TRAMINOFENOL 37.5 mg + 325 mg Tableta",new BigDecimal(3.00), 1, new java.util.Date(), new ProductType(2L,"MUCOLÍTICOS")));
		dummyData.add(new Product(14720L, "F014449","HIGANATUR 300MG CAPSULA",new BigDecimal(3.00), 1, new java.util.Date(), new ProductType(2L,"MUCOLÍTICOS")));
		dummyData.add(new Product(26L, "F000003","Paracetamol Jarabe x 60 ml",new BigDecimal(3.00), 1, new java.util.Date(), new ProductType(2L,"MUCOLÍTICOS")));
		dummyData.add(new Product(8476L, "F008442","IBANCHECK 150 mg Cápsula",new BigDecimal(3.5), 1, new java.util.Date(), new ProductType(2L,"MUCOLÍTICOS")));
		dummyData.add(new Product(11920L, "F011649","PRESER GENTS ESPUELAS (ROJO)",new BigDecimal(4.00), 1, new java.util.Date(), new ProductType(2L,"MUCOLÍTICOS")));
		dummyData.add(new Product(18247L, "F017976","HOJA DE AFEITAR DORCO Cja x 10 Unid",new BigDecimal(4.00), 1, new java.util.Date(), new ProductType(2L,"MUCOLÍTICOS")));
		dummyData.add(new Product(8028L, "F007994","MEBENDAZOL 100 mg/5 mL Suspensión",new BigDecimal(4.5), 1, new java.util.Date(), new ProductType(2L,"MUCOLÍTICOS")));
		dummyData.add(new Product(16L, "0","Esparadrapo",new BigDecimal(5.00), 1, new java.util.Date(), new ProductType(2L,"MUCOLÍTICOS")));
		dummyData.add(new Product(16446L, "F016175","BETAPLUSS 0,05% Crema x 20g",new BigDecimal(7.00), 1, new java.util.Date(), new ProductType(2L,"MUCOLÍTICOS")));
		dummyData.add(new Product(7878L, "F007844","DESO REXONA MEN SPRAY V8 X 105ML",new BigDecimal(7.00), 0, new java.util.Date(), new ProductType(2L,"MUCOLÍTICOS")));
		dummyData.add(new Product(15681L, "F015410","LIPFUNGOL 1% Crema x 20g",new BigDecimal(9.5), 1, new java.util.Date(), new ProductType(2L,"MUCOLÍTICOS")));
		dummyData.add(new Product(6472L, "F006438","LISTERINE ENJ BUCAL WHITENING (BLANCO) x 236mL",new BigDecimal(12.5), 1, new java.util.Date(), new ProductType(2L,"MUCOLÍTICOS")));
		dummyData.add(new Product(1889L, "F001855","DESO OLD SPICE MEN SPRAY BLOCKER x 150mL",new BigDecimal(12.5), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(9719L, "F009685","DESO AXE SPRAY MUSK x 150mL",new BigDecimal(12.5), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(8885L, "F008851","ASPIRADOR NASAL ",new BigDecimal(13.00), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(10680L, "F010409","PROPOL NF x 120mL ",new BigDecimal(14.00), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(8850L, "F008816","LACTULOSA 3.3 g/5 mL Solución x 120mL",new BigDecimal(14.5), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(9819L, "F009785","AEROCAMARA ADULTO IQ-MEDIC (AZUL)",new BigDecimal(15.5), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(6495L, "F006461","PINZA CORTACUTICULA PIE (DELGADA)",new BigDecimal(17.00), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(1784L, "F001750","ELVIVE Sh COLOR-VIVE FCO x 400mL ",new BigDecimal(17.5), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(6914L, "F006880","TERRAMISOL-A  Ungüento x 6g",new BigDecimal(17.5), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(1613L, "F001579","MULTI-3 PLUS x 60mL ",new BigDecimal(17.9), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(1763L, "F001729","BODY MILK ACEITE DE OLIVA PACK x 400mL",new BigDecimal(19.5), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(16765L, "F016494","PLIDAN COMPUESTO NF SOLUCION INYECTABLE",new BigDecimal(19.5), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(1666L, "F001632","XENILER 5 mg/5 mL Jarabe x 60mL",new BigDecimal(22.5), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(4043L, "F004009","AMMES SH ORIGINAL x 400mL",new BigDecimal(22.5), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(10285L, "F010014","NASTIZOL GOTAS x 15mL",new BigDecimal(24.5), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(8017L, "F007983","DESTOLIT 5% Crema x 30g",new BigDecimal(32.5), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(11778L, "F011507","TERRAMICINA 0.5 g + 1000000 U Ungüento x 10gr",new BigDecimal(34.00), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(16756L, "F016485","CITROCALCIO CJA x 30 Tab Rec",new BigDecimal(35.00), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(6891L, "F006857","LANCIPROX 0,003 Solución x 5mL",new BigDecimal(37.00), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(8803L, "F008769","DEXA NEUROBION  Solución Ampolla",new BigDecimal(42.00), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(7107L, "F007073","BUDESONIDA 200 µg/Dosis Aerosol INHALADOR",new BigDecimal(46.5), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(7305L, "F007271","VISTAGEL 0,002 Gel x 12g",new BigDecimal(49.7), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));
		dummyData.add(new Product(10426L, "F010155","TRUSOMIDA 2% Solución x 5ml",new BigDecimal(58.5), 1, new java.util.Date(), new ProductType(3L,"ANTIPIRÉTICOS")));

	}
	
	public static List<Product> getData(){
		List<Product> copyData = new ArrayList<>();
		try {
			for (Product product : dummyData) {
				copyData.add((Product)product.clone());
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return  copyData;
	}

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

	public BigDecimal getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Long getRowNum() {
		return rowNum;
	}

	public void setRowNum(Long rowNum) {
		this.rowNum = rowNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(((Product)obj).getTb_product_id().equals(this.getTb_product_id())){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return   name;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	
}