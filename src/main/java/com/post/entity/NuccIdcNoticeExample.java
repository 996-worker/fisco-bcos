package com.post.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NuccIdcNoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NuccIdcNoticeExample() {
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

        public Criteria andSeriesNoIsNull() {
            addCriterion("series_no is null");
            return (Criteria) this;
        }

        public Criteria andSeriesNoIsNotNull() {
            addCriterion("series_no is not null");
            return (Criteria) this;
        }

        public Criteria andSeriesNoEqualTo(String value) {
            addCriterion("series_no =", value, "seriesNo");
            return (Criteria) this;
        }

        public Criteria andSeriesNoNotEqualTo(String value) {
            addCriterion("series_no <>", value, "seriesNo");
            return (Criteria) this;
        }

        public Criteria andSeriesNoGreaterThan(String value) {
            addCriterion("series_no >", value, "seriesNo");
            return (Criteria) this;
        }

        public Criteria andSeriesNoGreaterThanOrEqualTo(String value) {
            addCriterion("series_no >=", value, "seriesNo");
            return (Criteria) this;
        }

        public Criteria andSeriesNoLessThan(String value) {
            addCriterion("series_no <", value, "seriesNo");
            return (Criteria) this;
        }

        public Criteria andSeriesNoLessThanOrEqualTo(String value) {
            addCriterion("series_no <=", value, "seriesNo");
            return (Criteria) this;
        }

        public Criteria andSeriesNoLike(String value) {
            addCriterion("series_no like", value, "seriesNo");
            return (Criteria) this;
        }

        public Criteria andSeriesNoNotLike(String value) {
            addCriterion("series_no not like", value, "seriesNo");
            return (Criteria) this;
        }

        public Criteria andSeriesNoIn(List<String> values) {
            addCriterion("series_no in", values, "seriesNo");
            return (Criteria) this;
        }

        public Criteria andSeriesNoNotIn(List<String> values) {
            addCriterion("series_no not in", values, "seriesNo");
            return (Criteria) this;
        }

        public Criteria andSeriesNoBetween(String value1, String value2) {
            addCriterion("series_no between", value1, value2, "seriesNo");
            return (Criteria) this;
        }

        public Criteria andSeriesNoNotBetween(String value1, String value2) {
            addCriterion("series_no not between", value1, value2, "seriesNo");
            return (Criteria) this;
        }

        public Criteria andContentJsonIsNull() {
            addCriterion("content_json is null");
            return (Criteria) this;
        }

        public Criteria andContentJsonIsNotNull() {
            addCriterion("content_json is not null");
            return (Criteria) this;
        }

        public Criteria andContentJsonEqualTo(String value) {
            addCriterion("content_json =", value, "contentJson");
            return (Criteria) this;
        }

        public Criteria andContentJsonNotEqualTo(String value) {
            addCriterion("content_json <>", value, "contentJson");
            return (Criteria) this;
        }

        public Criteria andContentJsonGreaterThan(String value) {
            addCriterion("content_json >", value, "contentJson");
            return (Criteria) this;
        }

        public Criteria andContentJsonGreaterThanOrEqualTo(String value) {
            addCriterion("content_json >=", value, "contentJson");
            return (Criteria) this;
        }

        public Criteria andContentJsonLessThan(String value) {
            addCriterion("content_json <", value, "contentJson");
            return (Criteria) this;
        }

        public Criteria andContentJsonLessThanOrEqualTo(String value) {
            addCriterion("content_json <=", value, "contentJson");
            return (Criteria) this;
        }

        public Criteria andContentJsonLike(String value) {
            addCriterion("content_json like", value, "contentJson");
            return (Criteria) this;
        }

        public Criteria andContentJsonNotLike(String value) {
            addCriterion("content_json not like", value, "contentJson");
            return (Criteria) this;
        }

        public Criteria andContentJsonIn(List<String> values) {
            addCriterion("content_json in", values, "contentJson");
            return (Criteria) this;
        }

        public Criteria andContentJsonNotIn(List<String> values) {
            addCriterion("content_json not in", values, "contentJson");
            return (Criteria) this;
        }

        public Criteria andContentJsonBetween(String value1, String value2) {
            addCriterion("content_json between", value1, value2, "contentJson");
            return (Criteria) this;
        }

        public Criteria andContentJsonNotBetween(String value1, String value2) {
            addCriterion("content_json not between", value1, value2, "contentJson");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusIsNull() {
            addCriterion("notice_status is null");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusIsNotNull() {
            addCriterion("notice_status is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusEqualTo(String value) {
            addCriterion("notice_status =", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusNotEqualTo(String value) {
            addCriterion("notice_status <>", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusGreaterThan(String value) {
            addCriterion("notice_status >", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("notice_status >=", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusLessThan(String value) {
            addCriterion("notice_status <", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusLessThanOrEqualTo(String value) {
            addCriterion("notice_status <=", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusLike(String value) {
            addCriterion("notice_status like", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusNotLike(String value) {
            addCriterion("notice_status not like", value, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusIn(List<String> values) {
            addCriterion("notice_status in", values, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusNotIn(List<String> values) {
            addCriterion("notice_status not in", values, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusBetween(String value1, String value2) {
            addCriterion("notice_status between", value1, value2, "noticeStatus");
            return (Criteria) this;
        }

        public Criteria andNoticeStatusNotBetween(String value1, String value2) {
            addCriterion("notice_status not between", value1, value2, "noticeStatus");
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