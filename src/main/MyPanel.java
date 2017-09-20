package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import item.Item;
/**
 * 
 * @author lirun
 *
 */
@SuppressWarnings("serial")
public class MyPanel extends JPanel {

	private MyInterface mIntf;				// 通过按键功能
	
	private Point downPoint;
	private Point upPoint;
	
	private List<Item> itemList;			// item集合，用于管理绘制的图形
	private Item currentItem;				// 当前选中的item
	
	private boolean isCtrlPressed;			// 是否按下了Ctrl键
	
	
	public MyPanel() {
		super();
		itemList = new ArrayList<>();
		setEvent();
	}

	// 点击按键，设置调用的方法
	public void setInterface(MyInterface myBtn) {
		this.mIntf = myBtn;
	}

	@Override
	protected void paintComponent(Graphics g) {
		if(mIntf == null) {
			return;
		}
		Graphics2D g2d = (Graphics2D) g;
		//  并添加到集合中进行管理  -- 
		itemList.add(mIntf.drawItem(g2d, downPoint, upPoint));
		// 绘制全部
		loadItem(g2d);
	}
	
	// 设置鼠标、键盘事件
	private void setEvent() {
		// 鼠标点击
		addMouseListener(new MouseListener() {
			// 释放
			@Override
			public void mouseReleased(MouseEvent e) {
				upPoint = e.getPoint();
				System.out.println("mouseReleased"+upPoint.x+" Y_"+upPoint.y);
				repaint();
//				downPoint = null;
//				upPoint = null;
			}
			// 按下
			@Override
			public void mousePressed(MouseEvent e) {
				downPoint = e.getPoint();
				System.out.println("mousePressed：X_"+downPoint.x+" Y_"+downPoint.y);
			}
			// 移除
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("mouseExited");
			}
			// 进入
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("mouseEntered");
			}
			// 点击
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseClicked");
			}
		});
		
		// 鼠标拖动
		addMouseMotionListener(new MouseMotionListener() {
			
			//  鼠标移动时触发
			@Override
			public void mouseMoved(MouseEvent e) {
			}
			
			// 鼠标拖动时触发
			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println("鼠标拖动");
			}
		});
	
		// 键盘事件
		addKeyListener(new KeyListener() {
			// 键入事件  -- 相当于Click
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println(e.getKeyCode());
				if(!isCtrlPressed){
					return;
				}
				switch (e.getKeyCode()) {
					case KeyEvent.VK_PLUS:		// 加号 （放大）
						currentItem.addMagnification();
					break;	
					case KeyEvent.VK_MINUS:					// 减号 （缩小）
						currentItem.reduceMagnification();
					break;
					case KeyEvent.VK_COMMA:					// 逗号（小于号）  加粗
						 currentItem.addWidth();
					break;
					case KeyEvent.VK_PERIOD: 					// 句号（大于号） 变细
						currentItem.reduceWidth();
					break;
				
				default:
					break;
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_CONTROL){
					isCtrlPressed = false;
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_CONTROL){
					isCtrlPressed = true;
				}
			}
		});
	
	}
	
	private void loadItem(Graphics2D g2d){
		removeAll();
		for(Item item : itemList){
			item.draw(g2d);
		}
	}
	
	public void deleteItem() {
		synchronized (itemList) {
			itemList.remove(currentItem);
		}
		repaint();
	}
	
	public void changeColor(Color color) {
		currentItem.setColor(color);
		repaint();
	}
}
