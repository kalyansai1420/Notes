# React

## Hooks

- **useState**
  - allows function component to have state
- **useEffect**
  - components do special things when they are created, updated & removed.
  - useEffect is like a side kick that helps us manage these special actions.
  - Component Did Mount
    - ` useEffect ( ()=> {
            //
            },[])`
  - Component Did Update
    - ` useEffect ( ()=>{
           //
        },[color])`
  - Component Will unmount
    -  ` useEffect ( ()=>{
       return ()=>{
            //
       }
      },[])`
  - two arguements
    - a callback function
    - an array of dependencies
  - useEffect is used to perform side effects in function component

- **Redux**
  - reducers
  - store
  - create redux slice in which initialization success & error state of API calls
  - index.js
    - set up redux store
    - pass root Reducer to initializer redux.
  - useSelector
    - get State
  - useDispatch
    - dispatch redux actions  