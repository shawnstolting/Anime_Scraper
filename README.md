# Anime Scraper:-
   
Anime Scraper is a library that provides unofficial api to scrape the diiferent anime streaming platform like gogoanime, nine anime website returns the data as JSON Object. This repository is broken into two pieces one contains <b>java scraper</b> and other contains <b> python scraper</b>.
</br>This project is created fo the purpose of using it into RawAnime.</br>
If you are using our project feel free to give us credit :)


#### java library is can be used by downloading and importing it into your application, however our api made from python is the only one maintained and supports multiple servers


 # How to Use java lib
 - Import this library to your project 

#### To  Get list of recently updated animes


```
// initalize the variable
Scraper animes= new Scraper();
animes.getRecentlyUpdated(); // returns JSON Object
  ``` 
   
#### Popular Animes
  ```
animes.getPopularOngoing(); // returns JSON Object
```

#### Search Animes
```
animes.searchAnime(animeName); // animeName is a String
```

### Episodes

```
animes.getAllEpisodes(animeUrl); // animeUrl is a String
```

### Video link from different Servers

```
animes.getServers(url); // url is a String
```

##### For  complete code example checkout the demo.java file in the repository

## Screenshot of JSON
![enter image description here](https://user-images.githubusercontent.com/25636146/48275506-a83cf180-e46b-11e8-9263-52fcba01b560.png)

## Library Used
- Jsoup
- java-JSON 

# For Python API

Make the post request on the given url, the data post should be in JSON

  ```url = 'https://cbpgeca.herokuapp.com/' ```
and in that JSON intent key whould be present which specifies what api to call, example of json given below

### For recently updated anime
```
   {
      "intent":"new"
   }
```   
### For searching anime
```
   {
      "intent":"search"
      "anime": "naruto shippuden"
   }

```

### Get details of specific anime

```
   {
      "intent":"getAnime"
      "url":"http//:gogoanime.com/naruto"
   }
  
```

### Get video link
```
   {
      "intent":"episode"
      "url": "http//:www.gogoanime.com/naruto/"
      "episode_number":"13"
   }

```
# Note:

The above key values are required for the api to work, and all requests are handled by the same base url, for different functionality just the data posted will be changed as suggested above


# Projects Using GogoScraper
- [RawAnime](https://github.com/Rawkush/RawAnime)

# Contribution 

Want to contribute? Great!

Fork your own copy of this repository, make changes, update, fix bugs, add additional features or just prettify the code and create a pull request explaining what have you added fixed or improved so that we can merge it to our branch.




This library is being developed to be used in [RawAnime ](https://github.com/Rawkush/RawAnime)  Andriod application, but feel free to use it in your project. 

This Library is created for education purpose only and we shall not be responsible for its misuse.

#### If you are using our library please do tell us so we can add your project link.


##  TODO
 - getting direct link of videos 
 - adding more anime streaming websites
 - Download or stream any episode or episode range of any anime.
 - Specify the quality you want to stream or download.

### Supported Websites 
 
 - 9anime.to
 - kissanime.ru
 - gogoanime (currently this is the only one supported)
 - horriblesub.
 - animekisa
 - anistream
 - wonderfulsub
 - chia anime
 - ryuanime
 - BestAnimes
 - animeultima
 - animepahe
 - KissCartoon
 - twist.moe
 - animeflix (supported as it have API's)
 
 
# IMPORTANT NOTE
 This is API in created without the consent of the owner of the websites, the main purpose of this project was for me to learn webscraping, so if you want to use our API, we are not be held responsible for any legal action taken on you by the owner. 

## Arigatou Gozaimasu
