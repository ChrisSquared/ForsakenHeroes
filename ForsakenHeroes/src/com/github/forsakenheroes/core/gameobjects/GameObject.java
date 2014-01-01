package com.github.forsakenheroes.core.gameobjects;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.github.forsakenheroes.core.gameobjects.components.Component;

public class GameObject {

	// Global Unique Identifier (GUID)
	private UUID guid;
	
	// Storage for the components tied to this GameObject
	private ConcurrentHashMap<String, Component> componentMap;
	
	/**
	 * Create a new GameObject with a unique GUID.
	 */
	public GameObject() {
		guid = UUID.randomUUID();
		componentMap = new ConcurrentHashMap<String, Component>();
	}
	
	/**
	 * Attempts to add a component to the 
	 * @param name
	 * @param component
	 * @return true if added, false if not.
	 */
	public boolean addComponent(String name, Component component) {
		if (name == null || name.equalsIgnoreCase("") || component == null) {
			throw new IllegalArgumentException("Component can't be null and7 name must be valid String");
		}
		
		return componentMap.putIfAbsent(name, component) == null;
	}
	
	public UUID getUUID() {
		return guid;
	}
}
