/****************************************************
 * Description: Controller for ${Title}管理
 * Copyright:   Copyright (c) 2019
 * Company:     beiwaionline
 * @author      bfsu
 * @version     1.0
 * @see
 *  ${Date} bfsu Create File
 **************************************************/
package ${BasePackageName}${ControllerPackageName};

import ${BasePackageName}${EntityPackageName}.${ClassName};
import ${BasePackageName}${ServicePackageName}.${ClassName}Service;
import org.apache.commons.collections.CollectionUtils;
import com.bfsuol.lms2014.bas.BasConstants;
import com.bfsuolcomponents.log.BfsuolLogger;
import com.bfsuolcomponents.security.annotations.*;
import com.bfsuolframework.core.controller.LoginInfo;
import com.bfsuolframework.core.controller.SpringControllerSupport;
import com.bfsuolframework.core.controller.json.MessageJson;
import com.bfsuolframework.core.controller.support.DefaultQueryParam;
import com.bfsuolframework.core.controller.support.Pagination;
import com.bfsuolframework.core.controller.support.QueryParam;
import com.bfsuolframework.core.exception.ValidationException;
import com.bfsuolframework.core.spring.QueryParameter;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Author ${Author}
 * Date  ${Date}
 */
@Controller
@RequestMapping(value = "/${ParentPath}/${EntityName}")
public class ${ClassName}Controller extends SpringControllerSupport{
    @Autowired
    private ${ClassName}Service ${EntityName}Service;

    @SecPrivilege(title="${Title}管理")
    @RequestMapping("/index")
    public String index(Model model){
        return getViewNamedPath("index");
    }
    @SecList
    @RequestMapping("/list")
    public String list(
            @QueryParameter("query") QueryParam query,
            @ModelAttribute("page") Pagination page){

        page = ${EntityName}Service.getPage(query, page);

        return getViewNamedPath("list");
    }
    @SecCreate(title="添加${Title}")
    @RequestMapping("/input")
    public String create(@ModelAttribute ${ClassName} ${EntityName}, Model model){

        return getViewNamedPath("input");
    }
    @SecEdit(title="修改${Title}")
    @RequestMapping("/input/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        ${ClassName} ${EntityName} = this.${EntityName}Service.getById(id);
        model.addAttribute(${EntityName});

        return getViewNamedPath("input");
    }
    @RequestMapping("/save")
    public @ResponseBody MessageJson save(@ModelAttribute ${ClassName} ${EntityName}){
        LoginInfo loginInfo = super.getLoginInfo();
        //校验
        validateSave(${EntityName});
        this.${EntityName}Service.saveOrUpdatePro(${EntityName},loginInfo);

        return MessageJson.information("保存成功");
    }

    /**
    * 数据校验
    **/
    private void validateSave(${ClassName} ${EntityName}){
        //必填项校验
        if(${EntityName}.getId() == null){
            throw new ValidationException("请选择${Title}");
        }
        QueryParam query = new DefaultQueryParam();
        if(${EntityName}.getId()!=null && ${EntityName}.getId() > 0){
        query.addQuery("id!ne@l", ${EntityName}.getId());
        }
        query.addQuery("title!eq@s", ${EntityName}.getTitle());
        List<${ClassName}> ${EntityName}List = this.${EntityName}Service.findAll(query);
            if(CollectionUtils.isNotEmpty(${EntityName}List)){
            throw new ValidationException("${Title}名称已经存在");
        }
    }
    @SecDelete
    @RequestMapping("/delete/{id}")
    public @ResponseBody MessageJson delete(@PathVariable("id") Long id){
        if(${EntityName}Service.isDeletable(id)){
            this.${EntityName}Service.delete(id);
            BfsuolLogger.data("${Title}删除，","${Title}id:"+id);
        }
        return MessageJson.information("成功删除1条");
    }

    @SecDelete
    @RequestMapping("/delete")
    public @ResponseBody MessageJson delete(@RequestParam("ids") Long[] ids){
        if(ids == null || ids.length == 0){
            return MessageJson.error("没有删除");
        }
        for(Long id : ids){
            if(${EntityName}Service.isDeletable(id)){
                ${EntityName}Service.delete(id);
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<ids.length;i++) {
            if(i==0) {
                sb.append(ids[i]);
            }else {
                sb.append(","+ids[i]);
            }
        }
        BfsuolLogger.data("批量删除${Title}，","${Title}ids:"+sb.toString()+"，数量:"+ids.length);
        return MessageJson.information("成功删除"+ids.length+"条");
    }
    /**
     * 下载
    **/
    @SecFunction(code = "down",title = "下载")
    @RequestMapping("/down/{fileId}")
    public void down(@PathVariable("fileId")Long fileId,
                     HttpServletRequest request,HttpServletResponse response){

        FileManager fileManager = fileManagerService.getById(fileId);
        try {
            DownloadUtils.downloadByFilePath(response,request,fileManager.getFilePath(),fileManager.getFileTitle(),false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 导出
    **/
    @SecFunction(code = "exportList",title = "导出列表")
    @RequestMapping("/exportList")
    public void exportList(@QueryParameter("query")QueryParam query,
                           HttpServletResponse response){
        LoginInfo loginInfo = getLoginInfo();
        List<${ClassName}> all = this.${EntityName}Service.findAll(query);
        LinkedHashMap<String,String> map = new LinkedHashMap<String, String>();
        map.put("semester.title" ,"学期");
        map.put("learner.baseUser.UserName" ,"姓名");
        map.put("learner.cardNum" ,"证件号码");
        map.put("checkStatus" ,"审核状态");
        map.put("checkTime" ,"审核时间");
        map.put("checkUserName","审核人");
        List<String> listZidian = new ArrayList<String>();
        listZidian.add("checkStatus");
        Excel2007Util.write(all, response,map,listZidian);
        BfsuolLogger.data("导出免考学生列表，操作人：",loginInfo.getUserName());
    }
}
