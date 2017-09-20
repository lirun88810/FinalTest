package main;

import java.awt.Graphics2D;
import java.awt.Point;

import item.Item;

/**
 * 操作的接口
 * @author lirun
 *
 */
public interface MyInterface {
	
	// 绘制 -- 内部创建Item对象，调用其对应draw的方法，并返回对象的实例
	Item drawItem(Graphics2D g2d, Point downPoint, Point upPoint);
	// 改变长度
	void changeLength(Graphics2D g2d);
	// 拖动
	void drag(Graphics2D g2d);
	// 改变宽度
	void changeWidth(Graphics2D g2d);
	// 改变颜色
	void changeColor(Graphics2D g2d);
	// 删除
	void delete();
	
	// 鼠标是否悬浮在某个区域
	boolean isItem();
}
