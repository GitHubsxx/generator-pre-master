/****************************************************
 * Description: Controller for ${Title}管理
 * Copyright:   Copyright (c) 2019
 * Company:     beiwaionline
 * @author      bfsu
 * @version     1.0
 * @see
 *  ${Date} bfsu Create File
 **************************************************/
package ${BasePackageName}${ServicePackageName};

import ${BasePackageName}${DaoPackageName}.${ClassName}DAO;
import ${BasePackageName}${EntityPackageName}.${ClassName};
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bfsuol.lms2014.common.Constants;
import com.bfsuolcomponents.log.BfsuolLogger;
import com.bfsuolframework.core.controller.LoginInfo;
import com.bfsuolframework.core.controller.json.MessageJson;
import com.bfsuolframework.core.exception.ValidationException;
import com.bfsuolframework.core.service.ServiceSupport;
import com.bfsuolframework.core.exception.BusinessException;

import java.util.List;

/**
* Author ${Author}
* Date  ${Date}
*/
@Service
public class ${ClassName}ServiceImpl extends ServiceSupport<${ClassName}> implements ${ClassName}Service{
    @Autowired
    private ${ClassName}DAO ${EntityName}DAO;

    @Override
	public ${ClassName}DAO getDao() {
	    return ${EntityName}DAO;
	}
    /**
	 * 是否可以删除
	 * @param ${EntityName}Id 主键
	 * @return 是否可以删除
	 */
    public boolean isDeletable(Long ${EntityName}Id){
		return true;
	}

    /**
	 * 保存或修改
	 * @param ${EntityName}
	 * @param loginInfo
	 */
    @Override
	public void saveOrUpdatePro(${ClassName} ${EntityName}, LoginInfo loginInfo){
            try{
                if(${EntityName}.isNew()){
                    ${EntityName}.setCreateUserId(loginInfo.getUserId());
                    ${EntityName}.setCreateUserName(loginInfo.getUserName());
                    ${EntityName}.setCreateTime(new Date());
                    this.${EntityName}DAO.save(${EntityName});
                    BfsuolLogger.data("新增${ClassName}，","新增的id为："+${EntityName}.getId()+"，创建人姓名:"+loginInfo.getUserName()+",创建时间："+new Date());
                }else {
                    ${ClassName} ${EntityName}_ = this.${EntityName}DAO.getById(${EntityName}.getId());
                    if (${EntityName}_ == null){
                        throw new ValidationException("程序未知错误");
                    }
                    ${EntityName}_.setTitle(${EntityName}.getTitle());
                    ${EntityName}_.setUpdateUserId(loginInfo.getUserId());
                    ${EntityName}_.setUpdateUserName(loginInfo.getUserName());
                    ${EntityName}_.setUpdateTime(new Date());
                    this.${EntityName}DAO.update(${EntityName}_);
                    BfsuolLogger.data("更新${ClassName}，","更新的id为："+${EntityName}.getId()+"，更新人姓名:"+loginInfo.getUserName()+",更新时间："+new Date());
                }

            }catch (Exception e){
                e.printStackTrace();
                throw new BusinessException("保存失败");
             }
        }

}
