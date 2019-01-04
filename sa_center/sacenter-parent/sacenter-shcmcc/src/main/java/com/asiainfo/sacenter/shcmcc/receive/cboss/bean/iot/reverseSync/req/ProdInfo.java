/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.4</a>, using an
 * XML Schema.
 * $Id$
 */

package com.asiainfo.sacenter.shcmcc.receive.cboss.bean.iot.reverseSync.req;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Vector;

/**
 * 原子产品信息
 * 
 * @version $Revision$ $Date$
**/
public class ProdInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 原子产品编码
    **/
    private java.lang.String _prodID;

    /**
     * 归属产品包编�?
    **/
    private java.lang.String _pkgProdID;

    /**
     * 产品订购实例唯一标识
    **/
    private java.lang.String _prodInstID;

    /**
     * 产品订购实例生效时间
    **/
    private java.lang.String _prodInstEffTime;

    /**
     * 产品订购实例失效时间
    **/
    private java.lang.String _prodInstExpTime;

    /**
     * 操作类型
    **/
    private java.lang.String _operType;

    /**
     * 产品的附加属�?
    **/
    private java.util.Vector _prodAttrInfoList;

    /**
     * 服务的附加属�?
    **/
    private java.util.Vector _serviceAttrInfoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ProdInfo() {
        super();
        _prodAttrInfoList = new Vector();
        _serviceAttrInfoList = new Vector();
    } //-- ProdInfo()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vProdAttrInfo
    **/
    public void addProdAttrInfo(ProdAttrInfo vProdAttrInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _prodAttrInfoList.addElement(vProdAttrInfo);
    } //-- void addProdAttrInfo(ProdAttrInfo) 

    /**
     * 
     * 
     * @param index
     * @param vProdAttrInfo
    **/
    public void addProdAttrInfo(int index, ProdAttrInfo vProdAttrInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _prodAttrInfoList.insertElementAt(vProdAttrInfo, index);
    } //-- void addProdAttrInfo(int, ProdAttrInfo) 

    /**
     * 
     * 
     * @param vServiceAttrInfo
    **/
    public void addServiceAttrInfo(ServiceAttrInfo vServiceAttrInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _serviceAttrInfoList.addElement(vServiceAttrInfo);
    } //-- void addServiceAttrInfo(ServiceAttrInfo) 

    /**
     * 
     * 
     * @param index
     * @param vServiceAttrInfo
    **/
    public void addServiceAttrInfo(int index, ServiceAttrInfo vServiceAttrInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _serviceAttrInfoList.insertElementAt(vServiceAttrInfo, index);
    } //-- void addServiceAttrInfo(int, ServiceAttrInfo) 

    /**
    **/
    public java.util.Enumeration enumerateProdAttrInfo()
    {
        return _prodAttrInfoList.elements();
    } //-- java.util.Enumeration enumerateProdAttrInfo() 

    /**
    **/
    public java.util.Enumeration enumerateServiceAttrInfo()
    {
        return _serviceAttrInfoList.elements();
    } //-- java.util.Enumeration enumerateServiceAttrInfo() 

    /**
     * Returns the value of field 'operType'. The field 'operType'
     * has the following description: 操作类型
     * 
     * @return the value of field 'operType'.
    **/
    public java.lang.String getOperType()
    {
        return this._operType;
    } //-- java.lang.String getOperType() 

    /**
     * Returns the value of field 'pkgProdID'. The field
     * 'pkgProdID' has the following description: 归属产品包编�?
     * 
     * @return the value of field 'pkgProdID'.
    **/
    public java.lang.String getPkgProdID()
    {
        return this._pkgProdID;
    } //-- java.lang.String getPkgProdID() 

    /**
     * 
     * 
     * @param index
    **/
    public ProdAttrInfo getProdAttrInfo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _prodAttrInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (ProdAttrInfo) _prodAttrInfoList.elementAt(index);
    } //-- ProdAttrInfo getProdAttrInfo(int) 

    /**
    **/
    public ProdAttrInfo[] getProdAttrInfo()
    {
        int size = _prodAttrInfoList.size();
        ProdAttrInfo[] mArray = new ProdAttrInfo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (ProdAttrInfo) _prodAttrInfoList.elementAt(index);
        }
        return mArray;
    } //-- ProdAttrInfo[] getProdAttrInfo() 

    /**
    **/
    public int getProdAttrInfoCount()
    {
        return _prodAttrInfoList.size();
    } //-- int getProdAttrInfoCount() 

    /**
     * Returns the value of field 'prodID'. The field 'prodID' has
     * the following description: 原子产品编码
     * 
     * @return the value of field 'prodID'.
    **/
    public java.lang.String getProdID()
    {
        return this._prodID;
    } //-- java.lang.String getProdID() 

    /**
     * Returns the value of field 'prodInstEffTime'. The field
     * 'prodInstEffTime' has the following description:
     * 产品订购实例生效时间
     * 
     * @return the value of field 'prodInstEffTime'.
    **/
    public java.lang.String getProdInstEffTime()
    {
        return this._prodInstEffTime;
    } //-- java.lang.String getProdInstEffTime() 

    /**
     * Returns the value of field 'prodInstExpTime'. The field
     * 'prodInstExpTime' has the following description:
     * 产品订购实例失效时间
     * 
     * @return the value of field 'prodInstExpTime'.
    **/
    public java.lang.String getProdInstExpTime()
    {
        return this._prodInstExpTime;
    } //-- java.lang.String getProdInstExpTime() 

    /**
     * Returns the value of field 'prodInstID'. The field
     * 'prodInstID' has the following description: 产品订购实例唯一标识
     * 
     * @return the value of field 'prodInstID'.
    **/
    public java.lang.String getProdInstID()
    {
        return this._prodInstID;
    } //-- java.lang.String getProdInstID() 

    /**
     * 
     * 
     * @param index
    **/
    public ServiceAttrInfo getServiceAttrInfo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _serviceAttrInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (ServiceAttrInfo) _serviceAttrInfoList.elementAt(index);
    } //-- ServiceAttrInfo getServiceAttrInfo(int) 

    /**
    **/
    public ServiceAttrInfo[] getServiceAttrInfo()
    {
        int size = _serviceAttrInfoList.size();
        ServiceAttrInfo[] mArray = new ServiceAttrInfo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (ServiceAttrInfo) _serviceAttrInfoList.elementAt(index);
        }
        return mArray;
    } //-- ServiceAttrInfo[] getServiceAttrInfo() 

    /**
    **/
    public int getServiceAttrInfoCount()
    {
        return _serviceAttrInfoList.size();
    } //-- int getServiceAttrInfoCount() 

    /**
    **/

    /**
     * 
     * 
     * @param out
    **/


    /**
     * 
     * 
     * @param handler
    **/


    /**
    **/
    public void removeAllProdAttrInfo()
    {
        _prodAttrInfoList.removeAllElements();
    } //-- void removeAllProdAttrInfo() 

    /**
    **/
    public void removeAllServiceAttrInfo()
    {
        _serviceAttrInfoList.removeAllElements();
    } //-- void removeAllServiceAttrInfo() 

    /**
     * 
     * 
     * @param index
    **/
    public ProdAttrInfo removeProdAttrInfo(int index)
    {
        java.lang.Object obj = _prodAttrInfoList.elementAt(index);
        _prodAttrInfoList.removeElementAt(index);
        return (ProdAttrInfo) obj;
    } //-- ProdAttrInfo removeProdAttrInfo(int) 

    /**
     * 
     * 
     * @param index
    **/
    public ServiceAttrInfo removeServiceAttrInfo(int index)
    {
        java.lang.Object obj = _serviceAttrInfoList.elementAt(index);
        _serviceAttrInfoList.removeElementAt(index);
        return (ServiceAttrInfo) obj;
    } //-- ServiceAttrInfo removeServiceAttrInfo(int) 

    /**
     * Sets the value of field 'operType'. The field 'operType' has
     * the following description: 操作类型
     * 
     * @param operType the value of field 'operType'.
    **/
    public void setOperType(java.lang.String operType)
    {
        this._operType = operType;
    } //-- void setOperType(java.lang.String) 

    /**
     * Sets the value of field 'pkgProdID'. The field 'pkgProdID'
     * has the following description: 归属产品包编�?
     * 
     * @param pkgProdID the value of field 'pkgProdID'.
    **/
    public void setPkgProdID(java.lang.String pkgProdID)
    {
        this._pkgProdID = pkgProdID;
    } //-- void setPkgProdID(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vProdAttrInfo
    **/
    public void setProdAttrInfo(int index, ProdAttrInfo vProdAttrInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _prodAttrInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _prodAttrInfoList.setElementAt(vProdAttrInfo, index);
    } //-- void setProdAttrInfo(int, ProdAttrInfo) 

    /**
     * 
     * 
     * @param prodAttrInfoArray
    **/
    public void setProdAttrInfo(ProdAttrInfo[] prodAttrInfoArray)
    {
        //-- copy array
        _prodAttrInfoList.removeAllElements();
        for (int i = 0; i < prodAttrInfoArray.length; i++) {
            _prodAttrInfoList.addElement(prodAttrInfoArray[i]);
        }
    } //-- void setProdAttrInfo(ProdAttrInfo) 

    /**
     * Sets the value of field 'prodID'. The field 'prodID' has the
     * following description: 原子产品编码
     * 
     * @param prodID the value of field 'prodID'.
    **/
    public void setProdID(java.lang.String prodID)
    {
        this._prodID = prodID;
    } //-- void setProdID(java.lang.String) 

    /**
     * Sets the value of field 'prodInstEffTime'. The field
     * 'prodInstEffTime' has the following description:
     * 产品订购实例生效时间
     * 
     * @param prodInstEffTime the value of field 'prodInstEffTime'.
    **/
    public void setProdInstEffTime(java.lang.String prodInstEffTime)
    {
        this._prodInstEffTime = prodInstEffTime;
    } //-- void setProdInstEffTime(java.lang.String) 

    /**
     * Sets the value of field 'prodInstExpTime'. The field
     * 'prodInstExpTime' has the following description:
     * 产品订购实例失效时间
     * 
     * @param prodInstExpTime the value of field 'prodInstExpTime'.
    **/
    public void setProdInstExpTime(java.lang.String prodInstExpTime)
    {
        this._prodInstExpTime = prodInstExpTime;
    } //-- void setProdInstExpTime(java.lang.String) 

    /**
     * Sets the value of field 'prodInstID'. The field 'prodInstID'
     * has the following description: 产品订购实例唯一标识
     * 
     * @param prodInstID the value of field 'prodInstID'.
    **/
    public void setProdInstID(java.lang.String prodInstID)
    {
        this._prodInstID = prodInstID;
    } //-- void setProdInstID(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vServiceAttrInfo
    **/
    public void setServiceAttrInfo(int index, ServiceAttrInfo vServiceAttrInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _serviceAttrInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _serviceAttrInfoList.setElementAt(vServiceAttrInfo, index);
    } //-- void setServiceAttrInfo(int, ServiceAttrInfo) 

    /**
     * 
     * 
     * @param serviceAttrInfoArray
    **/
    public void setServiceAttrInfo(ServiceAttrInfo[] serviceAttrInfoArray)
    {
        //-- copy array
        _serviceAttrInfoList.removeAllElements();
        for (int i = 0; i < serviceAttrInfoArray.length; i++) {
            _serviceAttrInfoList.addElement(serviceAttrInfoArray[i]);
        }
    } //-- void setServiceAttrInfo(ServiceAttrInfo) 

    /**
     * 
     * 
     * @param reader
    **/


}
