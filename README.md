<p align="center">
  <img src="/logo.png">
  <br/>
  <br/>
  <b>StoryTeller</b> is a terminal based character generator for Dungeons and Dragons.
  <br/>
  Thanks to our software, the character creation is streamlined with step by step instructions.
  <br/>
</p>

<hr>

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

When the character creation starts, the program will automatically simulate dice rolls to calculate six random values that the user will be able to assign to each of the Dungeons and Dragons stats: *Charisma*, *Constitution*, *Dexterity*, *Intelligence*, *Strength* and *Wisdom*.  

Each roll's value is determined by generating four random numbers and adding up the three highest ones.  
Once the rolls have been generated and displayed, the user can assign each value to a stat.
