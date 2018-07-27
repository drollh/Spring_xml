package spring.common.service;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.common.dao.CommonDao;
 
@Service("commonService")
public class CommonServiceImpl implements CommonService{
    Logger log = Logger.getLogger(this.getClass());
     
    @Autowired
    private CommonDao CommonDao;
    

    @Override
    public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
        return CommonDao.selectFileInfo(map);
    }
}
