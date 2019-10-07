package server;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.web.Login;
import com.web.Logout;
import com.web.Message;
import com.web.Register;
import com.web.Result;

public class SocketHandler implements Runnable {
	private Socket socket;
	private Result rs;
	private String name;
	ObjectOutputStream oos;
	Scanner input = new Scanner(System.in);

	public SocketHandler(Socket socket) {
		this.socket = socket;
	}

	@SuppressWarnings("unused")
	public void run() {
		try {
			InputStream reader = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(reader);

			OutputStream os = socket.getOutputStream();
			oos = new ObjectOutputStream(os);
			String client = "<" + socket.getInetAddress().toString() + " : " + socket.getPort() + ">";
			boolean f = true;
			while (f) {
				rs = (Result) ois.readObject();

				if (rs.getState().equals("1"))// 注册
				{
					name = ((Register) (rs.getCommand())).getName();
					Server.users.put(name, oos);// 存储写入图中

					if (name.equals("")) {
						Register register = new Register();
						rs.setCommand(register);
						rs.setState("fail");
						oos.writeObject(rs);
					} else {
						Register register = new Register();
						rs.setCommand(register);
						rs.setState("ok");
						oos.writeObject(rs);
					}
				} else if (rs.getState().equals("2"))// 登录
				{
					name = ((Login) (rs.getCommand())).getName();
					Server.users.put(name, oos);// 写入
					if (name.equals("")) {
						Login login = new Login();
						rs.setCommand(login);
						rs.setState("fail");
						oos.writeObject(rs);
					} else {
						Login login = new Login();
						rs.setCommand(login);
						rs.setState("ok");
						oos.writeObject(rs);
					}
				} else if (rs.getState().equals("3")) // 用于转发 信息message from="xu" to="zhang" message="ddd" />
				{
					String toName = ((Message) (rs.getCommand())).getTo();// 得到收件人的名字
					String message = ((Message) (rs.getCommand())).getMessage();// 获取信息

					Message message2 = new Message();
					message2.setTo(toName);
					message2.setMessage(message);
					oos.writeObject(message2);
					oos = Server.users.get(toName);

					if (oos != null) {
						oos.writeObject(message2);// 向客户端写入
						oos.flush();
					} else {
						oos.writeBytes("error");
					}
				} else if (rs.getState().equals("4"))//
				{
					name = ((Logout) (rs.getCommand())).getName();
					Server.users.remove(name);// 删除用户
					rs.setState("logout");
					oos.writeObject(rs);
					break;
				} else {
					oos.writeBytes("error");
				}
				oos.flush();
			}
			oos.close();
			ois.close();
			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void FileInformation(String texts) {// 显示文本
		JFrame showInfo = new JFrame();
		JPanel jp = new JPanel();
		JTextArea text = new JTextArea(30, 30);
		text.append(texts + "\n");// 输入
		jp.add(text);
		showInfo.add(jp);

		showInfo.setTitle("服务端相应响应 !!！");
		showInfo.setVisible(true);
		showInfo.setSize(500, 500);
		showInfo.setLocation(500, 500);
		showInfo.setDefaultCloseOperation(1);
	}
}
