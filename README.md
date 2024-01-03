# Mars Rover

## Problem Statement:

A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.

A rover’s position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points (North, South, East, or West). The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.

In order to control a rover, NASA sends a simple string of letters. The possible letters are ‘L’, ‘R’ and ‘M’. ‘L’ and ‘R’ makes the rover spin 90 degrees left or right respectively, without moving from its current spot. ‘M’ means move forward one grid point, and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1).  Assume that the square directly East from (x, y) is (x+1, y).

### INPUT: 

The rover begins at position 0, 0 and accepts either L R or M as an input. Based on this input, a new set of coordinates is returned, as well as the current direction the rover is facing. 

The position is made up of two integers and a letter separated by spaces, corresponding to the x and y coordinates and the rover’s orientation.

### OUTPUT:

The output for each rover should be its final co-ordinates and the direction.

i.e. `The rover's current coordinates are (0, 4) and it is facing S`

The above state could be achieved by the following sequence: 

Input: `M`

Output: `The rover's current coordinates are (0, 1) and it is facing N`

Input: `M`

Output: `The rover's current coordinates are (0, 2) and it is facing N`

Input: `M`

Output: `The rover's current coordinates are (0, 3) and it is facing N`

Input: `M`

Output: `The rover's current coordinates are (0, 4) and it is facing N`

Input: `L`

Output: `The rover's current coordinates are (0, 4) and it is facing W`

Input: `L`

Output: `The rover's current coordinates are (0, 4) and it is facing S`


## Challenge:

Note: It would be helpful to read and understand each of these before starting.

1. Design objects or functions to describe the Rover.
2. Add functions/methods to support the command to move, and the command to change direction.
3. Return the result, formatted as per the above 
4. Stretch Goal 1: Add boundaries to the space that prevents movement outside of a certain set of coordinates
5. Stretch Goal 2: Add an additional rover and alternate between Rovers for each input. Ensure that the Rovers do not overlap. 
6. Stretch Goal 3: Add “boulders” in a couple of grid locations and have the Rovers avoid them.
7. Stretch Goal 4:  Verbally describe a design that would represent a Driver and talk through how you would have a Driver with a single Rover, cover every valid square in the grid. (Keeping in mind that there can still be boulders)
