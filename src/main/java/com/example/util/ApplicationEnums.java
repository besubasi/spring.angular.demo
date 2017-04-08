package com.example.util;

public final class ApplicationEnums {
	
	
	
	public enum PopularURL{
		
		GOOGLE("https://www.google.com"),
		FACEBOOK("https://www.facebook.com/"),
		INSTAGRAM("https://www.instagram.com/"),
		TWITTER("https://twitter.com"),
		LINKEDIN("https://www.linkedin.com");
		
		private String url;

		PopularURL(String url) {
	        this.url = url;
	    }

	    public String getUrl() {
	        return url;
	    }
	    
	    @Override
	    public String toString() {
	        return this.getUrl();
	    }
	    

	}


}
