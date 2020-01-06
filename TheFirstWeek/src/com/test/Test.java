package com.test;
// ��̬�������ּ���ͼ��
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
		this.setFont(new Font("����", Font.PLAIN, 20));
		this.setTitle("java��ͼ����");
		setLocationRelativeTo(null);// �Ѵ���λ�����õ���Ļ����
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setResizable(true);// ���ܸı䴰���С
		this.setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		this.getContentPane().setBackground(Color.white);

		Button yellowButton, greenButton, redButton, orangeButton, 
			   eraserButton, cancleButton, deleteAllButton, circleButton, 
			   rectangleButton,roundedRectangleButton, arcButton, 
			   rectangle3DButton, textButton;
		yellowButton = new Button("��ɫ");
		yellowButton.setBounds(0, 0, 140, 40);
		yellowButton.setBackground(Color.yellow);
		yellowButton.addActionListener(this);
		this.add(yellowButton);

		greenButton = new Button("��ɫ");
		greenButton.setBounds(160, 0, 140, 40);
		greenButton.setBackground(Color.green);
		greenButton.addActionListener(this);
		this.add(greenButton);

		redButton = new Button("��ɫ");
		redButton.setBounds(320, 0, 140, 40);
		redButton.setBackground(Color.red);
		redButton.addActionListener(this);
		this.add(redButton);

		orangeButton = new Button("��ɫ");
		orangeButton.setBackground(Color.orange);
		orangeButton.setBounds(480, 0, 140, 40);
		orangeButton.addActionListener(this);
		this.add(orangeButton);

		eraserButton = new Button("��Ƥ��");
		eraserButton.setBounds(640, 0, 140, 40);
		eraserButton.addActionListener(this);
		this.add(eraserButton);

		cancleButton = new Button("����");
		cancleButton.setBounds(800, 0, 140, 40);
		cancleButton.addActionListener(this);
		this.add(cancleButton);

		deleteAllButton = new Button("ȫ��ɾ��");
		deleteAllButton.setBounds(960, 0, 140, 40);
		deleteAllButton.addActionListener(this);
		this.add(deleteAllButton);

		circleButton = new Button("Բ��");
		circleButton.setBounds(1120, 0, 140, 40);
		circleButton.addActionListener(this);
		this.add(circleButton);

		rectangleButton = new Button("����");
		rectangleButton.setBounds(1280, 0, 140, 40);
		rectangleButton.addActionListener(this);
		this.add(rectangleButton);
		
		roundedRectangleButton = new Button("Բ�Ǿ���");
		roundedRectangleButton.setBounds(1440, 0, 140, 40);
		roundedRectangleButton.addActionListener(this);
		this.add(roundedRectangleButton);
		
		arcButton = new Button("Բ��");
		arcButton.setBounds(1600, 0, 140, 40);
		arcButton.addActionListener(this);
		this.add(arcButton);
		
		rectangle3DButton = new Button("3D����");
		rectangle3DButton.setBounds(1760, 0, 140, 40);
		rectangle3DButton.addActionListener(this);
		this.add(rectangle3DButton);
		
		textButton = new Button("3D����");
		textButton.setBounds(1760, 0, 140, 40);
		textButton.addActionListener(this);
		this.add(textButton);


	}

	
	public static void main(String[] args) {
		Test test = new Test();
		test.clear(test.getGraphics());
	}

	
	public void paint(Graphics g) {
		// super.paint(g); // �������Ŵ��� 
		g.setColor(Color.white);// ���û����ʼ��ɫΪ��ɫ
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
	 * ����
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	
	/**
	 * ����
	 */
	@Override
	public void mousePressed(MouseEvent e) {

		x = e.getX();
		y = e.getY();

	}
	

	/**
	 * �ɿ�
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
	 * �������¼�
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	
	/**
	 * ����Ƴ��¼�
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand().hashCode()) {
		case 1038352:
			// ��ɫ
			c = Color.red;
			break;
		case 1041235:
			// ��ɫ
			c = Color.green;
			break;
		case 1293358:
			// ��ɫ
			c = Color.yellow;
			break;
		case 877369:
			// ��ɫ
			c = Color.orange;
			break;
		case 27138585:
			// ��Ƥ��
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
			// ȫ��ɾ��
			clear(getGraphics());
			break;
		case 715036:
			// Բ��
			flag = 1;
			break;
		case 976025:
			// ����
			flag = 2;
			break;
		case 698565925:
			// Բ�Ǿ���
			flag = 3;
			break;
		case 714977:
			// Բ��
			flag = 4;
			break;
		case 2560714:
			// 3D����
			flag = 5;
			break;
		default:
			System.out.println(e.getActionCommand().hashCode());
			break;
		}
	}
}