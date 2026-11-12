# JSH – Java Shell

### A Cross-Platform Command-Line Environment Using Java

## 1. Project Overview

JSH (Java Shell) is a command-line environment developed using Java. It provides users with a simple interface to interact with the filesystem through commands similar to those available in traditional operating system shells.

The project demonstrates the application of Object-Oriented Programming concepts, Java filesystem APIs, command parsing, exception handling, and modular software design.

## 2. Project Objectives

- Develop a command-line environment using Java.
- Implement commonly used filesystem commands.
- Understand and apply Object-Oriented Programming concepts.
- Implement command parsing and execution.
- Handle filesystem operations and exceptions.
- Create a modular and maintainable application architecture.
- Provide a simple and user-friendly command-line interface.

## 3. Features

JSH currently provides the following features:

- Interactive command-line interface.
- Directory navigation and management.
- File creation, reading, and deletion.
- Copying single and multiple files.
- Moving and renaming files.
- Moving single and multiple directories.
- Session-based command history.
- Searching for files and directories by name.
- Displaying directory structures using a tree representation.
- Support for quoted arguments containing spaces.
- Error handling for invalid commands and filesystem operations.

## 4. Supported Commands

| Command | Description |
|---|---|
| `pwd` | Displays the current working directory. |
| `ls` | Lists files and directories. |
| `cd` | Changes the current directory. |
| `mkdir` | Creates new directories. |
| `rmdir` | Removes empty directories. |
| `touch` | Creates new files. |
| `cat` | Displays file contents. |
| `rm` | Removes files. |
| `cp` | Copies single or multiple files to a destination. |
| `mv` | Moves or renames files and directories. Supports multiple sources. |
| `history` | Displays commands entered during the current session. |
| `find` | Searches for files and directories by name. |
| `tree` | Displays the directory hierarchy. |
| `exit` | Terminates the shell. |

## 5. Command Usage and Examples

### 5.1 Directory Operations

Display the current working directory:

```bash
JSH> pwd
```

List files and directories:

```bash
JSH> ls
```

Create a directory:

```bash
JSH> mkdir projects
```

Create multiple directories:

```bash
JSH> mkdir folder1 folder2 folder3
```

Change the current directory:

```bash
JSH> cd projects
```

Move to the parent directory:

```bash
JSH> cd ..
```

Remove an empty directory:

```bash
JSH> rmdir folder1
```

### 5.2 File Operations

Create a file:

```bash
JSH> touch notes.txt
```

Display file contents:

```bash
JSH> cat notes.txt
```

Delete a file:

```bash
JSH> rm notes.txt
```

### 5.3 Copy Operations

Copy a single file with a new name:

```bash
JSH> cp file1.txt backup.txt
```

Copy a file into an existing directory:

```bash
JSH> cp file1.txt backup
```

Copy multiple files into an existing directory:

```bash
JSH> cp file1.txt file2.txt file3.txt backup
```

### 5.4 Move Operations

Rename a file:

```bash
JSH> mv file1.txt renamed.txt
```

Move a file into an existing directory:

```bash
JSH> mv file1.txt backup
```

Move multiple files into an existing directory:

```bash
JSH> mv file1.txt file2.txt file3.txt backup
```

Move a directory into another directory:

```bash
JSH> mv projects backup
```

Rename a directory:

```bash
JSH> mv projects new_projects
```

Move multiple directories into an existing directory:

```bash
JSH> mv folder1 folder2 folder3 backup
```

### 5.5 Search and Navigation Operations

Search for a file or directory by name:

```bash
JSH> find notes.txt
```

Display the directory hierarchy:

```bash
JSH> tree
```

Display command history:

```bash
JSH> history
```

Terminate the shell:

```bash
JSH> exit
```

### 5.6 Paths Containing Spaces

JSH supports arguments enclosed in double quotation marks.

