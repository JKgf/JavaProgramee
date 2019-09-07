package com.test;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Polygon;
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
		this.setTitle("java��ͼ����");
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setResizable(true);// ���ܸı䴰���С
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		this.getContentPane().setBackground(Color.WHITE);

		Button button1, button2, button3, button4, 
			   button5, button6, button7, button8, 
			   button9,button10, button11, button12;
		button1 = new Button("��ɫ");
		button1.setBounds(0, 0, 80, 30);
		button1.setBackground(Color.RED);
		button1.addActionListener(this);
		this.add(button1);

		button2 = new Button("��ɫ");
		button2.setBounds(90, 0, 80, 30);
		button2.setBackground(Color.black);
		button2.addActionListener(this);
		this.add(button2);

		button3 = new Button("��ɫ");
		button3.setBounds(180, 0, 80, 30);
		button3.setBackground(Color.YELLOW);
		button3.addActionListener(this);
		this.add(button3);

		button4 = new Button("��ɫ");
		button4.setBackground(Color.BLUE);
		button4.setBounds(270, 0, 80, 30);
		button4.addActionListener(this);
		this.add(button4);

		button5 = new Button("��Ƥ��");
		button5.setBounds(360, 0, 80, 30);
		button5.addActionListener(this);
		this.add(button5);

		button6 = new Button("����");
		button6.setBounds(450, 0, 80, 30);
		button6.addActionListener(this);
		this.add(button6);

		button7 = new Button("ȫ��ɾ��");
		button7.setBounds(540, 0, 80, 30);
		button7.addActionListener(this);
		this.add(button7);

		button8 = new Button("Բ��");
		button8.setBounds(630, 0, 80, 30);
		button8.addActionListener(this);
		this.add(button8);

		button9 = new Button("����");
		button9.setBounds(720, 0, 80, 30);
		button9.addActionListener(this);
		this.add(button9);
		
		button10 = new Button("Բ�Ǿ���");
		button10.setBounds(810, 0, 80, 30);
		button10.addActionListener(this);
		this.add(button10);
		
		button11 = new Button("Բ��");
		button11.setBounds(900, 0, 80, 30);
		button11.addActionListener(this);
		this.add(button11);
		
		button12 = new Button("3D����");
		button12.setBounds(990, 0, 80, 30);
		button12.addActionListener(this);
		this.add(button12);

	}

	
	public static void main(String[] args) {
		Test test = new Test();
		test.clear(test.getGraphics());
	}

	
	public void paint(Graphics g) {
		if (c == null)
			c = g.getColor();
		g.setColor(c);
		if (flag == 1) {
			g.fillOval(x, y, w, h);
			
		} else if(flag == 2) {
			g.fillRect(x, y, w, h);
		}
		else if(flag == 3){
			g.fillRoundRect(x, y, w, h, 20, 20);
		}else if(flag == 4){
			g.fillArc(x, y, w, h, 20, 20);
		}else {
			g.fill3DRect(x, y, w, h, true);
			
		}
		

	}

	public void clear(Graphics g) {
		g.setColor(Color.WHITE);
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
			c = Color.RED;
			break;
		case 1293761:
			// ��ɫ
			c = Color.BLACK;
			break;
		case 1293358:
			// ��ɫ
			c = Color.YELLOW;
			break;
		case 1087797:
			// ��ɫ
			c = Color.BLUE;
			break;
		case 27138585:
			// ��Ƥ��
			c = Color.WHITE;
			break;
		case 836828:
			Graphics graphics = getGraphics();
			graphics.setColor(Color.WHITE);

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
		case 23085411:
			// Բ��
			flag = 4;
			break;
		case 2308541:
			// 3D����
			flag = 5;
			break;
		default:
			System.out.println(e.getActionCommand().hashCode());
			break;
		}
	}

}