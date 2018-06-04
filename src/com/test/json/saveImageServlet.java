package com.test.json;

import com.google.gson.Gson;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.*;
import com.test.model.ResponseCode;
import com.test.sqlUtil.ConnectFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

public class saveImageServlet extends HttpServlet {
    public static final String storageConnectionString = "DefaultEndpointsProtocol=https;AccountName=hire;AccountKey=ZAZgMFyyl/62tz+9QEfA9HlpE40825F4rK6p+pkzYi8/GH6l57/2rTRJPEShbSlud8rB8dk5foufFsGX6ITxAQ==;EndpointSuffix=core.chinacloudapi.cn";
    private CloudStorageAccount storageAccount;
    private CloudBlobClient blobClient;
    private CloudBlobContainer container;
    private BlobContainerPermissions containerPermissions;
    private ResponseCode responseCode;

    @Override
    public void init() throws ServletException {
        System.out.println("init azureCloud");
        try {
            // 获得微软云连接
            storageAccount = CloudStorageAccount.parse(storageConnectionString);
            // 获得Blob客户端
            blobClient = storageAccount.createCloudBlobClient();
            // 定义container
            container = blobClient.getContainerReference("userimage");
            // 配置访问权限为公开只读
            containerPermissions = new BlobContainerPermissions();
            containerPermissions.setPublicAccess(BlobContainerPublicAccessType.CONTAINER);
            container.uploadPermissions(containerPermissions);
            // 创建container
            container.createIfNotExists();
        } catch (Exception e) {
            System.out.println("微软云启动失败" + e.getMessage());
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=utf-8");

        //1、设置临时上传的路径
        DiskFileItemFactory disk = new DiskFileItemFactory(10240,new File("D:\\image"));//本地
        //2、设置文件上传的目标路径
        String servePath = getServletContext().getRealPath("/serviceDisk");
        System.out.println(servePath);
        //3、申明upload
        ServletFileUpload up = new ServletFileUpload(disk);
        //4、解析request
        try {
            List<FileItem> list = up.parseRequest(req);
            for(FileItem file:list){
                if(!file.isFormField()){
                    //获取上传文件的名字
                    String fileName = file.getName();
                    fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
                    //获取上传文件的后缀
                    String extName = fileName.substring(fileName.lastIndexOf("."));
                    //申明UUID
                    String uuid = UUID.randomUUID().toString().replace("-", "");
                    //组成新的名称
                    String newName = uuid+extName;
                    //上传文件
                    FileUtils.copyInputStreamToFile(file.getInputStream(), new File(servePath+"/"+newName));
                    //封装
                    req.setAttribute("newName", newName);
                    req.setAttribute("oldName", fileName);
                    String[] values=new String[10];
                    int i=0;
                    Enumeration en = req.getParameterNames();
                    while (en.hasMoreElements()) {
                        String paramName = (String) en.nextElement();
                        values[i]=req.getParameter(paramName);
                        i++;
                    }
                    ConnectFactory CF=new ConnectFactory();
                    try {
                        CloudBlockBlob blob = container.getBlockBlobReference(newName);
                        File source=new File(servePath+"\\"+newName);
                        blob.upload(new FileInputStream(source), source.length());
                        //System.out.println("上传图片成功");
                        responseCode=new ResponseCode("上传头像成功","209");
                        String imageurl="https://hire.blob.core.chinacloudapi.cn/userimage/"+newName;
                        CF.UseUpdate("update user set imageurl='"+imageurl+"' where id='"+values[0]+"'");
                        Gson gson=new Gson();
                        String json=gson.toJson(responseCode);
                        PrintWriter pw = res.getWriter();
                        pw.print(json);
                        pw.flush();
                    } catch (Exception e) {
                        e.printStackTrace();
                        responseCode=new ResponseCode("上传头像失败","210");
                        Gson gson=new Gson();
                        String json=gson.toJson(responseCode);
                        PrintWriter pw = res.getWriter();
                        pw.print(json);
                        pw.flush();
                    }
                }
            }
        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            new RuntimeException();
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