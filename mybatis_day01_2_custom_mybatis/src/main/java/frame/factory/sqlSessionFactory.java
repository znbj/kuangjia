package frame.factory;

import frame.dao.Impl.sqlSessionImpl;
import frame.dao.sqlSession;
import frame.domain.Mapper;
import frame.domain.configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 使用工厂模式创建sqlsession
 */
public class sqlSessionFactory {

    private InputStream inputStream;

    public sqlSessionFactory(InputStream inputStream) {
        this.inputStream=inputStream;
    }

    public sqlSession openSession() {

        configuration configuration = new configuration();
        loadConfiguration(configuration);
        return new sqlSessionImpl(configuration );

    }

    /**
     * 读取配置文件
     */
    public void loadConfiguration(configuration configuration) {
        SAXReader sax = new SAXReader();
        Document document =null;
        try {
            document = sax.read(inputStream);
            Element rootElement = document.getRootElement();
            List<Element> list = rootElement.selectNodes("//property");

            for (Element ele : list) {
                if (ele.attributeValue("name").equalsIgnoreCase("driver")) {
                    configuration.setDriverClass(ele.attributeValue("value"));
                }

                if (ele.attributeValue("name").equalsIgnoreCase("username")) {
                    configuration.setUsername(ele.attributeValue("value"));
                }

                if (ele.attributeValue("name").equalsIgnoreCase("password")) {
                    configuration.setPassword(ele.attributeValue("value"));
                }

                if (ele.attributeValue("name").equalsIgnoreCase("url")) {
                    configuration.setUrl(ele.attributeValue("value"));
                }

            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        //读取mappers节点
        Element root = document.getRootElement();
        Element mappers = root.element("mappers");
        List<Element> mapperList = mappers.elements("mapper");
        for (Element element : mapperList) {
            String mapperPath = element.attributeValue("resource");
            loadMapperConfiguration(mapperPath,configuration);


        }


    }

    /**
     * 读取mapper
     * @param mapperPath 映射文件的路径
     * @param configuration
     */
    private void loadMapperConfiguration(String mapperPath, configuration configuration) {
        //获取该配置文件的流
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(mapperPath);
        SAXReader sax = new SAXReader();
        try {
            Document doc = sax.read(inputStream);
            Element root = doc.getRootElement();
            Map<String, Mapper> xmlMap = configuration.getXmlMap();
//          添加对象
// key 唯一的id namespace + id
// value 存储mapper对象 sql语句 返回的对象类型
            String key =null;
            String namespace = root.attributeValue("namespace");
            //根节点下 所有子节点
            List<Element> elements = root.elements();
            for (Element element : elements) {
                String id = element.attributeValue("id");
                key=namespace+"."+id;
                Mapper mapper=new Mapper();
                mapper.setResultType(element.attributeValue("resultType"));
                mapper.setSql(element.getTextTrim());
                xmlMap.put(key,mapper);

            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }
 }
