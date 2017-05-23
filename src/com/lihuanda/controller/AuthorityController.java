package com.lihuanda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lihuanda.annotation.FireAuthority;
import com.lihuanda.beans.AuthorityType;
import com.lihuanda.beans.ResultTypeEnum;

@Controller
//定义url的根路径，访问时根路径+方法名的url
@RequestMapping("/controller")
public class AuthorityController {
	//方式一

	@RequestMapping(value="/error.html",method=RequestMethod.GET)
	public ModelAndView error(String msg) throws Exception
	{
		 ModelAndView mav = new ModelAndView();
		 System.out.println("进入error1111111111111111");
	       mav.setViewName("error");
		   mav.addObject("msg", msg);
		  
		   return  mav;
	}
	@FireAuthority(authorityTypes = AuthorityType. SALES_ORDER_CREATE)
	@RequestMapping(value="/save.html", method=RequestMethod.GET)
	public ModelAndView save(String  name) throws Exception {
		 ModelAndView mav = new ModelAndView();
		 System.out.println("进入controller1111111111111111");
	       mav.setViewName("hello");
		   mav.addObject("msg", name);
		  
		   return  mav;
	    //some code
	}
	//方式二

	@FireAuthority(authorityTypes = {AuthorityType.SALES_ORDER_DELETE,AuthorityType.SALES_ORDER_CREATE})
	    @RequestMapping(value="/save1.html", method=RequestMethod.GET)
	    public ModelAndView save1(String  name) throws Exception {
			return null;
	        //some code
	    }
	//方式三

	@FireAuthority(authorityTypes = AuthorityType.SALES_ORDER_DELETE, resultType=ResultTypeEnum.page)
	@RequestMapping(value="/save2.html", method=RequestMethod.GET)
	public ModelAndView save2(String  name) throws Exception {
		return null;
	    //some code
	}
}
