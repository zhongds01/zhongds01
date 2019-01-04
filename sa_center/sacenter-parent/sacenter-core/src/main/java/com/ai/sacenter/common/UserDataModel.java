package com.ai.sacenter.common;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.common.DBGFInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.set.FieldTypeSetDB;
import com.ai.appframe2.set.FieldTypeSetDBFactory;
import com.ai.appframe2.web.CustomProperty;
import com.ai.appframe2.web.HttpUtil;
import com.ai.sacenter.base.BasicFactory;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Copyright: Copyright (c) 2010-12-3</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UserDataModel extends com.ai.appframe2.web.tag.DefaultDataModel {
    private final static Log log = LogFactory.getLog( UserDataModel.class );
    protected String   conditionName;
    protected String   parametersName;
    protected String   setName;
    protected String[] boAttrCols;
    protected String   condition;
    protected java.util.HashMap paraList = new java.util.HashMap();
	public UserDataModel() {
		super();
	}
	/* (non-Javadoc)
	 * @see com.ai.appframe2.web.tag.DefaultDataModel#init(javax.servlet.ServletRequest, com.ai.appframe2.common.DBGFInterface)
	 */
	public void init(ServletRequest request, DBGFInterface gfInterface) throws Exception {
		setName = gfInterface.getSetname();
		boAttrCols = gfInterface.getBOAttrCols();
		if( conditionName != null ){
			condition = (String)request.getAttribute( conditionName );
			if ( condition == null ) {
		        condition = request.getParameter( conditionName);
		        if ( condition != null) condition = new String( condition.getBytes("ISO-8859-1"), "GBK" );
			}
		}
		StringBuilder aIConditiL = new StringBuilder();
		String aIOrderByL = null;
		aIConditiL.append(" 1 = 1 " );
		WebGernalProperty aIPropertyL = WebGernalProperty.getInstanceFromReader( (HttpServletRequest)request );
		for( java.util.Iterator itera = aIPropertyL.getProperties().entrySet().iterator() ; itera.hasNext() ; ){
			java.util.Map.Entry aIEntryL = (java.util.Map.Entry)itera.next();
			if( aIEntryL.getKey().equals( "ASCENDING" ) ){
				aIOrderByL = aIEntryL.getValue().toString();
			}
			else{
				String aIValueL[] = StringUtils.split( aIEntryL.getValue() != null?(String)aIEntryL.getValue():"", "," );
				if( aIValueL == null || aIValueL.length < 2 ) continue;
				if( aIValueL[0].equals( "equal" ) ){
					aIConditiL.append( " and ").append( (String)aIEntryL.getKey() ).append(" = :p_" ).append( (String)aIEntryL.getKey() );
					paraList.put( "p_" + (String)aIEntryL.getKey(), aIValueL[1] );
				}
				else if( aIValueL[0].equals( "like" ) ){
					aIConditiL.append( " and ").append( (String)aIEntryL.getKey() ).append(" like :p_" ).append( (String)aIEntryL.getKey() );
					paraList.put( "p_" + (String)aIEntryL.getKey(), "%"+aIValueL[1]+"%" );
				}
			}
		}
		if( this.condition != null ) aIConditiL.append(" " ).append( condition );
		if( aIOrderByL != null ) aIConditiL.append(" order by ").append( aIOrderByL );
		this.condition = aIConditiL.toString();
		if (log.isDebugEnabled()) log.debug( "defaultmodel additional conditions " + condition );
	}
	/* (non-Javadoc)
	 * @see com.ai.appframe2.web.tag.DefaultDataModel#init(java.lang.Object, com.ai.appframe2.common.DBGFInterface)
	 */
	public void init(Object conditionObj, DBGFInterface dbGFInterface) {
		java.util.HashMap map = (java.util.HashMap) conditionObj;
		setName = dbGFInterface.getSetname();
		boAttrCols = dbGFInterface.getBOAttrCols();
		condition = (String) map.get("condition");
		paraList = (java.util.HashMap) map.get("parameters");
	}
	/* (non-Javadoc)
	 * @see com.ai.appframe2.web.tag.DefaultDataModel#getConditionObject()
	 */
	public Object getConditionObject() {
		java.util.HashMap map = new java.util.HashMap();
	    map.put("condition", this.condition);
	    map.put("parameters", this.paraList);
	    return map;
	}
	/**
	 * 
	 */
	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}
	/**
	 * 
	 */
	public void setParametersName(String parametersName) {
		this.parametersName = parametersName;
	}
	/**
	 * 
	 * @param setName
	 * @return
	 * @throws Exception
	 */
	protected ObjectType getObjectType(String setName) throws Exception {
		FieldTypeSetDB fieldTypeSet = FieldTypeSetDBFactory.getFieldTypeSet(
				setName, true);
		String sBOName = fieldTypeSet.getBOName();
		return SessionManager.getObjectTypeFactory().getInstance(sBOName);
	}
	
	/* (non-Javadoc)
	 * @see com.ai.appframe2.web.tag.DefaultDataModel#count()
	 */
	public int count() throws Exception {
		return super.count();
	}
	/* (non-Javadoc)
	 * @see com.ai.appframe2.web.tag.DefaultDataModel#getGridData(int, int)
	 */
	public Object getGridData(int arg0, int arg1) throws Exception {
		return super.getGridData(arg0, arg1);
	}

	/* (non-Javadoc)
	 * @see com.ai.appframe2.web.tag.DefaultDataModel#getFormData()
	 */
	public Object getFormData() throws Exception {
		return super.getFormData();
	}

	/**
	 * 基础数据
	 * <p>Copyright: Copyright (c) 2010-12-3</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class BasisDataModel extends UserDataModel{
		public BasisDataModel(){
			super();
		}

		/* (non-Javadoc)
		 * @see com.ai.openframe.Webdesk.tag.DynamicDataModel#count()
		 */
		public int count() throws Exception {
			return BasicFactory.getIBaseSV().retrieveCount( getObjectType(setName) , condition, paraList);
		}

		/* (non-Javadoc)
		 * @see com.ai.openframe.Webdesk.tag.DynamicDataModel#getGridData(int, int)
		 */
		public Object getGridData(int startRowIndex, int endRowIndex) throws Exception {
			return BasicFactory.getIBaseSV().retrieve( getObjectType(setName), condition, paraList, boAttrCols, startRowIndex, endRowIndex);
		}

		/* (non-Javadoc)
		 * @see com.ai.openframe.Webdesk.tag.DynamicDataModel#getFormData()
		 */
		public Object getFormData() throws Exception {
			return BasicFactory.getIBaseSV().retrieve( getObjectType(setName), condition, paraList, boAttrCols, -1, -1);
		}
	}
	/**
	 * 
	 * <p>Title: openframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2010-12-3</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class WebGernalProperty {
	    private static final String PAGE_PARAM = "PARAM";
	    private java.util.HashMap map = new java.util.HashMap();
	    public WebGernalProperty(String strXml) throws Exception {
	    	if(StringUtils.isBlank( strXml )) return;
	    	initial(strXml);
	    }
	    /**
	     * 
	     * @param request
	     * @return
	     * @throws Exception
	     */
	    public static WebGernalProperty getInstanceFromReader(HttpServletRequest request) throws Exception {
	        String strXml = HttpUtil.getStringFromBufferedReader(request);
	        return new WebGernalProperty(strXml);
	    }
	    /**
	     * 
	     * @param request
	     * @return
	     * @throws Exception
	     */
	    public static WebGernalProperty getInstanceFromParam(HttpServletRequest request) throws Exception {
	        String strXml = request.getParameter(PAGE_PARAM);
	        return new WebGernalProperty(strXml);
	    }
	    /**
	     * 
	     * @param request
	     * @return
	     * @throws Exception
	     */
	    public static CustomProperty getCustomProperty(HttpServletRequest request) throws Exception {
	        String strXml = request.getParameter(PAGE_PARAM);
	        CustomProperty property = CustomProperty.getInstance();
	        property.initial(strXml);
	        return property;
	    }
	    /**
	     * 
	     * @param aName
	     * @return
	     */
	    public String get(String aName) {
	        if (map.containsKey(aName.toUpperCase()))  return (String) this.map.get(aName.toUpperCase());
	        return null;
	    }
	    /**
	     * 
	     * @param strStartsWith
	     * @return
	     * @throws Exception
	     */
	    public java.util.List getList(String strStartsWith) throws Exception {
	        String[] keys = (String[]) this.map.keySet().toArray(new String[0]);
	        java.util.List list = new java.util.ArrayList();
	        for (int i = 0; i < keys.length; i++) {
	            if (keys[i].startsWith(strStartsWith.toUpperCase()))  list.add(this.map.get(keys[i]));
	        }
	        return list;
	    }
	    /**
	     * 
	     * @return
	     */
	    public String[] values() {
	        return (String[]) this.map.values().toArray(new String[0]);
	    }
	    /**
	     * 
	     * @param strStartsWith
	     * @param a
	     * @return
	     * @throws Exception
	     */
	    public java.math.BigDecimal[] values(String strStartsWith,java.math.BigDecimal[] a) throws Exception{
	        java.util.List list = getList(strStartsWith);
	        a = (java.math.BigDecimal[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), list.size());
	        for (int i = 0; i < list.size(); i++) {
	            a[i] = java.math.BigDecimal.valueOf(Long.parseLong((String) list.get(i)));
	        }
	        return a;
	    }
	    /**
	     * 
	     * @param strStartsWith
	     * @param a
	     * @return
	     * @throws Exception
	     */
	    public String[] values(String strStartsWith, String[] a) throws Exception {
	    	java.util.List list = getList(strStartsWith);
		    a = (String[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), list.size());
		    for (int i = 0; i < list.size(); i++) a[i] =(String) list.get(i);
		    return a;
		}
	    /**
	     * 
	     * @param strStartsWith
	     * @param a
	     * @return
	     * @throws Exception
	     */
	    public long[] values(String strStartsWith,long[] a) throws Exception{
	        java.util.List list = getList(strStartsWith);
	        a = (long[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), list.size());
	        for (int i = 0; i < list.size(); i++) {
	            a[i] = Long.parseLong((String) list.get(i));
	        }
	        return a;
	    }
	    /**
	     * 
	     * @return
	     * @throws Exception
	     */
	    public java.util.Map getProperties() throws Exception{
	    	return this.map;
	    }
	    /**
	     * 
	     * @param xmlStr
	     * @throws Exception
	     */
	    private void initial(String xmlStr) throws Exception {
	        try {
	            org.dom4j.Element root = XmlUtils.parseXml( xmlStr );
	            if (!root.getName().equals("UD"))  throw new Exception("root name must be <UD>");
	            this.map.clear();
	            java.util.List list = root.elements("p");
	            for (int i = 0; i < list.size(); i++) {
	                String strKey = ((org.dom4j.Element) list.get(i)).attributeValue("n");
	                if (StringUtils.isNotEmpty(strKey)) 
	                    this.map.put(strKey.toUpperCase(), ((org.dom4j.Element) list.get(i)).getText());
	            }
	        }
	        catch (Exception ex) {	
	        	log.error("解析xml出错.xmlstr=" + xmlStr + ",ex=" + ex.getMessage());
	            throw ex;
	        }
	    }	
	}
}
