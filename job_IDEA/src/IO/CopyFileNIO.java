package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class CopyFileNIO {
	public void myClose(Channel ch) {
		if(ch!=null) {
			try {
				ch.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void myClose(InputStream c) {
		if(c!=null) {
			try {
				c.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void myClose(OutputStream c) {
		if(c!=null) {
			try {
				c.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void copyFile() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel ich=null;
		FileChannel och = null;
		try {
			fis = new FileInputStream(new File("D:/study/eclipse project/1.png"));
			fos = new FileOutputStream(new File("D:/study/eclipse project/3.png"));
			ich = fis.getChannel();
			och = fos.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			while(true) {
				int tmp = ich.read(buffer);
				if(tmp==-1) {
					break;
				}
				buffer.flip();
				och.write(buffer);
				buffer.clear();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			myClose(ich);
			myClose(och);
			myClose(fis);
			myClose(fos);
		}
	}
	public static void main(String[] args) {
		new CopyFileNIO().copyFile();
		
	}
}
