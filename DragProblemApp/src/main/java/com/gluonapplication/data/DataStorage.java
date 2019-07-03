package com.gluonapplication.data;

import java.util.ArrayList;
import java.util.List;

import com.gluonapplication.impl.ViewObject;
import com.gluonapplication.interfaces.IVisible;

public class DataStorage 
{
	
	public static List<IVisible> getDataList()
	{
		List<IVisible> returnValue = new ArrayList<IVisible>();
		returnValue.add(new ViewObject("Item 1"));
		returnValue.add(new ViewObject("Item 2"));
		returnValue.add(new ViewObject("Item 3"));
//		returnValue.add(new ViewObject("Item 4"));
//		returnValue.add(new ViewObject("Item 5"));
//		returnValue.add(new ViewObject("Item 6"));
//		returnValue.add(new ViewObject("Item 7"));
//		returnValue.add(new ViewObject("Item 8"));
//		returnValue.add(new ViewObject("Item 9"));
		return returnValue;
	}

}
