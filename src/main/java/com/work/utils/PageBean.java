package com.work.utils;

import java.util.List;

public class PageBean<E> {

	private int index;		// 现在所在页
	private int offPage;		//每页多少条
	private int countNum;		//总条数
	private int numPage;			//总页数
	private int nextPage;		//下一页
	private int prevPage;		//上一页
	private List<E> lists;		//记录
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
		this.setNextPage(index);
		this.setPrevPage(index);
	}
	public int getOffPage() {
		return offPage;
	}
	public void setOffPage(int offPage) {
		this.offPage = offPage;
	}
	public int getCountNum() {
		return countNum;
	}
	public void setCountNum(int countNum) {
		this.numPage = (countNum/this.offPage)+1;
		this.countNum = countNum;
	}
	public int getNumPage() {
		return numPage;
	}
	public void setNumPage(int numPage) {
		this.numPage = numPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		int next = nextPage+1;
		if(next>=numPage){
			this.nextPage = numPage;
			return ;
		}
		this.nextPage = nextPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		int prev = prevPage-1;
		if(prev<=1){
			this.prevPage = 1;
			return ;
		}
		this.prevPage = prevPage;
	}
	public List<E> getLists() {
		return lists;
	}
	public void setLists(List<E> lists) {
		this.lists = lists;
	}
	
}
