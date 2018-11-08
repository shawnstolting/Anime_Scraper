package com.gecdevelopers.scrapper;

import java.util.ArrayList;



public class Scrapper {

	
    private ArrayList<AnimeModel> recentAnimeList;
    private ArrayList<AnimeModel> popularOngoingAnimeList; // ongoing and popular
    
    public Scrapper() {
    	recentAnimeList= new ArrayList<>();
    	popularOngoingAnimeList= new ArrayList<>();
    }
	
    
	
	public void scrapeForPopularOngoingAnimeList() {
		
	}
	
	public void scrapeForRecentAnimeList() {
		RecentAnimeScrapper var= new RecentAnimeScrapper();
		var.startScraping();
		recentAnimeList.addAll(var.getList());
	}
	
    
	public ArrayList<AnimeModel> getRecentAnimeList(){
		return recentAnimeList;
	}
	
	public ArrayList<AnimeModel> getPopularOngoindAnimeList(){
		return popularOngoingAnimeList;
	}
	
	
	
	
	
}
