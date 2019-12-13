package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "district" database table.
 * 
 */
@Entity
@Table(name="district")
@NamedQuery(name="District.findAll", query="SELECT d FROM District d")
public class District extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//Not needed
	//@Column(name="id_site")
	//private int idSite;

	@Column(name="name", length=45)
	private String name;

	//bi-directional many-to-one association to Area
	@OneToMany(mappedBy="district")
	private List<Area> areas;

	//bi-directional many-to-one association to Site
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_site")
	private Site site;

	public District() {
	}

	/*
	public int getIdSite() {
		return this.idSite;
	}

	public void setIdSite(int idSite) {
		this.idSite = idSite;
	}
	*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Area> getAreas() {
		return this.areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public Area addArea(Area area) {
		getAreas().add(area);
		area.setDistrict(this);

		return area;
	}

	public Area removeArea(Area area) {
		getAreas().remove(area);
		area.setDistrict(null);

		return area;
	}

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}