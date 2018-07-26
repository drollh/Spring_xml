package spring.sample.service;

import java.util.List;
import java.util.Map;

import spring.common.common.CommandMap;


public interface SampleService {

	List<Map<String, Object>> selectBoardList(CommandMap map) throws Exception;

	void insertBoard(Map<String, Object> map) throws Exception;;

	Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception;

	void updateBoard(Map<String, Object> map) throws Exception;

	void deleteBoard(Map<String, Object> map)throws Exception;
}
