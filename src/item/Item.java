package item;
/**
 * 画出的形状的基类
 * @author lirun
 *
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public abstract class Item {
	
	Point downPoint;		// 鼠标按下点
	Point upPoint;			// 鼠标抬起点
	Type type;				// item类型
	
	private Color color = Color.BLACK;		// item颜色 -- 默认黑色
	private float width = 1f;			// item 线宽
	private float rate = 0.1f;	// 放大倍率
	private int magnification = 10;	// 放大的倍数   --  实际放大值 == 放大倍率 * 放大倍数
	
	private String text = null;		// 绘制文本时的文字
	
	public Item(Type type,Point downPoint,Point upPoint) {
		this.type = type;
		this.downPoint = new Point(downPoint);
		this.upPoint = new Point(upPoint);
	}
	
	public Type getType() {
		return type;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	// 设置新的起点
	public void setDownPoint(Point downPoint) {
		this.downPoint = downPoint;
	}

	// 新终点
	public void setUpPoint(Point upPoint) {
		this.upPoint = upPoint;
	}

	// 改变颜色
	public void setColor(Color color) {
		this.color = color;
	}

	// 改变线宽
	public void addWidth() {
		this.width = width + 0.5f;
	}
	
	public void reduceWidth(){
		if(width < 1){	// 最细0.5
			return;
		}
		this.width = width - 0.5f;
	}
	
	// 改变大小
	public void addMagnification() {
		this.magnification = this.magnification + 1;
	}
	
	public void reduceMagnification() {
		if(this.magnification < 2){		// 最小0.1
			return;
		}
		this.magnification = this.magnification - 1;
	}

	//
	protected abstract void drawItem(Graphics2D graphics2d,Object object);
	
	/**
	 *  绘制方法 
	 * @param g2d
	 * @param object 额外的绘制信息，如文字
	 */
	public void draw(Graphics2D g2d){
		drawPre(g2d);
		if(type == Type.TEXT){
			if(text != null || !"".equals(text)){
				drawItem(g2d, text);
			}else{
				System.out.println("输入文字：");
			}
		}else{
			drawItem(g2d, null);
		}
	}
	
	// 绘制之前的设置，如改变画笔颜色，粗细，变大等
	private void drawPre(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(width));
		// 放大
		int dValue_X = (int) (Math.abs(upPoint.x - downPoint.x)*(rate * Math.abs(magnification - 10)));
		System.out.println("x:绝对值："+dValue_X);
		int dValue_Y = (int) (Math.abs(upPoint.y - downPoint.y) * (rate * Math.abs(magnification - 10)));
		System.out.println("y:绝对值："+dValue_Y);
		// 调整起点终点位置
		if(type != Type.LINE){
			if((downPoint.x < upPoint.x && downPoint.y > upPoint.y)
					|| (downPoint.x > upPoint.y && downPoint.y < upPoint.y)){
				// 以down为起点建立数学坐标系，  在一三象限中，将两点的y值互换即可
				int tempY = upPoint.y;
				upPoint.y = downPoint.y;
				downPoint.y = tempY;
			}else if(downPoint.x > upPoint.x && downPoint.y > upPoint.y){
				// 以down为起点建立数学坐标系，  在二象限中，将两点的位置互换
				int tempX = upPoint.x;
				int tempY = upPoint.y;
				upPoint.x = downPoint.x;
				downPoint.x = tempX;
				upPoint.y = downPoint.y;
				downPoint.y = tempY;
			}	
		}
		System.out.println("调整后：dx_" +downPoint.x +" ux_"+ upPoint.x+ " dy_"+ downPoint.y + " uy_ "+upPoint.y );
		// 放大 -- 调整后 up点一定在down点右下角
		downPoint.x = downPoint.x - dValue_X;
		downPoint.y = downPoint.y - dValue_Y;
		upPoint.x = upPoint.x + dValue_X;
		upPoint.y = upPoint.y + dValue_Y;
	}

	/**
	 *  是否操作当前Item
	 * @param currentPoint 当前鼠标操作的点
	 * @return
	 */
	public abstract boolean isSelected(Point currentPoint);
}
