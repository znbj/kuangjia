package frame.factory;

import java.io.InputStream;

public class sqlSessionFactoryBuilder {
    /**
     * 通过输入流创建对象
     * @param inputStream
     * @return
     */
    public sqlSessionFactory builder(InputStream inputStream) {
        return new sqlSessionFactory(inputStream);
    }

    /**
     * 通过路径创建对象
     * @param path
     * @return
     */
    public sqlSessionFactory builder(String path) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
        return new sqlSessionFactory(inputStream);
    }

    /**
     * 默认路径
     * @param
     * @return
     */
    public sqlSessionFactory builder() {
        String path = "sqlMapConfig.xml";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
        return new sqlSessionFactory(inputStream);
    }
}
