<p align="center">
  <img src="/logo.png">
  <br/>
  <br/>
  <b>StoryTeller</b> is a terminal based character generator for Dungeons and Dragons 5th Edition SRD content.
  <br/>
  Thanks to our software, the character creation is streamlined with step by step instructions.
  <br/>
</p>

<hr>

<p align="center">
  LATEST RELEASE - StoryTeller v0.0.1.
</p>

<hr>

### Why are we making it?

We decided to make this software because we are both eager enthusiasts when it comes to Roleplaying games, especiallly Dungeons and Dragons, and wanted to give something back to the community, as the community surrounding roleplaying games have given us the tools to use in our games and as a result improved our experience playing the game.

We are also making it as most of the character creation tools out there are quite complicated and require alot of knowledge to make a character. With that in mind we wanted to make a minimalistic character creator that you can simply run on your computer and it will handle all the potentially difficult stuff of understanding how modifiers work when selecting your stats
to deciding a background, by limiting the options and handling what features these options give you in the background, while at the same time giving you the information to keep up with your character during the creation process.  


### How does it work?

*StoryTeller* follows the official Dungeons and Dragons character creations steps.  

#### STEP 1: Choose whether you want to create a new character or load one.
  
When you run the program, you will be asked whether you want to **load** a character or **create** a new one.  
  
##### Loading a character.

If you select to **load** a character, StoryTeller will automatically load the files with the `.stc` extension located in the `characters` folder in your *StoryTeller* installation folder.  
The program will automatically parse the character's name and display a list of all the characters found.

##### Creating a character.

If you select to **create** a new character, StoryTeller will initialize the character creation process.

#### STEP 2: Rolling and assigning stats.

When the character creation starts, the program will automatically simulate dice rolls to calculate six random values that the user will be able to assign to each of the characters stats: *Charisma*, *Constitution*, *Dexterity*, *Intelligence*, *Strength* and *Wisdom*.  

Each roll's value is determined by generating four random numbers and adding up the three highest ones.  
Once the rolls have been generated and displayed, the user can assign each value to a stat.


#### STEP 3: Choosing your character's name.

When you are done rolling and assigning stats, you will be able to choose a name for your character.

#### STEP 4: Choosing your character's gender.

Once you have chosen a name for your character, you will be able to choose your character's gender.  
To support diversity and ease impersonation of the characters, you will be able to choose between male, female or a third option that will allow you to specify another gender.

#### STEP 5: Choosing a race.

At this point, StoryTeller supports all the *nine* races. You can choose between *Dragonborn*, *Dwarf*, *Elf*, *Gnome*, *Half Elf*, *Half Orc*, *Halfling*, *Human* and *Tiefling*.  
Each race has its own perks and limits, that can be found in [our wiki page](https://github.com/Nosp1/Dnd/wiki/Races).

#### STEP 6: Choosing your age.

You will then have to pick your age, that has to be within the limits set by the race you have chosen.

#### STEP 7: Choosing a role.

StoryTeller currently supports *six* roles. You can choose between *Barbarian*, *Cleric*, *Druid*, *Fighter*, *Paladin* and *Rogue* with more to come in later releases.  

##### Selecting your skills.

Each role has access to a different set of skills among which you can choose proficiency in.  
To check which skill each role has available, check [our wiki page](https://github.com/Nosp1/Dnd/wiki/Roles).

#### STEP 8: Choosing a background.

StoryTeller supports backgrounds. At the moment, you can be an *Acolyte* or a *Criminal*.
To find out the differences between these backgrounds, check [our wiki page](https://github.com/Nosp1/Dnd/wiki/Backgrounds).

#### STEP 9: See a summary of your character.

When all the steps above have been completed, you will be able to see a summary of your character, and you will be able to choose whether you want to save it or not.

<hr>

### Future features:

To check out what we are working on check out [our Issues page](https://github.com/nosp1/Dnd/issues).

### How can you contribute?
This project is made in the spirit of open source and as such any form contribution is gladly accepted.
We the developers are mostly focused on the coding aspects of this application and will further improve on the applications features.

We currently have not set an end goal for this software, other than delivering a minimalistic character creator, as we wish for it to evolve into something not only made by us but a greater community, therefore we glady accept any of form of ideas or general comments or concerns you might have reagarding future development of this project as long as the comments are kept healthy and
in a civil manor, as we are pretty inexperienced with open source and development in general. 

If you wish to contribute with code or any ideas to further develop this project, or simply wish for your awsome custom Race or Role to be implemented, we sugest that you follow our [contribution guide](https://github.com/Nosp1/Dnd/wiki/Contributions-guide).



  
