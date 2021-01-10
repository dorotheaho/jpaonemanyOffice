package model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the coffees database table.
 * 
 */
@Entity
@Table(name="coffees")
@NamedQuery(name="Coffee.findAll", query="SELECT c FROM Coffee c")
public class Coffee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COF_NAME", unique=true, nullable=false, length=32)
	private String cofName;

	@Column(nullable=false, precision=10, scale=2)
	private double price;

	@Column(nullable=false)
	private int sales;


	@Column(nullable=false)
	private int total;


	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="SUP_ID", nullable=false)
	private Supplier supplier;

	public Coffee() {
	}

	public String getCofName() {
		return this.cofName;
	}

	public void setCofName(String cofName) {
		this.cofName = cofName;
	}


	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public int getSales() {
		return this.sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}



	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}


	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}