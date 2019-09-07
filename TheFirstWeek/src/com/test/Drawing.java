package com.test;
// 绘制静态图形(线段,文本)    尝试获取类名...
import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.*;
public class Drawing {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
           // 创建一个线程
            public void run() {
                // 创建窗口对象
                MyFrame frame = new MyFrame();
                // 显示窗口
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
     * 窗口
     */
    public static class MyFrame extends JFrame {
        /**
		 * MyFrame
		 */
		private static final long serialVersionUID = 1L;
		public static final String title = "Java图形绘制";// 设置标题
        public static final int width = 600;// 设置长宽
        public static final int height = 600;

        public MyFrame() {
            super();
            initFrame();
        }

        private void initFrame() {
            setTitle(title);// 设置标题
            setSize(width, height);// 设置宽度和高度
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// 设置关闭操作
            setLocationRelativeTo(null);// 设置在屏幕中间显示
            MyPanel panel = new MyPanel(this);// 画布
            setContentPane(panel);
        }

    }

    /**
     * 内容面板
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

            // 1. 线段
             drawLine(g);
           
            // 2. 文本
//            drawString(g);
        }

        /**
         * 1. 线段 
         */
        private void drawLine(Graphics g) {
            frame.setTitle("线段,折线,虚线");
            // 创建 Graphics 的副本, 需要改变 Graphics 的参数,
            Graphics2D g2d = (Graphics2D) g.create();
            // 抗锯齿
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // 设置画笔颜色
            g2d.setColor(Color.blue);
            // 1. 两点绘制线段: 点(20, 50), 点(200, 50)
            g2d.drawLine(50, 50, 300, 50);

            // 2. 多点绘制折线: 点(60, 120), 点(120, 130), 点(180, 70), 点(250, 120)
            int[] xPoints = new int[] { 60, 120, 180, 250 };
            int[] yPoints = new int[] { 120, 130, 70, 120 };
            int nPoints = 4;
            g2d.drawPolyline(xPoints, yPoints, nPoints);

            // 3. 两点绘制线段（设置线宽为3px）: 点(50, 150), 点(200, 150)
            BasicStroke bs1 = new BasicStroke(3);       // 笔画的轮廓
            g2d.setStroke(bs1);
            g2d.drawLine(50, 150, 300, 150);

            // 4. 绘制虚线: 将虚线分为若干段（ 实线段 和 空白段 都认为是一段）, 实线段 和 空白段 交替绘制,
            //             绘制的每一段（包括 实线段 和 空白段）的 长度 从 dash 虚线模式数组中取值（从首
            //             元素开始循环取值）
            float[] dash = new float[] { 6, 12 };
            BasicStroke bs2 = new BasicStroke(
                    2,                      // 画笔宽度/线宽
                    BasicStroke.CAP_SQUARE,
                    BasicStroke.JOIN_MITER,
                    10.0f,
                    dash,                   // 虚线模式数组
                    0.0f
            );
            g2d.setStroke(bs2);
            g2d.drawLine(50, 300, 300, 300);
            g2d.dispose();// dispose方法是关闭窗体，并释放一部分资源
        }

        
        /**
         * 2. 文本
         */
        private void drawString(Graphics g) {
            frame.setTitle("文本");
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // 设置字体样式, null 表示使用默认字体, Font.PLAIN 为普通样式, 大小为 25px
            g2d.setFont(new Font(null, Font.PLAIN, 25));
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            g2d.drawString(s, 20, 60);
            g2d.dispose();
        }

    }

}