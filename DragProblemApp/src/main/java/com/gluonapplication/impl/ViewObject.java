package com.gluonapplication.impl;

import com.gluonapplication.interfaces.IVisible;

public class ViewObject implements IVisible
{
	private String description;
	
	private boolean isLongPressedSelected = false;

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
	public boolean isLongPressed() {
		return isLongPressedSelected;
	}

	@Override
	public void setLongPressed(boolean isLongPressed) {
		this.isLongPressedSelected = isLongPressed;
	}

}
