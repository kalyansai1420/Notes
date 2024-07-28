# Concepts

## Middlewares

- Middlewares are code that runs before/after you request handler.
- It's commonly used for things
  - Analytics
  - Authentication
  - Redirecting the user

## Client Side rendering

- CSR is a modern technique used in web dev where the rendering of webpage is performed in the browser using JS.
- Instead of server sending a fully rendered HTML page to the client.
- First html page gets load which is blank
- Then, js runs and this injects code over the html
- This is what happens in the react which is not good.
  - Not SEO optimized
    - Bots do not understand the page
    - They scan the website before the js runs and injects code over the html
  - User sees a `flash` before the page renders
  - Waterfalling problem : request is been send one after another
    - browser(white page) hits some.com to CDN and gets index.html
    - sends again a request to CDN to get chunk.js. JS runs
    - Page renders with loader ---get my details---> backend server
    - Page renders with the user details

## Server Side rendering

- Solution for the above porblems in CSR
- When the rendering process (converting JS components to HTML) happens on the server, it's called SSR.
- Workflow
  - whitepage --------mywebsite.com------>Next Server
  - Page renders with the user details <------index.html is populated----- Next Server
- Why SSR?
  - SEO optimizations
  - Gets rid of the waterfalling problem
  - No white flash before you see content
- What happens is that
  - It converts the components into html and sent that from the backend
  - index.html is populated and shown in the browser
- Downsides of SSR?
  - Expensive since every request needs to render on the server
  - Harder to scale, you can't cache to CDNs

## Static site generation

- If a page uses **Static Generation**, the page HTML is generated at build time.
- That means in a productions, the page HTML is generated when you run `next build`.
- This HTML will then be reused on each request. It can be cached by a CDN.
- Why ?
  - If you use static site generation, you can defer the `expensive` operation of rendering a page to the `build time` so it only happens once.
- How ?
  - Let's say you have an endpoint that gives you all the `global` todos of an app.
  - By `global todos` we mean that they are the same for all users, and hence this page can be statically generated.
