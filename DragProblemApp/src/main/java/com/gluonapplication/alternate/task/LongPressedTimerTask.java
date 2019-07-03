package com.gluonapplication.alternate.task;

import java.util.TimerTask;

import com.gluonapplication.alternate.MoveItemPresenter;
import com.gluonapplication.alternate.item.CardPaneItem;

import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.scene.input.MouseEvent;

/**
 * long pressed detection
 * @author m.goerlich
 *
 */
public class LongPressedTimerTask extends TimerTask
{
	
	private CardPaneItem cardPaneItem;
	
	public LongPressedTimerTask(CardPaneItem cardPaneItem)
	{
		this.cardPaneItem = cardPaneItem;
	}
	
	
	

	@Override
	public void run() 
	{
		Platform.runLater(() ->
		{
			MoveItemPresenter.addMoveItem(cardPaneItem);
			
		});
			
	
		
		
		
	}

}
