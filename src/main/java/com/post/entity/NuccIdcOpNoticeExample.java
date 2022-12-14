package com.post.entity;

import java.util.ArrayList;
import java.util.List;

public class NuccIdcOpNoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NuccIdcOpNoticeExample() {
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

        public Criteria andRecIdIsNull() {
            addCriterion("rec_id is null");
            return (Criteria) this;
        }

        public Criteria andRecIdIsNotNull() {
            addCriterion("rec_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecIdEqualTo(String value) {
            addCriterion("rec_id =", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdNotEqualTo(String value) {
            addCriterion("rec_id <>", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdGreaterThan(String value) {
            addCriterion("rec_id >", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdGreaterThanOrEqualTo(String value) {
            addCriterion("rec_id >=", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdLessThan(String value) {
            addCriterion("rec_id <", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdLessThanOrEqualTo(String value) {
            addCriterion("rec_id <=", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdLike(String value) {
            addCriterion("rec_id like", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdNotLike(String value) {
            addCriterion("rec_id not like", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdIn(List<String> values) {
            addCriterion("rec_id in", values, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdNotIn(List<String> values) {
            addCriterion("rec_id not in", values, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdBetween(String value1, String value2) {
            addCriterion("rec_id between", value1, value2, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdNotBetween(String value1, String value2) {
            addCriterion("rec_id not between", value1, value2, "recId");
            return (Criteria) this;
        }

        public Criteria andCntNoIsNull() {
            addCriterion("cnt_no is null");
            return (Criteria) this;
        }

        public Criteria andCntNoIsNotNull() {
            addCriterion("cnt_no is not null");
            return (Criteria) this;
        }

        public Criteria andCntNoEqualTo(String value) {
            addCriterion("cnt_no =", value, "cntNo");
            return (Criteria) this;
        }

        public Criteria andCntNoNotEqualTo(String value) {
            addCriterion("cnt_no <>", value, "cntNo");
            return (Criteria) this;
        }

        public Criteria andCntNoGreaterThan(String value) {
            addCriterion("cnt_no >", value, "cntNo");
            return (Criteria) this;
        }

        public Criteria andCntNoGreaterThanOrEqualTo(String value) {
            addCriterion("cnt_no >=", value, "cntNo");
            return (Criteria) this;
        }

        public Criteria andCntNoLessThan(String value) {
            addCriterion("cnt_no <", value, "cntNo");
            return (Criteria) this;
        }

        public Criteria andCntNoLessThanOrEqualTo(String value) {
            addCriterion("cnt_no <=", value, "cntNo");
            return (Criteria) this;
        }

        public Criteria andCntNoLike(String value) {
            addCriterion("cnt_no like", value, "cntNo");
            return (Criteria) this;
        }

        public Criteria andCntNoNotLike(String value) {
            addCriterion("cnt_no not like", value, "cntNo");
            return (Criteria) this;
        }

        public Criteria andCntNoIn(List<String> values) {
            addCriterion("cnt_no in", values, "cntNo");
            return (Criteria) this;
        }

        public Criteria andCntNoNotIn(List<String> values) {
            addCriterion("cnt_no not in", values, "cntNo");
            return (Criteria) this;
        }

        public Criteria andCntNoBetween(String value1, String value2) {
            addCriterion("cnt_no between", value1, value2, "cntNo");
            return (Criteria) this;
        }

        public Criteria andCntNoNotBetween(String value1, String value2) {
            addCriterion("cnt_no not between", value1, value2, "cntNo");
            return (Criteria) this;
        }

        public Criteria andInfoNoIsNull() {
            addCriterion("info_no is null");
            return (Criteria) this;
        }

        public Criteria andInfoNoIsNotNull() {
            addCriterion("info_no is not null");
            return (Criteria) this;
        }

        public Criteria andInfoNoEqualTo(String value) {
            addCriterion("info_no =", value, "infoNo");
            return (Criteria) this;
        }

        public Criteria andInfoNoNotEqualTo(String value) {
            addCriterion("info_no <>", value, "infoNo");
            return (Criteria) this;
        }

        public Criteria andInfoNoGreaterThan(String value) {
            addCriterion("info_no >", value, "infoNo");
            return (Criteria) this;
        }

        public Criteria andInfoNoGreaterThanOrEqualTo(String value) {
            addCriterion("info_no >=", value, "infoNo");
            return (Criteria) this;
        }

        public Criteria andInfoNoLessThan(String value) {
            addCriterion("info_no <", value, "infoNo");
            return (Criteria) this;
        }

        public Criteria andInfoNoLessThanOrEqualTo(String value) {
            addCriterion("info_no <=", value, "infoNo");
            return (Criteria) this;
        }

        public Criteria andInfoNoLike(String value) {
            addCriterion("info_no like", value, "infoNo");
            return (Criteria) this;
        }

        public Criteria andInfoNoNotLike(String value) {
            addCriterion("info_no not like", value, "infoNo");
            return (Criteria) this;
        }

        public Criteria andInfoNoIn(List<String> values) {
            addCriterion("info_no in", values, "infoNo");
            return (Criteria) this;
        }

        public Criteria andInfoNoNotIn(List<String> values) {
            addCriterion("info_no not in", values, "infoNo");
            return (Criteria) this;
        }

        public Criteria andInfoNoBetween(String value1, String value2) {
            addCriterion("info_no between", value1, value2, "infoNo");
            return (Criteria) this;
        }

        public Criteria andInfoNoNotBetween(String value1, String value2) {
            addCriterion("info_no not between", value1, value2, "infoNo");
            return (Criteria) this;
        }

        public Criteria andInfoTypeIsNull() {
            addCriterion("info_type is null");
            return (Criteria) this;
        }

        public Criteria andInfoTypeIsNotNull() {
            addCriterion("info_type is not null");
            return (Criteria) this;
        }

        public Criteria andInfoTypeEqualTo(String value) {
            addCriterion("info_type =", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNotEqualTo(String value) {
            addCriterion("info_type <>", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeGreaterThan(String value) {
            addCriterion("info_type >", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("info_type >=", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeLessThan(String value) {
            addCriterion("info_type <", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeLessThanOrEqualTo(String value) {
            addCriterion("info_type <=", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeLike(String value) {
            addCriterion("info_type like", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNotLike(String value) {
            addCriterion("info_type not like", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeIn(List<String> values) {
            addCriterion("info_type in", values, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNotIn(List<String> values) {
            addCriterion("info_type not in", values, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeBetween(String value1, String value2) {
            addCriterion("info_type between", value1, value2, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNotBetween(String value1, String value2) {
            addCriterion("info_type not between", value1, value2, "infoType");
            return (Criteria) this;
        }

        public Criteria andInstIdIsNull() {
            addCriterion("inst_id is null");
            return (Criteria) this;
        }

        public Criteria andInstIdIsNotNull() {
            addCriterion("inst_id is not null");
            return (Criteria) this;
        }

        public Criteria andInstIdEqualTo(String value) {
            addCriterion("inst_id =", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdNotEqualTo(String value) {
            addCriterion("inst_id <>", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdGreaterThan(String value) {
            addCriterion("inst_id >", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdGreaterThanOrEqualTo(String value) {
            addCriterion("inst_id >=", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdLessThan(String value) {
            addCriterion("inst_id <", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdLessThanOrEqualTo(String value) {
            addCriterion("inst_id <=", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdLike(String value) {
            addCriterion("inst_id like", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdNotLike(String value) {
            addCriterion("inst_id not like", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdIn(List<String> values) {
            addCriterion("inst_id in", values, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdNotIn(List<String> values) {
            addCriterion("inst_id not in", values, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdBetween(String value1, String value2) {
            addCriterion("inst_id between", value1, value2, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdNotBetween(String value1, String value2) {
            addCriterion("inst_id not between", value1, value2, "instId");
            return (Criteria) this;
        }

        public Criteria andAccTypeIsNull() {
            addCriterion("acc_type is null");
            return (Criteria) this;
        }

        public Criteria andAccTypeIsNotNull() {
            addCriterion("acc_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccTypeEqualTo(String value) {
            addCriterion("acc_type =", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeNotEqualTo(String value) {
            addCriterion("acc_type <>", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeGreaterThan(String value) {
            addCriterion("acc_type >", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeGreaterThanOrEqualTo(String value) {
            addCriterion("acc_type >=", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeLessThan(String value) {
            addCriterion("acc_type <", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeLessThanOrEqualTo(String value) {
            addCriterion("acc_type <=", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeLike(String value) {
            addCriterion("acc_type like", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeNotLike(String value) {
            addCriterion("acc_type not like", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeIn(List<String> values) {
            addCriterion("acc_type in", values, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeNotIn(List<String> values) {
            addCriterion("acc_type not in", values, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeBetween(String value1, String value2) {
            addCriterion("acc_type between", value1, value2, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeNotBetween(String value1, String value2) {
            addCriterion("acc_type not between", value1, value2, "accType");
            return (Criteria) this;
        }

        public Criteria andInstNameIsNull() {
            addCriterion("inst_name is null");
            return (Criteria) this;
        }

        public Criteria andInstNameIsNotNull() {
            addCriterion("inst_name is not null");
            return (Criteria) this;
        }

        public Criteria andInstNameEqualTo(String value) {
            addCriterion("inst_name =", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameNotEqualTo(String value) {
            addCriterion("inst_name <>", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameGreaterThan(String value) {
            addCriterion("inst_name >", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameGreaterThanOrEqualTo(String value) {
            addCriterion("inst_name >=", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameLessThan(String value) {
            addCriterion("inst_name <", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameLessThanOrEqualTo(String value) {
            addCriterion("inst_name <=", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameLike(String value) {
            addCriterion("inst_name like", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameNotLike(String value) {
            addCriterion("inst_name not like", value, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameIn(List<String> values) {
            addCriterion("inst_name in", values, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameNotIn(List<String> values) {
            addCriterion("inst_name not in", values, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameBetween(String value1, String value2) {
            addCriterion("inst_name between", value1, value2, "instName");
            return (Criteria) this;
        }

        public Criteria andInstNameNotBetween(String value1, String value2) {
            addCriterion("inst_name not between", value1, value2, "instName");
            return (Criteria) this;
        }

        public Criteria andNoticeContentIsNull() {
            addCriterion("notice_content is null");
            return (Criteria) this;
        }

        public Criteria andNoticeContentIsNotNull() {
            addCriterion("notice_content is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeContentEqualTo(String value) {
            addCriterion("notice_content =", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotEqualTo(String value) {
            addCriterion("notice_content <>", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentGreaterThan(String value) {
            addCriterion("notice_content >", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentGreaterThanOrEqualTo(String value) {
            addCriterion("notice_content >=", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentLessThan(String value) {
            addCriterion("notice_content <", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentLessThanOrEqualTo(String value) {
            addCriterion("notice_content <=", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentLike(String value) {
            addCriterion("notice_content like", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotLike(String value) {
            addCriterion("notice_content not like", value, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentIn(List<String> values) {
            addCriterion("notice_content in", values, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotIn(List<String> values) {
            addCriterion("notice_content not in", values, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentBetween(String value1, String value2) {
            addCriterion("notice_content between", value1, value2, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeContentNotBetween(String value1, String value2) {
            addCriterion("notice_content not between", value1, value2, "noticeContent");
            return (Criteria) this;
        }

        public Criteria andNoticeDescIsNull() {
            addCriterion("notice_desc is null");
            return (Criteria) this;
        }

        public Criteria andNoticeDescIsNotNull() {
            addCriterion("notice_desc is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeDescEqualTo(String value) {
            addCriterion("notice_desc =", value, "noticeDesc");
            return (Criteria) this;
        }

        public Criteria andNoticeDescNotEqualTo(String value) {
            addCriterion("notice_desc <>", value, "noticeDesc");
            return (Criteria) this;
        }

        public Criteria andNoticeDescGreaterThan(String value) {
            addCriterion("notice_desc >", value, "noticeDesc");
            return (Criteria) this;
        }

        public Criteria andNoticeDescGreaterThanOrEqualTo(String value) {
            addCriterion("notice_desc >=", value, "noticeDesc");
            return (Criteria) this;
        }

        public Criteria andNoticeDescLessThan(String value) {
            addCriterion("notice_desc <", value, "noticeDesc");
            return (Criteria) this;
        }

        public Criteria andNoticeDescLessThanOrEqualTo(String value) {
            addCriterion("notice_desc <=", value, "noticeDesc");
            return (Criteria) this;
        }

        public Criteria andNoticeDescLike(String value) {
            addCriterion("notice_desc like", value, "noticeDesc");
            return (Criteria) this;
        }

        public Criteria andNoticeDescNotLike(String value) {
            addCriterion("notice_desc not like", value, "noticeDesc");
            return (Criteria) this;
        }

        public Criteria andNoticeDescIn(List<String> values) {
            addCriterion("notice_desc in", values, "noticeDesc");
            return (Criteria) this;
        }

        public Criteria andNoticeDescNotIn(List<String> values) {
            addCriterion("notice_desc not in", values, "noticeDesc");
            return (Criteria) this;
        }

        public Criteria andNoticeDescBetween(String value1, String value2) {
            addCriterion("notice_desc between", value1, value2, "noticeDesc");
            return (Criteria) this;
        }

        public Criteria andNoticeDescNotBetween(String value1, String value2) {
            addCriterion("notice_desc not between", value1, value2, "noticeDesc");
            return (Criteria) this;
        }

        public Criteria andContactsIsNull() {
            addCriterion("contacts is null");
            return (Criteria) this;
        }

        public Criteria andContactsIsNotNull() {
            addCriterion("contacts is not null");
            return (Criteria) this;
        }

        public Criteria andContactsEqualTo(String value) {
            addCriterion("contacts =", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotEqualTo(String value) {
            addCriterion("contacts <>", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThan(String value) {
            addCriterion("contacts >", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThanOrEqualTo(String value) {
            addCriterion("contacts >=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThan(String value) {
            addCriterion("contacts <", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThanOrEqualTo(String value) {
            addCriterion("contacts <=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLike(String value) {
            addCriterion("contacts like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotLike(String value) {
            addCriterion("contacts not like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsIn(List<String> values) {
            addCriterion("contacts in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotIn(List<String> values) {
            addCriterion("contacts not in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsBetween(String value1, String value2) {
            addCriterion("contacts between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotBetween(String value1, String value2) {
            addCriterion("contacts not between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andIdcListIsNull() {
            addCriterion("idc_list is null");
            return (Criteria) this;
        }

        public Criteria andIdcListIsNotNull() {
            addCriterion("idc_list is not null");
            return (Criteria) this;
        }

        public Criteria andIdcListEqualTo(String value) {
            addCriterion("idc_list =", value, "idcList");
            return (Criteria) this;
        }

        public Criteria andIdcListNotEqualTo(String value) {
            addCriterion("idc_list <>", value, "idcList");
            return (Criteria) this;
        }

        public Criteria andIdcListGreaterThan(String value) {
            addCriterion("idc_list >", value, "idcList");
            return (Criteria) this;
        }

        public Criteria andIdcListGreaterThanOrEqualTo(String value) {
            addCriterion("idc_list >=", value, "idcList");
            return (Criteria) this;
        }

        public Criteria andIdcListLessThan(String value) {
            addCriterion("idc_list <", value, "idcList");
            return (Criteria) this;
        }

        public Criteria andIdcListLessThanOrEqualTo(String value) {
            addCriterion("idc_list <=", value, "idcList");
            return (Criteria) this;
        }

        public Criteria andIdcListLike(String value) {
            addCriterion("idc_list like", value, "idcList");
            return (Criteria) this;
        }

        public Criteria andIdcListNotLike(String value) {
            addCriterion("idc_list not like", value, "idcList");
            return (Criteria) this;
        }

        public Criteria andIdcListIn(List<String> values) {
            addCriterion("idc_list in", values, "idcList");
            return (Criteria) this;
        }

        public Criteria andIdcListNotIn(List<String> values) {
            addCriterion("idc_list not in", values, "idcList");
            return (Criteria) this;
        }

        public Criteria andIdcListBetween(String value1, String value2) {
            addCriterion("idc_list between", value1, value2, "idcList");
            return (Criteria) this;
        }

        public Criteria andIdcListNotBetween(String value1, String value2) {
            addCriterion("idc_list not between", value1, value2, "idcList");
            return (Criteria) this;
        }

        public Criteria andBizChanIsNull() {
            addCriterion("biz_chan is null");
            return (Criteria) this;
        }

        public Criteria andBizChanIsNotNull() {
            addCriterion("biz_chan is not null");
            return (Criteria) this;
        }

        public Criteria andBizChanEqualTo(String value) {
            addCriterion("biz_chan =", value, "bizChan");
            return (Criteria) this;
        }

        public Criteria andBizChanNotEqualTo(String value) {
            addCriterion("biz_chan <>", value, "bizChan");
            return (Criteria) this;
        }

        public Criteria andBizChanGreaterThan(String value) {
            addCriterion("biz_chan >", value, "bizChan");
            return (Criteria) this;
        }

        public Criteria andBizChanGreaterThanOrEqualTo(String value) {
            addCriterion("biz_chan >=", value, "bizChan");
            return (Criteria) this;
        }

        public Criteria andBizChanLessThan(String value) {
            addCriterion("biz_chan <", value, "bizChan");
            return (Criteria) this;
        }

        public Criteria andBizChanLessThanOrEqualTo(String value) {
            addCriterion("biz_chan <=", value, "bizChan");
            return (Criteria) this;
        }

        public Criteria andBizChanLike(String value) {
            addCriterion("biz_chan like", value, "bizChan");
            return (Criteria) this;
        }

        public Criteria andBizChanNotLike(String value) {
            addCriterion("biz_chan not like", value, "bizChan");
            return (Criteria) this;
        }

        public Criteria andBizChanIn(List<String> values) {
            addCriterion("biz_chan in", values, "bizChan");
            return (Criteria) this;
        }

        public Criteria andBizChanNotIn(List<String> values) {
            addCriterion("biz_chan not in", values, "bizChan");
            return (Criteria) this;
        }

        public Criteria andBizChanBetween(String value1, String value2) {
            addCriterion("biz_chan between", value1, value2, "bizChan");
            return (Criteria) this;
        }

        public Criteria andBizChanNotBetween(String value1, String value2) {
            addCriterion("biz_chan not between", value1, value2, "bizChan");
            return (Criteria) this;
        }

        public Criteria andBizTypeListIsNull() {
            addCriterion("biz_type_list is null");
            return (Criteria) this;
        }

        public Criteria andBizTypeListIsNotNull() {
            addCriterion("biz_type_list is not null");
            return (Criteria) this;
        }

        public Criteria andBizTypeListEqualTo(String value) {
            addCriterion("biz_type_list =", value, "bizTypeList");
            return (Criteria) this;
        }

        public Criteria andBizTypeListNotEqualTo(String value) {
            addCriterion("biz_type_list <>", value, "bizTypeList");
            return (Criteria) this;
        }

        public Criteria andBizTypeListGreaterThan(String value) {
            addCriterion("biz_type_list >", value, "bizTypeList");
            return (Criteria) this;
        }

        public Criteria andBizTypeListGreaterThanOrEqualTo(String value) {
            addCriterion("biz_type_list >=", value, "bizTypeList");
            return (Criteria) this;
        }

        public Criteria andBizTypeListLessThan(String value) {
            addCriterion("biz_type_list <", value, "bizTypeList");
            return (Criteria) this;
        }

        public Criteria andBizTypeListLessThanOrEqualTo(String value) {
            addCriterion("biz_type_list <=", value, "bizTypeList");
            return (Criteria) this;
        }

        public Criteria andBizTypeListLike(String value) {
            addCriterion("biz_type_list like", value, "bizTypeList");
            return (Criteria) this;
        }

        public Criteria andBizTypeListNotLike(String value) {
            addCriterion("biz_type_list not like", value, "bizTypeList");
            return (Criteria) this;
        }

        public Criteria andBizTypeListIn(List<String> values) {
            addCriterion("biz_type_list in", values, "bizTypeList");
            return (Criteria) this;
        }

        public Criteria andBizTypeListNotIn(List<String> values) {
            addCriterion("biz_type_list not in", values, "bizTypeList");
            return (Criteria) this;
        }

        public Criteria andBizTypeListBetween(String value1, String value2) {
            addCriterion("biz_type_list between", value1, value2, "bizTypeList");
            return (Criteria) this;
        }

        public Criteria andBizTypeListNotBetween(String value1, String value2) {
            addCriterion("biz_type_list not between", value1, value2, "bizTypeList");
            return (Criteria) this;
        }

        public Criteria andOpListIsNull() {
            addCriterion("op_list is null");
            return (Criteria) this;
        }

        public Criteria andOpListIsNotNull() {
            addCriterion("op_list is not null");
            return (Criteria) this;
        }

        public Criteria andOpListEqualTo(String value) {
            addCriterion("op_list =", value, "opList");
            return (Criteria) this;
        }

        public Criteria andOpListNotEqualTo(String value) {
            addCriterion("op_list <>", value, "opList");
            return (Criteria) this;
        }

        public Criteria andOpListGreaterThan(String value) {
            addCriterion("op_list >", value, "opList");
            return (Criteria) this;
        }

        public Criteria andOpListGreaterThanOrEqualTo(String value) {
            addCriterion("op_list >=", value, "opList");
            return (Criteria) this;
        }

        public Criteria andOpListLessThan(String value) {
            addCriterion("op_list <", value, "opList");
            return (Criteria) this;
        }

        public Criteria andOpListLessThanOrEqualTo(String value) {
            addCriterion("op_list <=", value, "opList");
            return (Criteria) this;
        }

        public Criteria andOpListLike(String value) {
            addCriterion("op_list like", value, "opList");
            return (Criteria) this;
        }

        public Criteria andOpListNotLike(String value) {
            addCriterion("op_list not like", value, "opList");
            return (Criteria) this;
        }

        public Criteria andOpListIn(List<String> values) {
            addCriterion("op_list in", values, "opList");
            return (Criteria) this;
        }

        public Criteria andOpListNotIn(List<String> values) {
            addCriterion("op_list not in", values, "opList");
            return (Criteria) this;
        }

        public Criteria andOpListBetween(String value1, String value2) {
            addCriterion("op_list between", value1, value2, "opList");
            return (Criteria) this;
        }

        public Criteria andOpListNotBetween(String value1, String value2) {
            addCriterion("op_list not between", value1, value2, "opList");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(String value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(String value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(String value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(String value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(String value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLike(String value) {
            addCriterion("start_time like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotLike(String value) {
            addCriterion("start_time not like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<String> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<String> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(String value1, String value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(String value1, String value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("end_time like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("end_time not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andSendStatusIsNull() {
            addCriterion("send_status is null");
            return (Criteria) this;
        }

        public Criteria andSendStatusIsNotNull() {
            addCriterion("send_status is not null");
            return (Criteria) this;
        }

        public Criteria andSendStatusEqualTo(String value) {
            addCriterion("send_status =", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotEqualTo(String value) {
            addCriterion("send_status <>", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusGreaterThan(String value) {
            addCriterion("send_status >", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusGreaterThanOrEqualTo(String value) {
            addCriterion("send_status >=", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusLessThan(String value) {
            addCriterion("send_status <", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusLessThanOrEqualTo(String value) {
            addCriterion("send_status <=", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusLike(String value) {
            addCriterion("send_status like", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotLike(String value) {
            addCriterion("send_status not like", value, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusIn(List<String> values) {
            addCriterion("send_status in", values, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotIn(List<String> values) {
            addCriterion("send_status not in", values, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusBetween(String value1, String value2) {
            addCriterion("send_status between", value1, value2, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andSendStatusNotBetween(String value1, String value2) {
            addCriterion("send_status not between", value1, value2, "sendStatus");
            return (Criteria) this;
        }

        public Criteria andIdcList2IsNull() {
            addCriterion("idc_list2 is null");
            return (Criteria) this;
        }

        public Criteria andIdcList2IsNotNull() {
            addCriterion("idc_list2 is not null");
            return (Criteria) this;
        }

        public Criteria andIdcList2EqualTo(String value) {
            addCriterion("idc_list2 =", value, "idcList2");
            return (Criteria) this;
        }

        public Criteria andIdcList2NotEqualTo(String value) {
            addCriterion("idc_list2 <>", value, "idcList2");
            return (Criteria) this;
        }

        public Criteria andIdcList2GreaterThan(String value) {
            addCriterion("idc_list2 >", value, "idcList2");
            return (Criteria) this;
        }

        public Criteria andIdcList2GreaterThanOrEqualTo(String value) {
            addCriterion("idc_list2 >=", value, "idcList2");
            return (Criteria) this;
        }

        public Criteria andIdcList2LessThan(String value) {
            addCriterion("idc_list2 <", value, "idcList2");
            return (Criteria) this;
        }

        public Criteria andIdcList2LessThanOrEqualTo(String value) {
            addCriterion("idc_list2 <=", value, "idcList2");
            return (Criteria) this;
        }

        public Criteria andIdcList2Like(String value) {
            addCriterion("idc_list2 like", value, "idcList2");
            return (Criteria) this;
        }

        public Criteria andIdcList2NotLike(String value) {
            addCriterion("idc_list2 not like", value, "idcList2");
            return (Criteria) this;
        }

        public Criteria andIdcList2In(List<String> values) {
            addCriterion("idc_list2 in", values, "idcList2");
            return (Criteria) this;
        }

        public Criteria andIdcList2NotIn(List<String> values) {
            addCriterion("idc_list2 not in", values, "idcList2");
            return (Criteria) this;
        }

        public Criteria andIdcList2Between(String value1, String value2) {
            addCriterion("idc_list2 between", value1, value2, "idcList2");
            return (Criteria) this;
        }

        public Criteria andIdcList2NotBetween(String value1, String value2) {
            addCriterion("idc_list2 not between", value1, value2, "idcList2");
            return (Criteria) this;
        }

        public Criteria andOverOperaIsNull() {
            addCriterion("over_opera is null");
            return (Criteria) this;
        }

        public Criteria andOverOperaIsNotNull() {
            addCriterion("over_opera is not null");
            return (Criteria) this;
        }

        public Criteria andOverOperaEqualTo(String value) {
            addCriterion("over_opera =", value, "overOpera");
            return (Criteria) this;
        }

        public Criteria andOverOperaNotEqualTo(String value) {
            addCriterion("over_opera <>", value, "overOpera");
            return (Criteria) this;
        }

        public Criteria andOverOperaGreaterThan(String value) {
            addCriterion("over_opera >", value, "overOpera");
            return (Criteria) this;
        }

        public Criteria andOverOperaGreaterThanOrEqualTo(String value) {
            addCriterion("over_opera >=", value, "overOpera");
            return (Criteria) this;
        }

        public Criteria andOverOperaLessThan(String value) {
            addCriterion("over_opera <", value, "overOpera");
            return (Criteria) this;
        }

        public Criteria andOverOperaLessThanOrEqualTo(String value) {
            addCriterion("over_opera <=", value, "overOpera");
            return (Criteria) this;
        }

        public Criteria andOverOperaLike(String value) {
            addCriterion("over_opera like", value, "overOpera");
            return (Criteria) this;
        }

        public Criteria andOverOperaNotLike(String value) {
            addCriterion("over_opera not like", value, "overOpera");
            return (Criteria) this;
        }

        public Criteria andOverOperaIn(List<String> values) {
            addCriterion("over_opera in", values, "overOpera");
            return (Criteria) this;
        }

        public Criteria andOverOperaNotIn(List<String> values) {
            addCriterion("over_opera not in", values, "overOpera");
            return (Criteria) this;
        }

        public Criteria andOverOperaBetween(String value1, String value2) {
            addCriterion("over_opera between", value1, value2, "overOpera");
            return (Criteria) this;
        }

        public Criteria andOverOperaNotBetween(String value1, String value2) {
            addCriterion("over_opera not between", value1, value2, "overOpera");
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