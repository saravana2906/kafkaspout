# kafkaspout
Simple kafkaspout consumes POJO from kafka and counting order counts

This Application helps to add unique order id counts, which consumes Order POJO from kafka which uses custom deserialiser. <br>
OrderSpout emits orderid to ordercount bolt which has Set object contains received order ids and finally Set size helps us to get ordercount at any moment. <br>
You need producer program also to test this consumer , below is the given link <br>
https://github.com/saravana2906/kafkaproducer

