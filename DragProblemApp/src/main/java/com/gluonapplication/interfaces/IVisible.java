package com.gluonapplication.interfaces;

import javafx.beans.property.SimpleBooleanProperty;

/**
 * Eine Schnittstelle, die alle Objekte implementieren müssen,
 * die auf dem Bildschirm angezeigt werden können
 * @author m.allertz
 *
 */
public interface IVisible 
{

	public String getDescription();
	
	public boolean isSelectedLongPressed();
	
	public void setSelectedLongPressed(boolean isLongPressed);
	
	public SimpleBooleanProperty getLongPressedProperty();
}
