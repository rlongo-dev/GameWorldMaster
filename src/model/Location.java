package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "location" database table.
 * 
 */
@Entity
@Table(name="location")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/* Not needed
	@Column(name="id_area")
	private int idArea;

	@Column(name="id_plot")
	private int idPlot;

	@Column(name="id_region")
	private int idRegion;
	*/
	@Column(name="name", length=45)
	private String name;

	//bi-directional many-to-one association to Area
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_area")
	private Area area;

	//bi-directional many-to-one association to Plot
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_plot")
	private Plot plot;

	//bi-directional many-to-one association to Region
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_region")
	private Region region;

	//bi-directional many-to-one association to Storyline
	@OneToMany(mappedBy="location")
	private List<Storyline> storylines;

	public Location() {
	}

	/*
	public int getIdArea() {
		return this.idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public int getIdPlot() {
		return this.idPlot;
	}

	public void setIdPlot(int idPlot) {
		this.idPlot = idPlot;
	}

	public int getIdRegion() {
		return this.idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}
	*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Plot getPlot() {
		return this.plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Storyline> getStorylines() {
		return this.storylines;
	}

	public void setStorylines(List<Storyline> storylines) {
		this.storylines = storylines;
	}

	public Storyline addStoryline(Storyline storyline) {
		getStorylines().add(storyline);
		storyline.setLocation(this);

		return storyline;
	}

	public Storyline removeStoryline(Storyline storyline) {
		getStorylines().remove(storyline);
		storyline.setLocation(null);

		return storyline;
	}

}