### distributed messgaing queue

#### what is messaging queue ? why its needed & its advantages ?
- In messaging queue we have producer, queue and consumer
- Use case
  - Asynchronous nature
    - In ecom, user buys a product and user doesn't require any notification immediately, so the message is sent through queue to send notification application due to this whole latency got reduce. 
    - retry capability
  - Pace matching
    - In e-com(20m/s) ,inventory(30m/s), application(10m/s) they all want to send the notification to send notification application, when they are all call the send notification application(15m/s), so adding message queue we have can pace matching.

#### what is point 2 point & pub/sub messaging types ?
- P2P 
  - When ever a publisher sends a particular message in queue either one consumer is used.
- Pub/Sub 
  - same message sent by publisher can be consumed by every consumer


#### How messaging queues works ? KAFKA & RABBITMQ
- Kafka
  - components
    - producer    
    - consumer
    - consumer group
    - topic
    - partition
    - offset
    - broker
    - cluster
    - zookeeper

