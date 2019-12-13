package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "area" database table.
 * 
 */
@Entity
@Table(name="area")
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private int id;

	//member below commented out because not needed if referenced in joinColumn relationship below
	//@Column(name="id_district")
	//private int idDistrict;

	@Column(name="name", length=45)
	private String name;

	//bi-directional many-to-one association to District
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_district")
	private District district;

	//bi-directional many-to-one association to Location
	@OneToMany(mappedBy="area")
	private List<Location> locations;

	//bi-directional many-to-one association to Plot
	@OneToMany(mappedBy="area")
	private List<Plot> plots;

	public Area() {
	}
	
	public Area(int id, String name) {
		this.setId(id);
		this.setName(name);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	/*
	public int getIdDistrict() {
		return this.idDistrict;
	}

	public void setIdDistrict(int idDistrict) {
		this.idDistrict = idDistrict;
	}
	*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setArea(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setArea(null);

		return location;
	}

	public List<Plot> getPlots() {
		return this.plots;
	}

	public void setPlots(List<Plot> plots) {
		this.plots = plots;
	}

	public Plot addPlot(Plot plot) {
		getPlots().add(plot);
		plot.setArea(this);

		return plot;
	}

	public Plot removePlot(Plot plot) {
		getPlots().remove(plot);
		plot.setArea(null);

		return plot;
	}

}