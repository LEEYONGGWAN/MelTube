package com.meltube.community.vo;

import com.meltube.member.vo.MemberVO;

public class CommunityVO {

	private int id;
	private int likeIt;
	private int userId;
	
	private String title;
	private String singer;
	private String album;
	private String genre;
	private String releaseDate;
	private String lyrics;
	
	private String requestIp;
	private String displayFilename;
	
	private MemberVO memberVO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLikeIt() {
		return likeIt;
	}

	public void setLikeIt(int likeIt) {
		this.likeIt = likeIt;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	public String getDisplayFilename() {
		return displayFilename;
	}

	public void setDisplayFilename(String displayFilename) {
		this.displayFilename = displayFilename;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

}
