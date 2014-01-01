package com.github.forsakenheroes.core.gameobjects.components;

import com.github.forsakenheroes.core.gameobjects.GameObject;

/**
 * Abstract class that all components will extend from.
 * 
 */
public abstract class Component {
	protected GameObject owner;
	
	public Component(GameObject owner) {
		this.owner = owner;
	}
	
	/**
	 * Get the GameObject this component belongs to.
	 * 
	 * @return GameObject owner.
	 */
	public GameObject getOwner() {
		return this.owner;
	}

}
