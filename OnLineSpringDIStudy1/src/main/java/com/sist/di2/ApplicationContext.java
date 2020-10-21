package com.sist.di2;

import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.*;
public class ApplicationContext {
	private Map map=new HashMap();
	public ApplicationContext(String path)
	{
		try
		{
			SAXParserFactory spf=SAXParserFactory.newInstance();
			SAXParser sp=spf.newSAXParser();
			XMLParser xp=new XMLParser();
			sp.parse(new File(path), xp);
			map=xp.map;
		}catch(Exception ex){}
	}
	// DL(Lookup) => �̸�(key)�� ������ Ŭ���� ��ü �ּҸ� ã���ִ� ����
	public Object getBean(String key)
	{
		return map.get(key);
	}
}
