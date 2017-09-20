package button;

import java.awt.Graphics2D;
import java.awt.Point;

import item.Item;
import item.TextItem;
import item.Type;

@SuppressWarnings("serial")
public class TextButton extends MyButton {
	
	private String text;
	
	public void setText(String text) {
		this.text = text;
	}

	public TextButton() {
	}
	
	public TextButton(String string) {
		super(string);
	}


	@Override
	public Item drawItem(Graphics2D g2d, Point downPoint, Point upPoint) {
		// 提示输入
		
		
		TextItem item = new TextItem(Type.TEXT, downPoint, upPoint);
		item.setText(text);
//		item.draw(g2d);
		return item;
	}


	@Override
	public void delete() {

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
