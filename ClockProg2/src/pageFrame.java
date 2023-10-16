/*
Name: Zhou, Albert
Email: azhou2@lsu.edu
Project: PA-2 
Instructor: Feng Chen
Class: cs4103-sp23
Login ID: cs410388
 */
public class pageFrame {
	private String MB;
	private String pageNum;
	private String RB;
	public pageFrame() {
		MB=null;
		pageNum=null;
		RB=null;
	}
	public pageFrame(String MB, String pageNum, String RB) {
		this.MB=MB;
		this.pageNum=pageNum;
		this.RB=RB;
	}
	public String getMB() {
		return MB;
	}
	public String getPageNum() {
		return pageNum;
	}
	public String getRB() {
		return RB;
	}
	public void setMB(String mb) {
		MB=mb;
	}
	public void setPageNum(String numberPage) {
		pageNum=numberPage;
	}
	public void setRB(String rb) {
		RB=rb;
	}
	public void frameReplace(pageFrame pf) {
		MB=pf.getMB();
		pageNum=pf.getPageNum();
		RB=pf.getRB();
	}
}
