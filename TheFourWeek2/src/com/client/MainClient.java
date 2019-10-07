package com.client;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.web.Command;
import com.web.Login;
import com.web.Logout;
import com.web.Message;
import com.web.Register;
import com.web.Result;

public class MainClient {
	private static Command c;
	private static Result rs;

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("127.0.0.1", 8888);
		OutputStream os = socket.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(os);

		InputStream reader = socket.getInputStream();

		ObjectInputStream ois = new ObjectInputStream(reader);
		Scanner input = new Scanner(System.in);
		boolean f = true;
		String name = null;
		String toName = null;
		int temp = 0;// ���ڶ�λ�Ƿ����Ѿ���������
		int i = 0;
		int logout = 0; // �ж��Ƿ��˳�

		System.out.println("��ѡ��:1.ע��  2.��½  3.����Ϣ  4.�˳�:");

		while (f) {

			i = input.nextInt();
			if (i == 1) { // ע��
				System.out.print("����:");
				name = input.next();
				Register register = new Register();
				register.setName(name);
				register.setSendDate(new Date());
				Result result = new Result(register, "1");
				oos.writeObject(result);
				rs = (Result) ois.readObject();
				System.out.println("��������Ӧ: command=" + rs.getCommand() + "state=" + rs.getState());
			} else if (i == 2) {// ��¼
				System.out.print("����:");
				// String name="xu";
				name = input.next();
				Login login = new Login();
				login.setName(name);
				// c.setSendDate(new Date());
				Result result = new Result(login, "2");
				oos.writeObject(result);
				rs = (Result) ois.readObject();
				System.out.println("��������Ӧ: command=" + rs.getCommand() + "state=" + rs.getState());
			} else if (i == 3) {// ������...
				System.out.print("���ܷ�����:");
				toName = input.next();
				System.out.print("��(" + name + ")˵:");
				// name=input.next();

				String message = input.next();
				;
				Message message2 = new Message();
				message2.setFrom(name);
				message2.setTo(toName);
				message2.setMessage(message);

				temp = 1;

				if (message.equals("logout")) {// �������logou�ʹ����˳����������
					logout = 1;
				} else {
					// c.setSendDate(new Date());
					Result result = new Result(message2, "3");
					oos.writeObject(result);
					// ������Ϣ
					Message m = (Message) ois.readObject();
					String str = "�Ҷ�" + toName + "˵��" + m.getMessage();
					System.out.println(str);
					FileInformation(str, "��");
				}
			}
			if (i == 4 || logout == 1) {// �˳�
				Logout logout2 = new Logout();
				logout2.setName(name);
				// c.setSendDate(new Date());
				Result result = new Result(logout2, "4");
				oos.writeObject(result);
				rs = (Result) ois.readObject();
				System.out.println("��������Ӧ : command=" + rs.getCommand() + "state=" + rs.getState());
				f = false;
			}
		}
		
		ois.close();
		oos.close();
		socket.close();

	}

	public static void FileInformation(String texts, String name) {// ��ʾ�յ����ı�
		JFrame showInfo = new JFrame();
		JPanel jp = new JPanel();
		JTextArea text = new JTextArea(20, 20);// �ı���
		text.append(texts + "\n");// ����
		jp.add(text);
		showInfo.add(jp);

		showInfo.setTitle(name + "�ش�");
		showInfo.setVisible(true);
		showInfo.setSize(300, 200);
		showInfo.setLocation(500, 500);
		showInfo.setDefaultCloseOperation(1);
	}

	public static Command getC() {
		return c;
	}

	public static void setC(Command c) {
		MainClient.c = c;
	}
}
