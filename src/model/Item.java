package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the "item" database table.
 * 
 */
@Entity
@Table(name="item")
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="description", length=1000)
	private String description;

	@Column(name="availability", precision=7, scale=4)
	private BigDecimal availability;

	@Column(name="base_price", precision=15, scale=4)
	private BigDecimal basePrice;

	@Column(name="name", length=45)
	private String name;
	
	//bi-directional many-to-one association to Item
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_item")
	private State item;
	
	//bi-directional many-to-one association to Inventory
	@OneToMany(mappedBy="item")
	private List<Inventory> inventories;

	public Item() {
	}

	public BigDecimal getAvailability() {
		return this.availability;
	}

	public void setAvailability(BigDecimal availability) {
		this.availability = availability;
	}

	public BigDecimal getBasePrice() {
		return this.basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Inventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}

	public Inventory addInventory(Inventory inventory) {
		getInventories().add(inventory);
		inventory.setItem(this);

		return inventory;
	}

	public Inventory removeInventory(Inventory inventory) {
		getInventories().remove(inventory);
		inventory.setItem(null);

		return inventory;
	}

}