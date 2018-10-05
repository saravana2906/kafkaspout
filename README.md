# kafkaspout
Simple kafkaspout consumes Order POJO from kafka and counting order counts

This Application helps to add unique order id counts, which consumes Order POJO from kafka which uses custom deserialiser. <br>
OrderSpout emits orderid to ordercount bolt which has Set object contains received order ids and finally Set size helps us to get ordercount at any moment. <br>
You need producer program also to test this consumer , below is the link <br>
https://github.com/saravana2906/kafkaproducer

<br>
I have used same zookeeper instance for kafka and storm.<br>
started the required services in the below order for kafka<br>.
zookeeper<br>
nimbus<br>
supervisor<br>
ui<br>

Don't forget to start the kafka, and once zookeeper started, you can start kafka server.<br>

First start the topology which acts as consumer which is never ending process.<br>

Next start the producer you can also have loop to post more orders. producer program given will post only one order and you can see the results in topology execution where , order counts will get printed for every order you receives from kafka.<br>

