### Week 2 (4/22 - 4/29)

I worked on the register entity with Bhavana again. 
I helped her fix the dependency problem.
This took some time because of the interwoven dependencies.
We had to remove the jpa repository queries for the register entity and tweaked register controller.
It was an issue with multiple jpa repositories interacting with each other and causing errors with the bean factory. 

I started the mysql implementation.
I created a prototype docker-compose.yaml for a mysql server.

![](images/mysql-docker.PNG)

I will probably have to switch to a different task due to the group's priorities.
We somewhat agreed that we focus on the core app first.
