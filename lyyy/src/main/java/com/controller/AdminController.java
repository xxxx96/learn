package com.controller;

import com.annotation.NeedLogin;
import com.entity.Admin;
import com.entity.Category;
import com.entity.Details;
import com.entity.Result;
import com.service.AdminService;
import com.service.CategoryService;
import com.service.DetailsService;
import com.util.ImgCheckCode;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;


@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DetailsService detailsService;
    @Autowired
    private Result result;

    public static String CODE_SESSION_NAME="imgCode";

    /*
     * 后台登陆
     */
    @RequestMapping("login")
    public String login(){
        return "admin/login";
    }

    @RequestMapping(value="getcode",method=RequestMethod.GET)
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImgCheckCode imgCheckCode=new ImgCheckCode();
        String code=imgCheckCode.getRandomCodeStr();
        BufferedImage buffImg= imgCheckCode.getImgCode(code); System.out.println("Code is " +code);
        // 将四位数字的验证码保存到Session中。
        HttpSession session = request.getSession();
        session.setAttribute(CODE_SESSION_NAME,code);
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos = response.getOutputStream();
        ImageIO.write(buffImg, "jpeg", sos);
        sos.close();
    }
    @NeedLogin
    @RequestMapping("index")
    public String index(){
        return "admin/index";
    }
    /*
     *分类
     */
    @RequestMapping("product_category")
    public String productCategory(){
        return "admin/product_category";
    }
    /*
     *分类添加
     */
    @RequestMapping("product_category_add")
    public String productCategoryAdd(){
        return "admin/product_category_add";
    }
    /*
     *商品管理
     */
    @RequestMapping("product_list")
    public String productist(HttpServletRequest request){
        ArrayList<Category> list= (ArrayList<Category>) categoryService.selectAll();
        JSONArray jsonArray = JSONArray.fromObject(list);
        ArrayList<Details> detailsArrayList = (ArrayList<Details>)detailsService.findAll();
        for (Details details: detailsArrayList) {
            if(details.getPicUrl()!=null){
                String[] strArr = details.getPicUrl().split(";");
                details.setPicUrl(strArr[0]);
            }
        }
        request.setAttribute("category",jsonArray.toString());
        request.setAttribute("details",detailsArrayList);
        System.out.println(jsonArray.toString());
        return "admin/product_list";
    }
    /*
     *密码验证
     */
    @ResponseBody
    @RequestMapping(value = "authentication",method = RequestMethod.POST)
    public String  authentication(HttpSession session,Admin admin,String captcha){
        System.out.println(captcha);
        if(session.getAttribute(CODE_SESSION_NAME)==null||session.getAttribute(CODE_SESSION_NAME).equals(captcha)){
            result.setCode(0);
            result.setResult("验证码错误");
            JSONObject json = new JSONObject(result);
            return json.toString();
        }
        if (adminService.authentication(admin)){
            session.setAttribute("admin",admin);
            result.setCode(1);
            result.setResult("success");
            JSONObject json = new JSONObject(result);
            return json.toString();
        }else {
            result.setCode(0);
            result.setResult("defeat");
            JSONObject json = new JSONObject(result);
            return json.toString();
        }
    }
    /*
     *图片上传
     */
    @ResponseBody
    @PostMapping("/upload")
    public String uploadFile(@RequestPart("file") MultipartFile file,HttpServletRequest request) throws IOException {

        String pictureName = UUID.randomUUID().toString() + ".jpg";

            //获取上传路径
            String fileSavePath = System.getProperty("user.dir")+"\\src\\main\\webapp\\root\\";
            /**
             * transferTo在开发Web应用程序时比较常见的功能之一，
             * 就是允许用户利用multipart请求将本地文件上传到服务器,
             * Spring通过对ServletAPI的HttpServletRequest接口进行扩展，使其能够很好地处理文件上传
             */
        file.transferTo(new File(fileSavePath + pictureName));
        System.out.println(fileSavePath);
        result.setCode(1);
        result.setResult(pictureName);
        JSONObject json = new JSONObject(result);
        return json.toString();
    }
    /*
     *添加商品
     */
    @RequestMapping("product_add")
    public String productAdd(HttpServletRequest request){
        ArrayList<Category> list= (ArrayList<Category>) categoryService.selectAll();
        for (Category category:list) {
            String str="";
            for(int i=0;i<category.getLevel()-1;i++){
                str=str+"├";
            }
            str=str+category.getName();
            category.setName(str);
        }
        request.setAttribute("category",list);
        return "admin/product_add";
    }
    /*
     *验证并添加商品
     */
    @RequestMapping(value = "product_add",method = RequestMethod.POST)
    @ResponseBody
    public String productAdd(HttpServletRequest request,Details details){
        if(details.getTitle()==null||details.getCategoryId()==null||details.getCategoryId()==0){
            result.setCode(0);
            result.setResult("没有填写标题或选择分类");
            JSONObject json = new JSONObject(result);
            return json.toString();
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        details.setTime(df.format(new Date()));
        detailsService.save(details);
        result.setCode(1);
        result.setResult("success");
        JSONObject json = new JSONObject(result);
            return json.toString();
    }
    /*
     *删除商品
     */
    @RequestMapping(value = "delete_product",method = RequestMethod.POST)
    @ResponseBody
    public String deleteProduct(Integer id){
        detailsService.delete(id);
        if(detailsService.findById(id)!=null){
            result.setCode(1);
            result.setResult("success");
            JSONObject json = new JSONObject(result);
            return json.toString();
        }
        result.setCode(0);
        result.setResult("删除失败，稍后再试");
        JSONObject json = new JSONObject(result);
        return json.toString();
    }

}