package com.gluonapplication.item;

import com.gluonapplication.interfaces.IVisible;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class CardPaneItem extends HBox
{
	
	private IVisible iVisible;
	
	private Label label;
	
	public CardPaneItem()
	{
		super(15);
		this.setPadding(new Insets(1,5,1,1));
		
		this.setMinHeight(60);
		this.setPrefHeight(60);
		
		label = new Label();
		//add label in the middle of the hbox
		this.getChildren().addAll(createSpacer(), label, createSpacer());
		
		this.setOnDragDetected(new EventHandler<MouseEvent>()
		{

			@Override
			public void handle(MouseEvent event) 
			{
				System.out.println("event " + event.getSceneX() + " y " + event.getSceneY());
				
				Dragboard dragboard = CardPaneItem.this.startDragAndDrop(TransferMode.ANY);
				ClipboardContent content = new ClipboardContent();
				
				//quick and dirty; changed color of item before the snapshot
				CardPaneItem.this.setStyle("-fx-background-color: #FF0000");
				Image imageSnapshot = CardPaneItem.this.snapshot(null, null);
				//reset color
				CardPaneItem.this.setStyle("");
				dragboard.setDragView(imageSnapshot) ;
				
				//correction of x; when event in the middle of the item...not all, not finished
				double wVerschiebung = imageSnapshot.getWidth() - event.getSceneX();
				
				
				dragboard.setDragViewOffsetX(wVerschiebung);
				dragboard.setDragViewOffsetY(0);
				content.putString("TEST DRAG");
				dragboard.setContent(content);
				event.consume();
				
			}
			
		});
	}
	
	public void setIVisible(IVisible iVisible)
	{
		this.iVisible = iVisible;
		label.setText(iVisible.getDescription());
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


}
