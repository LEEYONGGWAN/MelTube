package com.meltube.community.vo;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

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
	private String sing_img;
	
	private String mTitle;
	private String mSinger;
	
	
	
	
	
	private MultipartFile file;
	
	
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
		if (displayFilename == null) {
			displayFilename = "";
		}
		
		return displayFilename;
	}

	public void setDisplayFilename(String displayFilename) {
		this.displayFilename = displayFilename;
	}

	public String getSing_img() {
		return sing_img;
	}

	public void setSing_img(String sing_img) {
		this.sing_img = sing_img;
	}
	
	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String save() {
		if (file != null && !file.isEmpty()) {

			displayFilename = file.getOriginalFilename();

			File newFile = new File("D:\\uploadFiles/" + file.getOriginalFilename());
			try {
				file.transferTo(newFile);
				return newFile.getAbsolutePath();
			} catch (IllegalStateException e) {
				throw new RuntimeException(e.getMessage(), e);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		return null;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public String getmSinger() {
		return mSinger;
	}

	public void setmSinger(String mSinger) {
		this.mSinger = mSinger;
	}
	
	
	
}
