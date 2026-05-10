[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=23508260)
# AP Computer Science A – Final Project

---

## 🔹 Simulation of Sheep and Wolf Interactions

## 🔹 What This Software Does
This simulates very basic interactions between sheep, wolves, and plants. Watch the populations rise and fall as they interact with each other and the surrounding environment.

## 🔹 Who It’s For
This simulation is for those interested in exploring what an ecosystem is like, on a very basic scale. 

## 🔹 How to Run the Program
This project has a GUI component which cannot run on codespaces so must be opened in VS Code or used with an appropriate extension. 
The user starts the program and is able to select a default simulation size and number of wolve or customize a simulation. 
Watch the simulation until one population completely takes over or simply close the GUI screen in order to end the program. 

## 🔹 Technical Overview

- App: Runs the user input, the timer, and the JFrame for the simulation
- SimulationPanel: Runs the visual aspect of the JPanel changing
- Simulation: Runs the non visual aspects of the simulation updating, including removing dead animals
- Cell: Runs each individual cell, determining whether there are occupants etc., as well as controlling plants
- Animal: Basic movement and other methods for the Animals
- Prey: Extends the animal class with a custom isAlive, feeding, and reproduction
- Predator: Extends the animal class with a custom isAlive, hunting, and reproduction

- Some key data structures are the use of Java Swing and that Animal is extended to Prey and Predator

- The program sets the intial world, then each animal runs through potential actions, first looking for reproduction oppurtunites,feeding oppurtunities, then finally random movement


## 🔹 Class Diagram
<img width="1292" height="1676" alt="Image 5-10-26 at 10 45 AM" src="https://github.com/user-attachments/assets/74642832-ae48-4f9d-b101-c8b6ca44db2f" />


## 🔹 Known Limitations / Future Improvements
The actual code works well and smoothly, especially because there is not a lot of user input.
However, some of the logic is a little funky and some things don't make all the way sense, wolves
seem to live for much too long after all sheep die. Also some of the movement tends to go to the upper left corner,
while for some movement this issue has been resolved, it has not been resolved for eating plants and for reproduction.
Also there is a constant summary of the number of wolves and sheep and updates on what they are doing, but there is not a final summary when you
end the program. Also I did not add a lot of try catches for user input, so if the user puts in a String when prompted to put in an integer
the exception is not handled by me. 

---

