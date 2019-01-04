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
 * 用户数据
 * 
 * @version $Revision$ $Date$
**/
public class PersonInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 本次操作的流�?
    **/
    private java.lang.String _oprSeq;

    /**
     * 操作时间
    **/
    private java.lang.String _oprTime;

    /**
     * 本业务信息的操作编码
    **/
    private java.lang.String _oprCode;

    /**
     * 用户ID
    **/
    private java.lang.String _subsID;

    /**
     * 终端MSISDN
    **/
    private java.lang.String _mobNum;

    /**
     * 原子产品信息
    **/
    private java.util.Vector _prodInfoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public PersonInfo() {
        super();
        _prodInfoList = new Vector();
    } //-- PersonInfo()


      //-----------/
     //- Methods -/
    //-----------/

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
    public java.util.Enumeration enumerateProdInfo()
    {
        return _prodInfoList.elements();
    } //-- java.util.Enumeration enumerateProdInfo() 

    /**
     * Returns the value of field 'mobNum'. The field 'mobNum' has
     * the following description: 终端MSISDN
     * 
     * @return the value of field 'mobNum'.
    **/
    public java.lang.String getMobNum()
    {
        return this._mobNum;
    } //-- java.lang.String getMobNum() 

    /**
     * Returns the value of field 'oprCode'. The field 'oprCode'
     * has the following description: 本业务信息的操作编码
     * 
     * @return the value of field 'oprCode'.
    **/
    public java.lang.String getOprCode()
    {
        return this._oprCode;
    } //-- java.lang.String getOprCode() 

    /**
     * Returns the value of field 'oprSeq'. The field 'oprSeq' has
     * the following description: 本次操作的流�?
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
     * Returns the value of field 'subsID'. The field 'subsID' has
     * the following description: 用户ID
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
    public void removeAllProdInfo()
    {
        _prodInfoList.removeAllElements();
    } //-- void removeAllProdInfo() 

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
     * Sets the value of field 'mobNum'. The field 'mobNum' has the
     * following description: 终端MSISDN
     * 
     * @param mobNum the value of field 'mobNum'.
    **/
    public void setMobNum(java.lang.String mobNum)
    {
        this._mobNum = mobNum;
    } //-- void setMobNum(java.lang.String) 

    /**
     * Sets the value of field 'oprCode'. The field 'oprCode' has
     * the following description: 本业务信息的操作编码
     * 
     * @param oprCode the value of field 'oprCode'.
    **/
    public void setOprCode(java.lang.String oprCode)
    {
        this._oprCode = oprCode;
    } //-- void setOprCode(java.lang.String) 

    /**
     * Sets the value of field 'oprSeq'. The field 'oprSeq' has the
     * following description: 本次操作的流�?
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
     * Sets the value of field 'subsID'. The field 'subsID' has the
     * following description: 用户ID
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
