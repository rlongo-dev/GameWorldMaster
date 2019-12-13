package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "world" database table.
 * 
 */
@Entity
@Table(name="world")
@NamedQuery(name="World.findAll", query="SELECT w FROM World w")
public class World extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	@Column(name="id_world")
	private int idWorld;
	*/
	
	@Column(name="name", length=45)
	private String name;

	//bi-directional many-to-one association to Region
	@OneToMany(mappedBy="world")
	private List<Region> regions;

	//bi-directional many-to-one association to Storyline
	@OneToMany(mappedBy="world")
	private List<Storyline> storylines;

	//bi-directional many-to-one association to World
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_world")
	private World world;

	//bi-directional many-to-one association to World
	@OneToMany(mappedBy="world")
	private List<World> worlds;

	public World() {
	}

	/*
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

	public List<Region> getRegions() {
		return this.regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public Region addRegion(Region region) {
		getRegions().add(region);
		region.setWorld(this);

		return region;
	}

	public Region removeRegion(Region region) {
		getRegions().remove(region);
		region.setWorld(null);

		return region;
	}

	public List<Storyline> getStorylines() {
		return this.storylines;
	}

	public void setStorylines(List<Storyline> storylines) {
		this.storylines = storylines;
	}

	public Storyline addStoryline(Storyline storyline) {
		getStorylines().add(storyline);
		storyline.setWorld(this);

		return storyline;
	}

	public Storyline removeStoryline(Storyline storyline) {
		getStorylines().remove(storyline);
		storyline.setWorld(null);

		return storyline;
	}

	public World getWorld() {
		return this.world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public List<World> getWorlds() {
		return this.worlds;
	}

	public void setWorlds(List<World> worlds) {
		this.worlds = worlds;
	}

	public World addWorld(World world) {
		getWorlds().add(world);
		world.setWorld(this);

		return world;
	}

	public World removeWorld(World world) {
		getWorlds().remove(world);
		world.setWorld(null);

		return world;
	}

}