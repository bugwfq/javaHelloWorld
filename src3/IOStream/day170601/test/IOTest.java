package IOStream.day170601.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class IOTest {
	//@Test
	public void test1(){
		//�ֽ���
		//�ļ�����
		File file = new File("src3/day170601/test/IOTest.java");
		FileInputStream fs = null;
		try {
			//��ļ������֮��Ĺܵ�
			fs = new FileInputStream(file);
			int mark = 0;
			try {
				while((mark=fs.read()) != -1){
					System.out.print((char)mark);
				}
			} catch (IOException e) {
				System.out.println("IO��д�쳣");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("�ļ��Ҳ����쳣");
		}finally{
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//@Test
	public void test2(){
		//�ַ���
		//�ļ�����
		File file = new File("src3/day170601/test/IOTest.java");
		FileReader fr = null;
		try {
			//��ļ������Ĺܵ�
			fr = new FileReader(file);
			int mark = 0;
			try {
				while((mark=fr.read())!=-1){
					System.out.print((char)mark);
				}
			} catch (IOException e) {
				System.out.println("IO��д�쳣");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�·���쳣");
		}finally{
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//@Test
	public void test3(){
		//�ļ�����
		File file = new File("src3/day170601/test/IOTest.java");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			char[] cs = new char[8192];
			try {
				fr.read(cs,10,23);//һ���Խ��ļ�����cs����:10������ʼ�����λ�ã�23����������ֽ���
//				int mark = 0;
				/*while((mark = fr.read())!=-1){
					System.out.print((char)mark);
				}*/
				
				for (char c : cs) {
					System.out.print(c);
				}
			} catch (IOException e) {
				System.out.println("IO��д�쳣");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�·���쳣");
		}finally{
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//@Test
	public void test4(){
		//�ļ�����
		File file = new File("src3/day170601/test/a.txt");
		
		//��ļ���������ӵĹܵ�
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(file);
			try {
				while(fs.available()>0){
					System.out.print((char)fs.read());
				}
			} catch (IOException e) {
				System.out.println("IO��д�쳣");
			}
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�·���쳣");
		}finally{
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//@Test
	public void test5() throws Exception{
		//�����
		//���ļ����ݶ������
		File rFile = new File("src3/day170601/test/IOTest.java");
		FileInputStream fs = null;
		fs = new FileInputStream(rFile);
		byte[] bs = new byte[(int)rFile.length()];
		fs.read(bs);
		fs.close();
		//�����������д���ļ���
		
		File wFile = new File("src3/day170601/test/IOTest.java.bak");
		FileOutputStream fos = null;
		fos = new FileOutputStream(wFile);
		
		fos.write(bs);
		fos.close();
	}
	@Test
	public void test6(){
		//���ļ����������
		//�ļ�����
		File rfile = new File("src3/day170601/test/IOTest.java");
		FileInputStream fs = null;
		byte[] bs = null;
		try {
			fs = new FileInputStream(rfile);
			bs = new byte[(int)rfile.length()];
			try {
				fs.read(bs);
				
				for (byte b : bs) {
					System.out.print(b);
				}
			} catch (IOException e) {
				System.out.println("IO��д�쳣");
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�·���쳣");
		}finally{
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//�������е�����д���ļ���
		//�ļ�����
		File wfile = new File("src3/day170601/test/IOTest.java.bak");//.bak:�����ļ�
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(wfile);
			try {
				fos.write(bs);
				for (byte b : bs) {
					System.out.print(b);
				}
			} catch (IOException e) {
				System.out.println("IO��д�쳣");
			}
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�·���쳣");
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}