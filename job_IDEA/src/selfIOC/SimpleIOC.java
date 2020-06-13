package selfIOC;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SimpleIOC {

	private HashMap<String, Object> beanMap = new HashMap<>();

	public SimpleIOC(InputStream location) {
		try {
			loadBeans(location);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object getBean(String name) {
		Object bean = beanMap.get(name);
		if (bean == null) {
			throw new IllegalArgumentException("there is no bean with name " + name);
		}

		return bean;
	}
	
	private void loadBeans(InputStream inputStream) throws Exception {
        // 加载 xml 配置文件
        //InputStream inputStream = new FileInputStream(resourceAsStream);
        //将xml文件看成一棵树，dom就是对这个树的一个数据结构的描述
        //DocumentBuilderFactory   解析工厂类 
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //DocumentBuilder 解析器
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        //Document 解析树模型
        /**
         * Node对象是DOM中最基本的对象，代表了文档树中的抽象节点。
         * 但在实际使用中很少会直接使用Node对象，而是使用Node对象的子对象Element,Attr,Text等
         * 元素类Element是Node类最主要的子对象，在元素中可以包含属性，因而Element中有存取其属性的方法
         */
        Document doc = docBuilder.parse(inputStream);
        Element root = doc.getDocumentElement();
        NodeList nodes = root.getChildNodes();

        // 遍历 <bean> 标签
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                String id = ele.getAttribute("id");
                String className = ele.getAttribute("class");
                
                // 加载 beanClass
                Class beanClass = null;
                try {
                    beanClass = Class.forName(className);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    return;
                }

                   // 创建 bean
                Object bean = beanClass.newInstance();

                // 遍历 <property> 标签
                NodeList propertyNodes = ele.getElementsByTagName("property");
                for (int j = 0; j < propertyNodes.getLength(); j++) {
                    Node propertyNode = propertyNodes.item(j);
                    if (propertyNode instanceof Element) {
                        Element propertyElement = (Element) propertyNode;
                        String name = propertyElement.getAttribute("name");
                        String value = propertyElement.getAttribute("value");

                            // 利用反射将 bean 相关字段访问权限设为可访问，反射在java.lang.refect包下
                        Field declaredField = bean.getClass().getDeclaredField(name);
                        declaredField.setAccessible(true);

                        if (value != null && value.length() > 0) {
                            // 确定属性不为空，将属性值填充到相关字段中
                            declaredField.set(bean, value);
                        } else {
                            String ref = propertyElement.getAttribute("ref");
                            if (ref == null || ref.length() == 0) {
                                throw new IllegalArgumentException("ref config error");
                            }
                            
                            // 将引用填充到相关字段中
                            declaredField.set(bean, getBean(ref));
                        }

                        // 将 bean 注册到 bean 容器中
                        registerBean(id, bean);
                    }
                }
            }
        }
    }

    private void registerBean(String id, Object bean) {
        beanMap.put(id, bean);
    }
}
	
