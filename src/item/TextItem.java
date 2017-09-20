package item;

import java.awt.Graphics2D;
import java.awt.Point;

public class TextItem extends Item {

	public TextItem(Type type, Point downPoint, Point upPoint) {
		super(type, downPoint, upPoint);
	}

	@Override
	public void drawItem(Graphics2D g2d, Object object) {
		g2d.drawString(object.toString(), downPoint.x, downPoint.y);
	}

	@Override
	public boolean isSelected(Point currentPoint) {
		return false;
	}

}
