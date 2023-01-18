package com.example.topsite;

public class SocialData {

String social_name;
String social_photo_url;
String social_url;

public String getSocial_name() {
	return social_name;
}

public void setSocial_name(String social_name) {
	this.social_name = social_name;
}

public String getSocial_photo_url() {
	return social_photo_url;
}

public void setSocial_photo_url(String social_photo_url) {
	this.social_photo_url = social_photo_url;
}

public String getSocial_url() {
	return social_url;
}

public void setSocial_url(String social_url) {
	this.social_url = social_url;
}

public SocialData(String social_name, String social_url , String social_photo_url ) {
	this.social_name = social_name;
	this.social_photo_url = social_photo_url;
	this.social_url = social_url;
}
}
