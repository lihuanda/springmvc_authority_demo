package com.lihuanda.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
	
	
	@RequestMapping(value="view.html",method=RequestMethod.GET)
	public String view()
	{
		System.out.println("--����view-------");
		return "view";
		
	}
	
	/*
     * ����file.Transto �������ϴ����ļ�
     */
    @RequestMapping(value = "fileUpload2.html",method=RequestMethod.POST)
    public String  fileUpload2(@RequestParam(value = "file", required = false)CommonsMultipartFile file) throws IOException {
//         long  startTime=System.currentTimeMillis();
        System.out.println("fileName��"+file.getOriginalFilename());
        String path="E:/"+file.getOriginalFilename();
         
        File newFile=new File(path);
        //ͨ��CommonsMultipartFile�ķ���ֱ��д�ļ���ע�����ʱ��
        file.transferTo(newFile);
//        long  endTime=System.currentTimeMillis();
//        System.out.println("������������ʱ�䣺"+String.valueOf(endTime-startTime)+"ms");
        return "success"; 
    }

}
