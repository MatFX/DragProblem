package com.gluonapplication;


import java.util.List;

import com.gluonapplication.data.DataStorage;
import com.gluonapplication.interfaces.IVisible;
import com.gluonapplication.item.CardPaneItem;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.CardCell;
import com.gluonhq.charm.glisten.control.CardPane;
import com.gluonhq.charm.glisten.mvc.View;

public class BasicView extends View {
	
	
	/**
	 * cardpane with the data content
	 */
	private CardPane<IVisible> cardPane;
	
    public BasicView() {
    	
    	cardPane = new CardPane<IVisible>();
    	cardPane.setCellFactory(p -> new CardCell<IVisible>() 
		{
			private final CardPaneItem cardPaneItem;
            {
            	cardPaneItem = new CardPaneItem();
            	
            	
            }
            
            @Override
            public void updateItem(IVisible iVisible, boolean empty) 
            {
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
    }

    @Override
    protected void updateAppBar(AppBar appBar) {}
    
}
