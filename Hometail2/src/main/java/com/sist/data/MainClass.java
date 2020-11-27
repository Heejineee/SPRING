package com.sist.data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MainClass {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
			String json="{\"sawon\":[{\"name\":null,\"attachBoardName\":null,\"post_id\":1,\"id\":0,\"reg_name\":\"최고운영자\",\"reg_id\":100,\"title\":\"홈스 잘 지내고 있습니다\",\"content\":\"&lt;p&gt;&lt;img alt=&quot;KakaoTalk_20181107_100033204.jpg&quot; src=&quot;/upload/preimg/4139/624/003/bcaa2ebac2d79739064a9064a3d41956.jpg&quot; /&gt;&lt;/p&gt;\n\n&lt;p&gt;&lt;img alt=&quot;KakaoTalk_20181107_100033405.jpg&quot; src=&quot;/upload/preimg/4139/624/003/da1b2ee282640163485250aa6635da36.jpg&quot; /&gt;&lt;/p&gt;\n\n&lt;p&gt;&lt;img alt=&quot;KakaoTalk_20181107_100033612.jpg&quot; src=&quot;/upload/preimg/4139/624/003/046ceabbe769b1cf39e7308e2f5d0683.jpg&quot; /&gt;&lt;/p&gt;\n\n&lt;p&gt;안녕하세요 입양간 골든리트리버 홈스 입니다 !&lt;/p&gt;\n\n&lt;p&gt;새로운 견주님을 만나 행복하게 잘 지내고 있습니다.&lt;/p&gt;\n\n&lt;p&gt;장난감도 가지고 놀고 밥도 잘 먹고 산책도 매일나가 행복한 삶을 지내고 있습니다&lt;/p&gt;\n\n&lt;p&gt;훈련이 다 되어 있는터라 견주님도 홈스도 서로 불편함 없이 즐거운 나날을 보내고 있습니다&amp;nbsp;&lt;/p&gt;\n\n&lt;p&gt;감사합니다&amp;nbsp;&lt;/p&gt;\n\",\"hit\":2,\"reg_date\":\"2018.10.30\",\"attachyn\":\"2\",\"notice_yn\":null,\"attach_file\":\"/upload/adoptreview/20190530/THUMB_1559179760919.jpg\",\"attach_file_r\":null,\"video_link\":\"\",\"user_id\":0,\"role_id\":0,\"adopt_type\":0,\"currentPage\":0,\"pageSize\":0,\"startPage\":0,\"searchKey\":null,\"totalPage\":0,\"orderBy\":null}]}";
			   try
			   {
				   JSONParser jp=new JSONParser();
				   JSONObject root=(JSONObject)jp.parse(json);
				   JSONArray arr=(JSONArray)root.get("sawon");
				   for(int i=1;i<arr.size();i++)
				   {
					   JSONObject obj=(JSONObject)arr.get(i);
					  // System.out.println(obj.get("reg_name"));
					   String name=String.valueOf(obj.get("reg_name"));
					   //System.out.println(obj.get("title"));
					   String title=String.valueOf(obj.get("title"));
					   String s=String.valueOf(obj.get("content"));
						   s=s.replaceAll("[A-Za-z]", "");
						   s=s.replaceAll("&lt;", "");
						   s=s.replaceAll("&gt;", "");
						   s=s.replaceAll("&amp;", "");
						   s=s.replaceAll("[0-9]", "");
						   s=s.replaceAll("nbsp;", "");
						   s=s.replaceAll("&quot;", "");
						   s=s.replaceAll("&;", "");
						   s=s.replaceAll("/", "");
						   s=s.replaceAll("=", "");
						   s=s.replaceAll(";", "");
						   s=s.replaceAll("-", "");
						   s=s.replaceAll(":", "");
						   s=s.replaceAll("\\(", "");
						   s=s.replaceAll("\\)", "");
						   s=s.replaceAll("\\.", "");
						   //s=s.replaceAll("\\s", "");
						String content=s;
						String regdate=String.valueOf(obj.get("reg_date"));
					    String poster="https://animalwa.org"+String.valueOf(obj.get("attach_file"));
					   //System.out.println("============");
					   System.out.println("INSERT INTO board VALUES("+(i+44)+",'"+name+"',2,'"+title+"','"+content+"','"+regdate+"',"+0+",'"+poster+"');");
				   }
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		
		
		
		
		
	}

}
