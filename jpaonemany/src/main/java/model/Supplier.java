package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the suppliers database table.
 * 
 */
@Entity
@Table(name="suppliers")
@NamedQuery(name="Supplier.findAll", query="SELECT s FROM Supplier s")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SUP_ID", unique=true, nullable=false)
	private int supId;

	@Column(nullable=false, length=20)
	private String city;

	@Column(nullable=false, length=2)
	private String state;


	@Column(nullable=false, length=40)
	private String street;


	@Column(name="SUP_NAME", nullable=false, length=40)
	private String supName;


	@Column(length=5)
	private String zip;



	//bi-directional many-to-one association to Coffee
	@OneToMany(mappedBy="supplier", cascade=CascadeType.PERSIST)
	private List<Coffee> coffees;

	public Supplier() {
	}

	public int getSupId() {
		return this.supId;
	}

	public void setSupId(int supId) {
		this.supId = supId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}



	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}


	public String getSupName() {
		return this.supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public List<Coffee> getCoffees() {
		return this.coffees;
	}

	public void setCoffees(List<Coffee> coffees) {
		this.coffees = coffees;
	}

	public Coffee addCoffee(Coffee coffee) {
		getCoffees().add(coffee);
		coffee.setSupplier(this);

		return coffee;
	}

	public Coffee removeCoffee(Coffee coffee) {
		getCoffees().remove(coffee);
		coffee.setSupplier(null);

		return coffee;
	}

}