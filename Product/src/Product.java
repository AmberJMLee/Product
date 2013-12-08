import java.io.File;
import java.math.BigDecimal;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
public class Product
{
	static int count;
	String name;
	String description;
	BigDecimal price;
	int quantity = 0;
	String barcode;
	String image;
	

	
	public Product(String name, String description, BigDecimal price,
			int quantity, String barcode, String image) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.barcode = barcode; //for the barcode, just add the source folder. The file will be generated for you.
		this.image = image;
	}
	public Product()
	{
		this.name = "Nutella";
		this.description = "Chocolate-hazelnut spread";
		this.price = new BigDecimal(4);
		this.quantity = 0;
		this.barcode = "";
		this.image = "";
	}
	public String getName()
	{
		return name;
	}
	public void setName(String na)
	{
		name = na;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String des)
	{
		description = des;
	}
	public BigDecimal getPrice()
	{
		return price;
	}
	public void setPrice(BigDecimal pri)
	{
		price = pri;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity()
	{
		quantity++;
	}
	public String getBarcode()
	{
		return barcode;
	}
	public void setBarcode(String bar) throws Exception
	{
		
		Barcode bc = BarcodeFactory.createCode128(bar);
        File f = new File(bar+".png");
        BarcodeImageHandler.savePNG(bc, f);
        barcode = bar+".png";
	}	
	public String getImage()
	{
		return image;
	}
	public void setImage(String im)
	{
		image = im;
	}
	public static void getCount(int count)
	{
		Product.count = count;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description
				+ ", price=" + price + ", quantity=" + quantity + ", barcode="
				+ barcode + ", image=" + image + "]";
	}
}