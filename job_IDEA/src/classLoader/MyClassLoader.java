package classLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;


public class MyClassLoader extends ClassLoader{
	private String mLiPath;
	public MyClassLoader(String path) {
		this.mLiPath = path;
	}
	@Override
	protected Class findClass(String name) throws ClassNotFoundException {
		String fileName = getFileName(name);
		File file = new File(mLiPath,fileName);//new File(路径,文件名)	
		try {
			FileInputStream fis = new FileInputStream(file);
			ByteOutputStream bos = new ByteOutputStream();
			int len = 0;
			try {
				while((len = fis.read())!=-1) {
					bos.write(len);
				}
				byte[] data = bos.toByteArray();				
				return defineClass(name,data,0,data.length);//defineClass将class二进制内容转换为class对象
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				bos.close();
				fis.close();
			}
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return super.findClass(name);
	}
	
		//获取要加载的class文件名
		private String getFileName(String name) {
			int index = name.lastIndexOf('.');
			if(index == -1){ 
				return name+".class";
			}else{
				return name.substring(index+1)+".class";
			}
		}

}
