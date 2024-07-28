# Distributed Messaging Queue

## What is a messaging queue? Why is it needed and what are its advantages?

- In a messaging queue, we have a producer, queue, and consumer.

- Use cases:
  - Asynchronous nature:
    - In e-commerce, when a user buys a product and doesn't require immediate notification, the message is sent through a queue to the notification application, reducing latency.
    - Retry capability.
  - Pace matching:
    - In e-commerce (20m/s), inventory (30m/s), and application (10m/s), they all want to send notifications to the notification application. By adding a message queue, we can pace match.

## What are point-to-point and publish/subscribe messaging types?

- Point-to-point (P2P):
  - When a publisher sends a particular message in a queue, only one consumer is used.

- Publish/Subscribe (Pub/Sub):
  - The same message sent by a publisher can be consumed by every consumer.

## How do messaging queues work? KAFKA & RABBITMQ

- Kafka:
  - Components:
    - Producer
    - Consumer
    - Consumer group
    - Topic
    - Partition
    - Offset
    - Broker
    - Cluster
    - Zookeeper
