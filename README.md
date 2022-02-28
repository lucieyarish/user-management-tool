# User Management System
* [Task Description](#task)
* [Project Design](#design)
* [Tech Stack](#techstack)
* [Process Documentation](#documentation)
* [Outcome](#outcome)
* [Self-Reflection](#self-reflection)


### Task Description

* Design and create an admin page for user management
* The page will display an overview of users
* There will be a filter block in front of the overview, which will allow filtering by id, name, surname, status, and
  creation date (from and to)
* The overview should be paged
* The user overview will contain the following information: id, name, surname, status (active, deactivated), email,
  phone, date of creation
* It will be possible to perform the following actions on each user: activate/deactivate, edit, delete

### Project Design

When you look at the [final result](#outcome), you will immediately notice that the initial design looks quite different. See [this](#self-reflection) section to read more about the project's drawbacks.

![page layout](https://github.com/lucieyarish/user-management-tool/blob/main/assets/layout.png)

![edit user](https://github.com/lucieyarish/user-management-tool/blob/main/assets/edit-usr.png)

### Tech Stack and Tools
* Spring Boot
* Gradle
* Spring Data JPA
* Hibernate
* PostgreSQL

* Thymeleaf
* Bootstrap

* Git
* GitHub

* Canva (design)
* Notion (progress notes)

### Process Documentation
The whole process began by designing the layout of the application in [Canva](https://www.canva.com) and research on Java Enterprise, JSF, and PrimeFaces. The attempt to build the project with the help of technologies that I wasn't familiar with was quickly abandoned due to time pressure. After deciding for the combination of Spring Boot, Thymeleaf and PostgreSQL, I also opted for dividing the entire project into respective featureas and work in separate branches here on GitHub.

![branches overview](https://github.com/lucieyarish/user-management-tool/blob/main/assets/branchesOverview.png)

The next step was to create project base structure and User database model. At the same time, I prepared [SQL queries](https://github.com/lucieyarish/user-management-tool/blob/main/assets/sampleData.txt) in order to load sample data into PostgreSQL and began to learn how to use Thymeleaf since I had never used it before. After that, I created index template and the necessary endpoints and methods to render the database data, and also added the logic needed for changing users' status (active/inactive).

In the next phase I worked on two CRUD operation features—the possibility of updating users' information and deleting them from the database. Next, I moved onto the filtering feature. I have decided to add a search bar and native queries that enable returning results which contain the searched keyword included in user's id, name, surname, email, creation date, and status. You might have noticed that there is no search bar in the application design. The reason behind that is that I misunderstood the assignment instructions and mistakened the filtering feature with ordering items in the database.

The final stage of the project was devoted to implementing pagination and a feature that provides users with search by date functionality, followed by refactoring, the addition of error handling, and this structured overview on GitHub.


### Outcome

##### Pagination Feature
![](https://github.com/lucieyarish/user-management-tool/blob/main/assets/pagination.mov)

##### Filtering 
![](https://github.com/lucieyarish/user-management-tool/blob/main/assets/filtering.mov)

##### Update Info & Remove User
![](https://github.com/lucieyarish/user-management-tool/blob/main/assets/crud.mov)

### Self-Reflection
