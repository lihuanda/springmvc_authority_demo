package com.lihuanda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lihuanda.annotation.FireAuthority;
import com.lihuanda.beans.AuthorityType;
import com.lihuanda.beans.ResultTypeEnum;

@Controller
//����url�ĸ�·��������ʱ��·��+��������url
@RequestMapping("/controller")
public class AuthorityController {
	//��ʽһ

	@RequestMapping(value="/error.html",method=RequestMethod.GET)
	public ModelAndView error(String msg) throws Exception
	{
		 ModelAndView mav = new ModelAndView();
		 System.out.println("����error1111111111111111");
	       mav.setViewName("error");
		   mav.addObject("msg", msg);
		  
		   return  mav;
	}
	@FireAuthority(authorityTypes = AuthorityType. SALES_ORDER_CREATE)
	@RequestMapping(value="/save.html", method=RequestMethod.GET)
	public ModelAndView save(String  name) throws Exception {
		 ModelAndView mav = new ModelAndView();
		 System.out.println("����controller1111111111111111");
	       mav.setViewName("hello");
		   mav.addObject("msg", name);
		  
		   return  mav;
	    //some code
	}
	//��ʽ��

	@FireAuthority(authorityTypes = {AuthorityType.SALES_ORDER_DELETE,AuthorityType.SALES_ORDER_CREATE})
	    @RequestMapping(value="/save1.html", method=RequestMethod.GET)
	    public ModelAndView save1(String  name) throws Exception {
			return null;
	        //some code
	    }
	//��ʽ��

	@FireAuthority(authorityTypes = AuthorityType.SALES_ORDER_DELETE, resultType=ResultTypeEnum.page)
	@RequestMapping(value="/save2.html", method=RequestMethod.GET)
	public ModelAndView save2(String  name) throws Exception {
		return null;
	    //some code
	}
}
