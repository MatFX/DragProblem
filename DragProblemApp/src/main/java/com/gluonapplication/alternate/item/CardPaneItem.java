package com.gluonapplication.alternate.item;

import java.util.Timer;

import com.gluonapplication.alternate.task.LongPressedTimerTask;
import com.gluonapplication.interfaces.IVisible;
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
	
	//private boolean isSelectedLongPressed = false;
	
	private Timer timerLongPressed;
	
	public CardPaneItem()
	{
		super(15);
		this.setPadding(new Insets(1,5,1,1));
		
		this.setMinHeight(60);
		this.setPrefHeight(60);
		
		label = new Label();
		//add label in the middle of the hbox
		this.getChildren().addAll(createSpacer(), label, createSpacer());
		
		
		this.setOnMousePressed(new EventHandler<MouseEvent>() 
		{
			@Override
			public void handle(MouseEvent event) 
			{
				startLongPressedTimer();
				
			}
			
		});
		
		this.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//stop long pressed when timer is running
				stopLongPressedTimer();
				
			}
			
		});
	}
	

	/**
	 * 
	 */
	public void startLongPressedTimer() 
	{
		if(timerLongPressed != null)
		{
			//zurücksetzen
			timerLongPressed.cancel();
			timerLongPressed.purge();
		}
		
		timerLongPressed = new Timer();
		//> 500ms is long pressed
		timerLongPressed.schedule(new LongPressedTimerTask(this), 500 * 1);
	}
	
	/**
	 * es kann sein, dass der Timer noch nicht ausgelöst wurde deswegen die etwaige Verarbeitung stoppen
	 */
	public void stopLongPressedTimer()
	{
		if(timerLongPressed != null)
		{
			timerLongPressed.cancel();
			timerLongPressed.purge();
		}
		
	}
	
	public void setSelectedLongPressed(boolean isSelectedLongPressed)
	{
		this.iVisible.setLongPressed(isSelectedLongPressed);
		this.changeItemStyle();
		
		
	}
	
	private void changeItemStyle() 
	{
		System.out.println(" this.iVisible.isLongPressed() + " + this.iVisible.isLongPressed());
		if(this.iVisible.isLongPressed())
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
