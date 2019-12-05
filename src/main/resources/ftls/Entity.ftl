/****************************************************
 * Description: Controller for ${Title}管理
 * Copyright:   Copyright (c) 2019
 * Company:     beiwaionline
 * @author      sxx
 * @version     1.0
 * @see
 *  ${Date} sxx Create File
 **************************************************/
package ${BasePackageName}${EntityPackageName};

import java.util.Date;
import com.bfsuolframework.core.entity.Entity;
import com.bfsuolframework.core.entity.EntitySupport;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
* Author ${Author}
* Date  ${Date}
*/
public class ${ClassName} extends EntitySupport implements Entity {
    private static final long serialVersionUID = 1L;
    ${Properties}

    public ${ClassName}(){
    }

    ${Methods}

    /* (non-Javadoc)
	 * @see com.bfsuolframework.core.entity.EntitySupport#hashCode()
	 */
    public int hashCode() {
        return new HashCodeBuilder().append("${BasePackageName}${EntityPackageName}.${ClassName}").append(this.getId()).toHashCode();
    }
    /* (non-Javadoc)
     * @see com.bfsuolframework.core.entity.EntitySupport#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
    	if(null == obj) {
    		return false;
    	}
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        if (!(obj instanceof ${ClassName}))
            return false;
        final ${ClassName} that = (${ClassName})obj;
        return new EqualsBuilder().append(this.getId(), that.getId()).isEquals();
    }
    /* (non-Javadoc)
     * @see com.bfsuolframework.core.entity.EntitySupport#toString()
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("${BasePackageName}${EntityPackageName}.${ClassName}").append("ID="+this.getId()).toString();
    }

}