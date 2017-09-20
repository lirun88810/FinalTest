package item;

import java.awt.Graphics2D;
import java.awt.Point;

public class LineItem extends Item{

	public LineItem(Type type, Point downPoint, Point upPoint) {
		super(type, downPoint, upPoint);
	}

	@Override
	public void drawItem(Graphics2D g2d, Object object) {
		g2d.drawLine(downPoint.x, downPoint.y, upPoint.x, upPoint.y);
	}

	@Override
	public boolean isSelected(Point currentPoint) {
		return false;
	}

}
