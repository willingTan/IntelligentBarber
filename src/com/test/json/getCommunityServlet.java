package com.test.json;

import com.google.gson.Gson;
import com.test.model.Community;
import com.test.model.CommunityTotal;
import com.test.sqlUtil.ConnectFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 这是一个get请求，用于得到社区的内容
 */
public class getCommunityServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnectFactory CF=new ConnectFactory();
        List<Community> communities=new ArrayList<Community>();
        try{
            ResultSet rs= CF.getQueryRs("select * from community");
            while (rs.next()){
                int content_id=rs.getInt("content_id");
                int user_id=rs.getInt("user_id");
                String user_name=rs.getString("user_name");
                int communiy_type=rs.getInt("community_type");
                int up=rs.getInt("up");
                int down=rs.getInt("down");
                String content=rs.getString("content");
                String communityimageurl=rs.getString("communityimageurl");
                Community community=new Community(content_id,user_id,user_name,communiy_type,up,down,content,communityimageurl);
                communities.add(community);
            }
            CommunityTotal communityTotal=new CommunityTotal("访问成功",communities.size(),communities);

            Gson gson=new Gson();
            String json=gson.toJson(communityTotal);
            //System.out.println(json);
            resp.setContentType("text/html");
            resp.setCharacterEncoding("utf-8");
            PrintWriter pw=new PrintWriter(resp.getWriter());
            pw.print(json);
            pw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}