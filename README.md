# redeggs - Parsing RED?gular EGGSpressions

[![Java](https://img.shields.io/badge/language-Java-blue.svg)](https://www.java.com/)
[![Build with Maven](https://img.shields.io/badge/build-Maven-ff69b4.svg)](https://maven.apache.org/)
[![GitHub Classroom](https://img.shields.io/badge/classroom-assignment-yellow.svg)](https://classroom.github.com/)
[![Tests](https://img.shields.io/badge/tests-failing-red.svg)](##-running-the-tests)

Welcome to **redeggs**, a Java-based starter project for building a recursive descent parser for regular expressions. This project kicks off your journey from raw regular expressions to a working lexer.

> ⚠️ **Heads Up!** Most tests will fail until you implement the core logic. That's not a bug - it's your job to fix it. 🧠



## 🧩 Project Overview

Your task is to implement a **recursive descent parser** that reads a regular expression and builds an **abstract syntax tree (AST)** representing its structure. This parser will serve as the foundation for more advanced projects where you'll generate **lexers** based on regular expressions.


### 💼 What's Provided

You've got a helpful starter pack:
- Java scaffolding for regex parsing
- Partial implementation of:
  - `RegularExpression` AST node classes
  - A `SymbolFactory` abstraction
  - A stubbed `RecursiveDescentRegexParser`
- A suite of unit tests (currently failing by design)

## 🎯 Your Mission

Crack open the structure of these EGGSpressions! Just kidding. Implement the `parse(String regex)` method in the `RecursiveDescentRegexParser` class. There's a `TODO` comment to guide your work.

This method should:
- Parse a regex string
- Return a corresponding AST built using `RegularExpression` classes

### Regex Features You'll Support

- **Literals**: `a`, `b`, ...
- **Character classes**: `[a-zA-Z_]`
- **Concatenation**: `ab`
- **Alternation**: `a|b`
- **Repetition (Kleene star)**: `a*`
- **Empty word**: `ε`
- **Empty set**: `∅`


## 🛠️ Requirements

- **Java 17** or higher
- **Maven** for building and testing

## 🚀 Getting Started

1. Clone the repo from GitHub Classroom
2. Make sure Java and Maven are installed
3. Open the project in your favorite IDE

## 🔧 Building the Project

To compile the project, run the following commands from the root of your redeggs project:

```bash
mvn compile
```

## 🧪 Running the Tests

Tests are located in `RecursiveDescentRegexParserTest`. They cover various regex constructs and validate the structure of your AST.

To run the tests:
```bash
mvn test
```

### What You'll See (Initially):

```bash
Tests run: 7, Failures: 6
```

Once you implement the parser correctly:

```bash
Tests run: 7, Failures: 0
```

## 📚 Learning Outcomes

By completing this assignment, you will:

- Understand the structure and syntax of regular expressions
- Learn how to write a recursive descent parser
- Gain hands-on experience with tree-based data structures
- Lay the groundwork for lexer and compiler generators


## 🧑‍💻 Assignment Checklist

1. Clone your repo from GitHub Classroom
2. Open `RecursiveDescentRegexParser`
3. Implement `parse(String regex)`
4. Use the provided tests to validate your work
5. Commit early and often
6. Push to GitHub and submit through Classroom

## 💡 Why "redeggs"?

Great question! It started with an AI pun on "regex" → "regeggs". With Easter nearby, I leaned into the seasonal fun and renamed it **redeggs**.

So yes - it's a regex parser, but with extra yolk and charm. 🐰🥚

## 🗂️ Project Status

| Component        | Status     |
|------------------|------------|
| AST Node Classes | ✅ Complete |
| Parser Skeleton  | ⚠️ Incomplete (You build it!) |
| Test Suite       | ✅ Provided |
| Easter Puns      | ✅ Included with care |


## 🙋 Questions?

If you're stuck, don't scramble! Ask for help. Either myself or your fellow students.

## 🐰 Good Luck and Happy Hatching!

Remember: failing tests are part of the journey.

Crack the code, hatch those eggs, and watch your parser come to life.

Will you spot all the Easter eggs hiding in your syntax trees?
