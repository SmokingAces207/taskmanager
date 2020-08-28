# Task-Manager-Spring-Boot

Project Notes:

This application is a simple task manager, it allows users to add tasks to a list.
They can set a date, priority, title and description.
Tasks can be updated after they are created, marked as complete, or deleted.
Another key feature of the application, is the ability to filter completed, or active tasks.

Two features that have yet to be fully implemented are the "Check All", and "Clear Completed" features.

This application consists of two microservices, one for the front end VueJS and one for the backend Java Spring boot.
The frontend (todo-vue) application runs on port 8080 of your localhost.
The backend (TaskManager) application runs on port 8081 of your localhost.

Maven command to main run application from root:
mvn spring-boot:run

To run front end applicaition. cd into todo-view folder, then run :
npm run dev

For this project I used NPM to manage my front end libraries.
VueJS is the front end framework of choice for this project. It is a lightweight framework, which is perfect for a small application like this.
I have decided to make use of SCSS, this gives me the option to nest selectors, which creates more powerful Style Sheets.
I also used the Animate CSS library to add some smooth animations to the project.

I've decided to use the Lombok library to avoid lots of extra boilerplate code, such as getters and setters. 
This helps the Entity files stay clean and easy to read.