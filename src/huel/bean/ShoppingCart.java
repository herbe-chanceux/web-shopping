package huel.bean;

public class ShoppingCart {
	  private Integer Id;
	  private Integer productid;
	  public Integer getProductid() {
	  return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	private String Name;
	  private String Type;
	  private float UnitPrice;
	  private Integer num;
	  private String pic;
	  public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public float getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		UnitPrice = unitPrice;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num=num;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	  
}
