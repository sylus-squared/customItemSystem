**This was my first real project learning to use the spigot API and it sucks** </br>
I was planning on remaking in now I know a lot more about spigot and can use it, but I can't be bothered </br>
I like preservation so im leaving up the repo but I really hate it </br>

This is a repo for a minecraft 1.18 custom item system I am making

You are welcome to use it if you want but I would not recomend it

This will probbly be very buggy and unstable ¯\_(ツ)_/¯. Feel free to open an issue if you find one but there is a low chance that I will acctually fix it in this plugin. Although it will help me with future plugins and systems.
Please bear in mind this is my first propper attempt at a plugin, all my others were just messing around


Planned:
Make a GUI based custom Item system

You should be able to apply enchants to the items as well as give it custom onclick properties from a list
For example you can choose a stick as an item and make it shoot arrows when right clicked
Another example is you can get a sword and make it launch the player up when they right click
Another example is you can take a pair of boots and make them launch you up when you press shift

Ideas for custom properties:

Items:

Right click the item and it will launch the player up 10 blocks **DONE**

Right click an item and it will strike lightning on everything within 5 blocks doing 10 damage **DONE**

Right click an item and it will shoot an arrow that damages anything in it's path **DONE**

Right click an item and it will throw a peice of TNT that will explode after 5 seconds **DONE**

Right click an item and it will shoot an egg  **DONE**

Right click an item and it will set anything in it's path on fire

Right click an item and it will launch all entities in a 5 block radius up 20 blocks **DONE**

Right click an item and it will rain anvils from the sky

Right click an item and it will have a 20% cahance to give you a gapple if you dont get it then you take 5 damage

Final one Right click an item and it will give all entities within a 30 block radius glow effect **DONE**

(An example of the GUI)
![The image](https://github.com/SylusSquared7/customItemSystem/tree/main/Images/ItemDemo.png?raw=true)

Armour:

Sneeking will launch the player up 20 blocks and negate their fall damage

One hit of damage will be negated

Blocks any arrow damage

Allows the player to use /fly

Gives the player 10s of levitation every 5mins. Also displays a chat message at 10 seconds saying levitation in 10s

Allows the player to double jump (It just adds 5 to their up velicoty when they press space while not on a block)

Gives the player a halo effect

Breaks as soon as the person is hit (Rubbish armour)

Drops iron golems from 30 blocks above the player when on 2hp (1 Heart) This one needs to check if there are blocks 30 blocks above the player

And finally lets the player be jesus and walk on water. It just needs to check if they are standing on water and teleport them up untill they are not This will need to take the item and add NBT data to it. For example it could add the NBT tag of leapingArmour for armour that makes the player jump higher.
