package com.test;
// ���ƾ�̬ͼ��(�߶�,�ı�)    ���Ի�ȡ����...
import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.*;
public class Drawing {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
           // ����һ���߳�
            public void run() {
                // �������ڶ���
                MyFrame frame = new MyFrame();
                // ��ʾ����
                frame.setVisible(true);
            }
        });
        
		/*
		 * Class<Drawing> clazz = Drawing.class;
		 * System.out.println(clazz.getCanonicalName());
		 * System.out.println(clazz.getClass()); System.out.println(clazz.getName());
		 * System.out.println(clazz.getTypeName());
		 * System.out.println(clazz.getAnnotatedInterfaces());
		 * System.out.println(clazz.getTypeParameters());
		 */
        
       /*
        * Class<Drawing> clazz = Drawing.class;
          try {
			Constructor<Drawing> constructor = clazz.getConstructor();
			System.out.println(constructor.toString());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         */
    }
   

    /**
     * ����
     */
    public static class MyFrame extends JFrame {
        /**
		 * MyFrame
		 */
		private static final long serialVersionUID = 1L;
		public static final String title = "Javaͼ�λ���";// ���ñ���
        public static final int width = 600;// ���ó���
        public static final int height = 600;

        public MyFrame() {
            super();
            initFrame();
        }

        private void initFrame() {
            setTitle(title);// ���ñ���
            setSize(width, height);// ���ÿ�Ⱥ͸߶�
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// ���ùرղ���
            setLocationRelativeTo(null);// ��������Ļ�м���ʾ
            MyPanel panel = new MyPanel(this);// ����
            setContentPane(panel);
        }

    }

    /**
     * �������
     */
    public static class MyPanel extends JPanel {

        /**
		 * MyPanel
		 */
		private static final long serialVersionUID = 1L;
		private MyFrame frame;

        public MyPanel(MyFrame frame) {
            super();
            this.frame = frame;
        }

        
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 1. �߶�
             drawLine(g);
           
            // 2. �ı�
//            drawString(g);
        }

        /**
         * 1. �߶� 
         */
        private void drawLine(Graphics g) {
            frame.setTitle("�߶�,����,����");
            // ���� Graphics �ĸ���, ��Ҫ�ı� Graphics �Ĳ���,
            Graphics2D g2d = (Graphics2D) g.create();
            // �����
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // ���û�����ɫ
            g2d.setColor(Color.blue);
            // 1. ��������߶�: ��(20, 50), ��(200, 50)
            g2d.drawLine(50, 50, 300, 50);

            // 2. ����������: ��(60, 120), ��(120, 130), ��(180, 70), ��(250, 120)
            int[] xPoints = new int[] { 60, 120, 180, 250 };
            int[] yPoints = new int[] { 120, 130, 70, 120 };
            int nPoints = 4;
            g2d.drawPolyline(xPoints, yPoints, nPoints);

            // 3. ��������߶Σ������߿�Ϊ3px��: ��(50, 150), ��(200, 150)
            BasicStroke bs1 = new BasicStroke(3);       // �ʻ�������
            g2d.setStroke(bs1);
            g2d.drawLine(50, 150, 300, 150);

            // 4. ��������: �����߷�Ϊ���ɶΣ� ʵ�߶� �� �հ׶� ����Ϊ��һ�Σ�, ʵ�߶� �� �հ׶� �������,
            //             ���Ƶ�ÿһ�Σ����� ʵ�߶� �� �հ׶Σ��� ���� �� dash ����ģʽ������ȡֵ������
            //             Ԫ�ؿ�ʼѭ��ȡֵ��
            float[] dash = new float[] { 6, 12 };
            BasicStroke bs2 = new BasicStroke(
                    2,                      // ���ʿ��/�߿�
                    BasicStroke.CAP_SQUARE,
                    BasicStroke.JOIN_MITER,
                    10.0f,
                    dash,                   // ����ģʽ����
                    0.0f
            );
            g2d.setStroke(bs2);
            g2d.drawLine(50, 300, 300, 300);
            g2d.dispose();// dispose�����ǹرմ��壬���ͷ�һ������Դ
        }

        
        /**
         * 2. �ı�
         */
        private void drawString(Graphics g) {
            frame.setTitle("�ı�");
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // ����������ʽ, null ��ʾʹ��Ĭ������, Font.PLAIN Ϊ��ͨ��ʽ, ��СΪ 25px
            g2d.setFont(new Font(null, Font.PLAIN, 25));
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            g2d.drawString(s, 20, 60);
            g2d.dispose();
        }

    }

}