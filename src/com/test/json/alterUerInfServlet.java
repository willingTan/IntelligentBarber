package com.test.json;

import com.google.gson.Gson;
import com.test.model.ResponseCode;
import com.test.sqlUtil.ConnectFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class alterUerInfServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //List<Check> checks=new ArrayList<Check>();
        ResponseCode responseCode = null;
        String[] values=new String[10];
        int i=0;
        Enumeration en = req.getParameterNames();
        while (en.hasMoreElements()) {
            String paramName = (String) en.nextElement();
            values[i]=req.getParameter(paramName);
            //Check check=new Check(paramName,req.getParameter(paramName));
            //checks.add(check);
            i++;
        }
        ConnectFactory CF=new ConnectFactory();
        try {
            CF.UseUpdate("update user set username='"+values[0]+"',password='"+values[1]+"',birthday='"+values[2]+"',sex='"+values[3]+"',address='"+values[4]+"' where id='"+values[5]+"'");
            responseCode=new ResponseCode("用户信息修改成功","207");
        }catch (Exception e){
            e.printStackTrace();
        }
        //CheckTotal checkTotal=new CheckTotal("访问成功",checks.size(),checks);
        Gson gson=new Gson();
        String json=gson.toJson(responseCode);
        //System.out.println(json);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.print(json);
        pw.flush();
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
