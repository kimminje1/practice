package com.wing.util;

import java.io.Serializable;

public class Paging implements Serializable{

	// 페이지당 게시물 수
	public static final int PAGE_SCALE = 10;
	// 화면당 블럭 수
	public static final int BLOCK_SCALE = 5;
	
	private int curPage = 0; // 현재 페이지
	
	private int totPage; // 전체 페이지 갯수
	private int totBlock; // 전체 페이지 블록 갯수
	
	private int curBlock; // 현재 페이지 블록
	
	private int prevBlock;
	private int nextBlock;
	
	private int pageBegin;
	private int pageEnd;
	
	private int blockBegin;
	private int blockEnd;
	
	public Paging(int count, int curPage) {
		this.curBlock = 1;
		
		setTotPage(count);
		
		if(curPage > totPage) {
			curPage = totPage;
		}
		
		this.curPage = curPage;
		
		setPageRange();
		setTotBlock();
		setBlockRange();
	}

	public void setBlockRange() {
		// TODO Auto-generated method stub
		curBlock = (int)Math.ceil((curPage - 1) / BLOCK_SCALE) + 1;
		
		blockBegin = (curBlock - 1) * BLOCK_SCALE + 1;
		
		blockEnd = blockBegin + BLOCK_SCALE - 1;
		
		if(blockEnd > totPage) {
			blockEnd = totPage;
		}
		
		prevBlock = (curPage == 1) ? 1 : (curBlock - 1) * BLOCK_SCALE;
		
		nextBlock = curBlock > totBlock ? (curBlock * BLOCK_SCALE)
				: (curBlock * BLOCK_SCALE) + 1;
		
		if(prevBlock <= 0) {
			prevBlock = 1;
		}
		
		if(nextBlock >= totPage) {
			nextBlock = totPage;
		}
	}

	public void setTotBlock() {
		// TODO Auto-generated method stub
		this.totBlock = (int)Math.ceil((double)totPage / (double)BLOCK_SCALE);
	}

	public void setPageRange() {
		// TODO Auto-generated method stub
		pageBegin = (curPage - 1) * PAGE_SCALE + 1;
		pageEnd = pageBegin + PAGE_SCALE - 1;
		
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getTotPage() {
		return totPage;
	}

	public void setTotPage(int totPage) {
		this.totPage = (int)Math.ceil(totPage * 1.0 / PAGE_SCALE);
	}

	public int getTotBlock() {
		return totBlock;
	}

	public void setTotBlock(int totBlock) {
		this.totBlock = totBlock;
	}

	public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getPrevBlock() {
		return prevBlock;
	}

	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}

	public int getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public int getBlockBegin() {
		return blockBegin;
	}

	public void setBlockBegin(int blockBegin) {
		this.blockBegin = blockBegin;
	}

	public int getBlockEnd() {
		return blockEnd;
	}

	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Paging [curPage=");
		builder.append(curPage);
		builder.append(", totPage=");
		builder.append(totPage);
		builder.append(", totBlock=");
		builder.append(totBlock);
		builder.append(", curBlock=");
		builder.append(curBlock);
		builder.append(", prevBlock=");
		builder.append(prevBlock);
		builder.append(", nextBlock=");
		builder.append(nextBlock);
		builder.append(", pageBegin=");
		builder.append(pageBegin);
		builder.append(", pageEnd=");
		builder.append(pageEnd);
		builder.append(", blockBegin=");
		builder.append(blockBegin);
		builder.append(", blockEnd=");
		builder.append(blockEnd);
		builder.append("]");
		return builder.toString();
	}
	
}
