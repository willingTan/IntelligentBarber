package com.test.json;

import com.google.gson.Gson;
import com.test.model.UserTotal;
import com.test.model.Users;
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
 * 这是一个get请求，用于得到用户相关信息
 */
public class getUsersServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
        ConnectFactory CF=new ConnectFactory();
        List<Users> usersList=new ArrayList<Users>();
        try{
            ResultSet rs= CF.getQueryRs("select * from user");
            while (rs.next()){
                int user_id=rs.getInt("id");
                String user_name=new String(rs.getString("username").getBytes("utf-8"),"utf-8");
                String user_birthday=new String(rs.getString("birthday").getBytes("utf-8"),"utf-8");
                String user_sex=new String(rs.getString("sex").getBytes("utf-8"),"utf-8");
                String user_address=new String(rs.getString("address").getBytes("utf-8"),"utf-8");
                String user_password=new String(rs.getString("password").getBytes("utf-8"),"utf-8");
                String user_image=rs.getString("imageurl");
                Users users=new Users(user_id,user_name,user_birthday,user_sex,user_address,user_password,user_image);
                usersList.add(users);
            }
            UserTotal userTotal=new UserTotal("访问成功",usersList.size(),usersList);

            Gson gson=new Gson();
            //String json=new String(gson.toJson(userTotal).getBytes("utf-8"));
            String json=new String(gson.toJson(userTotal));
            //System.out.println(json);
            resp.setContentType("text/html");
            resp.setCharacterEncoding("utf-8");
            //resp.setContentType("text/html;charset=utf-8");
            //PrintWriter out = new PrintWriter(resp.getOutputStream());
            PrintWriter out = new PrintWriter(resp.getWriter());
            out.print(json);
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
