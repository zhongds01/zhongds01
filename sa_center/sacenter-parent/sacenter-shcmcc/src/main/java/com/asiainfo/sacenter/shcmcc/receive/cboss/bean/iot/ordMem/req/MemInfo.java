/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.4</a>, using an
 * XML Schema.
 * $Id$
 */

package com.asiainfo.sacenter.shcmcc.receive.cboss.bean.iot.ordMem.req;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.util.Vector;

/**
 * 用户数据
 * 
 * @version $Revision$ $Date$
**/
public class MemInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 本次操作的流水
    **/
    private java.lang.String _oprSeq;

    /**
     * 操作时间
    **/
    private java.lang.String _oprTime;

    /**
     * 操作编码
    **/
    private java.lang.String _oprCode;

    /**
     * 业务受理的渠道
    **/
    private java.lang.String _applyChannel;

    /**
     * 成员产品编码
    **/
    private java.lang.String _prodID;

    /**
     * 成员产品订购实例唯一标识
    **/
    private java.lang.String _prodInstID;

    /**
     * 成员的用户ID
    **/
    private java.lang.String _subsID;

    /**
     * 成员产品订购实例生效时间
    **/
    private java.lang.String _prodInstEffTime;

    /**
     * 成员产品订购实例失效时间
    **/
    private java.lang.String _prodInstExpTime;

    /**
     * ?产品信息
    **/
    private java.util.Vector _prodInfoList;

    /**
     * EC唯一标识
    **/
    private java.lang.String _customerNumber;

    /**
     * 企业产品订购实例唯一标识
    **/
    private java.lang.String _ECProdInstID;

    /**
     * EC企业产品实例对应的用户ID
    **/
    private java.lang.String _ECSubsID;

    /**
     * 销售省编码
    **/
    private java.lang.String _provinceID;

    /**
     * 其它信息
    **/
    private java.util.Vector _otherInfoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public MemInfo() {
        super();
        _prodInfoList = new Vector();
        _otherInfoList = new Vector();
    } //-- MemInfo()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vOtherInfo
    **/
    public void addOtherInfo(OtherInfo vOtherInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _otherInfoList.addElement(vOtherInfo);
    } //-- void addOtherInfo(OtherInfo) 

    /**
     * 
     * 
     * @param index
     * @param vOtherInfo
    **/
    public void addOtherInfo(int index, OtherInfo vOtherInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _otherInfoList.insertElementAt(vOtherInfo, index);
    } //-- void addOtherInfo(int, OtherInfo) 

    /**
     * 
     * 
     * @param vProdInfo
    **/
    public void addProdInfo(ProdInfo vProdInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _prodInfoList.addElement(vProdInfo);
    } //-- void addProdInfo(ProdInfo) 

    /**
     * 
     * 
     * @param index
     * @param vProdInfo
    **/
    public void addProdInfo(int index, ProdInfo vProdInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _prodInfoList.insertElementAt(vProdInfo, index);
    } //-- void addProdInfo(int, ProdInfo) 

    /**
    **/
    public java.util.Enumeration enumerateOtherInfo()
    {
        return _otherInfoList.elements();
    } //-- java.util.Enumeration enumerateOtherInfo() 

    /**
    **/
    public java.util.Enumeration enumerateProdInfo()
    {
        return _prodInfoList.elements();
    } //-- java.util.Enumeration enumerateProdInfo() 

    /**
     * Returns the value of field 'applyChannel'. The field
     * 'applyChannel' has the following description: 业务受理的渠道
     * 
     * @return the value of field 'applyChannel'.
    **/
    public java.lang.String getApplyChannel()
    {
        return this._applyChannel;
    } //-- java.lang.String getApplyChannel() 

    /**
     * Returns the value of field 'customerNumber'. The field
     * 'customerNumber' has the following description: EC唯一标识
     * 
     * @return the value of field 'customerNumber'.
    **/
    public java.lang.String getCustomerNumber()
    {
        return this._customerNumber;
    } //-- java.lang.String getCustomerNumber() 

    /**
     * Returns the value of field 'ECProdInstID'. The field
     * 'ECProdInstID' has the following description: 企业产品订购实例唯一标识
     * 
     * @return the value of field 'ECProdInstID'.
    **/
    public java.lang.String getECProdInstID()
    {
        return this._ECProdInstID;
    } //-- java.lang.String getECProdInstID() 

    /**
     * Returns the value of field 'ECSubsID'. The field 'ECSubsID'
     * has the following description: EC企业产品实例对应的用户ID
     * 
     * @return the value of field 'ECSubsID'.
    **/
    public java.lang.String getECSubsID()
    {
        return this._ECSubsID;
    } //-- java.lang.String getECSubsID() 

    /**
     * Returns the value of field 'oprCode'. The field 'oprCode'
     * has the following description: 操作编码
     * 
     * @return the value of field 'oprCode'.
    **/
    public java.lang.String getOprCode()
    {
        return this._oprCode;
    } //-- java.lang.String getOprCode() 

    /**
     * Returns the value of field 'oprSeq'. The field 'oprSeq' has
     * the following description: 本次操作的流水
     * 
     * @return the value of field 'oprSeq'.
    **/
    public java.lang.String getOprSeq()
    {
        return this._oprSeq;
    } //-- java.lang.String getOprSeq() 

    /**
     * Returns the value of field 'oprTime'. The field 'oprTime'
     * has the following description: 操作时间
     * 
     * @return the value of field 'oprTime'.
    **/
    public java.lang.String getOprTime()
    {
        return this._oprTime;
    } //-- java.lang.String getOprTime() 

    /**
     * 
     * 
     * @param index
    **/
    public OtherInfo getOtherInfo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _otherInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (OtherInfo) _otherInfoList.elementAt(index);
    } //-- OtherInfo getOtherInfo(int) 

    /**
    **/
    public OtherInfo[] getOtherInfo()
    {
        int size = _otherInfoList.size();
        OtherInfo[] mArray = new OtherInfo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (OtherInfo) _otherInfoList.elementAt(index);
        }
        return mArray;
    } //-- OtherInfo[] getOtherInfo() 

    /**
    **/
    public int getOtherInfoCount()
    {
        return _otherInfoList.size();
    } //-- int getOtherInfoCount() 

    /**
     * Returns the value of field 'prodID'. The field 'prodID' has
     * the following description: 成员产品编码
     * 
     * @return the value of field 'prodID'.
    **/
    public java.lang.String getProdID()
    {
        return this._prodID;
    } //-- java.lang.String getProdID() 

    /**
     * 
     * 
     * @param index
    **/
    public ProdInfo getProdInfo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _prodInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (ProdInfo) _prodInfoList.elementAt(index);
    } //-- ProdInfo getProdInfo(int) 

    /**
    **/
    public ProdInfo[] getProdInfo()
    {
        int size = _prodInfoList.size();
        ProdInfo[] mArray = new ProdInfo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (ProdInfo) _prodInfoList.elementAt(index);
        }
        return mArray;
    } //-- ProdInfo[] getProdInfo() 

    /**
    **/
    public int getProdInfoCount()
    {
        return _prodInfoList.size();
    } //-- int getProdInfoCount() 

    /**
     * Returns the value of field 'prodInstEffTime'. The field
     * 'prodInstEffTime' has the following description:
     * 成员产品订购实例生效时间
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
     * 成员产品订购实例失效时间
     * 
     * @return the value of field 'prodInstExpTime'.
    **/
    public java.lang.String getProdInstExpTime()
    {
        return this._prodInstExpTime;
    } //-- java.lang.String getProdInstExpTime() 

    /**
     * Returns the value of field 'prodInstID'. The field
     * 'prodInstID' has the following description: 成员产品订购实例唯一标识
     * 
     * @return the value of field 'prodInstID'.
    **/
    public java.lang.String getProdInstID()
    {
        return this._prodInstID;
    } //-- java.lang.String getProdInstID() 

    /**
     * Returns the value of field 'provinceID'. The field
     * 'provinceID' has the following description: 销售省编码
     * 
     * @return the value of field 'provinceID'.
    **/
    public java.lang.String getProvinceID()
    {
        return this._provinceID;
    } //-- java.lang.String getProvinceID() 

    /**
     * Returns the value of field 'subsID'. The field 'subsID' has
     * the following description: 成员的用户ID
     * 
     * @return the value of field 'subsID'.
    **/
    public java.lang.String getSubsID()
    {
        return this._subsID;
    } //-- java.lang.String getSubsID() 

    /**
    **/

    /**
     * 
     * 
     * @param handler
    **/

    /**
    **/
    public void removeAllOtherInfo()
    {
        _otherInfoList.removeAllElements();
    } //-- void removeAllOtherInfo() 

    /**
    **/
    public void removeAllProdInfo()
    {
        _prodInfoList.removeAllElements();
    } //-- void removeAllProdInfo() 

    /**
     * 
     * 
     * @param index
    **/
    public OtherInfo removeOtherInfo(int index)
    {
        java.lang.Object obj = _otherInfoList.elementAt(index);
        _otherInfoList.removeElementAt(index);
        return (OtherInfo) obj;
    } //-- OtherInfo removeOtherInfo(int) 

    /**
     * 
     * 
     * @param index
    **/
    public ProdInfo removeProdInfo(int index)
    {
        java.lang.Object obj = _prodInfoList.elementAt(index);
        _prodInfoList.removeElementAt(index);
        return (ProdInfo) obj;
    } //-- ProdInfo removeProdInfo(int) 

    /**
     * Sets the value of field 'applyChannel'. The field
     * 'applyChannel' has the following description: 业务受理的渠道
     * 
     * @param applyChannel the value of field 'applyChannel'.
    **/
    public void setApplyChannel(java.lang.String applyChannel)
    {
        this._applyChannel = applyChannel;
    } //-- void setApplyChannel(java.lang.String) 

    /**
     * Sets the value of field 'customerNumber'. The field
     * 'customerNumber' has the following description: EC唯一标识
     * 
     * @param customerNumber the value of field 'customerNumber'.
    **/
    public void setCustomerNumber(java.lang.String customerNumber)
    {
        this._customerNumber = customerNumber;
    } //-- void setCustomerNumber(java.lang.String) 

    /**
     * Sets the value of field 'ECProdInstID'. The field
     * 'ECProdInstID' has the following description: 企业产品订购实例唯一标识
     * 
     * @param ECProdInstID the value of field 'ECProdInstID'.
    **/
    public void setECProdInstID(java.lang.String ECProdInstID)
    {
        this._ECProdInstID = ECProdInstID;
    } //-- void setECProdInstID(java.lang.String) 

    /**
     * Sets the value of field 'ECSubsID'. The field 'ECSubsID' has
     * the following description: EC企业产品实例对应的用户ID
     * 
     * @param ECSubsID the value of field 'ECSubsID'.
    **/
    public void setECSubsID(java.lang.String ECSubsID)
    {
        this._ECSubsID = ECSubsID;
    } //-- void setECSubsID(java.lang.String) 

    /**
     * Sets the value of field 'oprCode'. The field 'oprCode' has
     * the following description: 操作编码
     * 
     * @param oprCode the value of field 'oprCode'.
    **/
    public void setOprCode(java.lang.String oprCode)
    {
        this._oprCode = oprCode;
    } //-- void setOprCode(java.lang.String) 

    /**
     * Sets the value of field 'oprSeq'. The field 'oprSeq' has the
     * following description: 本次操作的流水
     * 
     * @param oprSeq the value of field 'oprSeq'.
    **/
    public void setOprSeq(java.lang.String oprSeq)
    {
        this._oprSeq = oprSeq;
    } //-- void setOprSeq(java.lang.String) 

    /**
     * Sets the value of field 'oprTime'. The field 'oprTime' has
     * the following description: 操作时间
     * 
     * @param oprTime the value of field 'oprTime'.
    **/
    public void setOprTime(java.lang.String oprTime)
    {
        this._oprTime = oprTime;
    } //-- void setOprTime(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vOtherInfo
    **/
    public void setOtherInfo(int index, OtherInfo vOtherInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _otherInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _otherInfoList.setElementAt(vOtherInfo, index);
    } //-- void setOtherInfo(int, OtherInfo) 

    /**
     * 
     * 
     * @param otherInfoArray
    **/
    public void setOtherInfo(OtherInfo[] otherInfoArray)
    {
        //-- copy array
        _otherInfoList.removeAllElements();
        for (int i = 0; i < otherInfoArray.length; i++) {
            _otherInfoList.addElement(otherInfoArray[i]);
        }
    } //-- void setOtherInfo(OtherInfo) 

    /**
     * Sets the value of field 'prodID'. The field 'prodID' has the
     * following description: 成员产品编码
     * 
     * @param prodID the value of field 'prodID'.
    **/
    public void setProdID(java.lang.String prodID)
    {
        this._prodID = prodID;
    } //-- void setProdID(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vProdInfo
    **/
    public void setProdInfo(int index, ProdInfo vProdInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _prodInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _prodInfoList.setElementAt(vProdInfo, index);
    } //-- void setProdInfo(int, ProdInfo) 

    /**
     * 
     * 
     * @param prodInfoArray
    **/
    public void setProdInfo(ProdInfo[] prodInfoArray)
    {
        //-- copy array
        _prodInfoList.removeAllElements();
        for (int i = 0; i < prodInfoArray.length; i++) {
            _prodInfoList.addElement(prodInfoArray[i]);
        }
    } //-- void setProdInfo(ProdInfo) 

    /**
     * Sets the value of field 'prodInstEffTime'. The field
     * 'prodInstEffTime' has the following description:
     * 成员产品订购实例生效时间
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
     * 成员产品订购实例失效时间
     * 
     * @param prodInstExpTime the value of field 'prodInstExpTime'.
    **/
    public void setProdInstExpTime(java.lang.String prodInstExpTime)
    {
        this._prodInstExpTime = prodInstExpTime;
    } //-- void setProdInstExpTime(java.lang.String) 

    /**
     * Sets the value of field 'prodInstID'. The field 'prodInstID'
     * has the following description: 成员产品订购实例唯一标识
     * 
     * @param prodInstID the value of field 'prodInstID'.
    **/
    public void setProdInstID(java.lang.String prodInstID)
    {
        this._prodInstID = prodInstID;
    } //-- void setProdInstID(java.lang.String) 

    /**
     * Sets the value of field 'provinceID'. The field 'provinceID'
     * has the following description: 销售省编码
     * 
     * @param provinceID the value of field 'provinceID'.
    **/
    public void setProvinceID(java.lang.String provinceID)
    {
        this._provinceID = provinceID;
    } //-- void setProvinceID(java.lang.String) 

    /**
     * Sets the value of field 'subsID'. The field 'subsID' has the
     * following description: 成员的用户ID
     * 
     * @param subsID the value of field 'subsID'.
    **/
    public void setSubsID(java.lang.String subsID)
    {
        this._subsID = subsID;
    } //-- void setSubsID(java.lang.String) 

    /**
     * 
     * 
     * @param reader
    **/


}
