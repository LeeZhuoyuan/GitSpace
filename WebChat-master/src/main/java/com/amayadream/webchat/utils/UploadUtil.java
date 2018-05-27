package com.amayadream.webchat.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * NAME   :  EmailSystem/com.amayadream.emailsystem.util
 * Author :  Amayadream
 * Date   :  2015.12.05 15:22
 * TODO   :  文件上传工具类
 */
public class UploadUtil {

    /**
     * Spring MVC文件上传,返回的是经过处理的path+fileName
     * @param request    request
     * @param folder    上传文件夹
     * @param userid    用户名
     * @return
     */
    public String upload(HttpServletRequest request, String folder, String userid){
        FileUtil fileUtil = new FileUtil();
        String file_url = "";
        System.out.println(getTomcatWebappsPath(request));
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if(multipartResolver.isMultipart(request)){
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while(iter.hasNext()){
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                String prefix = fileUtil.getFilePrefix(file);
                if(file != null){
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    //如果名称不为"",说明该文件存在，否则说明该文件不存在
                    if(myFileName.trim() !=""){
                        System.out.println(myFileName);
                        //重命名上传后的文件名
                        String fileName =  userid + "." + prefix;
                        //定义上传路径,格式为 upload/Amayadream/Amayadream.jpg
                        System.out.println(request.getServletContext().getRealPath(""));
                        String path = request.getServletContext().getRealPath("/") + "upload" + "/" + userid;
                        File localFile = new File(path, fileName);
                        if(!localFile.exists()){
                            localFile.mkdirs();
                            try {
                                localFile.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            file.transferTo(localFile);
                            file_url = folder + "/" + userid + "/" + fileName;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return file_url;
    }

    public static String getTomcatWebappsPath(HttpServletRequest request){
        String tomcatRoot = request.getSession().getServletContext().getRealPath("/");
        String[] foo = tomcatRoot.split("/");
        StringBuilder tomcatWebAppsBuilder = new StringBuilder();
        int i = 0;
        for(String paths : foo){
            ++i;
            if(i != foo.length){
                tomcatWebAppsBuilder.append(paths);
                tomcatWebAppsBuilder.append("/");
            }
        }
        String tomcatWebApps = tomcatWebAppsBuilder.toString();
        return tomcatWebApps;
    }

    /*public static String fileUpload(MultipartFile imageFile,HttpServletRequest request, String userId) throws Exception{
        String fileName = null;
        FileUtil file = new FileUtil();
        if(!imageFile.isEmpty()){
            //获取项目跟路径
            String filePath = request.getServletContext().getRealPath("/");
            //获取项目名
            String projectName = request.getContextPath();
            //将项目跟路劲下的项目名称置为空，因为图片需要在项目外的webapp下面存放,sub截取下标为1的字符
            filePath=filePath.replace(projectName.substring(1),"");
            System.out.println(filePath);
            //重新生成文件名字
            String prefix = imageFile.getFilePrefix(file);
            fileName = DateUtil.getCurrentDateStr()+"."+imageFile.getOriginalFilename().split("\\.")[1];
            //将文件保存到指定目录
            imageFile.transferTo(new File(filePath+"staticimage/"+fileName));
        }
        //返回文件名字供保存
        return fileName;
    }*/

}
