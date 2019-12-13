package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "attribute" database table.
 * 
 */
@Entity
@Table(name="attribute")
@NamedQuery(name="Attribute.findAll", query="SELECT a FROM Attribute a")
public class Attribute extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//member below commented out because not needed if referenced in joinColumn relationship below
	//@Column(name="id_attribute")
	//private int idAttribute;

	@Column(name="name", length=45)
	private String name;

	//bi-directional many-to-one association to Attribute
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_attribute")
	private Attribute attribute;

	//bi-directional many-to-one association to Attribute
	@OneToMany(mappedBy="attribute")
	private List<Attribute> attributes;

	//bi-directional many-to-many association to CreatureType
	@ManyToMany(mappedBy="attributes")
	private List<CreatureType> creatureTypes;

	//bi-directional many-to-one association to Statistic
	@OneToMany(mappedBy="attribute")
	private List<Statistic> statistics;

	public Attribute() {
	}

	/*
	public int getIdAttribute() {
		return this.idAttribute;
	}

	public void setIdAttribute(int idAttribute) {
		this.idAttribute = idAttribute;
	}
	*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Attribute getAttribute() {
		return this.attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public List<Attribute> getAttributes() {
		return this.attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public Attribute addAttribute(Attribute attribute) {
		getAttributes().add(attribute);
		attribute.setAttribute(this);

		return attribute;
	}

	public Attribute removeAttribute(Attribute attribute) {
		getAttributes().remove(attribute);
		attribute.setAttribute(null);

		return attribute;
	}

	public List<CreatureType> getCreatureTypes() {
		return this.creatureTypes;
	}

	public void setCreatureTypes(List<CreatureType> creatureTypes) {
		this.creatureTypes = creatureTypes;
	}

	public List<Statistic> getStatistics() {
		return this.statistics;
	}

	public void setStatistics(List<Statistic> statistics) {
		this.statistics = statistics;
	}

	public Statistic addStatistic(Statistic statistic) {
		getStatistics().add(statistic);
		statistic.setAttribute(this);

		return statistic;
	}

	public Statistic removeStatistic(Statistic statistic) {
		getStatistics().remove(statistic);
		statistic.setAttribute(null);

		return statistic;
	}

}