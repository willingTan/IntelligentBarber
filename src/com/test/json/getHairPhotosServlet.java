package com.test.json;

import com.google.gson.Gson;
import com.test.model.HairPhotoTotal;
import com.test.model.HairPhotos;
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
 * 这是一个get请求，用于得到所有发型的信息，可以再没有选择的情况下，进行合理全部发型的给出，让用户能够选中最为满意的一款发型
 */
public class getHairPhotosServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnectFactory CF=new ConnectFactory();
        List<HairPhotos> hairPhotos=new ArrayList<HairPhotos>();
        try{
            ResultSet rs= CF.getQueryRs("select * from hp");
            while (rs.next()){
                int hp_id=rs.getInt("hp_id");
                int hp_type=rs.getInt("hp_type");
                String hp_url=rs.getString("hp_url");
                HairPhotos hp=new HairPhotos(hp_id,hp_type,hp_url);
                hairPhotos.add(hp);
            }
            HairPhotoTotal hairPhotoTotal=new HairPhotoTotal("访问成功",hairPhotos.size(),hairPhotos);

            Gson gson=new Gson();
            String json=gson.toJson(hairPhotoTotal);
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
        this.doGet(req, resp);
    }
}
