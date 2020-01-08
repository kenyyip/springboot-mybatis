package com.keny.controller;

import com.alibaba.fastjson.JSON;
import com.keny.pager.Page;
import com.keny.service.DossiersService;
import com.keny.entity.Dossiers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/dossiers")
public class DossiersController {

    @Autowired
    private DossiersService dossiersService;

    /**
     * http://localhost:8080/mybatis_spring_springmvc/dossiersController/showDossiers/1.do
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/get/{id}")
    public String get(@PathVariable Long id, HttpServletRequest request) {
        Dossiers obj = dossiersService.getById(id);
        log.debug("名称：{}", obj.getName());
        request.setAttribute("o", obj);
        return "show";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Page<Dossiers> list(@RequestBody Map<String, Object> params) {
        Page<Dossiers> obj = dossiersService.findByParamPage(params);
        log.debug(JSON.toJSON(obj).toString());
        return obj;
    }

}
