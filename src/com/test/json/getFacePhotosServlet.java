package com.test.json;

import com.google.gson.Gson;
import com.test.model.FacePhotoTotal;
import com.test.model.FacePhotos;
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
 * 这是一个get请求，用于得到标准人脸的参数，与用户提供的相片进行比较，进而得到最合理的发型推荐
 */
public class getFacePhotosServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnectFactory CF=new ConnectFactory();
        List<FacePhotos> facePhotos=new ArrayList<FacePhotos>();
        try{
            ResultSet rs= CF.getQueryRs("select * from fp");
            while (rs.next()){
                int fp_id=rs.getInt("fp_id");
                String fp_url=rs.getString("fp_url");
                int fp_type=rs.getInt("fp_type");
                String fp_description=rs.getString("fp_description");
                FacePhotos fp=new FacePhotos(fp_id,fp_url,fp_type,fp_description);
                facePhotos.add(fp);
            }
            FacePhotoTotal facePhotoTotal=new FacePhotoTotal("访问成功",facePhotos.size(),facePhotos);

            Gson gson=new Gson();
            String json=gson.toJson(facePhotoTotal);
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
