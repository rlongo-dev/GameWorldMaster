package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "storyline" database table.
 * 
 */
@Entity
@Table(name="storyline")
@NamedQuery(name="Storyline.findAll", query="SELECT s FROM Storyline s")
public class Storyline extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="begin_time")
	private int beginTime;

	@Column(name="description", length=1000)
	private String description;

	@Column(name="end_time")
	private int endTime;
	/*
	@Column(name="id_location")
	private int idLocation;

	@Column(name="id_region")
	private int idRegion;

	@Column(name="id_storyline")
	private int idStoryline;

	@Column(name="id_world")
	private int idWorld;
	*/
	@Column(name="name", length=45)
	private String name;

	@Column(name="type")
	private int type;

	//bi-directional many-to-one association to Condition
	@OneToMany(mappedBy="storyline")
	private List<Condition> conditions;

	//bi-directional many-to-one association to Location
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_location")
	private Location location;

	//bi-directional many-to-one association to Region
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_region")
	private Region region;

	//bi-directional many-to-one association to Storyline
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_storyline")
	private Storyline storyline;

	//bi-directional many-to-one association to Storyline
	@OneToMany(mappedBy="storyline")
	private List<Storyline> storylines;

	//bi-directional many-to-one association to World
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_world")
	private World world;

	public Storyline() {
	}

	public int getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(int beginTime) {
		this.beginTime = beginTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEndTime() {
		return this.endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	/*
	public int getIdLocation() {
		return this.idLocation;
	}

	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}

	public int getIdRegion() {
		return this.idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}

	public int getIdStoryline() {
		return this.idStoryline;
	}

	public void setIdStoryline(int idStoryline) {
		this.idStoryline = idStoryline;
	}

	public int getIdWorld() {
		return this.idWorld;
	}

	public void setIdWorld(int idWorld) {
		this.idWorld = idWorld;
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

	public List<Condition> getConditions() {
		return this.conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public Condition addCondition(Condition condition) {
		getConditions().add(condition);
		condition.setStoryline(this);

		return condition;
	}

	public Condition removeCondition(Condition condition) {
		getConditions().remove(condition);
		condition.setStoryline(null);

		return condition;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Storyline getStoryline() {
		return this.storyline;
	}

	public void setStoryline(Storyline storyline) {
		this.storyline = storyline;
	}

	public List<Storyline> getStorylines() {
		return this.storylines;
	}

	public void setStorylines(List<Storyline> storylines) {
		this.storylines = storylines;
	}

	public Storyline addStoryline(Storyline storyline) {
		getStorylines().add(storyline);
		storyline.setStoryline(this);

		return storyline;
	}

	public Storyline removeStoryline(Storyline storyline) {
		getStorylines().remove(storyline);
		storyline.setStoryline(null);

		return storyline;
	}

	public World getWorld() {
		return this.world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}