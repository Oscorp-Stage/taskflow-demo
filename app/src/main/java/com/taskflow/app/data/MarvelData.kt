package com.taskflow.app.data

data class MarvelEntity(
    val name: String,
    val img: String,
    val children: List<Group>?
)

data class Group(
    val name: String,
    val children: List<Character>?
)

data class Character(
    val hero: String,
    val name: String,
    val link: String,
    val img: String,
    val size: Int
)

val marvelJSONObject = """
{
{
 "name": "marvel",
 "img": "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/marvel.png",
 "children": [
  {
   "name": "Heroes",
   "children": [
    {
      "hero": "Spider-Man",
      "name": "Peter Benjamin Parker", 
      "link": "http://marvel.com/characters/54/spider-man",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/top_spiderman.png",
      "size": 40000
    },
    {
      "hero": "CAPTAIN MARVEL",
      "name": "Carol Danvers", 
      "link": "http://marvel.com/characters/9/captain_marvel",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/top_captainmarvel.png",
      "size": 40000
    },
    {
      "hero": "HULK", 
      "name": "Robert Bruce Banner",
      "link": "http://marvel.com/characters/25/hulk",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/top_hulk.png",
      "size": 40000
    },
    {
      "hero": "Black Widow", 
      "name": "Natalia 'Natasha' Alianovna Romanova",
      "link": "http://marvel.com/characters/6/black_widow",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/top_blackwidow.png",
      "size": 40000
    },
    {
      "hero": "Daredevil", 
      "name": "Matthew Michael Murdock",
      "link": "http://marvel.com/characters/11/daredevil",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/top_daredevil.png",
      "size": 40000
    },
    {
      "hero": "Wolverine", 
      "name": "James Howlett",
      "link": "http://marvel.com/characters/66/wolverine",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/top_wolverine.png",
      "size": 40000
    },
    {
      "hero": "Captain America", 
      "name": "Steven Rogers",
      "link": "http://marvel.com/characters/8/captain_america",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/top_captainamerica.png",
      "size": 40000
    },
    {
      "hero": "Iron Man", 
      "name": "Anthony Edward 'Tony' Stark",
      "link": "http://marvel.com/characters/29/iron_man",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/top_ironman.png",
      "size": 40000
    },
    {
      "hero": "THOR", 
      "name": "Thor Odinson",
      "link": "http://marvel.com/characters/60/thor",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/top_thor.png",
      "size": 40000
    }
  ]
  },
  {
   "name": "Villains",
   "children": [
    {
      "hero": "Dr. Doom",
      "name": "Victor von Doom", 
      "link": "http://marvel.com/characters/13/dr_doom",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/drdoom.png",
      "size": 40000
    },
    {
      "hero": "Mystique",
      "name": "Unrevealed", 
      "link": "http://marvel.com/characters/1552/mystique",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/mystique.png",
      "size": 40000
    },
    {
      "hero": "Red Skull",
      "name": "Johann Shmidt", 
      "link": "http://marvel.com/characters/1901/red_skull",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/redskull.png",
      "size": 40000
    },
    {
      "hero": "Ronan",
      "name": "Ronan", 
      "link": "http://marvel.com/characters/49/ronan",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/ronan.png",
      "size": 40000
    },
    {
      "hero": "Magneto",
      "name": "Max Eisenhardt", 
      "link": "http://marvel.com/characters/35/magneto",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/magneto.png",
      "size": 40000
    },
    {
      "hero": "Thanos",
      "name": "Thanos", 
      "link": "http://marvel.com/characters/58/thanos",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/thanos.png",
      "size": 40000
    },
    {
      "hero": "Black Cat",
      "name": "Felicia Hardy", 
      "link": "http://marvel.com/characters/271/black_cat",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/blackcat.png",
      "size": 40000
    }
   ]
  },
  {
   "name": "Teams",
   "children": [
    {
      "hero": "Avengers",
      "name": "", 
      "link": "http://marvel.com/characters/68/avengers",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/avengers.png",
      "size": 40000
    },
    {
      "hero": "Guardians of the Galaxy",
      "name": "", 
      "link": "http://marvel.com/characters/70/guardians_of_the_galaxy",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/gofgalaxy.png",
      "size": 40000
    },
    {
      "hero": "Defenders",
      "name": "", 
      "link": "http://marvel.com/characters/534/defenders",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/defenders.png",
      "size": 40000
    },
    {
      "hero": "X-Men",
      "name": "", 
      "link": "http://marvel.com/characters/71/x-men",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/xmen.png",
      "size": 40000
    },
    {
      "hero": "Fantastic Four",
      "name": "", 
      "link": "http://marvel.com/characters/69/fantastic_four",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/fantasticfour.png",
      "size": 40000
    },
    {
      "hero": "Inhumans",
      "name": "", 
      "link": "http://marvel.com/characters/1040/inhumans",
      "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/inhumans.png",
      "size": 40000
    }
   ]
  }  
 ]
}
"""