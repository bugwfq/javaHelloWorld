package net.netCommunication.test.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		input.useDelimiter("\n");
		// ����һ�����׽��ֲ��������ӵ�ָ�������ϵ�ָ���˿ںš�
		Socket s = new Socket("localhost",8888);
		
		//�������������ӵ����������
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//�½��߳�    ���߳���ҪΪ�ͻ�������
		OutThread ot = new OutThread(bw);
		//�����߳�����Ϊ�ػ��߳�
		ot.setDaemon(true);
		//����
		ot.start();
		
		String message;
		while(true){
			
			
			//д���ٶ�
			message = br.readLine();
			if(message == null || message.trim().equals("over")){
				break;
			}
			System.out.println("�յ��������Ϣ��"+message);
			

		}
		br.close();
		br.close();
		s.close();
	}
}