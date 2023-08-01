# Moving Object Simulator
This console application simulates a moving object on a table and checks if the combination of movements ends up in the object going out of bounds or not.


If the object's final position is within the table, the simulation is considered successful and the final coordinates will be printed to the console.


If the object's final position is outside the table's limits, the simulation is considered failed and [-1,-1] will be printed.


## How to use
The application will accept two rows of input from the user. 
Both rows consist of integers separated by commas. 


First row accepts only 4 digits `w,h,x,y`  where w = width, h = height,
x = starting position on x-axis,
y = starting position on y-axis.

Second row accepts a longer sequence of digits ranging from 0-4 that represents commands:

- 0 = quit simulation and print results
- 1 = move forward one step
- 2 = move backwards one step
- 3 = rotate clockwise 90 degrees (e.g. north to East)
- 4 = rotate counterclockwise 90 degrees (e.g. west to South)

Origo is the top left corner of the table. 
The object has a default direction set to North.

### Example
If the program gets 4,4,2,2 as input for the first row, the table is initiated to size 4 x 4 with the object in the starting
position [2, 2] with direction north. 

If the sequence 1,4,1,3,2,3,2,4,1,0 are input for the second row
and executed. 

The final output would then be the final position [0, 1] which means a successful simulation.

## How to run
Clone the repository and run the application using your preferred IDEA.

### Requirements
- Java Development Kit (JDK):
Version 11 or higher.

- Apache Maven:
Version 3.0.5 or higher.

- Any Java compatible IDEA: e.g. IntelliJ.

Environment variables must be set to the correct Program folder paths!

### Run using IntelliJ
Open the project using IntelliJ by selecting the pom.xml file.
Build and run application from the menu tab > Run > Run 'Main' or press Shift+F10 (Windows).

## Limitations
The application assumes a perfect user who will enter the correct input format.
There are no checks or handling of invalid inputs from the user.

The simulation does not fail as soon as one command in the input sequence puts the object out of the table range.
As long as the final coordinates are within the table range, the simulation is considered successful.