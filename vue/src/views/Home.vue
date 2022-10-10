<template>
  <body class="home">
    <h1 class="title" style="position: relative; top: 25px">Vending Machine</h1>
    <img
      alt="Vending Machine"
      src="../assets/vending.png"
      style="position: relative; top: 25px"
      class="blur"
      id="image"
    />
    <div class="vmPicker">
      <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">#</span>
        <input
          type="text"
          class="form-control"
          placeholder="Slot Location"
          aria-label="Slot Location"
          aria-describedby="button-addon2"
          v-model="slotLocation"
        />
        <button
          class="btn btn-primary"
          type="button"
          id="button-addon2"
        >
          Buy!
        </button>
      </div>

      <div
        class="btn-toolbar justify-content-between"
        role="toolbar"
        aria-label="Toolbar with button groups"
      >
        <div class="btn-group" role="group" aria-label="First group">
          <button type="radio" class="btn btn-outline-warning" v-on:click="changeSlot($event)">A1</button>
          <button type="button" class="btn btn-outline-warning" v-on:click="changeSlot($event)">A2</button>
          <button type="button" class="btn btn-outline-warning" v-on:click="changeSlot($event)">A3</button>
          <button type="button" class="btn btn-outline-warning" v-on:click="changeSlot($event)">A4</button>
        </div>
      </div>
      <div
        class="btn-toolbar justify-content-between"
        role="toolbar"
        aria-label="Toolbar with button groups"
      >
        <div class="btn-group" role="group" aria-label="First group">
          <button type="button" class="btn btn-outline-warning" v-on:click="changeSlot($event)">B1</button>
          <button type="button" class="btn btn-outline-warning" v-on:click="changeSlot($event)">B2</button>
          <button type="button" class="btn btn-outline-warning" v-on:click="changeSlot($event)">B3</button>
          <button type="button" class="btn btn-outline-warning" v-on:click="changeSlot($event)">B4</button>
        </div>
      </div>
      <div
        class="btn-toolbar justify-content-between"
        role="toolbar"
        aria-label="Toolbar with button groups"
      >
        <div class="btn-group" role="group" aria-label="First group">
          <button type="button" class="btn btn-outline-warning" v-on:click="changeSlot($event)">C1</button>
          <button type="button" class="btn btn-outline-warning" v-on:click="changeSlot($event)">C2</button>
          <button type="button" class="btn btn-outline-warning" v-on:click="changeSlot($event)">C3</button>
          <button type="button" class="btn btn-outline-warning" v-on:click="changeSlot($event)">C4</button>
        </div>
      </div>
      <div
        class="btn-toolbar justify-content-between"
        role="toolbar"
        aria-label="Toolbar with button groups"
      >
        <div class="btn-group" role="group" aria-label="First group">
          <button type="button" class="btn btn-outline-warning" v-on:click="changeSlot($event)">D1</button>
          <button type="button" class="btn btn-outline-warning" v-on:click="changeSlot($event)">D2</button>
          <button type="button" class="btn btn-outline-warning" v-on:click="changeSlot($event)">D3</button>
          <button type="button" class="btn btn-outline-warning" v-on:click="changeSlot($event)">D4</button>
        </div>
      </div>
      <div style="padding-bottom: 10px">Total Money: $</div>
      <div class="btn-group">
        <button
          type="button"
          class="btn btn-danger dropdown-toggle"
          data-bs-toggle="dropdown"
          aria-expanded="false"
        >
          Feed Money
        </button>
        <ul class="dropdown-menu">
          <li><a class="dropdown-item" href="#">$1</a></li>
          <li><a class="dropdown-item" href="#">$5</a></li>
          <li><a class="dropdown-item" href="#">$10</a></li>
        </ul>
      </div>
    </div>
  </body>
</template>

<script>
// @ is an alias to /src

export default {
  name: "Home",
  data() {
    return {
      slotLocation: "",
    };
  },
  components: {},
  methods: {
    changeSlot(event) {
      this.slotLocation = event.target.innerText;

    }
  }
};
</script>

<style>
.vmPicker {
  color: rgb(66, 135, 214);
  float: left;
  position: absolute;
  left: 38%;
  top: 300px;
  z-index: 1000;
  color: rgb(66, 135, 214);
  border-color: rgb(66, 135, 214);
  border-style: solid;
  border-radius: 60px;
  padding: 5px;
  height: 42%;
  width: 25%;
  font-weight: bold;
  background: #00050b;
  animation: fadeIn 5s;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.btn-toolbar {
  padding-bottom: 11px;
}
.mb-3 {
  padding-top: 10px;
  width: 70%;
}

@keyframes fadeIn {
  0% {
    opacity: 0;
  }
  100% {
    opacity: 1;
  }
}

.home {
  background: #00050b;
  font-family: "Brush Script MT", cursive;

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
  margin: 0 auto;
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