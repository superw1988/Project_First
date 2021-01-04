package com.sw.first.sample.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sw.first.sample.dao.SampleDAO;

@Service("sampleService") 
public class SampleServiceImpl implements SampleService{ 
	Logger log = Logger.getLogger(this.getClass()); 
	
	@Resource(name="sampleDAO") 
	private SampleDAO sampleDAO; 
	
	@Override public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception { 
		return sampleDAO.selectBoardList(map); 
		
	}
	
	@Override public void insertBoard(Map<String, Object> map) throws Exception { 
		sampleDAO.insertBoard(map); 
		
	}
	
	@Override public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception { 
		//ServiceImpl 에는 하나의 페이지를 호출할 때 필요한 비지니스 로직을 묶어서 처리하는 곳 (DAO를 두개 호출함)
		sampleDAO.updateHitCnt(map); 
		Map<String, Object> resultMap = sampleDAO.selectBoardDetail(map); 
		
		return resultMap; 
		
	}
	
	@Override public void updateBoard(Map<String, Object> map) throws Exception{ 
		sampleDAO.updateBoard(map); 
		
	}
	
	@Override public void deleteBoard(Map<String, Object> map) throws Exception { 
		sampleDAO.deleteBoard(map); 
		
	}


}
