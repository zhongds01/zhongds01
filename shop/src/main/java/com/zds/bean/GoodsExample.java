package com.zds.bean;

import java.util.ArrayList;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("GOODS_ID is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("GOODS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("GOODS_ID =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("GOODS_ID <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("GOODS_ID >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("GOODS_ID >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("GOODS_ID <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("GOODS_ID <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("GOODS_ID in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("GOODS_ID not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("GOODS_ID between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("GOODS_ID not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("GOODS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("GOODS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("GOODS_NAME =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("GOODS_NAME <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("GOODS_NAME >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_NAME >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("GOODS_NAME <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("GOODS_NAME <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("GOODS_NAME like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("GOODS_NAME not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("GOODS_NAME in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("GOODS_NAME not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("GOODS_NAME between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("GOODS_NAME not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsCataIsNull() {
            addCriterion("GOODS_CATA is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCataIsNotNull() {
            addCriterion("GOODS_CATA is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCataEqualTo(String value) {
            addCriterion("GOODS_CATA =", value, "goodsCata");
            return (Criteria) this;
        }

        public Criteria andGoodsCataNotEqualTo(String value) {
            addCriterion("GOODS_CATA <>", value, "goodsCata");
            return (Criteria) this;
        }

        public Criteria andGoodsCataGreaterThan(String value) {
            addCriterion("GOODS_CATA >", value, "goodsCata");
            return (Criteria) this;
        }

        public Criteria andGoodsCataGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_CATA >=", value, "goodsCata");
            return (Criteria) this;
        }

        public Criteria andGoodsCataLessThan(String value) {
            addCriterion("GOODS_CATA <", value, "goodsCata");
            return (Criteria) this;
        }

        public Criteria andGoodsCataLessThanOrEqualTo(String value) {
            addCriterion("GOODS_CATA <=", value, "goodsCata");
            return (Criteria) this;
        }

        public Criteria andGoodsCataLike(String value) {
            addCriterion("GOODS_CATA like", value, "goodsCata");
            return (Criteria) this;
        }

        public Criteria andGoodsCataNotLike(String value) {
            addCriterion("GOODS_CATA not like", value, "goodsCata");
            return (Criteria) this;
        }

        public Criteria andGoodsCataIn(List<String> values) {
            addCriterion("GOODS_CATA in", values, "goodsCata");
            return (Criteria) this;
        }

        public Criteria andGoodsCataNotIn(List<String> values) {
            addCriterion("GOODS_CATA not in", values, "goodsCata");
            return (Criteria) this;
        }

        public Criteria andGoodsCataBetween(String value1, String value2) {
            addCriterion("GOODS_CATA between", value1, value2, "goodsCata");
            return (Criteria) this;
        }

        public Criteria andGoodsCataNotBetween(String value1, String value2) {
            addCriterion("GOODS_CATA not between", value1, value2, "goodsCata");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("GOODS_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("GOODS_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(Double value) {
            addCriterion("GOODS_PRICE =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(Double value) {
            addCriterion("GOODS_PRICE <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(Double value) {
            addCriterion("GOODS_PRICE >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("GOODS_PRICE >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(Double value) {
            addCriterion("GOODS_PRICE <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(Double value) {
            addCriterion("GOODS_PRICE <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<Double> values) {
            addCriterion("GOODS_PRICE in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<Double> values) {
            addCriterion("GOODS_PRICE not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(Double value1, Double value2) {
            addCriterion("GOODS_PRICE between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(Double value1, Double value2) {
            addCriterion("GOODS_PRICE not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsStockIsNull() {
            addCriterion("GOODS_STOCK is null");
            return (Criteria) this;
        }

        public Criteria andGoodsStockIsNotNull() {
            addCriterion("GOODS_STOCK is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsStockEqualTo(Integer value) {
            addCriterion("GOODS_STOCK =", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockNotEqualTo(Integer value) {
            addCriterion("GOODS_STOCK <>", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockGreaterThan(Integer value) {
            addCriterion("GOODS_STOCK >", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("GOODS_STOCK >=", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockLessThan(Integer value) {
            addCriterion("GOODS_STOCK <", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockLessThanOrEqualTo(Integer value) {
            addCriterion("GOODS_STOCK <=", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockIn(List<Integer> values) {
            addCriterion("GOODS_STOCK in", values, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockNotIn(List<Integer> values) {
            addCriterion("GOODS_STOCK not in", values, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockBetween(Integer value1, Integer value2) {
            addCriterion("GOODS_STOCK between", value1, value2, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockNotBetween(Integer value1, Integer value2) {
            addCriterion("GOODS_STOCK not between", value1, value2, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsPicIsNull() {
            addCriterion("GOODS_PIC is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPicIsNotNull() {
            addCriterion("GOODS_PIC is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPicEqualTo(String value) {
            addCriterion("GOODS_PIC =", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicNotEqualTo(String value) {
            addCriterion("GOODS_PIC <>", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicGreaterThan(String value) {
            addCriterion("GOODS_PIC >", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_PIC >=", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicLessThan(String value) {
            addCriterion("GOODS_PIC <", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicLessThanOrEqualTo(String value) {
            addCriterion("GOODS_PIC <=", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicLike(String value) {
            addCriterion("GOODS_PIC like", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicNotLike(String value) {
            addCriterion("GOODS_PIC not like", value, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicIn(List<String> values) {
            addCriterion("GOODS_PIC in", values, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicNotIn(List<String> values) {
            addCriterion("GOODS_PIC not in", values, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicBetween(String value1, String value2) {
            addCriterion("GOODS_PIC between", value1, value2, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsPicNotBetween(String value1, String value2) {
            addCriterion("GOODS_PIC not between", value1, value2, "goodsPic");
            return (Criteria) this;
        }

        public Criteria andGoodsDescIsNull() {
            addCriterion("GOODS_DESC is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescIsNotNull() {
            addCriterion("GOODS_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescEqualTo(String value) {
            addCriterion("GOODS_DESC =", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotEqualTo(String value) {
            addCriterion("GOODS_DESC <>", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescGreaterThan(String value) {
            addCriterion("GOODS_DESC >", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_DESC >=", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescLessThan(String value) {
            addCriterion("GOODS_DESC <", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescLessThanOrEqualTo(String value) {
            addCriterion("GOODS_DESC <=", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescLike(String value) {
            addCriterion("GOODS_DESC like", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotLike(String value) {
            addCriterion("GOODS_DESC not like", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescIn(List<String> values) {
            addCriterion("GOODS_DESC in", values, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotIn(List<String> values) {
            addCriterion("GOODS_DESC not in", values, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescBetween(String value1, String value2) {
            addCriterion("GOODS_DESC between", value1, value2, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotBetween(String value1, String value2) {
            addCriterion("GOODS_DESC not between", value1, value2, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsCommentIsNull() {
            addCriterion("GOODS_COMMENT is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCommentIsNotNull() {
            addCriterion("GOODS_COMMENT is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCommentEqualTo(String value) {
            addCriterion("GOODS_COMMENT =", value, "goodsComment");
            return (Criteria) this;
        }

        public Criteria andGoodsCommentNotEqualTo(String value) {
            addCriterion("GOODS_COMMENT <>", value, "goodsComment");
            return (Criteria) this;
        }

        public Criteria andGoodsCommentGreaterThan(String value) {
            addCriterion("GOODS_COMMENT >", value, "goodsComment");
            return (Criteria) this;
        }

        public Criteria andGoodsCommentGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_COMMENT >=", value, "goodsComment");
            return (Criteria) this;
        }

        public Criteria andGoodsCommentLessThan(String value) {
            addCriterion("GOODS_COMMENT <", value, "goodsComment");
            return (Criteria) this;
        }

        public Criteria andGoodsCommentLessThanOrEqualTo(String value) {
            addCriterion("GOODS_COMMENT <=", value, "goodsComment");
            return (Criteria) this;
        }

        public Criteria andGoodsCommentLike(String value) {
            addCriterion("GOODS_COMMENT like", value, "goodsComment");
            return (Criteria) this;
        }

        public Criteria andGoodsCommentNotLike(String value) {
            addCriterion("GOODS_COMMENT not like", value, "goodsComment");
            return (Criteria) this;
        }

        public Criteria andGoodsCommentIn(List<String> values) {
            addCriterion("GOODS_COMMENT in", values, "goodsComment");
            return (Criteria) this;
        }

        public Criteria andGoodsCommentNotIn(List<String> values) {
            addCriterion("GOODS_COMMENT not in", values, "goodsComment");
            return (Criteria) this;
        }

        public Criteria andGoodsCommentBetween(String value1, String value2) {
            addCriterion("GOODS_COMMENT between", value1, value2, "goodsComment");
            return (Criteria) this;
        }

        public Criteria andGoodsCommentNotBetween(String value1, String value2) {
            addCriterion("GOODS_COMMENT not between", value1, value2, "goodsComment");
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