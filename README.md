# Club Management System (Algorithms & OOP Project)

Welcome to the **Club Management System**, a Java-based application developed as a course project for **Algorithms and Data Structures (Level 2, Semester 2)**. 

This project integrates foundational **Object-Oriented Programming (OOP)** concepts with advanced structural algorithms to efficiently manage and process records for Clubs, Members, and Sports activities.

---

## 📌 Features & Core Implementations

The system manages three primary entities, each utilizing a specific sorting algorithm optimized for its structure, followed by fast binary searching capabilities:

### 1. Data Models (OOP Structure)
* **Club:** Contains details such as name, number of branches, manager, and location.
* **Member:** Tracks individual profiles using unique IDs, names, phone numbers, and family details.
* **Sport:** Manages sports categories, unique IDs, and associated team counts.

### 2. Algorithmic Processing (Sorting & Searching)
* 🧩 **Merge Sort (Clubs by Name):** Automatically sorts added clubs alphabetically with a time complexity of $O(N \log N)$.
* ⚡ **Quick Sort (Members by ID):** Sorts members instantly based on their unique ID using a divide-and-conquer strategy.
* 📥 **Insertion Sort (Sports by Name):** Efficiently organizes sports names in alphabetical order.
* 🔍 **Binary Search:** Provides ultra-fast search operations ($O(\log N)$) to find specific Clubs by Name or Members by ID, leveraging the pre-sorted arrays.

---

## 📷 Program Execution & Output Previews

Here are the visual demonstrations of the system in action, showcasing data input, execution flow, and algorithmic sorting:

### 1. Main System Menu & Setup
The main dashboard provides an interactive terminal loop preventing improper sequential flows:
<br>
<img src="project/photo/Screenshot 2026-06-29 134210.png" alt="System Setup" width="100%">

### 2. Algorithmic Sorting & Previews
Once the records are inputted, the corresponding backend sorting algorithm triggers automatically to structure the dataset:

<table>
  <tr>
    <td width="50%"><b>Club Sorting (Merge Sort) & Search</b></td>
    <td width="50%"><b>Member Sorting (Quick Sort)</b></td>
  </tr>
  <tr>
    <td><img src="project/photo/Screenshot 2026-06-29 134228.png" alt="Club Preview"></td>
    <td><img src="project/photo/Screenshot 2026-06-29 134237.png" alt="Member Preview"></td>
  </tr>
</table>
## 🚀 Technical Requirements & Execution

### Prerequisites
* Java Development Kit (JDK) 8 or higher.
* Any standard IDE (IntelliJ IDEA, Eclipse, VS Code) or terminal environment.

### How to Run
1. **Clone the repository:**
   ```bash
   git clone [https://github.com/youssefsaber592-netizen/club-management-system-algorithms.git](https://github.com/youssefsaber592-netizen/club-management-system-algorithms.git)