```bash
JSH> mkdir "My Projects"
JSH> cd "My Projects"
JSH> touch "my notes.txt"
JSH> cat "my notes.txt"
```

## 6. Technologies Used

- **Programming Language:** Java
- **Filesystem Operations:** Java NIO (`java.nio.file`)
- **Data Structures:** ArrayList, List, Map
- **Stream API:** Java Streams
- **Exception Handling:** Java Exception Handling
- **Development Environment:** Visual Studio Code
- **Version Control:** Git and GitHub

## 7. Project Structure

```text
JSH/
│
├── src/
│   │
│   ├── Main.java
│   │
│   ├── shell/
│   │   └── Shell.java
│   │
│   ├── parser/
│   │   └── CommandParser.java
│   │
│   └── commands/
│       ├── Command.java
│       ├── PwdCommand.java
│       ├── LsCommand.java
│       ├── CdCommand.java
│       ├── MkdirCommand.java
│       ├── RmdirCommand.java
│       ├── TouchCommand.java
│       ├── CatCommand.java
│       ├── RmCommand.java
│       ├── CpCommand.java
│       ├── MvCommand.java
│       ├── HistoryCommand.java
│       ├── FindCommand.java
│       └── TreeCommand.java
│
├── .gitignore
└── README.md
```

## 8. Application Architecture

JSH follows a modular, command-based architecture.

### Main.java

Acts as the entry point of the application. It creates the Shell object and starts the shell.

### Shell.java

Responsible for:

- Maintaining the command execution loop.
- Managing the current working directory.
- Registering available commands.
- Executing commands.
- Maintaining session-based command history.

### CommandParser.java

Processes user input and separates it into command names and arguments.

It also supports quoted arguments containing spaces and detects unclosed quotation marks.

### Command.java

An interface that defines a common execution contract for all command classes.

### Individual Command Classes

Each command is implemented in a separate class. These classes implement the Command interface and handle their respective filesystem operations.

## 9. Object-Oriented Programming Concepts

The project demonstrates the following OOP concepts:

### Abstraction

The Command interface provides a common execution contract without exposing the internal implementation of individual commands.

### Encapsulation

Command-specific implementation details are maintained within their respective classes. The Shell maintains its internal state and exposes required functionality through methods.

### Polymorphism

Different command objects are stored and executed through references of the common Command interface.

### Modularity

Each command has a separate implementation, making the application easier to maintain, test, and extend.

## 10. Installation and Setup

### Prerequisites

- Java Development Kit (JDK).
- Visual Studio Code or another Java-compatible IDE.
- Git (optional, for cloning the repository).

Verify Java installation:

```bash
java -version
javac -version
```

### Clone the Repository

```bash
git clone https://github.com/ansh47-art/JSH_Java_Shell.git
```

Navigate to the project directory:

```bash
cd JSH_Java_Shell
```

## 11. Compilation and Execution

From the project root directory, compile the Java source files:

```bash
javac -d out src/Main.java src/shell/Shell.java src/parser/CommandParser.java src/commands/*.java
```

Run the application:

```bash
java -cp out Main
```

## 12. Current Limitations

- Recursive directory deletion (`rm -r`) is not implemented.
- Command history is maintained only during the current session and is not saved permanently.
- Recursive directory copying is not implemented. The `cp` command currently supports individual files and multiple files.
- Directory moving is supported through `mv`, but moving across different filesystems may fail depending on the filesystem provider.
- Quoted arguments support double quotation marks, but escaped quotation marks are not supported.
- The shell does not currently implement every feature available in traditional Linux or Windows shells.

## 13. Future Enhancements

Possible future improvements include:

- Recursive directory deletion.
- Recursive directory copying.
- Persistent command history.
- Support for more complex command parsing.
- Additional filesystem commands.
- Improved cross-platform testing.
- Enhanced error reporting and user experience.

## 14. Contributors

Developed as a personal learning academic project for the Object-Oriented Programming laboratory.

## 15. License

This project is developed for educational purposes.