package com.ipartek.formacion.fichajes.joseba;

public class People {
	
	private String name;
	private int time; //minutes
	private int numConnection;
	
	
	public People() {
		super();
		this.name = "";
		this.time = 0;
		this.numConnection = 0;
	}

	public People(String name, int time, int numConnection) {
		super();
		this.name = name;
		this.time = time;
		this.numConnection = numConnection;
	}
	
	
	public int getNumConnection() {
		return numConnection;
	}

	public void setNumConnection(int numConnection) {
		this.numConnection = numConnection;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	
	@Override
	public String toString() {
		return "People [name=" + name + ", time=" + time + ", numConnection=" + numConnection + "]";
	}
}
