package spring.common.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;
 
@Repository
public class CommonDao extends AbstractDao{

	@SuppressWarnings("unchecked")
	public Map<String, Object> selectFileInfo(Map<String, Object> map) {
		return (Map<String, Object>)selectOne("common.selectFileInfo", map);
	}
 
}