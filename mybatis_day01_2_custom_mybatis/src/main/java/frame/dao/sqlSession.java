package frame.dao;

import java.util.List;

public interface sqlSession {

    /**
     *框架的入口
     * @param mapperId 唯一id
     *
     * @return
     */
    public List selectList(String mapperId);

    /**
     * 关闭`资源
     */
    public void close();

}
