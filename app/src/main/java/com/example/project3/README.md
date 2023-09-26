# Project_04 - Arithmetic App (w/ Sound and a Toast)
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

To begin we took the previous 3 fragments and reduced it down to 2 fragments. 

Fragment 1 now starts as the original screen where the user is prompted to make a selection using the Radio Buttons for their arithmetic quiz.
We kept the same functionalities as Project3 with the  '+' and '-' button to help them select how many questions they will be asked. As well as the 
"Start" button that, when pressed, takes them to the next screen to begin the arithmetic game!

Fragment 2 handles the difficulty level as well as the operator selection to produce the right content for the user. The improvements made are including a sound that is made when the arithmetic
performed by the user is correct they hear a higher pitched "ring" and when they get the question wrong they hear a harsher sounding "buzzer" noise. At the end of their session their performance
is calculated and if they did better than 80% then they receive a congratulatory message. However if they score below 80% they are given an encouraging message to improve their abilities.

Once they complete the total number of questions they are taken to the main screen where they are gretted by their performance message and a "Toast" with a similar corresponding popup message:
- good work if they scored 80% or higher
- bad, they need to continue working on their arithmetic

Fragment 1 is back and the user has the opportunity to  play the game again!

## Functionality
'*' indicates tested in GIF  
The following **required** functionality is completed:
<br>
_the number sequence is randomly generated and is not easily replicated_
<br>
Safeargs was implemented to transfer data from fragment to fragment. That was we can access our equations and solutions in fragment 2 and the final score in fragment 3

**Demonstrated** 4753
* [Easy] [Subtraction] [2 Questions] [ 8 - 8 = 0 | 10 - 6 = 4 ] [Done x 2 (after each problem)] [SCORE (2/2)] [Retry]  
* [Medium] [Division] [5 Questions] [1/12 = 1 | 23/5 = 5 | 6/18 = .33 | 0/21 = 0 | 18/15 = 1] [Done x 5 (after each problem)] [SCORE (2/5)] [Retry]
* [Medium] [Multiplication] [3 Questions] [ 10 x 17 = 170| 25 * 22 = 232|9 * 4 = 36] [Done x 3 (after each problem)] [SCORE (2/3)] [Retry]
* [Hard] [Addition] [10 Questions] [30 + 26  =  56 |43 + 9 = 52| 49 + 10 = 59| 37 + 41 = 53| 2 + 22 =24 | 34 + 42 = 75| 14 + 8 = 31 |40 + 23 = 63| 12 + 18 = 40|41 + 18 = 12|Completed] [Done x 10 (after each problem)] [SCORE (5/10)] [Retry]
* [Medium] [Subtraction] [3 Questions] [18 - 25 =  122| 18 - 6 = 12 |20 - 5 = 15] [Done x 3 (after each problem)] [SCORE (2/3)] [END]


---
## Video Walkthrough
Watch a demonstration of each difficulty level and operation demonstrated in the gif available on Github
Here's a walkthrough of a few cases:

<img src='https://github.com/jfritz25/Project3/blob/master/app/src/main/java/com/example/project3/RecordingProject3.gif' title='Project3 Video Walkthrough' width='50%' height = '50%' alt='Video Walkthrough' />

GIF created with [CloudConvert](https://cloudconvert.com/).

## Notes
UI Challenges:
- integrating the raw file instead of creating a directory called "raw" .. it impacts how the mp3 files are handeled
- adding the new textView under the image and adjsuting the topMargin for all following values
- placement of the messageId (needed to be in fragment 1 but was in fragment2 for far too long)
- Obtaining the rounded edges using on the buttons
- Connecting the fragments
- Changing the version our gradle was using
- Adding in the necessary dependencies
- Using the linear and relative layouts to have the items site next to each other
  - specifically the radio buttons
- Understanding the Nav graph component


Backend Challenges:
- Integrating the messageId to the fragment arguments to be passed
- Integrating the 80% if statement to catch and display the according message
- Overriding the text value on the fragment 1 page to accommodate the above feature
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
