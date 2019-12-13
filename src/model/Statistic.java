package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the "statistics" database table.
 * 
 */
@Entity
@Table(name="statistics")
@NamedQuery(name="Statistic.findAll", query="SELECT s FROM Statistic s")
public class Statistic extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	@Column(name="id_attribute")
	private int idAttribute;

	@Column(name="id_creature")
	private int idCreature;
	*/
	@Column(name="value", precision=2)
	private BigDecimal value;

	//bi-directional many-to-one association to Attribute
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_attribute")
	private Attribute attribute;

	//bi-directional many-to-one association to Creature
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_creature")
	private Creature creature;

	public Statistic() {
	}

	/*
	public int getIdAttribute() {
		return this.idAttribute;
	}

	public void setIdAttribute(int idAttribute) {
		this.idAttribute = idAttribute;
	}

	public int getIdCreature() {
		return this.idCreature;
	}

	public void setIdCreature(int idCreature) {
		this.idCreature = idCreature;
	}
	*/
	public BigDecimal getValue() {
		return this.value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Attribute getAttribute() {
		return this.attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public Creature getCreature() {
		return this.creature;
	}

	public void setCreature(Creature creature) {
		this.creature = creature;
	}

}