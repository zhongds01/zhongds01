/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.4</a>, using an
 * XML Schema.
 * $Id$
 */

package com.asiainfo.sacenter.shcmcc.receive.cboss.bean.iot.open.req;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Vector;

/**
 * ҵ����Ϣ
 * 
 * @version $Revision$ $Date$
**/
public class BizInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * ���β�����ˮ��
    **/
    @JSONField(name="sdf")
    private java.lang.String _oprSeq;

    /**
     * ����ʱ��
    **/

    private java.lang.String _oprTime;

    /**
     * ��ҵ����Ϣ�Ĳ�������
    **/
    private java.lang.String _oprCode;

    /**
     * ҵ�����������
    **/
    private java.lang.String _applyChannel;

    /**
     * ��ҵ��Ʒ����
    **/
    private java.lang.String _prodID;

    /**
     * ��ҵ��Ʒ����ʵ��Ψһ��ʶ
    **/
    private java.lang.String _prodInstID;

    /**
     * �û�Ψһ��ʶ
    **/
    private java.lang.String _subsID;

    /**
     * ��ҵ��Ʒ����ʵ����Чʱ��
    **/
    private java.lang.String _prodInstEffTime;

    /**
     * ��ҵ��Ʒ����ʵ��ʧЧʱ��
    **/
    private java.lang.String _prodInstExpTime;

    /**
     * ?��Ʒ��Ϣ
    **/
    private java.util.Vector _prodInfoList;

    /**
     * EC�����������Ϣ
    **/
    private ECBaseServCode _ECBaseServCode;

    /**
     * �������
    **/
    private java.lang.String _bizServCode;

    /**
     * ��������Ȩ��ʽ
    **/
    private java.lang.String _authMode;

    /**
     * ��ҵ��Ʒʵ����Ӧ����ҵ
    **/
    private java.lang.String _industryID;

    /**
     * �Ƿ�֧������ǩ��
    **/
    private java.lang.String _ISTextSign;

    /**
     * ȱʡǩ������
    **/
    private java.lang.String _defaultSignLang;

    /**
     * Ӣ������ǩ��
    **/
    private java.lang.String _textSignEn;

    /**
     * ��������ǩ��
    **/
    private java.lang.String _textSignZh;

    /**
     * ÿһλEC����Ա������Ϣ
    **/
    private java.util.Vector _mgrInfoList;

    /**
     * �û���Ϣ
    **/
    private java.util.Vector _subsInfoList;

    /**
     * ������Ϣ
    **/
    private java.util.Vector _otherInfoList;

    /**
     * ƽ̨���������ˮ
    **/
    private java.lang.String _platformOprSeq;


      //----------------/
     //- Constructors -/
    //----------------/

    public BizInfo() {
        super();
        _prodInfoList = new Vector();
        _mgrInfoList = new Vector();
        _subsInfoList = new Vector();
        _otherInfoList = new Vector();
    } //-- BizInfo()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vMgrInfo
    **/
    public void addMgrInfo(MgrInfo vMgrInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _mgrInfoList.addElement(vMgrInfo);
    } //-- void addMgrInfo(MgrInfo) 

    /**
     * 
     * 
     * @param index
     * @param vMgrInfo
    **/
    public void addMgrInfo(int index, MgrInfo vMgrInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _mgrInfoList.insertElementAt(vMgrInfo, index);
    } //-- void addMgrInfo(int, MgrInfo) 

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
     * 
     * 
     * @param vSubsInfo
    **/
    public void addSubsInfo(SubsInfo vSubsInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _subsInfoList.addElement(vSubsInfo);
    } //-- void addSubsInfo(SubsInfo) 

    /**
     * 
     * 
     * @param index
     * @param vSubsInfo
    **/
    public void addSubsInfo(int index, SubsInfo vSubsInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        _subsInfoList.insertElementAt(vSubsInfo, index);
    } //-- void addSubsInfo(int, SubsInfo) 

    /**
    **/
    public java.util.Enumeration enumerateMgrInfo()
    {
        return _mgrInfoList.elements();
    } //-- java.util.Enumeration enumerateMgrInfo() 

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
    **/
    public java.util.Enumeration enumerateSubsInfo()
    {
        return _subsInfoList.elements();
    } //-- java.util.Enumeration enumerateSubsInfo() 

    /**
     * Returns the value of field 'applyChannel'. The field
     * 'applyChannel' has the following description: ҵ�����������
     * 
     * @return the value of field 'applyChannel'.
    **/
    public java.lang.String getApplyChannel()
    {
        return this._applyChannel;
    } //-- java.lang.String getApplyChannel() 

    /**
     * Returns the value of field 'authMode'. The field 'authMode'
     * has the following description: ��������Ȩ��ʽ
     * 
     * @return the value of field 'authMode'.
    **/
    public java.lang.String getAuthMode()
    {
        return this._authMode;
    } //-- java.lang.String getAuthMode() 

    /**
     * Returns the value of field 'bizServCode'. The field
     * 'bizServCode' has the following description: �������
     * 
     * @return the value of field 'bizServCode'.
    **/
    public java.lang.String getBizServCode()
    {
        return this._bizServCode;
    } //-- java.lang.String getBizServCode() 

    /**
     * Returns the value of field 'defaultSignLang'. The field
     * 'defaultSignLang' has the following description: ȱʡǩ������
     * 
     * @return the value of field 'defaultSignLang'.
    **/
    public java.lang.String getDefaultSignLang()
    {
        return this._defaultSignLang;
    } //-- java.lang.String getDefaultSignLang() 

    /**
     * Returns the value of field 'ECBaseServCode'. The field
     * 'ECBaseServCode' has the following description: EC�����������Ϣ
     * 
     * @return the value of field 'ECBaseServCode'.
    **/
    public ECBaseServCode getECBaseServCode()
    {
        return this._ECBaseServCode;
    } //-- ECBaseServCode getECBaseServCode() 

    /**
     * Returns the value of field 'ISTextSign'. The field
     * 'ISTextSign' has the following description: �Ƿ�֧������ǩ��
     * 
     * @return the value of field 'ISTextSign'.
    **/
    public java.lang.String getISTextSign()
    {
        return this._ISTextSign;
    } //-- java.lang.String getISTextSign() 

    /**
     * Returns the value of field 'industryID'. The field
     * 'industryID' has the following description: ��ҵ��Ʒʵ����Ӧ����ҵ
     * 
     * @return the value of field 'industryID'.
    **/
    public java.lang.String getIndustryID()
    {
        return this._industryID;
    } //-- java.lang.String getIndustryID() 

    /**
     * 
     * 
     * @param index
    **/
    public MgrInfo getMgrInfo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _mgrInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (MgrInfo) _mgrInfoList.elementAt(index);
    } //-- MgrInfo getMgrInfo(int) 

    /**
    **/
    public MgrInfo[] getMgrInfo()
    {
        int size = _mgrInfoList.size();
        MgrInfo[] mArray = new MgrInfo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (MgrInfo) _mgrInfoList.elementAt(index);
        }
        return mArray;
    } //-- MgrInfo[] getMgrInfo() 

    /**
    **/
    public int getMgrInfoCount()
    {
        return _mgrInfoList.size();
    } //-- int getMgrInfoCount() 

    /**
     * Returns the value of field 'oprCode'. The field 'oprCode'
     * has the following description: ��ҵ����Ϣ�Ĳ�������
     * 
     * @return the value of field 'oprCode'.
    **/
    public java.lang.String getOprCode()
    {
        return this._oprCode;
    } //-- java.lang.String getOprCode() 

    /**
     * Returns the value of field 'oprSeq'. The field 'oprSeq' has
     * the following description: ���β�����ˮ��
     * 
     * @return the value of field 'oprSeq'.
    **/
    public java.lang.String getOprSeq()
    {
        return this._oprSeq;
    } //-- java.lang.String getOprSeq() 

    /**
     * Returns the value of field 'oprTime'. The field 'oprTime'
     * has the following description: ����ʱ��
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
     * Returns the value of field 'platformOprSeq'. The field
     * 'platformOprSeq' has the following description: ƽ̨���������ˮ
     * 
     * @return the value of field 'platformOprSeq'.
    **/
    public java.lang.String getPlatformOprSeq()
    {
        return this._platformOprSeq;
    } //-- java.lang.String getPlatformOprSeq() 

    /**
     * Returns the value of field 'prodID'. The field 'prodID' has
     * the following description: ��ҵ��Ʒ����
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
     * ��ҵ��Ʒ����ʵ����Чʱ��
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
     * ��ҵ��Ʒ����ʵ��ʧЧʱ��
     * 
     * @return the value of field 'prodInstExpTime'.
    **/
    public java.lang.String getProdInstExpTime()
    {
        return this._prodInstExpTime;
    } //-- java.lang.String getProdInstExpTime() 

    /**
     * Returns the value of field 'prodInstID'. The field
     * 'prodInstID' has the following description: ��ҵ��Ʒ����ʵ��Ψһ��ʶ
     * 
     * @return the value of field 'prodInstID'.
    **/
    public java.lang.String getProdInstID()
    {
        return this._prodInstID;
    } //-- java.lang.String getProdInstID() 

    /**
     * Returns the value of field 'subsID'. The field 'subsID' has
     * the following description: �û�Ψһ��ʶ
     * 
     * @return the value of field 'subsID'.
    **/
    public java.lang.String getSubsID()
    {
        return this._subsID;
    } //-- java.lang.String getSubsID() 

    /**
     * 
     * 
     * @param index
    **/
    public SubsInfo getSubsInfo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _subsInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (SubsInfo) _subsInfoList.elementAt(index);
    } //-- SubsInfo getSubsInfo(int) 

    /**
    **/
    public SubsInfo[] getSubsInfo()
    {
        int size = _subsInfoList.size();
        SubsInfo[] mArray = new SubsInfo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (SubsInfo) _subsInfoList.elementAt(index);
        }
        return mArray;
    } //-- SubsInfo[] getSubsInfo() 

    /**
    **/
    public int getSubsInfoCount()
    {
        return _subsInfoList.size();
    } //-- int getSubsInfoCount() 

    /**
     * Returns the value of field 'textSignEn'. The field
     * 'textSignEn' has the following description: Ӣ������ǩ��
     * 
     * @return the value of field 'textSignEn'.
    **/
    public java.lang.String getTextSignEn()
    {
        return this._textSignEn;
    } //-- java.lang.String getTextSignEn() 

    /**
     * Returns the value of field 'textSignZh'. The field
     * 'textSignZh' has the following description: ��������ǩ��
     * 
     * @return the value of field 'textSignZh'.
    **/
    public java.lang.String getTextSignZh()
    {
        return this._textSignZh;
    } //-- java.lang.String getTextSignZh() 

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
    public void removeAllMgrInfo()
    {
        _mgrInfoList.removeAllElements();
    } //-- void removeAllMgrInfo() 

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
    **/
    public void removeAllSubsInfo()
    {
        _subsInfoList.removeAllElements();
    } //-- void removeAllSubsInfo() 

    /**
     * 
     * 
     * @param index
    **/
    public MgrInfo removeMgrInfo(int index)
    {
        java.lang.Object obj = _mgrInfoList.elementAt(index);
        _mgrInfoList.removeElementAt(index);
        return (MgrInfo) obj;
    } //-- MgrInfo removeMgrInfo(int) 

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
     * 
     * 
     * @param index
    **/
    public SubsInfo removeSubsInfo(int index)
    {
        java.lang.Object obj = _subsInfoList.elementAt(index);
        _subsInfoList.removeElementAt(index);
        return (SubsInfo) obj;
    } //-- SubsInfo removeSubsInfo(int) 

    /**
     * Sets the value of field 'applyChannel'. The field
     * 'applyChannel' has the following description: ҵ�����������
     * 
     * @param applyChannel the value of field 'applyChannel'.
    **/
    public void setApplyChannel(java.lang.String applyChannel)
    {
        this._applyChannel = applyChannel;
    } //-- void setApplyChannel(java.lang.String) 

    /**
     * Sets the value of field 'authMode'. The field 'authMode' has
     * the following description: ��������Ȩ��ʽ
     * 
     * @param authMode the value of field 'authMode'.
    **/
    public void setAuthMode(java.lang.String authMode)
    {
        this._authMode = authMode;
    } //-- void setAuthMode(java.lang.String) 

    /**
     * Sets the value of field 'bizServCode'. The field
     * 'bizServCode' has the following description: �������
     * 
     * @param bizServCode the value of field 'bizServCode'.
    **/
    public void setBizServCode(java.lang.String bizServCode)
    {
        this._bizServCode = bizServCode;
    } //-- void setBizServCode(java.lang.String) 

    /**
     * Sets the value of field 'defaultSignLang'. The field
     * 'defaultSignLang' has the following description: ȱʡǩ������
     * 
     * @param defaultSignLang the value of field 'defaultSignLang'.
    **/
    public void setDefaultSignLang(java.lang.String defaultSignLang)
    {
        this._defaultSignLang = defaultSignLang;
    } //-- void setDefaultSignLang(java.lang.String) 

    /**
     * Sets the value of field 'ECBaseServCode'. The field
     * 'ECBaseServCode' has the following description: EC�����������Ϣ
     * 
     * @param ECBaseServCode the value of field 'ECBaseServCode'.
    **/
    public void setECBaseServCode(ECBaseServCode ECBaseServCode)
    {
        this._ECBaseServCode = ECBaseServCode;
    } //-- void setECBaseServCode(ECBaseServCode) 

    /**
     * Sets the value of field 'ISTextSign'. The field 'ISTextSign'
     * has the following description: �Ƿ�֧������ǩ��
     * 
     * @param ISTextSign the value of field 'ISTextSign'.
    **/
    public void setISTextSign(java.lang.String ISTextSign)
    {
        this._ISTextSign = ISTextSign;
    } //-- void setISTextSign(java.lang.String) 

    /**
     * Sets the value of field 'industryID'. The field 'industryID'
     * has the following description: ��ҵ��Ʒʵ����Ӧ����ҵ
     * 
     * @param industryID the value of field 'industryID'.
    **/
    public void setIndustryID(java.lang.String industryID)
    {
        this._industryID = industryID;
    } //-- void setIndustryID(java.lang.String) 

    /**
     * 
     * 
     * @param index
     * @param vMgrInfo
    **/
    public void setMgrInfo(int index, MgrInfo vMgrInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _mgrInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _mgrInfoList.setElementAt(vMgrInfo, index);
    } //-- void setMgrInfo(int, MgrInfo) 

    /**
     * 
     * 
     * @param mgrInfoArray
    **/
    public void setMgrInfo(MgrInfo[] mgrInfoArray)
    {
        //-- copy array
        _mgrInfoList.removeAllElements();
        for (int i = 0; i < mgrInfoArray.length; i++) {
            _mgrInfoList.addElement(mgrInfoArray[i]);
        }
    } //-- void setMgrInfo(MgrInfo) 

    /**
     * Sets the value of field 'oprCode'. The field 'oprCode' has
     * the following description: ��ҵ����Ϣ�Ĳ�������
     * 
     * @param oprCode the value of field 'oprCode'.
    **/
    public void setOprCode(java.lang.String oprCode)
    {
        this._oprCode = oprCode;
    } //-- void setOprCode(java.lang.String) 

    /**
     * Sets the value of field 'oprSeq'. The field 'oprSeq' has the
     * following description: ���β�����ˮ��
     * 
     * @param oprSeq the value of field 'oprSeq'.
    **/
    public void setOprSeq(java.lang.String oprSeq)
    {
        this._oprSeq = oprSeq;
    } //-- void setOprSeq(java.lang.String) 

    /**
     * Sets the value of field 'oprTime'. The field 'oprTime' has
     * the following description: ����ʱ��
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
     * Sets the value of field 'platformOprSeq'. The field
     * 'platformOprSeq' has the following description: ƽ̨���������ˮ
     * 
     * @param platformOprSeq the value of field 'platformOprSeq'.
    **/
    public void setPlatformOprSeq(java.lang.String platformOprSeq)
    {
        this._platformOprSeq = platformOprSeq;
    } //-- void setPlatformOprSeq(java.lang.String) 

    /**
     * Sets the value of field 'prodID'. The field 'prodID' has the
     * following description: ��ҵ��Ʒ����
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
     * ��ҵ��Ʒ����ʵ����Чʱ��
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
     * ��ҵ��Ʒ����ʵ��ʧЧʱ��
     * 
     * @param prodInstExpTime the value of field 'prodInstExpTime'.
    **/
    public void setProdInstExpTime(java.lang.String prodInstExpTime)
    {
        this._prodInstExpTime = prodInstExpTime;
    } //-- void setProdInstExpTime(java.lang.String) 

    /**
     * Sets the value of field 'prodInstID'. The field 'prodInstID'
     * has the following description: ��ҵ��Ʒ����ʵ��Ψһ��ʶ
     * 
     * @param prodInstID the value of field 'prodInstID'.
    **/
    public void setProdInstID(java.lang.String prodInstID)
    {
        this._prodInstID = prodInstID;
    } //-- void setProdInstID(java.lang.String) 

    /**
     * Sets the value of field 'subsID'. The field 'subsID' has the
     * following description: �û�Ψһ��ʶ
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
     * @param index
     * @param vSubsInfo
    **/
    public void setSubsInfo(int index, SubsInfo vSubsInfo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _subsInfoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _subsInfoList.setElementAt(vSubsInfo, index);
    } //-- void setSubsInfo(int, SubsInfo) 

    /**
     * 
     * 
     * @param subsInfoArray
    **/
    public void setSubsInfo(SubsInfo[] subsInfoArray)
    {
        //-- copy array
        _subsInfoList.removeAllElements();
        for (int i = 0; i < subsInfoArray.length; i++) {
            _subsInfoList.addElement(subsInfoArray[i]);
        }
    } //-- void setSubsInfo(SubsInfo) 

    /**
     * Sets the value of field 'textSignEn'. The field 'textSignEn'
     * has the following description: Ӣ������ǩ��
     * 
     * @param textSignEn the value of field 'textSignEn'.
    **/
    public void setTextSignEn(java.lang.String textSignEn)
    {
        this._textSignEn = textSignEn;
    } //-- void setTextSignEn(java.lang.String) 

    /**
     * Sets the value of field 'textSignZh'. The field 'textSignZh'
     * has the following description: ��������ǩ��
     * 
     * @param textSignZh the value of field 'textSignZh'.
    **/
    public void setTextSignZh(java.lang.String textSignZh)
    {
        this._textSignZh = textSignZh;
    } //-- void setTextSignZh(java.lang.String) 

    /**
     * 
     * 
     * @param reader
    **/


}
