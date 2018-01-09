package main.java.com.rockey.ssm.po;

import java.util.List;

import main.java.com.rockey.ssm.util.BasicUtil;


public class Page extends Customer {
	
	private int thispage;
	private int rowpage;
	private int firstpage;
	private int lastpage;
	private int prepage;
	private int nextpage;
	private int rowcount;
	private int pagecount;
	private int frompage;
	private List<Customer> list;
	public int getThispage() {
		return thispage;
	}
	public void setThispage(int thispage) {
		this.thispage = thispage;
	}
	public int getRowpage() {
		return rowpage;
	}
	public void setRowpage(int rowpage) {
		this.rowpage = rowpage;
	}
	public int getFirstpage() {
		return firstpage;
	}
	public void setFirstpage(int firstpage) {
		this.firstpage = firstpage;
	}
	public int getLastpage() {
		return lastpage;
	}
	public void setLastpage(int lastpage) {
		this.lastpage = lastpage;
	}
	public int getPrepage() {
		return prepage;
	}
	public void setPrepage(int prepage) {
		this.prepage = prepage;
	}
	public int getNextpage() {
		return nextpage;
	}
	public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}
	public int getRowcount() {
		return rowcount;
	}
	public void setRowcount(int rowcount) {
		this.rowcount = rowcount;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public List<Customer> getList() {
		return list;
	}
	public void setList(List<Customer> list) {
		this.list = list;
	}
	public int getFrompage() {
		return frompage;
	}
	public void setFrompage(int frompage) {
		this.frompage = frompage;
	}
}
