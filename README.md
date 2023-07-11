# Java-Mini-Projects
This repository contains 3 mini projects in Java which use Java Swing and multithreading.

**Project "Store".**
A simple simulation of the store.
1. load from a text file and display the items available in the store
2. the customer places an order, i.e. can:
- check if the item is available,
- put selected available articles into the "basket",
- price the "basket" of the order,
- complete the order (deduct the purchased articles from the store's inventory)
3. display the articles available in the store after realization
and update the file with them


**Project "Circles"**
Multi-threaded application using Java Swing.
1. display a window containing:
- a large circle with n colored circles
- a slider for the angular velocity of a given circle (for the value 0 - max)
2. the wheels move around the circle in the same direction
3. the angular velocity of a given caster changes as the assigned slider changes

Each circle
- has to be handled by a separate thread
- has a unique color, corresponding to the thread number
-has a randomly selected unique initial position and a randomly selected initial
angular velocity
- has an angular velocity controlled by a parameter (associated with the thread of a given circle), changed by a slider.
The number of circles n is to be specified from the program call line.
The circles must not overlap or overtake each other, i.e. slower circles slow down (block) faster circles behind them if touched by them.
The current position of the slider is to match the current speed of the associated circle.
The area where the circles move is to be a shared resource.



**Project "Snails"**
Multi-threaded application using Java Swing.
Easy sharing by threads (critical section) - leaf

A rectangle of size w × h, made of program call lines
- The leaf is divided into cells of size 1×1, taking values 0-10
- The value 0-10 defines the shade of color (dark green) and the amount of food (a lot).
The thread responsible for refreshing resources:
- It is supposed to run only one
- At specified intervals, it is to increment the values stored in the leaf cells
- While incrementing the cell values, it is supposed to block other threads accessing the leaf.
Snail thread:
- There are to be n threads (snails) running, the number n is to be specified from the program call line
- The snail is to be represented by a small red dot, moving incrementally on the leaf by 1 cell in a row, column or slant - towards the neighboring unoccupied cell with the largest value, greater than 0 and from the value of the current cell
- If there is more than one possibility to move the snail, the cell is to be randomized
- If there is no possibility for the slug to move, it has to be put to sleep for time t ( Snail thread parameter)
The snail is supposed to consume the leaf at a rate of v (The snail's thread parameter, the rate of decrement of the value of the cell the snail is on).
