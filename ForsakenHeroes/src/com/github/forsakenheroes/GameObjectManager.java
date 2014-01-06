package com.github.forsakenheroes;

import java.util.HashMap;

import com.github.evms.eventmangement.Event;
import com.github.evms.eventmangement.EventHandler;
import com.github.evms.eventmangement.EventManager;
import com.github.forsakenheroes.core.gameobjects.GameObject;

public class GameObjectManager implements EventHandler {

	private static GameObjectManager instance = null;
	private static HashMap<String, GameObject> gameObjects;
	
	private GameObjectManager() {
		gameObjects = new HashMap<String, GameObject>();
		EventManager.getInstance().registerEvent("EVENT_GAMEOBJECT_CREATED", this);
	}
	
	public synchronized static GameObjectManager getInstance() {
		if (instance == null) {
			instance = new GameObjectManager();
		}
		return instance;
	}

	@Override
	public void onEvent(Event event) {
		int typeHash = event.getType().hashCode();
		Object[] params = event.getParams();
		if (typeHash == "EVENT_GAMEOBJECT_CREATED".hashCode()) {
			if (params[0] instanceof GameObject) {
				GameObject obj = (GameObject) params[0];
				gameObjects.put(obj.getGUID(), obj);
			}
		}
	}
	
	

}
