package com.gecdevelopers.scrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EpisodeList {
	
    final String baseUrl="https://www4.gogoanime.se";
    ArrayList<EpisodeModel> episodeData;
    String animeUrl;
    int numberOfEpisodes;
    
    public EpisodeList(String animeUrl) {
    	this.animeUrl=animeUrl;
    	episodeData=new ArrayList<>();
    	numberOfEpisodes=0;
    }
    
	public void startScraping() {
	
		String url= urlCorrector(animeUrl);
		  try {
              Document doc = Jsoup.connect(url).get();

              Elements container= doc.select("div.anime_video_body");

              Elements container2=container.select("ul#episode_page");
              Elements range=container2.select("li");
              String lastEpisodeNumber="0";
              for(Element rng:range){
                  lastEpisodeNumber=rng.text();
              }
              if(lastEpisodeNumber.contains("-")){
                  String[] temp=lastEpisodeNumber.split("-");
                  lastEpisodeNumber=temp[1];
              }

              numberOfEpisodes= Integer.parseInt(lastEpisodeNumber);

          } catch (IOException e) {
              e.printStackTrace();
          }
		  
		  
		  animeUrl=getProperUrl(animeUrl);
          for(int i=1;i<=numberOfEpisodes;i++){
              if(animeUrl.contains("episode")){
                  episodeData.add(new EpisodeModel("episode "+i,animeUrl+"-"+i));

              }else
              episodeData.add(new EpisodeModel("episode "+i,animeUrl+"-episode-"+i));

          }

        //  Log.d("ashdb",episodesData.get(0).getEpisodeUrl());
          Collections.reverse(episodeData);
		
	}
	
	
	
	private String urlCorrector(String url) {
		String correctedUrl;
		if(url.contains("https"))
	        {
	            animeUrl=getGeneralUrl(url); // getting general url of the page
	            //Log.d("new", episodeUrl);
	            //task.execute(url);
	            correctedUrl=url;
	        }
	        else {
	            animeUrl = baseUrl + getProperUrl(url);
	          // Log.d("new", episodeUrl);
	          //  task.execute(episodeUrl);
	            correctedUrl=animeUrl;
	            animeUrl=getGeneralUrl(animeUrl);
	        
	        }
		 
		 return correctedUrl;
		 
	}

	private String getGeneralUrl(String murl){
		String[] temp=murl.split("-");     
		String URL=null;     
		for(int i=0;i<temp.length;i++){        
			if(i==0){            
				URL=temp[i];          
			}else            
				if(i!=temp.length-1){              
					URL=URL+"-"+temp[i];             
				}      
		}

	      if(!parseStrToInt(temp[temp.length-1])){
	          URL=URL+"-"+temp[temp.length-1];
	      }

	return URL;
	}	

	 private  boolean parseStrToInt(String str) {
	        if (str.matches("\\d+")) {
	            return true;
	        } else {
	            return false;
	        }
	    }
 
	 private  String getProperUrl(String url){
		 return url.replaceFirst("category/",""); 
	 }

	 public ArrayList<EpisodeModel> getEpisodeList() {
		return episodeData;
	}
	 
}
