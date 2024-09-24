## Exercise: Semaphore-Based Printing

#### Objective: 
The objective of this exercise is to practice using semaphores to implement a print job scheduling system with multiple print jobs and printer resources.

#### Instructions:

1.	Create a class named PrintJobSchedulingExercise.
2.	Inside the class, define a shared list of print jobs, which can be represented as strings (e.g., "Job 1", "Job 2", etc.).
3.	Create a Semaphore instance named printerSemaphore to control access to the printer resources. Initialize the semaphore with the number of available printers (e.g., 2).
4.	Implement two classes that extend the Thread class: PrintJob and Printer. The PrintJob class represents a print job, and the Printer class represents a printer resource.
5.	In the PrintJob class, use the printerSemaphore to acquire a printer resource and simulate printing by displaying a message (e.g., "Printing Job 1"). After printing, release the printer resource.
6.	In the Printer class, use the printerSemaphore to represent a printer resource. Simulate a printer by displaying a message (e.g., "Printer is ready").
7.	Create multiple instances of the PrintJob class to represent different print jobs.
8.	Create multiple instances of the Printer class to represent the available printer resources.
9.	Print messages to show when print jobs are scheduled and printed.
