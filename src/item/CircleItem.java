package item;

import java.awt.Graphics2D;
import java.awt.Point;

public class CircleItem extends Item{

	public CircleItem(Type type, Point downPoint, Point upPoint) {
		super(type, downPoint, upPoint);
	}

	@Override
	public void drawItem(Graphics2D g2d, Object object) {
		g2d.drawOval(downPoint.x, downPoint.y, upPoint.x - downPoint.x, upPoint.y - downPoint.y);
	}

	@Override
	public boolean isSelected(Point currentPoint) {
		// TODO Auto-generated method stub
		return false;
	}

}
