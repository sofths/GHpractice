package com.human.dto;

import java.util.Date;

public class BoardDTO {
	private int titleNum;
	private String userID;
	private String faqTitle;
	private String faqContent;
	private String questionType;
	private String email;
	private Date inquiryDate;
	public int getTitleNum() {
		return titleNum;
	}
	public void setTitleNum(int titleNum) {
		this.titleNum = titleNum;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getFaqTitle() {
		return faqTitle;
	}
	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}
	public String getFaqContent() {
		return faqContent;
	}
	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getInquiryDate() {
		return inquiryDate;
	}
	public void setInquiryDate(Date inquiryDate) {
		this.inquiryDate = inquiryDate;
	}
	@Override
	public String toString() {
		return "BoardDTO [titleNum=" + titleNum + ", userID=" + userID + ", faqTitle=" + faqTitle + ", faqContent="
				+ faqContent + ", questionType=" + questionType + ", email=" + email + ", inquiryDate=" + inquiryDate
				+ "]";
	}
}

	