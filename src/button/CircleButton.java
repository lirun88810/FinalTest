package button;

import java.awt.Graphics2D;
import java.awt.Point;

import item.CircleItem;
import item.Item;
import item.Type;

@SuppressWarnings("serial")
public class CircleButton extends MyButton {

	public CircleButton() {
	}
	
	public CircleButton(String text){
		super(text);
	}

	@Override
	public void delete() {

	}

	@Override
	public Item drawItem(Graphics2D g2d, Point downPoint, Point upPoint) {
		CircleItem item = new CircleItem(Type.CIRCLE,downPoint,upPoint);
//		item.draw(g2d);
		return item;
	}

	@Override
	public boolean isItem() {
		return false;
	}

	@Override
	public void changeLength(Graphics2D g2d) {
		
	}

	@Override
	public void drag(Graphics2D g2d) {
		
	}

	@Override
	public void changeWidth(Graphics2D g2d) {
		
	}

	@Override
	public void changeColor(Graphics2D g2d) {
		
	}

}
