package IO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;
/**
 * 字节流读取和输出数据
 * @author Xudong Zhang
 */
public class InputOutputStream {
	/**
	 * test1 test2是字节读取文件
	 * @throws IOException
	 */
	@Test
	public void test1(){
		//一个一个字节的读取文件
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File("D:\\study\\eclipse project\\a.text"));
			int ch = 0;
			while((ch = fis.read())!=-1) {
				System.out.print((char)ch);//英文的不会出现问题，中文的会出现问题，因为英文只有一个字节，可以直接转换，中文UTF-8三个字节，每次读取的不是一个完整的汉字
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println();
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void test2() {
		//按照bytes的容量读取文件
		/**
		 * 			ndsa
					周瑜打黄盖，一个愿打一个愿挨。
					这是文本，将n设置为3就不会出现问题，\r\n也会占用英文的字符，所以中文前面的英文个数 3n+1
		 */
		FileInputStream fis = null;
		try {
			fis=new FileInputStream(new File("D:/study/eclipse project/a.text"));//注意上面的分隔符不同，两者都可以
			int n = 3;
			byte[] bytes = new byte[n];
			while((fis.read(bytes,0,n))!=-1) {
				System.out.print(new String(bytes));		
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	/**
	 * test3 test4演示了字节流的写
	 */
	@Test
	public void test3() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		byte[] bytes = new byte[4];
		int tmp = 0;
		try {
			fis = new FileInputStream(new File("D:/study/eclipse project/a.text"));
			fos = new FileOutputStream(new File("D:\\study\\eclipse project\\b.text"));
			while( (tmp = fis.read())!=-1) {//每锟轿讹拷取一锟斤拷锟街斤拷
				fos.write(tmp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Test
	public void test4() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		byte[] bytes = new byte[5];
		int tmp = 0;
		try {
			
			fis = new FileInputStream(new File("D:/study/eclipse project/1.png"));
			fos = new FileOutputStream(new File("D:"+File.separator+"study\\eclipse project\\2.png"));
			while( (tmp = fis.read(bytes,0,bytes.length))!=-1) {//边读边写就不会出现问题
				fos.write(bytes,0,tmp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
