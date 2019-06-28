package com.gluonapplication.impl;

import com.gluonapplication.interfaces.IVisible;

public class ViewObject implements IVisible
{
	private String description;

	public ViewObject(String description)
	{
		this.description = description;
	}
	
	@Override
	public String getDescription() 
	{
		return description;
	}

}
