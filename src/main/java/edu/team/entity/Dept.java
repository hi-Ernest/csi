package edu.team.entity;

public class Dept {

	private int id;
	private String name;
	private String remake;
	
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemake() {
		return remake;
	}
	public void setRemake(String remake) {
		this.remake = remake;
	}
	public Dept(int id, String name, String remake) {
		super();
		this.id = id;
		this.name = name;
		this.remake = remake;
	}
	
	
}
