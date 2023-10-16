/*
Name: Zhou, Albert
Email: azhou2@lsu.edu
Project: PA-2 
Instructor: Feng Chen
Class: cs4103-sp23
Login ID: cs410388
 */
public class trace {
	private String MB;
	private String pageNum;
	private String pFault;
	private String pEvict;
	private String swapIn;
	private String swapOut;
	
	public trace() {
		MB=null;
		pageNum=null;
		pFault=null;
		pEvict=null;
		swapIn=null;
		swapOut=null;
	}
	public trace(String MB, String pageNum, String pFault, String pEvict, String swapIn, String swapOut) {
		this.MB=MB;
		this.pageNum=pageNum;
		this.pFault=pFault;
		this.pEvict=pEvict;
		this.swapIn=swapIn;
		this.swapOut=swapOut;
	}
	public String toString() {
		return MB+" "+pageNum+" "+pFault+" "+pEvict+" "+swapIn+" "+swapOut;
	}
	public String getInTime() {
		return swapIn;
	}
	public String getOutTime() {
		return swapOut;
	}
}
