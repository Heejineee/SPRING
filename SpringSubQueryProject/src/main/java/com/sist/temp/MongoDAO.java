package com.sist.temp;

import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.sist.dao.EmpVO;
import java.util.*;
@Repository
public class MongoDAO {
	private MongoClient mc;	// Connection
	private DB db;	// 데이터베이스(XE)
	private DBCollection dbc;	 // 테이블
	public MongoDAO()
	{
		try
		{
			mc=new MongoClient("localhost", 27017);
			db=mc.getDB("mydb");
			dbc=db.getCollection("emp");	// CREATE TABLE emp 랑 같은거
		}catch(Exception ex){}
	}
	public void empInsert(EmpVO vo)
	{
		BasicDBObject obj=new BasicDBObject();	// {}
		obj.put("empno", vo.getEmpno());
		obj.put("ename", vo.getEname());
		obj.put("job", vo.getJob());
		obj.put("hiredate", vo.getHiredate().toString());
		obj.put("dname", vo.getDname());
		obj.put("loc", vo.getLoc());
		
		dbc.insert(obj);
	}
	public List<EmpVO> empListData(int page)
	{
		List<EmpVO> list=new ArrayList<EmpVO>();
		int rowSize=10;
		int skip=(rowSize*page)-rowSize;
		DBCursor c=dbc.find().skip(skip).limit(rowSize);	// SELECT 해서 ResultSet에 넣는거, 페이지 나눔(skip은 버림!(말 그대로 스킵))
		while(c.hasNext())
		{
			BasicDBObject obj=(BasicDBObject)c.next();
			EmpVO vo=new EmpVO();
			vo.setEmpno(obj.getInt("empno"));
			vo.setEname(obj.getString("ename"));
			vo.setJob(obj.getString("job"));
			vo.setDname(obj.getString("dname"));
			vo.setLoc(obj.getString("loc"));
			list.add(vo);
			
		}
		c.close();
		return list;
		
	}
}










