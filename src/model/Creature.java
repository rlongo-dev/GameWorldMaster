package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "creature" database table.
 * 
 */
@Entity
@Table(name="creature")
@NamedQuery(name="Creature.findAll", query="SELECT c FROM Creature c")
public class Creature extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="name", length=45)
	private String name;

	//bi-directional many-to-many association to Condition
	@ManyToMany
	@JoinTable(
		name="many_condition_has_many_creature"
		, joinColumns={

			}
		, inverseJoinColumns={

			}
		)
	private List<Condition> conditions;

	//bi-directional many-to-many association to CreatureType
	@ManyToMany(mappedBy="creatures")
	private List<CreatureType> creatureTypes;

	//bi-directional many-to-one association to Statistic
	@OneToMany(mappedBy="creature")
	private List<Statistic> statistics;

	public Creature() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Condition> getConditions() {
		return this.conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
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
		statistic.setCreature(this);

		return statistic;
	}

	public Statistic removeStatistic(Statistic statistic) {
		getStatistics().remove(statistic);
		statistic.setCreature(null);

		return statistic;
	}

}