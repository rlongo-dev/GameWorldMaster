package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "creature_type" database table.
 * 
 */
@Entity
@Table(name="creature_type")
@NamedQuery(name="CreatureType.findAll", query="SELECT c FROM CreatureType c")
public class CreatureType extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//@Column(name="id_creature_type")
	//private int idCreatureType;

	@Column(name="name", length=45)
	private String name;

	//bi-directional many-to-many association to Attribute
	@ManyToMany
	@JoinTable(
		name="many_creature_type_has_many_attribute"
		, joinColumns={

			}
		, inverseJoinColumns={

			}
		)
	private List<Attribute> attributes;

	//bi-directional many-to-many association to Creature
	@ManyToMany
	@JoinTable(
		name="many_creature_has_many_creature_type"
		, joinColumns={

			}
		, inverseJoinColumns={

			}
		)
	private List<Creature> creatures;

	//bi-directional many-to-one association to CreatureType
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_creature_type")
	private CreatureType creatureType;

	//bi-directional many-to-one association to CreatureType
	@OneToMany(mappedBy="creatureType")
	private List<CreatureType> creatureTypes;

	public CreatureType() {
	}
	/*
	public int getIdCreatureType() {
		return this.idCreatureType;
	}

	public void setIdCreatureType(int idCreatureType) {
		this.idCreatureType = idCreatureType;
	}
	*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Attribute> getAttributes() {
		return this.attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public List<Creature> getCreatures() {
		return this.creatures;
	}

	public void setCreatures(List<Creature> creatures) {
		this.creatures = creatures;
	}

	public CreatureType getCreatureType() {
		return this.creatureType;
	}

	public void setCreatureType(CreatureType creatureType) {
		this.creatureType = creatureType;
	}

	public List<CreatureType> getCreatureTypes() {
		return this.creatureTypes;
	}

	public void setCreatureTypes(List<CreatureType> creatureTypes) {
		this.creatureTypes = creatureTypes;
	}

	public CreatureType addCreatureType(CreatureType creatureType) {
		getCreatureTypes().add(creatureType);
		creatureType.setCreatureType(this);

		return creatureType;
	}

	public CreatureType removeCreatureType(CreatureType creatureType) {
		getCreatureTypes().remove(creatureType);
		creatureType.setCreatureType(null);

		return creatureType;
	}

}