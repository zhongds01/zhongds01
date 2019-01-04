package com.asiainfo.sacenter.audit.bo;

import java.util.Map;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.ResultSet;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;
import com.ai.appframe2.bo.DataContainerFactory;

import com.asiainfo.sacenter.audit.ivalues.IBOISAEQUIPMENTNEWValue;

public class BOISAEQUIPMENTNEWEngine {

  public static BOISAEQUIPMENTNEWBean[] getBeans(DataContainerInterface dc) throws
      Exception {
    Map ps = dc.getProperties();
    StringBuffer buffer = new StringBuffer();
    Map pList = new HashMap();
    for (java.util.Iterator cc = ps.entrySet().iterator(); cc.hasNext(); ) {
      Map.Entry e = (Map.Entry) cc.next();
      if(buffer.length() >0)
	 buffer.append(" and ");
      buffer.append(e.getKey().toString() + " = :p_" + e.getKey().toString());
      pList.put("p_" + e.getKey().toString(),e.getValue());
    }
    Connection conn = ServiceManager.getSession().getConnection();
    try {
      return getBeans(buffer.toString(), pList);
    }finally{
      if (conn != null)
	conn.close();
    }
  }

  
  public static  BOISAEQUIPMENTNEWBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  BOISAEQUIPMENTNEWBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    Map param = null;
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
      param = sql.getParameters();
    }
    return (BOISAEQUIPMENTNEWBean[])getBeans(cols,condition,param,startNum,endNum,isShowFK);
  }




  public static  BOISAEQUIPMENTNEWBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  BOISAEQUIPMENTNEWBean[] getBeans(String[] cols,String condition,Map parameter,
	   int startNum,int endNum,boolean isShowFK) throws Exception{
	Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
		return (BOISAEQUIPMENTNEWBean[])ServiceManager.getDataStore().retrieve(conn,BOISAEQUIPMENTNEWBean.class,BOISAEQUIPMENTNEWBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
	}catch(Exception e){
		throw e;
	}finally{
	   if (conn != null)
	      conn.close();
	}
  }

   public static  BOISAEQUIPMENTNEWBean[] getBeans(String[] cols,String condition,Map parameter,
	  int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
	  Connection conn = null;
	  try {
		  conn = ServiceManager.getSession().getConnection();
		  return (BOISAEQUIPMENTNEWBean[])ServiceManager.getDataStore().retrieve(conn,BOISAEQUIPMENTNEWBean.class,BOISAEQUIPMENTNEWBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
	  }catch(Exception e){
		  throw e;
	  }finally{
		if (conn != null)
		  conn.close();
	  }
   }


   public static int getBeansCount(String condition,Map parameter) throws Exception{
     Connection conn = null;
      try {
	      conn = ServiceManager.getSession().getConnection();
	      return ServiceManager.getDataStore().retrieveCount(conn,BOISAEQUIPMENTNEWBean.getObjectTypeStatic(),condition,parameter,null);
      }catch(Exception e){
	      throw e;
      }finally{
	  if (conn != null)
	      conn.close();
      }
   }

   public static int getBeansCount(String condition,Map parameter,String[] extendBOAttrs) throws Exception{
	      Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
		return ServiceManager.getDataStore().retrieveCount(conn,BOISAEQUIPMENTNEWBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
	}catch(Exception e){
		throw e;
	}finally{
	  if (conn != null)
	      conn.close();
	}
   }

  public static void save( BOISAEQUIPMENTNEWBean aBean) throws Exception
  {
	  Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
		   ServiceManager.getDataStore().save(conn,aBean);
	   }catch(Exception e){
		throw e;
	}finally{
	  if (conn != null)
		  conn.close();
	}
  }

   public static  void save( BOISAEQUIPMENTNEWBean[] aBeans) throws Exception{
	     Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
		ServiceManager.getDataStore().save(conn,aBeans);
	}catch(Exception e){
		throw e;
	}finally{
	  if (conn != null)
	      conn.close();
	}
   }

   public static  void saveBatch( BOISAEQUIPMENTNEWBean[] aBeans) throws Exception{
	     Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
		ServiceManager.getDataStore().saveBatch(conn,aBeans);
	}catch(Exception e){
		throw e;
	}finally{
	  if (conn != null)
	      conn.close();
	}
   }


  public static  BOISAEQUIPMENTNEWBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
	  conn = ServiceManager.getSession().getConnection();
	  String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
	  resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
	  return (BOISAEQUIPMENTNEWBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BOISAEQUIPMENTNEWBean.class,BOISAEQUIPMENTNEWBean.getObjectTypeStatic(),resultset,null,true);
      }catch(Exception e){
	  throw e;
      }finally{
      if(resultset!=null)resultset.close();
	  if (conn != null)
	      conn.close();
      }
   }

     public static  BOISAEQUIPMENTNEWBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
	  conn = ServiceManager.getSession().getConnection();
	  resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
	  return (BOISAEQUIPMENTNEWBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(BOISAEQUIPMENTNEWBean.class,BOISAEQUIPMENTNEWBean.getObjectTypeStatic(),resultset,null,true);
      }catch(Exception e){
	  throw e;
      }finally{
      if(resultset!=null)resultset.close();
	  if (conn != null)
	      conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(BOISAEQUIPMENTNEWBean.getObjectTypeStatic());
   }


   public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(BOISAEQUIPMENTNEWBean.getObjectTypeStatic());
   }


   public static BOISAEQUIPMENTNEWBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (BOISAEQUIPMENTNEWBean)DataContainerFactory.wrap(source,BOISAEQUIPMENTNEWBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
	 throw new RuntimeException(e.getCause());
       else
	 throw new RuntimeException(e);
     }
   }
   public static BOISAEQUIPMENTNEWBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       BOISAEQUIPMENTNEWBean result = new BOISAEQUIPMENTNEWBean();
       DataContainerFactory.copy(source, result, colMatch);
       return result;
     }
     catch (AIException ex) {
       if(ex.getCause()!=null)
	 throw new RuntimeException(ex.getCause());
       else
	 throw new RuntimeException(ex);
     }
    }

   public static BOISAEQUIPMENTNEWBean transfer(IBOISAEQUIPMENTNEWValue value) {
	   if(value==null)
		   return null;
	try {
		if(value instanceof BOISAEQUIPMENTNEWBean){
			return (BOISAEQUIPMENTNEWBean)value;
		}
		BOISAEQUIPMENTNEWBean newBean = new BOISAEQUIPMENTNEWBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static BOISAEQUIPMENTNEWBean[] transfer(IBOISAEQUIPMENTNEWValue[] value) {
	   if(value==null || value.length==0)
		   return null;

	try {
		if(value instanceof BOISAEQUIPMENTNEWBean[]){
			return (BOISAEQUIPMENTNEWBean[])value;
		}
		BOISAEQUIPMENTNEWBean[] newBeans = new BOISAEQUIPMENTNEWBean[value.length];
		   for(int i=0;i<newBeans.length;i++){
			   newBeans[i] = new BOISAEQUIPMENTNEWBean();
			DataContainerFactory.transfer(value[i] ,newBeans[i]);
		}
		return newBeans;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }
  public static void save(IBOISAEQUIPMENTNEWValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IBOISAEQUIPMENTNEWValue[] aValues) throws Exception{
	  save(transfer(aValues));
   }

   public static  void saveBatch( IBOISAEQUIPMENTNEWValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
