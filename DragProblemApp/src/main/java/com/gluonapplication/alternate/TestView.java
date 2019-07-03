package com.gluonapplication.alternate;

import java.util.List;

import com.gluonapplication.alternate.item.CardPaneItem;
import com.gluonapplication.data.DataStorage;
import com.gluonapplication.interfaces.IVisible;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.CardCell;
import com.gluonhq.charm.glisten.control.CardPane;
import com.gluonhq.charm.glisten.mvc.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class TestView extends View
{
	
	/**
	 * cardpane with the data content
	 */
	private CardPane<IVisible> cardPane;
	
    public TestView() {
    	
    	
    	ListView listView = new ListView<IVisible>();
    	
    	cardPane = new CardPane<IVisible>();
    	cardPane.setOnScroll(new EventHandler<ScrollEvent>() 
    	{
            @Override 
            public void handle(ScrollEvent event) 
            {
            	System.out.println("event<"+event+">");
                
                event.consume();
            }
        });
    	cardPane.setCellFactory(p -> new CardCell<IVisible>() 
		{
			private final CardPaneItem cardPaneItem;
            {
            	cardPaneItem = new CardPaneItem();
            	
            	
            }
            
            @Override
            public void updateItem(IVisible iVisible, boolean empty) 
            {
            	System.out.println("aufruf von cardPaneItem");
            
            	//I have the feel, without the calling of the super method the view scrolling is faster
            	//super.updateItem(groupViewObject, empty);
            	if (iVisible != null && !empty) 
                {
            		cardPaneItem.setIVisible(iVisible);
                    setGraphic(cardPaneItem);
                    setText(null);
                } 
            	else
            	{
                    setGraphic(null);
                    setText(null);
                }
            }
		});
    	
    	//fill the card pane with the test values
    	List<IVisible> dataList = DataStorage.getDataList();
    	for(int i = 0; i < dataList.size(); i++)
    	{
    		cardPane.getItems().add(dataList.get(i));
    	}
    	setCenter(cardPane);
    	//set cardPane to presenter...the presenter will later change the up/down
    	MoveItemPresenter.setCardPane(cardPane);
    	
    	
    	Button up = new Button("Up");
    	up.setOnAction(new EventHandler<ActionEvent>() 
    	{
			@Override
			public void handle(ActionEvent event) 
			{
				MoveItemPresenter.moveUp();
				
				
			}
    		
    	});
    	
    	
    	Button down = new Button("Down");
    	down.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				MoveItemPresenter.moveDown();
			}
    		
    	});
    	
    	Button clearSelect = new Button("Clear");
    	clearSelect.setOnAction(new EventHandler<ActionEvent>() 
    	{

			@Override
			public void handle(ActionEvent event) 
			{
				//deselect the selected item
				MoveItemPresenter.removeMoveItem();
				
				
			}
    		
    	});
    	
    	
    	
    	HBox hBox = new HBox(3);
    	hBox.setPadding(new Insets(5,5,5,5));
    	
    	hBox.getChildren().addAll(createSpacer(), up, createSpacer(), down, createSpacer(), clearSelect, createSpacer());
    	//setBottom hinzufügen und entfernen?
    	this.setBottom(hBox);
    	
    	/*
    	MobileApplication.getInstance().getGlassPane().setOnMousePressed(new EventHandler<MouseEvent>()
    	{

			@Override
			public void handle(MouseEvent event) 
			{
				System.out.println("mousePressed ");
				
			}
    		
    	});
    	
    	MobileApplication.getInstance().getGlassPane().setOnMouseReleased(new EventHandler<MouseEvent>()
    	{

			@Override
			public void handle(MouseEvent event) 
			{
				System.out.println("mouseReleased ");
				
			}
    		
    	});*/
    	
    	
    }

    @Override
    protected void updateAppBar(AppBar appBar) {}
    
   
    private Node createSpacer() 
	{
		Region spacer = new Region();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		return spacer;
	}

}
