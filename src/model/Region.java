package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "region" database table.
 * 
 */
@Entity
@Table(name="region")
@NamedQuery(name="Region.findAll", query="SELECT r FROM Region r")
public class Region extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/*
	@Column(name="id_region")
	private int idRegion;

	@Column(name="id_world")
	private int idWorld;
	*/
	@Column(name="name", length=45)
	private String name;

	//bi-directional many-to-one association to Location
	@OneToMany(mappedBy="region")
	private List<Location> locations;

	//bi-directional many-to-one association to Region
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_region")
	private Region region;

	//bi-directional many-to-one association to Region
	@OneToMany(mappedBy="region")
	private List<Region> regions;

	//bi-directional many-to-one association to World
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_world")
	private World world;

	//bi-directional many-to-many association to State
	@ManyToMany(mappedBy="regions")
	private List<State> states;

	//bi-directional many-to-one association to Storyline
	@OneToMany(mappedBy="region")
	private List<Storyline> storylines;

	public Region() {
	}
	/*
	public int getIdRegion() {
		return this.idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
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

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setRegion(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setRegion(null);

		return location;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Region> getRegions() {
		return this.regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public Region addRegion(Region region) {
		getRegions().add(region);
		region.setRegion(this);

		return region;
	}

	public Region removeRegion(Region region) {
		getRegions().remove(region);
		region.setRegion(null);

		return region;
	}

	public World getWorld() {
		return this.world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public List<State> getStates() {
		return this.states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public List<Storyline> getStorylines() {
		return this.storylines;
	}

	public void setStorylines(List<Storyline> storylines) {
		this.storylines = storylines;
	}

	public Storyline addStoryline(Storyline storyline) {
		getStorylines().add(storyline);
		storyline.setRegion(this);

		return storyline;
	}

	public Storyline removeStoryline(Storyline storyline) {
		getStorylines().remove(storyline);
		storyline.setRegion(null);

		return storyline;
	}

}