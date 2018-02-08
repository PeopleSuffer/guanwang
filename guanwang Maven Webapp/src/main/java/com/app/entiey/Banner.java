package com.app.entiey;

public class Banner {
	private int id;
	private String title;
	private String imagePath;
	private String bannerDetails;
	private String bannerTime;
	private Integer state;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}
	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	/**
	 * @return the bannerDetails
	 */
	public String getBannerDetails() {
		return bannerDetails;
	}
	/**
	 * @param bannerDetails the bannerDetails to set
	 */
	public void setBannerDetails(String bannerDetails) {
		this.bannerDetails = bannerDetails;
	}
	/**
	 * @return the bannerTime
	 */
	public String getBannerTime() {
		return bannerTime;
	}
	/**
	 * @param bannerTime the bannerTime to set
	 */
	public void setBannerTime(String bannerTime) {
		if (bannerTime.contains(".")) {
			bannerTime=bannerTime.substring(0,bannerTime.lastIndexOf("."));
		}
		this.bannerTime = bannerTime;
	}
	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	
}
