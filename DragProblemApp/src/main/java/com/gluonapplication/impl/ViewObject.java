package com.gluonapplication.impl;

import com.gluonapplication.interfaces.IVisible;

import javafx.beans.property.SimpleBooleanProperty;

public class ViewObject implements IVisible
{
	private String description;
	
	private SimpleBooleanProperty isLongPressedSelected = new SimpleBooleanProperty(false);

	public ViewObject(String description)
	{
		this.description = description;
	}
	
	@Override
	public String getDescription() 
	{
		return description;
	}

	@Override
	public boolean isSelectedLongPressed() {
		return isLongPressedSelected.get();
	}

	@Override
	public void setSelectedLongPressed(boolean isLongPressed) {
		this.isLongPressedSelected.set(isLongPressed);
	}
	
	public SimpleBooleanProperty getLongPressedProperty()
	{
		return isLongPressedSelected;
	}

}
