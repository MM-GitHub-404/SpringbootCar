package com.mm.mmcar.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
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

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Integer value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Integer value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Integer value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Integer value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Integer value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Integer> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Integer> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Integer value1, Integer value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Integer value1, Integer value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUNameIsNull() {
            addCriterion("u_name is null");
            return (Criteria) this;
        }

        public Criteria andUNameIsNotNull() {
            addCriterion("u_name is not null");
            return (Criteria) this;
        }

        public Criteria andUNameEqualTo(String value) {
            addCriterion("u_name =", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotEqualTo(String value) {
            addCriterion("u_name <>", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThan(String value) {
            addCriterion("u_name >", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThanOrEqualTo(String value) {
            addCriterion("u_name >=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThan(String value) {
            addCriterion("u_name <", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThanOrEqualTo(String value) {
            addCriterion("u_name <=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLike(String value) {
            addCriterion("u_name like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotLike(String value) {
            addCriterion("u_name not like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameIn(List<String> values) {
            addCriterion("u_name in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotIn(List<String> values) {
            addCriterion("u_name not in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameBetween(String value1, String value2) {
            addCriterion("u_name between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotBetween(String value1, String value2) {
            addCriterion("u_name not between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUIntegralIsNull() {
            addCriterion("u_integral is null");
            return (Criteria) this;
        }

        public Criteria andUIntegralIsNotNull() {
            addCriterion("u_integral is not null");
            return (Criteria) this;
        }

        public Criteria andUIntegralEqualTo(Integer value) {
            addCriterion("u_integral =", value, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUIntegralNotEqualTo(Integer value) {
            addCriterion("u_integral <>", value, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUIntegralGreaterThan(Integer value) {
            addCriterion("u_integral >", value, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_integral >=", value, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUIntegralLessThan(Integer value) {
            addCriterion("u_integral <", value, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("u_integral <=", value, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUIntegralIn(List<Integer> values) {
            addCriterion("u_integral in", values, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUIntegralNotIn(List<Integer> values) {
            addCriterion("u_integral not in", values, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUIntegralBetween(Integer value1, Integer value2) {
            addCriterion("u_integral between", value1, value2, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("u_integral not between", value1, value2, "uIntegral");
            return (Criteria) this;
        }

        public Criteria andUAvatarIsNull() {
            addCriterion("u_avatar is null");
            return (Criteria) this;
        }

        public Criteria andUAvatarIsNotNull() {
            addCriterion("u_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andUAvatarEqualTo(String value) {
            addCriterion("u_avatar =", value, "uAvatar");
            return (Criteria) this;
        }

        public Criteria andUAvatarNotEqualTo(String value) {
            addCriterion("u_avatar <>", value, "uAvatar");
            return (Criteria) this;
        }

        public Criteria andUAvatarGreaterThan(String value) {
            addCriterion("u_avatar >", value, "uAvatar");
            return (Criteria) this;
        }

        public Criteria andUAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("u_avatar >=", value, "uAvatar");
            return (Criteria) this;
        }

        public Criteria andUAvatarLessThan(String value) {
            addCriterion("u_avatar <", value, "uAvatar");
            return (Criteria) this;
        }

        public Criteria andUAvatarLessThanOrEqualTo(String value) {
            addCriterion("u_avatar <=", value, "uAvatar");
            return (Criteria) this;
        }

        public Criteria andUAvatarLike(String value) {
            addCriterion("u_avatar like", value, "uAvatar");
            return (Criteria) this;
        }

        public Criteria andUAvatarNotLike(String value) {
            addCriterion("u_avatar not like", value, "uAvatar");
            return (Criteria) this;
        }

        public Criteria andUAvatarIn(List<String> values) {
            addCriterion("u_avatar in", values, "uAvatar");
            return (Criteria) this;
        }

        public Criteria andUAvatarNotIn(List<String> values) {
            addCriterion("u_avatar not in", values, "uAvatar");
            return (Criteria) this;
        }

        public Criteria andUAvatarBetween(String value1, String value2) {
            addCriterion("u_avatar between", value1, value2, "uAvatar");
            return (Criteria) this;
        }

        public Criteria andUAvatarNotBetween(String value1, String value2) {
            addCriterion("u_avatar not between", value1, value2, "uAvatar");
            return (Criteria) this;
        }

        public Criteria andUPhoneIsNull() {
            addCriterion("u_phone is null");
            return (Criteria) this;
        }

        public Criteria andUPhoneIsNotNull() {
            addCriterion("u_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUPhoneEqualTo(Integer value) {
            addCriterion("u_phone =", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotEqualTo(Integer value) {
            addCriterion("u_phone <>", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneGreaterThan(Integer value) {
            addCriterion("u_phone >", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_phone >=", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneLessThan(Integer value) {
            addCriterion("u_phone <", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneLessThanOrEqualTo(Integer value) {
            addCriterion("u_phone <=", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneIn(List<Integer> values) {
            addCriterion("u_phone in", values, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotIn(List<Integer> values) {
            addCriterion("u_phone not in", values, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneBetween(Integer value1, Integer value2) {
            addCriterion("u_phone between", value1, value2, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotBetween(Integer value1, Integer value2) {
            addCriterion("u_phone not between", value1, value2, "uPhone");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andUDateIsNull() {
            addCriterion("u_date is null");
            return (Criteria) this;
        }

        public Criteria andUDateIsNotNull() {
            addCriterion("u_date is not null");
            return (Criteria) this;
        }

        public Criteria andUDateEqualTo(Date value) {
            addCriterionForJDBCDate("u_date =", value, "uDate");
            return (Criteria) this;
        }

        public Criteria andUDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("u_date <>", value, "uDate");
            return (Criteria) this;
        }

        public Criteria andUDateGreaterThan(Date value) {
            addCriterionForJDBCDate("u_date >", value, "uDate");
            return (Criteria) this;
        }

        public Criteria andUDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("u_date >=", value, "uDate");
            return (Criteria) this;
        }

        public Criteria andUDateLessThan(Date value) {
            addCriterionForJDBCDate("u_date <", value, "uDate");
            return (Criteria) this;
        }

        public Criteria andUDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("u_date <=", value, "uDate");
            return (Criteria) this;
        }

        public Criteria andUDateIn(List<Date> values) {
            addCriterionForJDBCDate("u_date in", values, "uDate");
            return (Criteria) this;
        }

        public Criteria andUDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("u_date not in", values, "uDate");
            return (Criteria) this;
        }

        public Criteria andUDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("u_date between", value1, value2, "uDate");
            return (Criteria) this;
        }

        public Criteria andUDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("u_date not between", value1, value2, "uDate");
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