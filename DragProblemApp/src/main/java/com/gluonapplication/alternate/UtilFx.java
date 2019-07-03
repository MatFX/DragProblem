package com.gluonapplication.alternate;

import java.beans.EventHandler;

import com.gluonhq.charm.glisten.control.CardPane;
import com.sun.javafx.scene.control.skin.Utils;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Control;
import javafx.scene.control.ScrollToEvent;
import javafx.scene.control.Skin;
import javafx.scene.input.ScrollEvent;

public class UtilFx 
{
	
	public static void scrollToIndex(Control control, int index)
	{
		
		System.out.println("scrollToIndex " + control + " index " + index);
		//ControlUtils.scrollToIndex(control, index);
		  Utils.executeOnceWhenPropertyIsNonNull(control.skinProperty(), (Skin<?> skin) -> {
	            Event.fireEvent(control, new ScrollToEvent<>(control, control, ScrollToEvent.scrollToTopIndex(), index));
	        });
	}
}
