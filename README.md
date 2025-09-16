# Mood Tracker Java Project

## **Project Overview**

The **Mood Tracker** is a console-based Java application that allows users to track, edit, and manage their daily moods. The app demonstrates the use of **Object-Oriented Programming (OOP)**, **Collections**, **Date & Time APIs**, and **File I/O** in Java.

---

## **Learning Objectives**

After completing this project, you will be able to:

* Create classes and objects using **OOP concepts**.
* Use **ArrayLists** to store and manage objects in memory.
* Work with **LocalDate** and **LocalTime** to track date and time.
* Implement **File I/O** operations to persist data.
* Handle **exceptions and input validation** in Java applications.

---

## **Features**

* **Add Mood:** Add a mood with name, date, time, and notes. Duplicate moods on the same date and time are prevented.
* **Edit Notes:** Modify notes for an existing mood entry.
* **Delete Mood:** Delete moods by date or by all details (name, date, time).
* **Search Mood:** Search moods by date or by all details.
* **View All Moods:** Display all recorded moods.
* **Save to File:** Write all moods to a file `moodtracker.txt` for persistence.

---

## **Technologies Used**

* **Java 17** or above
* **ArrayList** for object storage
* **LocalDate & LocalTime** for date and time tracking
* **FileWriter & PrintWriter** for file I/O
* **Scanner** for console input

---

## **Getting Started**

### **1. Clone the Repository**

```bash
git clone https://github.com/your-username/MoodTrackerJava.git
cd MoodTrackerJava
```

### **2. Compile the Java Files**

```bash
javac Mood.java MoodTracker.java
```

### **3. Run the Application**

```bash
java MoodTracker
```

---

## **Sample Console Run**

```
Welcome to Mood Tracker

Choose an option:
a - Add Mood
v - View All Moods
e - Edit Mood Notes
w - Write Moods to File
exit - Quit

Your choice: a
Enter mood name: Happy
Enter date (yyyy-MM-dd): 2025-09-16
Enter time (HH:mm): 09:30
Enter notes: Morning jog
✅ Mood added successfully.

Your choice: v
All tracked moods:
Mood{name='Happy', date=2025-09-16, time=09:30, notes='Morning jog'}
```

---

## **Project Structure**

```
MoodTrackerProject/
│
├── Mood.java            # Class representing a Mood object
├── MoodTracker.java     # Main application with menu and logic
├── moodtracker.txt      # Generated file containing saved moods
└── README.md            # Project documentation
```

---

## **How it Works**

1. User selects an option from the menu.
2. For **Add**, the app validates that a mood for the same date and time does not already exist.
3. Users can **edit**, **delete**, or **search** moods using simple inputs.
4. Moods can be **persisted to a text file** for future reference.

---

## **Author**

**Spandan Sen** – B.Tech CSE, STCET (MAKAUT)

---
