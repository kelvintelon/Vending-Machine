<template>
  <body class="home">
    <h1 class="title" style = "position:relative; top:25px;">Vending Machine</h1>
    <img alt="Vending Machine" src="../assets/vending.png" style = "position:relative; top:25px;" class="blur" id="image">
  </body>
</template>

<script>
// @ is an alias to /src


export default {
  name: 'Home',
  components: {
    
  }
}
</script>

<style>
.home {
  background: #00050b;
  font-family: 'Brush Script MT', cursive;
  
  display: flex;
  flex-direction: column; 
}

.title {
  padding: 3px;
  color: rgb(66, 135, 214);
  border-color: rgb(66, 135, 214);
  border-style: solid;
  border-radius: 60px;
  width: 500px;
  display: flex;
  justify-content: center;
  margin:0 auto;
  
}

.image {
  
  /* display: flex;
  flex-basis: 100%; */
}

.blur {
  -webkit-animation: blur 0.5s linear forwards;
  -moz-animation: blur 0.5s linear forwards;
  -ms-animation: blur 0.5s linear forwards;
  -o-animation: blur 0.5s linear forwards;
  animation: blur 0.5s linear forwards;
  -webkit-animation-delay: 1s;
  -moz-animation-delay: 1s;
  animation-delay: 1s;
}
.delay {
  -webkit-animation-delay: 1s;
  -moz-animation-delay: 1s;
  animation-delay: 1s;
}
@-webkit-keyframes blur {
  to {
    -webkit-filter: blur(5px);
    filter: blur(5px);
  }
}
@-moz-keyframes blur {
  to {
    -moz-filter: blur(5px);
    filter: blur(5px);
  }
}
@keyframes blur {
  to {
    -webkit-filter: blur(5px);
    -moz-filter: blur(5px);
    filter: blur(5px);
  }
}

</style>