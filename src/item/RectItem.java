package item;

import java.awt.Graphics2D;
import java.awt.Point;

public class RectItem extends Item{

	public RectItem(Type type, Point downPoint, Point upPoint) {
		super(type, downPoint, upPoint);
	}

	@Override
	public void drawItem(Graphics2D g2d, Object object) {
		g2d.drawRect(downPoint.x, downPoint.y, upPoint.x - downPoint.x, upPoint.y - downPoint.y);		
	}

	@Override
	public boolean isSelected(Point currentPoint) {
		return false;
	}

}
