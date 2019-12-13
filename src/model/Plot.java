package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "plot" database table.
 * 
 */
@Entity
@Table(name="plot")
@NamedQuery(name="Plot.findAll", query="SELECT p FROM Plot p")
public class Plot extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/*Not needed
	@Column(name="id_area")
	private int idArea;
	*/
	
	@Column(name="name", length=45)
	private String name;

	@Column(name="type")
	private int type;

	//bi-directional many-to-one association to Inventory
	@OneToMany(mappedBy="plot")
	private List<Inventory> inventories;

	//bi-directional many-to-one association to Location
	@OneToMany(mappedBy="plot")
	private List<Location> locations;

	//bi-directional many-to-one association to Area
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_area")
	private Area area;

	public Plot() {
	}

	/*
	public int getIdArea() {
		return this.idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}
	*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Inventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}

	public Inventory addInventory(Inventory inventory) {
		getInventories().add(inventory);
		inventory.setPlot(this);

		return inventory;
	}

	public Inventory removeInventory(Inventory inventory) {
		getInventories().remove(inventory);
		inventory.setPlot(null);

		return inventory;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setPlot(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setPlot(null);

		return location;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}