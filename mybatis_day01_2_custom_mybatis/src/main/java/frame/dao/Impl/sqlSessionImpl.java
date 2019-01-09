package frame.dao.Impl;

import frame.dao.sqlSession;
import frame.domain.Mapper;
import frame.domain.configuration;
import frame.utils.Executor;


import java.util.List;

public class sqlSessionImpl implements sqlSession {

    private configuration cfg;
    private Executor executor;
    /**
     * 因为必须用到cfg ,通过构造方法传参
     * @param cfg
     */
    public sqlSessionImpl(configuration cfg ) {
        this.cfg=cfg;
        executor = new Executor(cfg);
    }

    public List selectList(String mapperId) {
        //通过唯一id获取到mapper对象,包含sql语句和 返回值类型

        Mapper mapper = cfg.getXmlMap().get(mapperId);

        String resultType = mapper.getResultType();
        String sql = mapper.getSql();
        Executor executor = new Executor(cfg);



        return executor.executeQuery(resultType,sql);
    }

    public void close() {
        executor.release();
    }
}
