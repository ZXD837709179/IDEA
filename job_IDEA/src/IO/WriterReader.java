package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;
/**
 * reader和writer处理字符，
 * 读取文件和写入文件
 * @author Xudong Zhang
 *
 */
public class WriterReader {
	@Test
	public void test() {
		FileReader fr = null;
		char[] chars = new char[1024];
		try {
			fr = new FileReader(new File("D:/study/eclipse project/a.text"));
			int tmp = 0;
			while((tmp=fr.read(chars,0,chars.length))!=-1) {
				System.out.print(new String(chars,0,tmp));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	@Test
	public void test2() {
		FileReader fr = null;
		char[] chars = new char[1024];
		try {
			fr = new FileReader(new File("D:/study/eclipse project/a.text"));
			int tmp = 0;
			while((tmp=fr.read())!=-1) {
				System.out.print((char)tmp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	@Test//通过bufferedreader的缓冲流
	public void test3() {
		FileReader fr = null;
		BufferedReader br = null;
		
		char[] chars = new char[1024];
		try {
			fr = new FileReader(new File("D:/study/eclipse project/a.text"));
			br = new BufferedReader(fr);
			String readLine = br.readLine();
			
			while(readLine!=null) {
				System.out.println(readLine);
				readLine = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	@Test
	public void test4() {
		InputStreamReader fr = null;
		BufferedReader br = null;
		try {
			fr = new InputStreamReader(new FileInputStream(new File("D:/study/eclipse project/a.text")),"UTF-8");
			br = new BufferedReader(fr);
			String readLine = br.readLine();
			
			while(readLine!=null) {
				System.out.println(readLine);
				readLine = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	@Test//字符流的写入
	public void test5() {
		OutputStreamWriter fw = null;
		InputStreamReader fr = null;
		
		try {
			int tmp;
			fw =new OutputStreamWriter(new FileOutputStream("D:/study/eclipse project/b.text"));
			fr =new InputStreamReader(new FileInputStream("D:/study/eclipse project/a.text"),"UTF-8");
			
			char[] chars = new char[4];
			while((tmp=fr.read(chars,0,chars.length))!=-1) {
				fw.write(chars,0,tmp);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fw!=null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}