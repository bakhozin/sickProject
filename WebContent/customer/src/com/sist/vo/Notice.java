package com.sist.vo;

public class Notice {
	private String seq; //��ȣ
	private String title; //����
	private String writer; //�ۼ���
	private String content; //�۳���
	private String regdate; //��¥
	private int hit; //��ȸ��
	
	//������ �Լ�
	public Notice() {
		this(null,null,null,null,null,0);
	}
	
	public Notice(String seq, String title, String writer, String content, String regdate, int hit) {
		this.seq=seq;
		this.title=title;
		this.writer=writer;
		this.content=content;
		this.regdate=regdate;
		this.hit=hit;
	}

	//getter-setter
	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
}
