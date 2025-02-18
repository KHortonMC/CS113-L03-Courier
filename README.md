# Lab03 - Currier (Inventory Management)
A simple gather items and drop them off text adventure

## Objective
In this lab, students will build a text-based adventure where a player can move around a map, pick up items, and drop them off at designated locations. The game will enforce inventory rules using **ArrayLists** and **generics**.

## Learning Outcomes
- Use ArrayLists to manage dynamic collections of items.
- Implement generics and inheritance to categorize game objects.
- Design a player movement system within a grid-based world.
- Develop an algorithm to transport items from one part of the map to another.
- Gain experience with loops, conditionals, and object-oriented design.

## Scenario: Currier
You are a courier in a text dungeon. Your job is to collect items scattered across the map and deliver them to designated drop zones.

### Game Mechanics:
- The world is a 5x5 grid-based map.
- The player can move up, down, left, or right.
- Items appear at random locations in the dungeon.
- The player picks up items by moving onto their location.
- The goal is to carry the items to a designated drop zone.
- Items are stored in an ArrayList-based inventory system, categorized into Weapons, Potions, and Miscellaneous using generics and inheritance.

## Game World Setup
The world is a 5x5 grid, where:

- P = Player
- D = Drop zone
- W = Weapon
- H = Health Potion
- M = Miscellaneous item

> .   .   W   .   .  
> .   P   .   H   .  
> .   .   .   .   M  
> .   .   .   .   .  
> .   .   .   .   .  

The player starts at (1,1), can move around the map, pick up items, and deliver them to (2,0) (the drop zone).

### ✅ Task 1: Understand the Starter Code
Explain how the ArrayList is used for inventory storage.
Describe the player movement system in the grid.

### ✅ Task 2: Limit Inventory Size
Players should only be able to carry 3 items at a time. If the inventory is full, they must drop items before picking up more.

### ✅ Task 3: Add More Item Types
Introduce Armor and update the code to allow picking up Armor items.

### ✅ Task 4: Implement Enemy Obstacles (Challenge Task)
Add E (Enemies) to the map that block movement. Players must find alternate paths to pick up items.

### ✅ Bonus: Add a Score System
Give points for each item delivered. Keep track of total deliveries.

## Wrap-Up Questions
- How do ArrayLists help with managing dynamic game objects?
- How does inheritance make item handling more flexible?
- What improvements could be made to the game’s inventory system?
