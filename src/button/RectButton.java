package button;

import java.awt.Graphics2D;
import java.awt.Point;

import item.Item;
import item.RectItem;
import item.Type;

@SuppressWarnings("serial")
public class RectButton extends MyButton {

	public RectButton() {
	}

	public RectButton(String string) {
		super(string);
	}

	@Override
	public void delete() {

	}

	@Override
	public Item drawItem(Graphics2D g2d, Point downPoint, Point upPoint) {
		RectItem item = new RectItem(Type.RECT, downPoint, upPoint);
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
