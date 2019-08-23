package com.zds.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CustomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andCustIdIsNull() {
            addCriterion("CUST_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("CUST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(Long value) {
            addCriterion("CUST_ID =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(Long value) {
            addCriterion("CUST_ID <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(Long value) {
            addCriterion("CUST_ID >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CUST_ID >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(Long value) {
            addCriterion("CUST_ID <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(Long value) {
            addCriterion("CUST_ID <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<Long> values) {
            addCriterion("CUST_ID in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<Long> values) {
            addCriterion("CUST_ID not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(Long value1, Long value2) {
            addCriterion("CUST_ID between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(Long value1, Long value2) {
            addCriterion("CUST_ID not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNull() {
            addCriterion("CUST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("CUST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("CUST_NAME =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("CUST_NAME <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("CUST_NAME >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_NAME >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("CUST_NAME <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("CUST_NAME <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("CUST_NAME like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("CUST_NAME not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("CUST_NAME in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("CUST_NAME not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("CUST_NAME between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("CUST_NAME not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustPwdIsNull() {
            addCriterion("CUST_PWD is null");
            return (Criteria) this;
        }

        public Criteria andCustPwdIsNotNull() {
            addCriterion("CUST_PWD is not null");
            return (Criteria) this;
        }

        public Criteria andCustPwdEqualTo(String value) {
            addCriterion("CUST_PWD =", value, "custPwd");
            return (Criteria) this;
        }

        public Criteria andCustPwdNotEqualTo(String value) {
            addCriterion("CUST_PWD <>", value, "custPwd");
            return (Criteria) this;
        }

        public Criteria andCustPwdGreaterThan(String value) {
            addCriterion("CUST_PWD >", value, "custPwd");
            return (Criteria) this;
        }

        public Criteria andCustPwdGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_PWD >=", value, "custPwd");
            return (Criteria) this;
        }

        public Criteria andCustPwdLessThan(String value) {
            addCriterion("CUST_PWD <", value, "custPwd");
            return (Criteria) this;
        }

        public Criteria andCustPwdLessThanOrEqualTo(String value) {
            addCriterion("CUST_PWD <=", value, "custPwd");
            return (Criteria) this;
        }

        public Criteria andCustPwdLike(String value) {
            addCriterion("CUST_PWD like", value, "custPwd");
            return (Criteria) this;
        }

        public Criteria andCustPwdNotLike(String value) {
            addCriterion("CUST_PWD not like", value, "custPwd");
            return (Criteria) this;
        }

        public Criteria andCustPwdIn(List<String> values) {
            addCriterion("CUST_PWD in", values, "custPwd");
            return (Criteria) this;
        }

        public Criteria andCustPwdNotIn(List<String> values) {
            addCriterion("CUST_PWD not in", values, "custPwd");
            return (Criteria) this;
        }

        public Criteria andCustPwdBetween(String value1, String value2) {
            addCriterion("CUST_PWD between", value1, value2, "custPwd");
            return (Criteria) this;
        }

        public Criteria andCustPwdNotBetween(String value1, String value2) {
            addCriterion("CUST_PWD not between", value1, value2, "custPwd");
            return (Criteria) this;
        }

        public Criteria andCustSexIsNull() {
            addCriterion("CUST_SEX is null");
            return (Criteria) this;
        }

        public Criteria andCustSexIsNotNull() {
            addCriterion("CUST_SEX is not null");
            return (Criteria) this;
        }

        public Criteria andCustSexEqualTo(String value) {
            addCriterion("CUST_SEX =", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexNotEqualTo(String value) {
            addCriterion("CUST_SEX <>", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexGreaterThan(String value) {
            addCriterion("CUST_SEX >", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_SEX >=", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexLessThan(String value) {
            addCriterion("CUST_SEX <", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexLessThanOrEqualTo(String value) {
            addCriterion("CUST_SEX <=", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexLike(String value) {
            addCriterion("CUST_SEX like", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexNotLike(String value) {
            addCriterion("CUST_SEX not like", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexIn(List<String> values) {
            addCriterion("CUST_SEX in", values, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexNotIn(List<String> values) {
            addCriterion("CUST_SEX not in", values, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexBetween(String value1, String value2) {
            addCriterion("CUST_SEX between", value1, value2, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexNotBetween(String value1, String value2) {
            addCriterion("CUST_SEX not between", value1, value2, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustTelIsNull() {
            addCriterion("CUST_TEL is null");
            return (Criteria) this;
        }

        public Criteria andCustTelIsNotNull() {
            addCriterion("CUST_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andCustTelEqualTo(Long value) {
            addCriterion("CUST_TEL =", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelNotEqualTo(Long value) {
            addCriterion("CUST_TEL <>", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelGreaterThan(Long value) {
            addCriterion("CUST_TEL >", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelGreaterThanOrEqualTo(Long value) {
            addCriterion("CUST_TEL >=", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelLessThan(Long value) {
            addCriterion("CUST_TEL <", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelLessThanOrEqualTo(Long value) {
            addCriterion("CUST_TEL <=", value, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelIn(List<Long> values) {
            addCriterion("CUST_TEL in", values, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelNotIn(List<Long> values) {
            addCriterion("CUST_TEL not in", values, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelBetween(Long value1, Long value2) {
            addCriterion("CUST_TEL between", value1, value2, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustTelNotBetween(Long value1, Long value2) {
            addCriterion("CUST_TEL not between", value1, value2, "custTel");
            return (Criteria) this;
        }

        public Criteria andCustEmailIsNull() {
            addCriterion("CUST_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andCustEmailIsNotNull() {
            addCriterion("CUST_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andCustEmailEqualTo(String value) {
            addCriterion("CUST_EMAIL =", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotEqualTo(String value) {
            addCriterion("CUST_EMAIL <>", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailGreaterThan(String value) {
            addCriterion("CUST_EMAIL >", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_EMAIL >=", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailLessThan(String value) {
            addCriterion("CUST_EMAIL <", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailLessThanOrEqualTo(String value) {
            addCriterion("CUST_EMAIL <=", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailLike(String value) {
            addCriterion("CUST_EMAIL like", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotLike(String value) {
            addCriterion("CUST_EMAIL not like", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailIn(List<String> values) {
            addCriterion("CUST_EMAIL in", values, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotIn(List<String> values) {
            addCriterion("CUST_EMAIL not in", values, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailBetween(String value1, String value2) {
            addCriterion("CUST_EMAIL between", value1, value2, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotBetween(String value1, String value2) {
            addCriterion("CUST_EMAIL not between", value1, value2, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustAddressIsNull() {
            addCriterion("CUST_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andCustAddressIsNotNull() {
            addCriterion("CUST_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andCustAddressEqualTo(String value) {
            addCriterion("CUST_ADDRESS =", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressNotEqualTo(String value) {
            addCriterion("CUST_ADDRESS <>", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressGreaterThan(String value) {
            addCriterion("CUST_ADDRESS >", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_ADDRESS >=", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressLessThan(String value) {
            addCriterion("CUST_ADDRESS <", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressLessThanOrEqualTo(String value) {
            addCriterion("CUST_ADDRESS <=", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressLike(String value) {
            addCriterion("CUST_ADDRESS like", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressNotLike(String value) {
            addCriterion("CUST_ADDRESS not like", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressIn(List<String> values) {
            addCriterion("CUST_ADDRESS in", values, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressNotIn(List<String> values) {
            addCriterion("CUST_ADDRESS not in", values, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressBetween(String value1, String value2) {
            addCriterion("CUST_ADDRESS between", value1, value2, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressNotBetween(String value1, String value2) {
            addCriterion("CUST_ADDRESS not between", value1, value2, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("MODIFY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("MODIFY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(Date value) {
            addCriterionForJDBCDate("MODIFY_DATE =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("MODIFY_DATE <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterionForJDBCDate("MODIFY_DATE >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("MODIFY_DATE >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterionForJDBCDate("MODIFY_DATE <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("MODIFY_DATE <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterionForJDBCDate("MODIFY_DATE in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("MODIFY_DATE not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("MODIFY_DATE between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("MODIFY_DATE not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}