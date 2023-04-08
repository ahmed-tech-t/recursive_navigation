<h1> Recursive Navigation </h1>
A mobile app that allows you to create a tree structure consisting of nodes, each of which has a name, children, and a reference to its parent. The app has a single screen with recursive navigation within this tree. You can create and delete entities at each level, and the state of the tree is saved on the device and pulled up on the next login. The node name is formed from the last 20 bytes of the node's hash, similar to Ethereum wallet addresses.

<h2> Technologies Used </h2>

* <b> Hilt </b> : dependency injection library for Android

* <b> AndroidX Activity KTX  </b> : provides Kotlin extensions for Android activities

* <b> ViewModel </b> : architecture component for managing UI-related data in a lifecycle-conscious way

* <b> Room  </b> : persistence library for local data storage

* <b> Gson  </b> : a Java serialization/deserialization library to convert Java Objects into JSON and back

* <b> Coroutines  </b> : a lightweight framework for asynchronous programming in Java and Kotlin

<h2> Getting Started </h2>

<h3> Prerequisites </h3>

* Android Studio 4.0 or higher
* Gradle 6.5 or higher

<h3> Installation </h3>

* Clone the repo:
* bash

<h3> Copy code </h3>

git clone https://github.com/ahmed-tech-t/recursive_navigation.git

Open the project in Android Studio.

Build and run the app.

<h2> Usage </h2>
* The app's main screen displays the secound level of the tree. 
* You can navigate to the child levels by clicking on the nodes. 
* To create a new node , click on the "Add" button at the bottom right corner of the screen. 
* To delete a node, swipe the node to left or right and you can undo deletion by clicking undo in snackbar.

The state of the tree is automatically saved on the device and retrieved on the next login.

<h2> License </h2>
This project is licensed under the MIT License. See the LICENSE file for details.

<h2> Acknowledgements </h2>
This project was inspired by the concept of tree data structure.

Thanks to the open source community for providing useful libraries and tools.
