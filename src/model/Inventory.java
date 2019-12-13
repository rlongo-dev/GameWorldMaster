package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "inventory" database table.
 * 
 */
@Entity
@Table(name="inventory")
@NamedQuery(name="Inventory.findAll", query="SELECT i FROM Inventory i")
public class Inventory extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/*Not needed
	@Column(name="id_condition")
	private int idCondition;

	@Column(name="id_item")
	private int idItem;

	@Column(name="id_plot")
	private int idPlot;
	*/
	@Column(name="name", length=45)
	private String name;

	//bi-directional many-to-one association to Condition
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_condition")
	private Condition condition;

	//bi-directional many-to-one association to Item
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_item")
	private Item item;

	//bi-directional many-to-one association to Plot
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_plot")
	private Plot plot;

	public Inventory() {
	}

	/*
	public int getIdCondition() {
		return this.idCondition;
	}

	public void setIdCondition(int idCondition) {
		this.idCondition = idCondition;
	}

	public int getIdItem() {
		return this.idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public int getIdPlot() {
		return this.idPlot;
	}

	public void setIdPlot(int idPlot) {
		this.idPlot = idPlot;
	}
	*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Condition getCondition() {
		return this.condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Plot getPlot() {
		return this.plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

}