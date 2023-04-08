# Recursive Navigation
A mobile app that allows you to create a tree structure consisting of nodes, each of which has a name, children, and a reference to its parent. The app has a single screen with recursive navigation within this tree. You can create and delete entities at each level, and the state of the tree is saved on the device and pulled up on the next login. The node name is formed from the last 20 bytes of the node's hash, similar to Ethereum wallet addresses.

Technologies Used
Hilt: dependency injection library for Android
AndroidX Activity KTX: provides Kotlin extensions for Android activities
ViewModel: architecture component for managing UI-related data in a lifecycle-conscious way
Room: persistence library for local data storage
Gson: a Java serialization/deserialization library to convert Java Objects into JSON and back
Coroutines: a lightweight framework for asynchronous programming in Java and Kotlin
Kotlinx Serialization: a Kotlin library for serialization and deserialization of JSON objects
Bouncy Castle Provider: a Java library that provides security features such as cryptography algorithms
Getting Started
Prerequisites
Android Studio 4.0 or higher
Gradle 6.5 or higher
Installation
Clone the repo:
bash
Copy code
git clone https://github.com/ahmed-tech-t/recursive_navigation.git
Open the project in Android Studio.

Build and run the app.

Usage
The app's main screen displays the root level of the tree. You can navigate to the child levels by clicking on the nodes. To create a new node, click on the "Add" button at the top right corner of the screen. To delete a node, long press on the node you want to delete and click on the "Delete" button.

The state of the tree is automatically saved on the device and retrieved on the next login.

License
This project is licensed under the MIT License. See the LICENSE file for details.

Acknowledgements
This project was inspired by the concept of tree data structure.
Thanks to the open source community for providing useful libraries and tools.
