package com.amayadream.webchat.controller;

import com.amayadream.webchat.pojo.Log;
import com.amayadream.webchat.service.ILogService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Author :  Amayadream
 * Date   :  2016.01.10 00:23
 * TODO   :
 */
@Controller
@RequestMapping(value = "")
public class LogController {

    @Resource
    private ILogService logService;

    @RequestMapping(value = "{userid}/log")
    public ModelAndView selectAll(@PathVariable("userid") String userid, @RequestParam(defaultValue = "1") int page) {
        int pageSize = 5;
        ModelAndView view = new ModelAndView("log");
        List<Log> list = logService.selectLogByUserid(userid, page, pageSize);//根据用户分页
        int count = logService.selectCountByUserid(userid, pageSize);
        view.addObject("list", list);
        view.addObject("count", count);
        return view;
    }

    @RequestMapping(value="searchLogToAdmin")
    public ModelAndView searchLogToAdmin(@RequestParam(value = "userId", required = false) String userId,
                                         @RequestParam(defaultValue = "1") int page, HttpSession session){

        if(userId != null){
            session.setAttribute("userId", userId);
        }else {
            userId = (String) session.getAttribute("userId");
        }
        int pageSize = 5;
        ModelAndView view = new ModelAndView("log");
        List<Log> list = logService.selectLogByUserid(userId, page, pageSize);//根据用户分页
        int count = logService.selectCountByUserid(userId, pageSize);
        view.addObject("userId", userId);
        view.addObject("list", list);
        view.addObject("count", count);
        return view;
    }

    @RequestMapping(value = "selectAllToAdmin")
    public ModelAndView selectAllToAdmin(@RequestParam(defaultValue = "1") int page){
        int pageSize = 5;
        ModelAndView view = new ModelAndView("log");
        List<Log> list = logService.selectAll(page, pageSize);
        int count = logService.selectCount(pageSize);
        view.addObject("list", list);
        view.addObject("count", count);
        return view;
    }

    @RequestMapping(value = "{id}/deleteLog")
    public ModelAndView deleteLog(@PathVariable("id") String id, HttpSession session){
        logService.delete(id);
        ModelAndView view = new ModelAndView();
        if(session.getAttribute("userId")!=null){
            view = searchLogToAdmin((String)session.getAttribute("userId"), 1, session);
            return view;
        }else {
            view = selectAllToAdmin(1);
            return view;
        }
    }
}
