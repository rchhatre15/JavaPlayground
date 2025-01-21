# WebPageGen

A Java-based HTML page generator that allows programmatic creation of web pages through an object-oriented approach.

## Features

- Create HTML pages with various elements:
  - Paragraphs (`<p>`)
  - Lists (ordered `<ol>` and unordered `<ul>`)
  - Tables (`<table>`)
  - Images (`<img>`)
  - Anchors/Links (`<a>`)
  - Text elements
  - Custom HTML elements with attributes

- Automatic ID generation for HTML elements
- Proper HTML indentation support
- HTML file generation with UTF-8 encoding

## Project Structure
'''
WebPageGen/
├── src/
│   ├── model/
│   │   ├── AnchorElement.java
│   │   ├── Element.java
│   │   ├── HeadingElement.java
│   │   ├── ImageElement.java
│   │   ├── ListElement.java
│   │   ├── ParagraphElement.java
│   │   ├── TableElement.java
│   │   ├── TagElement.java
│   │   ├── TextElement.java
│   │   ├── Utilities.java
│   │   └── WebPage.java
│   └── tests/
│       ├── PublicTests.java
│       ├── StudentTests.java
│       └── TestingSupport.java
'''

## Usage Example

```java
// Create a new web page
WebPage page = new WebPage("My Page");

// Add a paragraph with text
ParagraphElement para = new ParagraphElement("");
para.addItem(new TextElement("Hello, World!"));
page.addElement(para);

// Generate HTML and write to file
page.writeToFile("output.html", 2);
```
