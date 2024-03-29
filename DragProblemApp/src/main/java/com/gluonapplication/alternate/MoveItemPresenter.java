package com.gluonapplication.alternate;

import com.gluonapplication.interfaces.IVisible;
import com.gluonhq.charm.glisten.control.CardPane;

import javafx.scene.control.Control;

public class MoveItemPresenter
{
	private static MoveItemPresenter instance = new MoveItemPresenter();
	
	private IVisible itemToMove;
	
	private CardPane<IVisible> cardPane;
	
	private MoveItemPresenter()
	{
	}	
	
	
	public static void addMoveItem(IVisible cardPaneItem)
	{
		//reset the visu from the previous selected item
		if(instance.itemToMove != null)
			instance.itemToMove.setSelectedLongPressed(false);
		
		
		instance.itemToMove = cardPaneItem;
		instance.itemToMove.setSelectedLongPressed(true);
		
		
		
		
	}


	/**
	 * reset of the selection and remove it from the presenter instance
	 */
	public static void removeMoveItem() 
	{
		if(instance.itemToMove != null)
		{
			System.out.println("vor remove Item " + instance.itemToMove.isSelectedLongPressed());
			instance.itemToMove.setSelectedLongPressed(false);
		
		}
	}


	public static void moveUp() 
	{
		//get the current index; the items in the CardPane are ViewObjects!
		int indexOfItem = instance.cardPane.getItems().indexOf(instance.itemToMove);
	
		if(indexOfItem > 0)
		{
			int indexToSwap = indexOfItem - 1;
			IVisible swapIVisible = instance.cardPane.getItems().get(indexToSwap);
		
			instance.cardPane.getItems().set(indexToSwap, instance.itemToMove);
			instance.cardPane.getItems().set(indexOfItem, swapIVisible);
			

			//TODO
			UtilFx.scrollToIndex((Control)instance.cardPane.lookup(".list-view"), indexToSwap);
			
			//instance.cardPane.scrollTo(instance.itemToMove);
			
		}
	}
	
	public static void moveDown()
	{
		int indexOfItem = instance.cardPane.getItems().indexOf(instance.itemToMove);
		if(indexOfItem < instance.cardPane.getItems().size()-1)
		{
			int indexToSwap = indexOfItem + 1;
			IVisible swapIVisible = instance.cardPane.getItems().get(indexToSwap);
			
			instance.cardPane.getItems().set(indexToSwap, instance.itemToMove);
			instance.cardPane.getItems().set(indexOfItem, swapIVisible);
		
			//charm-list-view
			
			//list-view
			
			System.out.println(">> " + instance.cardPane.lookup(".list-view"));
			
			
			//TODO
			UtilFx.scrollToIndex((Control)instance.cardPane.lookup(".list-view"), indexToSwap);
			
			//instance.cardPane.scrollTo(instance.itemToMove);
		}
		
	}


	public static void setCardPane(CardPane<IVisible> cardPane) 
	{
		instance.cardPane = cardPane;
	}
	
	
	
	

}
