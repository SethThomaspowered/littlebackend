# Little Library Back End Development

This is where I will be using Java to build a Spring Boot application to support my frontend
application [LittleFrontEnd](https://github.com/SethThomaspowered/littlefrontend). 
Project has been deployed on Heroku at (LittleBackend)[https://littlebackend.herokuapp.com]

## User Stories

## ERD

| Books | datatype |
|:-----:|:-----:|
| id    | Long PK |
| bookTitle | string |
| authorName | string |
| Date Added | number |
| IsAvailable | boolean |
| GoogleBooksID | string FK |

| Users | datatype |
|:-----:|:------:|
| id | Long PK |
| username | string |
| email | string |
| password | string |

| Recommendations | datatype |
|:------:|:-----:|
| id | Long PK|
| title | string |
| post | string |
| date | number |
| userId | Long FK |
| bookId | Long FK |

## Updated ERD
<img width="412" alt="image" src="https://user-images.githubusercontent.com/83875269/152061136-33ec5487-0153-4ab6-93ca-13e466c12a85.png">

## REST API Endpoints

## POM Dependencies
- spring-boot-starter-data-rest
- postgresql
- spring-boot-starter
- spring-boot-starter-data-jpa
- spring-boot-devtools
- spring-boot-starter-test
- heroku-deploy
- junit
## System Tools Used

## Project Timeline

### Day 1
- Write User Stories
- Create ERD
- Start project in SpringBoot using IntelliJ
- Built BookController, Book(model) BookRepository, BookService.
- First attempt to deploy to Heroku
### Day 2
- Tested endpoints
- Connected to frontend.
- Created model GBBook to record book info pulled from GoogleBooks
### Day 3
- First successful deployment
- 
### Day 4
- Connected deployed Front End to backend


### Day 5

## Hurdles

