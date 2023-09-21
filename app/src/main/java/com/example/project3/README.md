# Project_03 - Arithmetic App
<span style="font-size: smaller;"><strong>Ashley Steitz and Jacob Fritz worked on this as partners</strong></span>

---
<span style="font-size: smaller;"><strong> Description </strong> </span>
In our efforts to complete Project 03 we implemented an interactive Ui (User Interface) that allows the user to select a arthmitic game that caters to their level of skill.
This includes selections of difficulty level and different arithmetic operators using radio buttons.

This app allows for 3 levels:
- Easy (numbers 1 - 10)
- Medium(numbers 1 - 25)
- Hard (numbers 1 - 50)

And 4 Arithmetic Operators:
- Multiplication
- Division
- Addition
- Subtraction

As well as the user to select how many questions they will be asked using "+" and "-" to add or subtract the number of questions before pressing the "Start" Button to begin the game.

To begin we have added 3 fragments that show the differing stages of the player's placement in the app. Fragment 1 is the selection screen that contains Radio Buttons that help makes the 
selection easy and simple by the user. Then we have a '+' and '-' button to help them select how many questions they will be asked. Finally the large "Start" button is pressed to take them 
to the next screen to begin the arithmetic game!

Fragment 2 handles the difficulty level as well as the operator selection to produce the right content for the user. Once they complete the total number of questions they press the "Done" button.
This takes them to the final fragment page.

Finally, Fragment 3 displays the score of the player and offers a "Retry" button to take them back to the start to play the game again!

## Functionality
'**' indicates tested in GIF  
The following **required** functionality is completed:
* the number sequence is randomly generated and is not easily replicated*
<br>
<span style="font-size: smaller;"><strong> tested prior to change of C button as mentioned in the inscribe post made by Ashley Steitz </strong></span>

**Demonstrated**
* [Easy] [Addition] [5 Questions] [Math Completed] [Done x 5 (after each problem)] [SCORE] [Retry]  
* [Hard] [Multiplication] [3 Questions] [Math Completed] [Done x 3 (after each problem)] [SCORE] [Rety]
* [Medium] [Subtraction] [2 Questions] [Math Completed] [Done x 2 (after each problem)] [SCORE] [Retry]
* [Hard] [Division] [10 Questions] [Math Completed] [Done x 10 (after each problem)] [SCORE] [END]


---
## Video Walkthrough
Watch a demonstration of each difficulty level and operation demonstrated in the gif available on Github
Here's a walkthrough of a few cases:

<img src='https://github.com/jfritz25/Calculator2.0/blob/master/app/src/main/java/com/example/calculator/Project_%202_GIF.gif' title='Project2 Video Walkthrough' width='50%' height = '50%' alt='Video Walkthrough' />

GIF created with [CloudConvert](https://cloudconvert.com/).

## Notes
UI Challenges:
- Obtaining the rounded edges using on the buttons
- Connecting the fragments
- Changing the version our gradle was using
- Adding in the necessary dependencies
- Using the linear and relative layouts to have the items site next to each other
  - specifically the radio buttons
- Understanding the Nav graph component

Backend Challenges:
- Implementing a way to pass items through safe args rather than bundles
- Understanding the inflating of views
- How to utilize onCreate() versus hard coding outside then calling it on inflate
- Passing items from one fragment to another

## License

    Copyright [2023] [Ashley Steitz, Jacob Fritz]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
