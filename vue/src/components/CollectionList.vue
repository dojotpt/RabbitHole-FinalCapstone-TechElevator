
<template>
    <div>
    <ul>
      <li v-for="collection in collections" :key="collection.id">
        {{ collection.title }}
      </li>
    </ul>
  </div>
  </template>
  
  <script>
  
  
  export default {
    props: {
    collections: {
      type: Array,
      required: true,
      
      
     }
        
        
    }
  
  
      
    
   
  }
  
  </script >
  
  <style scoped>
 .collection {
  border-bottom: 1px solid #f2f2f2;
}
.collection:last-child {
  border-bottom: 0px;
}
.collection a {
  display: block;
  padding: 10px 20px;
}
.collection a:link, .topic a:visited {
  color: blue;
  text-decoration: none;
}
.collection a:hover {
  background-color: #f2f2f2;
  cursor: pointer;
}
  



  </style>
  