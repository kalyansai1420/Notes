# Queues, Pub Subs and Redis

## What are we learning

- Queues
- Pub Subs
- Redis

More specifically, we're learning how we would build a system like leetcode

## Part 1 - Queues

- Use case : Video transcoding in youtube
- When you have users to do long running expensive operation be it submiting a leetcode submission or uploading a video in the youtube for transcoding for converting it into 720p,360p
- We need to use an architecture like this
- We need to upscale and downscale workers based on the length of the queue
- After the worker is done, it can tell a pub/sub please send this status.
- It won't talk to websocket, since there are many websockets present which worker does not know to which websocket the user is connected to send the status of the user.
- So using Pub/sub websocket can get the response by subscribing to Pub/sub and send it to user
- Final Architecture Image




