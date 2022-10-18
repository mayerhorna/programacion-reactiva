package rxjava3_pruebas.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductStock implements Cloneable{
	private Product product;
	private BigDecimal quantity;
	
	public ProductStock(Product product, BigDecimal quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	private static List<ProductStock> dummyData = new ArrayList<>();
	static {
		generateData();
	}
	private static void generateData() {
		dummyData.add(new ProductStock(new Product(9980L), new BigDecimal(200)));
		dummyData.add(new ProductStock(new Product(15411L),  new BigDecimal(100)));
		dummyData.add(new ProductStock(new Product(8174L), new BigDecimal(150)));
		dummyData.add(new ProductStock(new Product(17824L), new BigDecimal(120)));
		dummyData.add(new ProductStock(new Product(12943L),new BigDecimal(5.0)));
		dummyData.add(new ProductStock(new Product(4969L),new BigDecimal(3.0)));
		dummyData.add(new ProductStock(new Product(3439L),new BigDecimal(2.0)));
		dummyData.add(new ProductStock(new Product(14729L),new BigDecimal(1.0)));
		dummyData.add(new ProductStock(new Product(1706L),new BigDecimal(7.0)));
		dummyData.add(new ProductStock(new Product(24L),new BigDecimal(8.0)));
		dummyData.add(new ProductStock(new Product(28L),new BigDecimal(6.0)));
		dummyData.add(new ProductStock(new Product(5427L),new BigDecimal(4.0)));
		dummyData.add(new ProductStock(new Product(18046L),new BigDecimal(5.0)));
		dummyData.add(new ProductStock(new Product(7444L),new BigDecimal(3.0)));
		dummyData.add(new ProductStock(new Product(6675L),new BigDecimal(0.0)));
		dummyData.add(new ProductStock(new Product(13627L),new BigDecimal(2.0)));
		dummyData.add(new ProductStock(new Product(30L),new BigDecimal(9.0)));
		dummyData.add(new ProductStock(new Product(5068L),new BigDecimal(4.0)));
		dummyData.add(new ProductStock(new Product(14343L),new BigDecimal(15.0)));
		dummyData.add(new ProductStock(new Product(6618L),new BigDecimal(25.0)));
		dummyData.add(new ProductStock(new Product(8064L),new BigDecimal(35.0)));
		dummyData.add(new ProductStock(new Product(7701L),new BigDecimal(65.0)));
		dummyData.add(new ProductStock(new Product(2971L),new BigDecimal(15.0)));
		dummyData.add(new ProductStock(new Product(25L),new BigDecimal(75.0)));
		dummyData.add(new ProductStock(new Product(13371L),new BigDecimal(35.0)));
		dummyData.add(new ProductStock(new Product(14720L),new BigDecimal(45.0)));
		dummyData.add(new ProductStock(new Product(18462L),new BigDecimal(5.0)));
		dummyData.add(new ProductStock(new Product(26L),new BigDecimal(65.0)));
		dummyData.add(new ProductStock(new Product(6198L),new BigDecimal(15.0)));
		dummyData.add(new ProductStock(new Product(18393L),new BigDecimal(25.0)));
		dummyData.add(new ProductStock(new Product(8476L),new BigDecimal(15.0)));
		dummyData.add(new ProductStock(new Product(5706L),new BigDecimal(85.0)));
		dummyData.add(new ProductStock(new Product(11556L),new BigDecimal(35.0)));
		dummyData.add(new ProductStock(new Product(11920L),new BigDecimal(15.0)));
		dummyData.add(new ProductStock(new Product(18247L),new BigDecimal(65.0)));
		dummyData.add(new ProductStock(new Product(8028L),new BigDecimal(45.0)));
		dummyData.add(new ProductStock(new Product(17936L),new BigDecimal(15.0)));
		dummyData.add(new ProductStock(new Product(2973L),new BigDecimal(25.0)));
		dummyData.add(new ProductStock(new Product(16446L),new BigDecimal(55.0)));
		dummyData.add(new ProductStock(new Product(5033L),new BigDecimal(75.0)));
		dummyData.add(new ProductStock(new Product(7878L),new BigDecimal(15.0)));
		dummyData.add(new ProductStock(new Product(15832L),new BigDecimal(25.0)));
		dummyData.add(new ProductStock(new Product(17045L),new BigDecimal(35.0)));
		dummyData.add(new ProductStock(new Product(6114L),new BigDecimal(45.0)));
		dummyData.add(new ProductStock(new Product(15681L),new BigDecimal(65.0)));
		dummyData.add(new ProductStock(new Product(7888L),new BigDecimal(85.0)));
		dummyData.add(new ProductStock(new Product(4649L),new BigDecimal(95.0)));
		dummyData.add(new ProductStock(new Product(15067L),new BigDecimal(85.0)));
		dummyData.add(new ProductStock(new Product(5829L),new BigDecimal(45.0)));
		dummyData.add(new ProductStock(new Product(6472L),new BigDecimal(35.0)));
		dummyData.add(new ProductStock(new Product(1889L),new BigDecimal(45.0)));
		dummyData.add(new ProductStock(new Product(9719L),new BigDecimal(25.0)));
		dummyData.add(new ProductStock(new Product(8885L),new BigDecimal(5.0)));
		dummyData.add(new ProductStock(new Product(10680L),new BigDecimal(35.0)));
		dummyData.add(new ProductStock(new Product(9707L),new BigDecimal(15.0)));
		dummyData.add(new ProductStock(new Product(6835L),new BigDecimal(7.0)));
		dummyData.add(new ProductStock(new Product(7363L),new BigDecimal(4.0)));
		dummyData.add(new ProductStock(new Product(3506L),new BigDecimal(1.0)));
		dummyData.add(new ProductStock(new Product(8850L),new BigDecimal(2.0)));
		dummyData.add(new ProductStock(new Product(9819L),new BigDecimal(3.0)));
		dummyData.add(new ProductStock(new Product(6495L),new BigDecimal(4.0)));
		dummyData.add(new ProductStock(new Product(1784L),new BigDecimal(5.0)));
		dummyData.add(new ProductStock(new Product(1579L),new BigDecimal(6.0)));
		dummyData.add(new ProductStock(new Product(9103L),new BigDecimal(7.0)));
		dummyData.add(new ProductStock(new Product(6914L),new BigDecimal(8.0)));
		dummyData.add(new ProductStock(new Product(1613L),new BigDecimal(9.0)));
		dummyData.add(new ProductStock(new Product(1763L),new BigDecimal(10.0)));
		dummyData.add(new ProductStock(new Product(5597L),new BigDecimal(11.0)));
		dummyData.add(new ProductStock(new Product(6506L),new BigDecimal(12.0)));
		dummyData.add(new ProductStock(new Product(1740L),new BigDecimal(13.0)));
		dummyData.add(new ProductStock(new Product(16765L),new BigDecimal(14.0)));
		dummyData.add(new ProductStock(new Product(8721L),new BigDecimal(15.0)));
		dummyData.add(new ProductStock(new Product(1666L),new BigDecimal(16.0)));
		dummyData.add(new ProductStock(new Product(4043L),new BigDecimal(17.0)));
		dummyData.add(new ProductStock(new Product(10285L),new BigDecimal(18.0)));
		dummyData.add(new ProductStock(new Product(8017L),new BigDecimal(19.0)));
		dummyData.add(new ProductStock(new Product(11778L),new BigDecimal(20.0)));
		dummyData.add(new ProductStock(new Product(2269L),new BigDecimal(21.0)));
		dummyData.add(new ProductStock(new Product(16756L),new BigDecimal(22.0)));
		dummyData.add(new ProductStock(new Product(6891L),new BigDecimal(23.0)));
		dummyData.add(new ProductStock(new Product(8803L),new BigDecimal(24.0)));
		dummyData.add(new ProductStock(new Product(17413L),new BigDecimal(25.0)));
		dummyData.add(new ProductStock(new Product(7107L),new BigDecimal(26.0)));
		dummyData.add(new ProductStock(new Product(7305L),new BigDecimal(27.0)));
		dummyData.add(new ProductStock(new Product(10426L),new BigDecimal(28.0)));
		dummyData.add(new ProductStock(new Product(8035L),new BigDecimal(29.0)));

	}
	public static List<ProductStock> getData(){
		List<ProductStock> copyData = new ArrayList<>();
		try {
			for (ProductStock productStock : dummyData) {
				copyData.add((ProductStock)productStock.clone());
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return  copyData;
	}
	
	public static ProductStock findByProduct(Product productToSearch) {                    
		return dummyData.stream()                                            
				.filter(productStock -> productStock.getProduct().equals(productToSearch))          
				.findFirst()                                                 
				.get();                                                      
	}                                                                        
	                                                                         
}
