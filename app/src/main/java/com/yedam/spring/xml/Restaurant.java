package com.yedam.spring.xml;

public class Restaurant {

	private Chef chef;
	
	public void run() {
		chef.cooking();
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}
}
