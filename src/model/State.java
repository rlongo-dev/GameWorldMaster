package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "state" database table.
 * 
 */
@Entity
@Table(name="state")
@NamedQuery(name="State.findAll", query="SELECT s FROM State s")
public class State extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//@Column(name="id_state")
	//private int idState;

	@Column(name="id_world")
	private int idWorld;

	@Column(name="name", length=45)
	private String name;

	//bi-directional many-to-one association to Site
	@OneToMany(mappedBy="state")
	private List<Site> sites;

	//bi-directional many-to-many association to Region
	@ManyToMany
	@JoinTable(
		name="many_region_has_many_state"
		, joinColumns={

			}
		, inverseJoinColumns={

			}
		)
	private List<Region> regions;

	//bi-directional many-to-one association to State
	@ManyToOne
	//@JoinColumns({})
	@JoinColumn(name="id_state")
	private State state;

	//bi-directional many-to-one association to State
	@OneToMany(mappedBy="state")
	private List<State> states;

	public State() {
	}
	/*
	public int getIdState() {
		return this.idState;
	}

	public void setIdState(int idState) {
		this.idState = idState;
	}
	*/
	public int getIdWorld() {
		return this.idWorld;
	}

	public void setIdWorld(int idWorld) {
		this.idWorld = idWorld;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Site> getSites() {
		return this.sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

	public Site addSite(Site site) {
		getSites().add(site);
		site.setState(this);

		return site;
	}

	public Site removeSite(Site site) {
		getSites().remove(site);
		site.setState(null);

		return site;
	}

	public List<Region> getRegions() {
		return this.regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<State> getStates() {
		return this.states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public State addState(State state) {
		getStates().add(state);
		state.setState(this);

		return state;
	}

	public State removeState(State state) {
		getStates().remove(state);
		state.setState(null);

		return state;
	}

}