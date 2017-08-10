# activeMQDemo

This project is a small POC for activeMQ.

This POC code was created with Spring Boot and Apache Camel, to encapsulate the technical needs for deal with messages communication/synchronization, making it transparent and easy to understand.

In order to properly run this application you need to have downloaded [ActiveMQ](http://activemq.apache.org/download.html).

* Extract ActiveMQ file
* Run `./activemq start` in bin folder.
* Check your installation running on [http://localhost:8161/admin/](http://localhost:8161/admin/). When prompted, the default user/pass pair for the installation is admin/admin.

### Configuring ActiveMQ

Before running the application you need to replace the modified configuration files to make authentication and authorization works properly.

Copy the following files, under the [./src/main/resources](https://github.com/fzampa/activeMQDemo/tree/master/src/main/resources) folder:

* activemq.xml
* credentials.properties
* groups.properties
* login.configuration
* users.properties

And then paste these files on /conf folder under activeMQ installation path. You must replace the existing ones.

### Running the application

Having Maven installed, just run `mvn spring-boot:run`

## Testing the application

## Reading messages from queue

* On ActiveMQ administrator page, click on Queues link and then create a new queue named "test_queue".
* Click on "Send to" link on the right
* Write a message on text area and press "Send"
* Switch to the terminal window you ran the Spring Boot application and your message will be printed on console.

## Writing message on queue

* There is a web service running on Spring Boot application that allows you to send a message to an ActiveMQ queue just by accessing this link: [http://localhost:8080/send?message=MESSAGE](http://localhost:8080/send?message=MESSAGE)
* After making this GET call, refresh ActiveMQ administrators page to check there is another queue created, named "another_queue", which contains one message.
