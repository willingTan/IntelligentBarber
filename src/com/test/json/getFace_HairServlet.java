package com.test.json;

import com.google.gson.Gson;
import com.test.model.*;
import com.test.sqlUtil.ConnectFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 这是一个post请求，用于得到人脸与头发匹配的所有发型的信息
 */
public class getFace_HairServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ResponseCode responseCode = null;
        String[] values=new String[10];
        int i=0;
        Enumeration en = req.getParameterNames();
        while (en.hasMoreElements()) {
            String paramName = (String) en.nextElement();
            values[i]=req.getParameter(paramName);
            i++;
        }
        List<Face_Hair> face_hairs=new ArrayList<Face_Hair>();
        ConnectFactory CF=new ConnectFactory();
        try {
            ResultSet rs=CF.getQueryRs("select * from fh_match where fp_id="+values[0]);
            while (rs.next()){
                int identified_id=rs.getInt("identified_code");
                String hp_url=rs.getString("hp_url");
                int love=rs.getInt("love");
                int hate=rs.getInt("hate");
                String description=rs.getString("description");
                Face_Hair face_hair=new Face_Hair(identified_id,Integer.parseInt(values[0]),hp_url,love,hate,description);
                face_hairs.add(face_hair);
            }
            Face_HairTotal face_hairTotal=new Face_HairTotal("访问成功",face_hairs.size(),face_hairs);
            Gson gson=new Gson();
            String json=gson.toJson(face_hairTotal);
            //System.out.println(json);
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter pw = resp.getWriter();
            pw.print(json);
            pw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw=new PrintWriter(resp.getWriter());
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>checkLogin</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h1>Get() cannot use here,or you will get a 405 code</h1>");
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }
}
