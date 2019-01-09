package frame.domain;

import java.util.HashMap;
import java.util.Map;

public class configuration {
    private String url;
    private String password;
    private String username;
    private String driverClass;

    //String 存储唯一id
    //Mapper
    private Map<String, Mapper> xmlMap = new HashMap<String, Mapper>();

    public Map<String, Mapper> getXmlMap() {
        return xmlMap;
    }

    public void setXmlMap(Map<String, Mapper> xmlMap) {
        this.xmlMap = xmlMap;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }
}
