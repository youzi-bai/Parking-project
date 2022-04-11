package com.bai.config.entity;

import java.util.ArrayList;
import java.util.Date;
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

        public Criteria andIdUserIsNull() {
            addCriterion("id_user is null");
            return (Criteria) this;
        }

        public Criteria andIdUserIsNotNull() {
            addCriterion("id_user is not null");
            return (Criteria) this;
        }

        public Criteria andIdUserEqualTo(Integer value) {
            addCriterion("id_user =", value, "idUser");
            return (Criteria) this;
        }

        public Criteria andIdUserNotEqualTo(Integer value) {
            addCriterion("id_user <>", value, "idUser");
            return (Criteria) this;
        }

        public Criteria andIdUserGreaterThan(Integer value) {
            addCriterion("id_user >", value, "idUser");
            return (Criteria) this;
        }

        public Criteria andIdUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_user >=", value, "idUser");
            return (Criteria) this;
        }

        public Criteria andIdUserLessThan(Integer value) {
            addCriterion("id_user <", value, "idUser");
            return (Criteria) this;
        }

        public Criteria andIdUserLessThanOrEqualTo(Integer value) {
            addCriterion("id_user <=", value, "idUser");
            return (Criteria) this;
        }

        public Criteria andIdUserIn(List<Integer> values) {
            addCriterion("id_user in", values, "idUser");
            return (Criteria) this;
        }

        public Criteria andIdUserNotIn(List<Integer> values) {
            addCriterion("id_user not in", values, "idUser");
            return (Criteria) this;
        }

        public Criteria andIdUserBetween(Integer value1, Integer value2) {
            addCriterion("id_user between", value1, value2, "idUser");
            return (Criteria) this;
        }

        public Criteria andIdUserNotBetween(Integer value1, Integer value2) {
            addCriterion("id_user not between", value1, value2, "idUser");
            return (Criteria) this;
        }

        public Criteria andNameUserIsNull() {
            addCriterion("name_user is null");
            return (Criteria) this;
        }

        public Criteria andNameUserIsNotNull() {
            addCriterion("name_user is not null");
            return (Criteria) this;
        }

        public Criteria andNameUserEqualTo(String value) {
            addCriterion("name_user =", value, "nameUser");
            return (Criteria) this;
        }

        public Criteria andNameUserNotEqualTo(String value) {
            addCriterion("name_user <>", value, "nameUser");
            return (Criteria) this;
        }

        public Criteria andNameUserGreaterThan(String value) {
            addCriterion("name_user >", value, "nameUser");
            return (Criteria) this;
        }

        public Criteria andNameUserGreaterThanOrEqualTo(String value) {
            addCriterion("name_user >=", value, "nameUser");
            return (Criteria) this;
        }

        public Criteria andNameUserLessThan(String value) {
            addCriterion("name_user <", value, "nameUser");
            return (Criteria) this;
        }

        public Criteria andNameUserLessThanOrEqualTo(String value) {
            addCriterion("name_user <=", value, "nameUser");
            return (Criteria) this;
        }

        public Criteria andNameUserLike(String value) {
            addCriterion("name_user like", value, "nameUser");
            return (Criteria) this;
        }

        public Criteria andNameUserNotLike(String value) {
            addCriterion("name_user not like", value, "nameUser");
            return (Criteria) this;
        }

        public Criteria andNameUserIn(List<String> values) {
            addCriterion("name_user in", values, "nameUser");
            return (Criteria) this;
        }

        public Criteria andNameUserNotIn(List<String> values) {
            addCriterion("name_user not in", values, "nameUser");
            return (Criteria) this;
        }

        public Criteria andNameUserBetween(String value1, String value2) {
            addCriterion("name_user between", value1, value2, "nameUser");
            return (Criteria) this;
        }

        public Criteria andNameUserNotBetween(String value1, String value2) {
            addCriterion("name_user not between", value1, value2, "nameUser");
            return (Criteria) this;
        }

        public Criteria andIponeUserIsNull() {
            addCriterion("ipone_user is null");
            return (Criteria) this;
        }

        public Criteria andIponeUserIsNotNull() {
            addCriterion("ipone_user is not null");
            return (Criteria) this;
        }

        public Criteria andIponeUserEqualTo(String value) {
            addCriterion("ipone_user =", value, "iponeUser");
            return (Criteria) this;
        }

        public Criteria andIponeUserNotEqualTo(String value) {
            addCriterion("ipone_user <>", value, "iponeUser");
            return (Criteria) this;
        }

        public Criteria andIponeUserGreaterThan(String value) {
            addCriterion("ipone_user >", value, "iponeUser");
            return (Criteria) this;
        }

        public Criteria andIponeUserGreaterThanOrEqualTo(String value) {
            addCriterion("ipone_user >=", value, "iponeUser");
            return (Criteria) this;
        }

        public Criteria andIponeUserLessThan(String value) {
            addCriterion("ipone_user <", value, "iponeUser");
            return (Criteria) this;
        }

        public Criteria andIponeUserLessThanOrEqualTo(String value) {
            addCriterion("ipone_user <=", value, "iponeUser");
            return (Criteria) this;
        }

        public Criteria andIponeUserLike(String value) {
            addCriterion("ipone_user like", value, "iponeUser");
            return (Criteria) this;
        }

        public Criteria andIponeUserNotLike(String value) {
            addCriterion("ipone_user not like", value, "iponeUser");
            return (Criteria) this;
        }

        public Criteria andIponeUserIn(List<String> values) {
            addCriterion("ipone_user in", values, "iponeUser");
            return (Criteria) this;
        }

        public Criteria andIponeUserNotIn(List<String> values) {
            addCriterion("ipone_user not in", values, "iponeUser");
            return (Criteria) this;
        }

        public Criteria andIponeUserBetween(String value1, String value2) {
            addCriterion("ipone_user between", value1, value2, "iponeUser");
            return (Criteria) this;
        }

        public Criteria andIponeUserNotBetween(String value1, String value2) {
            addCriterion("ipone_user not between", value1, value2, "iponeUser");
            return (Criteria) this;
        }

        public Criteria andAddressUserIsNull() {
            addCriterion("address_user is null");
            return (Criteria) this;
        }

        public Criteria andAddressUserIsNotNull() {
            addCriterion("address_user is not null");
            return (Criteria) this;
        }

        public Criteria andAddressUserEqualTo(String value) {
            addCriterion("address_user =", value, "addressUser");
            return (Criteria) this;
        }

        public Criteria andAddressUserNotEqualTo(String value) {
            addCriterion("address_user <>", value, "addressUser");
            return (Criteria) this;
        }

        public Criteria andAddressUserGreaterThan(String value) {
            addCriterion("address_user >", value, "addressUser");
            return (Criteria) this;
        }

        public Criteria andAddressUserGreaterThanOrEqualTo(String value) {
            addCriterion("address_user >=", value, "addressUser");
            return (Criteria) this;
        }

        public Criteria andAddressUserLessThan(String value) {
            addCriterion("address_user <", value, "addressUser");
            return (Criteria) this;
        }

        public Criteria andAddressUserLessThanOrEqualTo(String value) {
            addCriterion("address_user <=", value, "addressUser");
            return (Criteria) this;
        }

        public Criteria andAddressUserLike(String value) {
            addCriterion("address_user like", value, "addressUser");
            return (Criteria) this;
        }

        public Criteria andAddressUserNotLike(String value) {
            addCriterion("address_user not like", value, "addressUser");
            return (Criteria) this;
        }

        public Criteria andAddressUserIn(List<String> values) {
            addCriterion("address_user in", values, "addressUser");
            return (Criteria) this;
        }

        public Criteria andAddressUserNotIn(List<String> values) {
            addCriterion("address_user not in", values, "addressUser");
            return (Criteria) this;
        }

        public Criteria andAddressUserBetween(String value1, String value2) {
            addCriterion("address_user between", value1, value2, "addressUser");
            return (Criteria) this;
        }

        public Criteria andAddressUserNotBetween(String value1, String value2) {
            addCriterion("address_user not between", value1, value2, "addressUser");
            return (Criteria) this;
        }

        public Criteria andGenderUserIsNull() {
            addCriterion("gender_user is null");
            return (Criteria) this;
        }

        public Criteria andGenderUserIsNotNull() {
            addCriterion("gender_user is not null");
            return (Criteria) this;
        }

        public Criteria andGenderUserEqualTo(String value) {
            addCriterion("gender_user =", value, "genderUser");
            return (Criteria) this;
        }

        public Criteria andGenderUserNotEqualTo(String value) {
            addCriterion("gender_user <>", value, "genderUser");
            return (Criteria) this;
        }

        public Criteria andGenderUserGreaterThan(String value) {
            addCriterion("gender_user >", value, "genderUser");
            return (Criteria) this;
        }

        public Criteria andGenderUserGreaterThanOrEqualTo(String value) {
            addCriterion("gender_user >=", value, "genderUser");
            return (Criteria) this;
        }

        public Criteria andGenderUserLessThan(String value) {
            addCriterion("gender_user <", value, "genderUser");
            return (Criteria) this;
        }

        public Criteria andGenderUserLessThanOrEqualTo(String value) {
            addCriterion("gender_user <=", value, "genderUser");
            return (Criteria) this;
        }

        public Criteria andGenderUserLike(String value) {
            addCriterion("gender_user like", value, "genderUser");
            return (Criteria) this;
        }

        public Criteria andGenderUserNotLike(String value) {
            addCriterion("gender_user not like", value, "genderUser");
            return (Criteria) this;
        }

        public Criteria andGenderUserIn(List<String> values) {
            addCriterion("gender_user in", values, "genderUser");
            return (Criteria) this;
        }

        public Criteria andGenderUserNotIn(List<String> values) {
            addCriterion("gender_user not in", values, "genderUser");
            return (Criteria) this;
        }

        public Criteria andGenderUserBetween(String value1, String value2) {
            addCriterion("gender_user between", value1, value2, "genderUser");
            return (Criteria) this;
        }

        public Criteria andGenderUserNotBetween(String value1, String value2) {
            addCriterion("gender_user not between", value1, value2, "genderUser");
            return (Criteria) this;
        }

        public Criteria andStateUserIsNull() {
            addCriterion("state_user is null");
            return (Criteria) this;
        }

        public Criteria andStateUserIsNotNull() {
            addCriterion("state_user is not null");
            return (Criteria) this;
        }

        public Criteria andStateUserEqualTo(Integer value) {
            addCriterion("state_user =", value, "stateUser");
            return (Criteria) this;
        }

        public Criteria andStateUserNotEqualTo(Integer value) {
            addCriterion("state_user <>", value, "stateUser");
            return (Criteria) this;
        }

        public Criteria andStateUserGreaterThan(Integer value) {
            addCriterion("state_user >", value, "stateUser");
            return (Criteria) this;
        }

        public Criteria andStateUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("state_user >=", value, "stateUser");
            return (Criteria) this;
        }

        public Criteria andStateUserLessThan(Integer value) {
            addCriterion("state_user <", value, "stateUser");
            return (Criteria) this;
        }

        public Criteria andStateUserLessThanOrEqualTo(Integer value) {
            addCriterion("state_user <=", value, "stateUser");
            return (Criteria) this;
        }

        public Criteria andStateUserIn(List<Integer> values) {
            addCriterion("state_user in", values, "stateUser");
            return (Criteria) this;
        }

        public Criteria andStateUserNotIn(List<Integer> values) {
            addCriterion("state_user not in", values, "stateUser");
            return (Criteria) this;
        }

        public Criteria andStateUserBetween(Integer value1, Integer value2) {
            addCriterion("state_user between", value1, value2, "stateUser");
            return (Criteria) this;
        }

        public Criteria andStateUserNotBetween(Integer value1, Integer value2) {
            addCriterion("state_user not between", value1, value2, "stateUser");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("`password` is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("`password` is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("`password` =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("`password` <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("`password` >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("`password` >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("`password` <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("`password` <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("`password` like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("`password` not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("`password` in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("`password` not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("`password` between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("`password` not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Integer value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Integer value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Integer value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Integer value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Integer> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Integer> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(Integer value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(Integer value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(Integer value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(Integer value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<Integer> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<Integer> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }
    }

    /**
     */
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