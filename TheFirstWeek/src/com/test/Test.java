package com.test;
// 动态画出各种几何图形
import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Test extends JFrame implements MouseListener, ActionListener {

	private static int x = 0;
	private static int y = 0;
	private static int w = 0;
	private static int h = 0;

	private static Color c;

	private int flag = 5;

	private static final long serialVersionUID = 1L;

	public Test() {
		this.setSize(1920, 1080);
		this.setVisible(true);
		this.setLayout(null);
		this.setFont(new Font("宋体", Font.PLAIN, 20));
		this.setTitle("java绘图程序");
		setLocationRelativeTo(null);// 把窗口位置设置到屏幕中心
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setResizable(true);// 不能改变窗体大小
		this.setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		this.getContentPane().setBackground(Color.white);

		Button yellowButton, greenButton, redButton, orangeButton, 
			   eraserButton, cancleButton, deleteAllButton, circleButton, 
			   rectangleButton,roundedRectangleButton, arcButton, 
			   rectangle3DButton, textButton;
		yellowButton = new Button("黄色");
		yellowButton.setBounds(0, 0, 140, 40);
		yellowButton.setBackground(Color.yellow);
		yellowButton.addActionListener(this);
		this.add(yellowButton);

		greenButton = new Button("绿色");
		greenButton.setBounds(160, 0, 140, 40);
		greenButton.setBackground(Color.green);
		greenButton.addActionListener(this);
		this.add(greenButton);

		redButton = new Button("红色");
		redButton.setBounds(320, 0, 140, 40);
		redButton.setBackground(Color.red);
		redButton.addActionListener(this);
		this.add(redButton);

		orangeButton = new Button("橙色");
		orangeButton.setBackground(Color.orange);
		orangeButton.setBounds(480, 0, 140, 40);
		orangeButton.addActionListener(this);
		this.add(orangeButton);

		eraserButton = new Button("橡皮擦");
		eraserButton.setBounds(640, 0, 140, 40);
		eraserButton.addActionListener(this);
		this.add(eraserButton);

		cancleButton = new Button("撤销");
		cancleButton.setBounds(800, 0, 140, 40);
		cancleButton.addActionListener(this);
		this.add(cancleButton);

		deleteAllButton = new Button("全部删除");
		deleteAllButton.setBounds(960, 0, 140, 40);
		deleteAllButton.addActionListener(this);
		this.add(deleteAllButton);

		circleButton = new Button("圆形");
		circleButton.setBounds(1120, 0, 140, 40);
		circleButton.addActionListener(this);
		this.add(circleButton);

		rectangleButton = new Button("矩形");
		rectangleButton.setBounds(1280, 0, 140, 40);
		rectangleButton.addActionListener(this);
		this.add(rectangleButton);
		
		roundedRectangleButton = new Button("圆角矩形");
		roundedRectangleButton.setBounds(1440, 0, 140, 40);
		roundedRectangleButton.addActionListener(this);
		this.add(roundedRectangleButton);
		
		arcButton = new Button("圆弧");
		arcButton.setBounds(1600, 0, 140, 40);
		arcButton.addActionListener(this);
		this.add(arcButton);
		
		rectangle3DButton = new Button("3D矩形");
		rectangle3DButton.setBounds(1760, 0, 140, 40);
		rectangle3DButton.addActionListener(this);
		this.add(rectangle3DButton);
		
		textButton = new Button("3D矩形");
		textButton.setBounds(1760, 0, 140, 40);
		textButton.addActionListener(this);
		this.add(textButton);


	}

	
	public static void main(String[] args) {
		Test test = new Test();
		test.clear(test.getGraphics());
	}

	
	public void paint(Graphics g) {
		// super.paint(g); // 可以缩放窗口 
		g.setColor(Color.white);// 设置画板初始颜色为白色
		if (c == null)
			c = g.getColor();
		g.setColor(c);
		if (flag == 1) {
			g.fillOval(x, y, w, h);
		} else if(flag == 2) {
			g.fillRect(x, y, w, h);
		}else if(flag == 3){
			g.fillRoundRect(x, y, w, h, 30, 30);
		}else if(flag == 4){
			g.fillArc(x, y, w, h, 20, 20);
		}else if(flag == 5){
			g.fill3DRect(x, y, w, h, true);
		}else {
			
		}		
	}

	
	public void clear(Graphics g) {
		g.setColor(Color.white);
		g.clearRect(0, 0, 1920, 1080);
	}

	
	/**
	 * 单击
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	
	/**
	 * 按下
	 */
	@Override
	public void mousePressed(MouseEvent e) {

		x = e.getX();
		y = e.getY();

	}
	

	/**
	 * 松开
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (x > Test.x) {
			w = x - Test.x;
		} else {
			w = Test.x - x;
		}
		if (y > Test.y) {
			h = y - Test.y;
		} else {
			h = Test.y - y;
		}
		paint(getGraphics());
	}
	

	/**
	 * 鼠标进入事件
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	
	/**
	 * 鼠标移除事件
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand().hashCode()) {
		case 1038352:
			// 红色
			c = Color.red;
			break;
		case 1041235:
			// 绿色
			c = Color.green;
			break;
		case 1293358:
			// 黄色
			c = Color.yellow;
			break;
		case 877369:
			// 橙色
			c = Color.orange;
			break;
		case 27138585:
			// 橡皮擦
			c = Color.white;
			break;
		case 836828:
			Graphics graphics = getGraphics();
			graphics.setColor(Color.white);

			if (flag == 1) {
				graphics.fillOval(x, y, w, h);
			} else if(flag == 2){
				graphics.fillRect(x, y, w, h);
			}else if(flag == 3){
				graphics.fillRoundRect(x, y, w, h,20,20);
			}else if(flag == 4){
				graphics.fillArc(x, y, w, h,20,20);
			}else {
				graphics.fill3DRect(x, y, w, h, true);
			}
			break;
		case 657183940:
			// 全部删除
			clear(getGraphics());
			break;
		case 715036:
			// 圆形
			flag = 1;
			break;
		case 976025:
			// 矩形
			flag = 2;
			break;
		case 698565925:
			// 圆角矩形
			flag = 3;
			break;
		case 714977:
			// 圆弧
			flag = 4;
			break;
		case 2560714:
			// 3D矩形
			flag = 5;
			break;
		default:
			System.out.println(e.getActionCommand().hashCode());
			break;
		}
	}
}