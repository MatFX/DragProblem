package com.gluonapplication.alternate.item;

import java.util.Timer;

import com.gluonapplication.alternate.MoveItemPresenter;
import com.gluonapplication.interfaces.IVisible;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class CardPaneItem extends HBox
{
	
	private IVisible iVisible;
	
	private Label label;
	
	private boolean isReleasedReceived = false;
	
	private Timer timerLongPressed;
	
	private long startTimePressed = Long.MIN_VALUE;
	
	public CardPaneItem()
	{
		super(15);
		this.setPadding(new Insets(1,5,1,1));
		
		this.setMinHeight(60);
		this.setPrefHeight(60);
		
		label = new Label();
		//add label in the middle of the hbox
		this.getChildren().addAll(createSpacer(), label, createSpacer());
		
		//das muss in die Oberfläche und nicht am item oder
		this.setOnMousePressed(new EventHandler<MouseEvent>() 
		{
			@Override
			public void handle(MouseEvent event) 
			{
				startTimePressed = System.currentTimeMillis();
			}
			
		});
		
		this.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				//nicht so schön von der Handhabung aber weniger Probleme beim sliden
				long currentTime = System.currentTimeMillis();
				if(startTimePressed != Long.MIN_VALUE && startTimePressed + 1000 < currentTime)
				{

					Platform.runLater(() ->
					{
						MoveItemPresenter.addMoveItem(iVisible);
						
					});
				}
				
				startTimePressed = Long.MIN_VALUE;
				
			}
			
		});
	}
	

	
	
	public void setSelectedLongPressed(boolean isSelectedLongPressed)
	{
		this.iVisible.setSelectedLongPressed(isSelectedLongPressed);
		//this.changeItemStyle();
		
		
		
	}
	
	private void changeItemStyle() 
	{
		System.out.println(" this.iVisible.isLongPressed() + " + this.iVisible.isSelectedLongPressed());
		if(this.iVisible.isSelectedLongPressed())
		{
			this.setStyle("-fx-background-color: #FF0000");
		}
		else
		{
			this.setStyle("");
		}
	}


	public boolean isSelectedLongPressed()
	{
		return this.isVisible();
	}
	
	public void setIVisible(IVisible iVisible)
	{
		this.iVisible = iVisible;
		
		//this.iVisible.getLongPressedProperty().addListener(listener);
		this.iVisible.getLongPressedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				System.out.println("newValue " + newValue);
				changeItemStyle();
				
			}
			
		});
		//this.iVisible.getLongPressedProperty().unbind();
		label.setText(iVisible.getDescription());
		//change the colorization
		changeItemStyle();
	}
	
	public String getDescription()
	{
		return iVisible.getDescription();
	}
	
	/**
     * boss mode in the layout
     * @return
     */
    private Node createSpacer() 
	{
		Region spacer = new Region();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		return spacer;
	}
    
    public IVisible getIVisible()
    {
    	return iVisible;
    }
    
   


}
