# EXAM 1: LegoSet Assignment

## Assignment
In this assignment, you must work with LEGO sets. The `legosets.LegoSet` record class represents a LEGO set, and it has the following components:

* number: `String`
* name: `String`
* year: `java.time.Year`
* theme: `String`
* subtheme: `String`, may be null
* numberOfPieces: `int`
* numberOfMinifigs: `int`
* tags: `Set`
* availability: `legosets.LegoSet.Availability` (`LEGO_EXCLUSIVE`, `RETAIL`, `RETAIL_LIMITED`)

Under the `src/main/resources/legosets` directory, you can find a binary file named `legosets.ser`. It contains a list of `LegoSet` objects written into the file with object serialization.
The `legosets.LegoSetManager` interface provides support to work with `LegoSet` objects. Its default method `getLegoSets()` returns the list of the objects. The interface contains five abstract interface methods.

## Preparations
Building the project requires JDK 21 or newer. All Git operations must be executed in your directory that contains the project's `pom.xml` file.

Create an empty Git repository by executing the command:
`git init`

Configure Git properly, setting the `user.name` and the `user.email` options in the repository with:
`git config --local user.name "your_full_name"`
`git config --local user.email "your_email"`
(To prove your identity, you must provide your full official name, in the same form as also shown in Neptun).

Import the directory of the project into the Git repository by executing:
`git add .`
`git commit -m "initial import"`

## Interface Implementation
Your job is to create a class named `LegoSetManagerImpl` in the `legosets` package that implements the interface.

First, implement the interface with the Implement Methods feature of IntelliJ IDEA. This will create stubs for the interface methods.

In the `LegoSetManagerImpl` class, add a `main` method. In the first line of the `main` method, declare a local variable whose value is a reference to an instance of the class:
`var manager = new LegoSetManagerImpl();`

Git operation: Add the `LegoSetManagerImpl` class with the method stubs and the main method to the repository in a commit whose message is:
`feat: add LegoSetManagerImpl class with method stubs`

In the `LegoSetManagerImpl` class, you must implement each abstract interface method. The bodies of the methods must contain only a single stream pipeline; nothing else is allowed! An interface method whose body contains anything other than a stream pipeline is rejected.

To demonstrate the use of the interface, you must call all five abstract methods of the interface on the instance in the `main` method. If a method returns a value, it must be printed to the console.

Git operation: Commit the changes with the message:
`fix: implement interface methods in LegoSetManagerImpl`

## Adding Dependencies to the Project
Git operation: In the repository, create a branch named `new-feature` and switch to it. The remaining changes must happen on the `new-feature` branch.
`git checkout -b new-feature`

In the `pom.xml` file, add the record-builder dependency and the annotation processor configuration to the project so you can use the Soabase Record Builder library (Group ID: `io.soabase.record-builder`, Artifact ID: `record-builder-core` and `record-builder-processor`, Version: `52`).

Important: After adding the dependencies, right-click `pom.xml` on the Project tab, then choose Sync Project from the Maven submenu.

Git operation: Commit the changes with the message:
`build: add record-builder dependencies to pom.xml`

Now, make the following changes to the code. First, annotate the `LegoSet` record class with:
`@io.soabase.recordbuilder.core.RecordBuilder`

Compile the project to generate the `LegoSetBuilder` class. In your `LegoSetManagerImpl` main method, write a quick test to prove the generated feature works by building and printing a custom `LegoSet` using the builder.

Git operation: Commit the changes with the message:
`feat: add fancy new feature with record-builder to LegoSet`

## Submitting Your Work
You must submit your project's working directory as a ZIP archive that also contains your Git repository, i.e., the `.git` folder.
