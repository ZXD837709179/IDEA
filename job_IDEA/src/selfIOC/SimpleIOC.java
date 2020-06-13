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
        // ���� xml �����ļ�
        //InputStream inputStream = new FileInputStream(resourceAsStream);
        //��xml�ļ�����һ������dom���Ƕ��������һ�����ݽṹ������
        //DocumentBuilderFactory   ���������� 
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //DocumentBuilder ������
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        //Document ������ģ��
        /**
         * Node������DOM��������Ķ��󣬴������ĵ����еĳ���ڵ㡣
         * ����ʵ��ʹ���к��ٻ�ֱ��ʹ��Node���󣬶���ʹ��Node������Ӷ���Element,Attr,Text��
         * Ԫ����Element��Node������Ҫ���Ӷ�����Ԫ���п��԰������ԣ����Element���д�ȡ�����Եķ���
         */
        Document doc = docBuilder.parse(inputStream);
        Element root = doc.getDocumentElement();
        NodeList nodes = root.getChildNodes();

        // ���� <bean> ��ǩ
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                String id = ele.getAttribute("id");
                String className = ele.getAttribute("class");
                
                // ���� beanClass
                Class beanClass = null;
                try {
                    beanClass = Class.forName(className);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    return;
                }

                   // ���� bean
                Object bean = beanClass.newInstance();

                // ���� <property> ��ǩ
                NodeList propertyNodes = ele.getElementsByTagName("property");
                for (int j = 0; j < propertyNodes.getLength(); j++) {
                    Node propertyNode = propertyNodes.item(j);
                    if (propertyNode instanceof Element) {
                        Element propertyElement = (Element) propertyNode;
                        String name = propertyElement.getAttribute("name");
                        String value = propertyElement.getAttribute("value");

                            // ���÷��佫 bean ����ֶη���Ȩ����Ϊ�ɷ��ʣ�������java.lang.refect����
                        Field declaredField = bean.getClass().getDeclaredField(name);
                        declaredField.setAccessible(true);

                        if (value != null && value.length() > 0) {
                            // ȷ�����Բ�Ϊ�գ�������ֵ��䵽����ֶ���
                            declaredField.set(bean, value);
                        } else {
                            String ref = propertyElement.getAttribute("ref");
                            if (ref == null || ref.length() == 0) {
                                throw new IllegalArgumentException("ref config error");
                            }
                            
                            // ��������䵽����ֶ���
                            declaredField.set(bean, getBean(ref));
                        }

                        // �� bean ע�ᵽ bean ������
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
	
