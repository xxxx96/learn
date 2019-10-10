package com.controller;

import com.entity.Details;
import com.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("app")
public class AppController {
    @Autowired
    private DetailsService detailsService;
    @RequestMapping("index")
    public String index(HttpServletRequest request){
        ArrayList<Details> details = (ArrayList<Details>) detailsService.findAll();
        for (Details each:details
             ) {
            String[] strArr = each.getPicUrl().split(";");
            if(strArr!=null){
                each.setPicUrl(strArr[0]);
            }
        }
        request.setAttribute("details",details);
        return "APP/index";
    }
    @RequestMapping("about")
    public String about(){
        return "APP/about";
    }
    @RequestMapping("contact")
    public String contact(){
        return "APP/contact";
    }
    @RequestMapping("anli")
    public String anli(HttpServletRequest request){
        ArrayList<Details> res=detailsService.findByCategoryId(11);
        for (Details each:res){
            String[] strArr = each.getPicUrl().split(";");
            if(strArr!=null){
                each.setPicUrl(strArr[0]);
            }
        }
        request.setAttribute("details",res);
        return "APP/anli";
    }
    @RequestMapping("view")
    public String view(HttpServletRequest request){
       ArrayList<Details> res= detailsService.findByCategoryId(12);
        for (Details each:res
        ) {
            String[] strArr = each.getPicUrl().split(";");
            if(strArr!=null){
                each.setPicUrl(strArr[0]);
            }
        }
       request.setAttribute("details",res);
       return "APP/view";
    }
    @RequestMapping("view_del")
    public String view_del(HttpServletRequest request,Integer id){

    Details details = detailsService.findById(id);
    String[] str=details.getPicUrl().split(";");
        request.setAttribute("pic",str);
        request.setAttribute("details",details);
        return "APP/view_del";
    }
    @RequestMapping("anlidel")
    public String anlidel(HttpServletRequest request,Integer id){
        Details details = detailsService.findById(id);
        String[] str=details.getPicUrl().split(";");
        request.setAttribute("pic",str);
        request.setAttribute("details",details);
        return "APP/anlidel";
    }
}
