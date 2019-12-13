package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "site" database table.
 * 
 */
@Entity
@Table(name="site")
@NamedQuery(name="Site.findAll", query="SELECT s FROM Site s")
public class Site extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//@Column(name="id_state")
	//private int idState;

	@Column(name="name", length=45)
	private String name;

	//bi-directional many-to-one association to District
	@OneToMany(mappedBy="site")
	private List<District> districts;

	//bi-directional many-to-one association to State
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_state")
	private State state;

	public Site() {
	}
	/*
	public int getIdState() {
		return this.idState;
	}

	public void setIdState(int idState) {
		this.idState = idState;
	}
	*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<District> getDistricts() {
		return this.districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	public District addDistrict(District district) {
		getDistricts().add(district);
		district.setSite(this);

		return district;
	}

	public District removeDistrict(District district) {
		getDistricts().remove(district);
		district.setSite(null);

		return district;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

}