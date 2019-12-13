package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "condition" database table.
 * 
 */
@Entity
@Table(name="condition")
@NamedQuery(name="Condition.findAll", query="SELECT c FROM Condition c")
public class Condition extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//Not needed below, referenced in M2O relationship
	//@Column(name="id_storyline")
	//private int idStoryline;

	@Column(name="name", length=45)
	private String name;

	@Column(name="type")
	private int type;

	//bi-directional many-to-one association to Storyline
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_storyline")
	private Storyline storyline;

	//bi-directional many-to-many association to Creature
	@ManyToMany(mappedBy="conditions")
	private List<Creature> creatures;

	//bi-directional many-to-one association to Inventory
	@OneToMany(mappedBy="condition")
	private List<Inventory> inventories;

	public Condition() {
	}

	/*
	public int getIdStoryline() {
		return this.idStoryline;
	}

	public void setIdStoryline(int idStoryline) {
		this.idStoryline = idStoryline;
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

	public Storyline getStoryline() {
		return this.storyline;
	}

	public void setStoryline(Storyline storyline) {
		this.storyline = storyline;
	}

	public List<Creature> getCreatures() {
		return this.creatures;
	}

	public void setCreatures(List<Creature> creatures) {
		this.creatures = creatures;
	}

	public List<Inventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}

	public Inventory addInventory(Inventory inventory) {
		getInventories().add(inventory);
		inventory.setCondition(this);

		return inventory;
	}

	public Inventory removeInventory(Inventory inventory) {
		getInventories().remove(inventory);
		inventory.setCondition(null);

		return inventory;
	}

}