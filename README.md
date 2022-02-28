# User Management System

1. [Task Description](#task)
2. [Project Design](#design)
3. [Tech Stack](#techstack)
4. [Process Documentation](#documentation)
5. [Outcome](#outcome)
6. [Self-Reflection](#self-reflection)


## Task Description<a name="task"></a>

* Design and create an admin page for user management
* The page will display an overview of users
* There will be a filter block in front of the overview, which will allow filtering by id, name, surname, status, and
  creation date (from and to)
* The overview should be paged
* The user overview will contain the following information: id, name, surname, status (active, deactivated), email,
  phone, date of creation
* It will be possible to perform the following actions on each user: activate/deactivate, edit, delete

## Project Design<a name="design"></a>

When you look at the [final result](#outcome), you will immediately notice that the initial design looks quite different. See [this](#self-reflection) section to read more about the project's drawbacks.

![page layout](https://github.com/lucieyarish/user-management-tool/blob/main/assets/layout.png)

![edit user](https://github.com/lucieyarish/user-management-tool/blob/main/assets/edit-usr.png)

## Tech Stack and Tools<a name="techstack"></a>
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

## Process Documentation<a name="documentation"></a>
The whole process began by designing the layout of the application in [Canva](https://www.canva.com) and research on Java Enterprise, JSF, and PrimeFaces. The attempt to build the project with the help of technologies that I wasn't familiar with was quickly abandoned due to time pressure. After deciding for the combination of Spring Boot, Thymeleaf and PostgreSQL, I also opted for dividing the entire project into respective featureas and work in separate branches here on GitHub.

![branches overview](https://github.com/lucieyarish/user-management-tool/blob/main/assets/branchesOverview.png)

The next step was to create project base structure (Spring MVC)and User database model. At the same time, I prepared [SQL queries](https://github.com/lucieyarish/user-management-tool/blob/main/assets/sampleData.txt) in order to load sample data into PostgreSQL and began to learn how to use Thymeleaf since I had never used it before. After that, I created index template and the necessary endpoints and methods to render the database data, and also added the logic needed for changing users' status (active/inactive).

In the next phase I worked on two CRUD operation features—the possibility of updating users' information and deleting them from the database. Next, I moved onto the filtering feature. I have decided to add a search bar and native queries that enable returning results which contain the searched keyword included in user's id, name, surname, email, creation date, and status. You might have noticed that there is no search bar in the application design. The reason behind that is that I misunderstood the assignment instructions and mistakened the filtering feature with ordering items in the database.

The final stage of the project was devoted to implementing pagination and a feature that provides users with search by date functionality, followed by refactoring, the addition of error handling, and this structured overview on GitHub.


## Outcome<a name="outcome"></a>

### Pagination Feature
![](https://github.com/lucieyarish/user-management-tool/blob/main/assets/pagination.mov)

### Filtering 
![](https://github.com/lucieyarish/user-management-tool/blob/main/assets/filtering.mov)

### Update Info & Remove User
![](https://github.com/lucieyarish/user-management-tool/blob/main/assets/crud.mov)

## Self-Reflection<a name="self-reflection"></a>

Although I am very much aware that the application still needs a lot of work, I am quite happy with the result because I enjoyed the whole process and learned new things along the way. Just to name a few, I've learned how to keep better organized, had a chance to practice SQL, learned to work with Thymeleaf, and managed to create application structure and design from scratch. 

There are, of course, many drawbacks that need to be addressed:
* Not being able to build REST API (due to the use of Thymeleaf) had led to (sometimes) ugly endpoint naming 
* Even though the project is divided into branches based on its respective features, I would occasionally start working on unrelated functionalities by accident, and therefore failing to stick to the structure 100%
* When searching for users with either active or inactive status, keywords "true" and "false" have to be used
* Although I added result sorting function, users whom status is changed by clicking the status active/inactive link "automatically "jump" to the very end of the list
* My error handling skills are something that I am going to start working on as soon as possible
* There is code duplication present when filtering (because of paginated results)
* Tests are missing
* The [videos](#outcome) showcasing the app are extremely slow for some reason (I promise that I don't move my mouse this slow)

I have to say that I am very thankful for the opportunity to work on this great project which has helped me identify the skills that should be improved!
