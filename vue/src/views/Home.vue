<template>
  <body class="home">
    <h1 class="title" style="position: relative; top: 25px">
      Tasty TEch Vending
    </h1>
    <img
      alt="Vending Machine"
      src="../assets/vending.png"
      style="position: relative; top: 25px"
      class="blur"
      id="image"
    />
    <div class="vmPicker" id="vmPicker">
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
          v-on:click="purchase"
        >
          BUY
        </button>
      </div>
      <div style="padding-bottom: 10px">You selected:</div>
      <div style="padding-bottom: 10px">A1 Doritos $1.90</div>
      <div
        class="btn-toolbar justify-content-between"
        role="toolbar"
        aria-label="Toolbar with button groups"
      >
        <div class="btn-group" role="group" aria-label="First group">
          <button
            type="radio"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
            ref="myBtn"
          >
            A1
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
          >
            A2
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
          >
            A3
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
          >
            A4
          </button>
        </div>
      </div>
      <div
        class="btn-toolbar justify-content-between"
        role="toolbar"
        aria-label="Toolbar with button groups"
      >
        <div class="btn-group" role="group" aria-label="First group">
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
          >
            B1
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
          >
            B2
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
          >
            B3
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
          >
            B4
          </button>
        </div>
      </div>
      <div
        class="btn-toolbar justify-content-between"
        role="toolbar"
        aria-label="Toolbar with button groups"
      >
        <div class="btn-group" role="group" aria-label="First group">
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
          >
            C1
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
          >
            C2
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
          >
            C3
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
          >
            C4
          </button>
        </div>
      </div>
      <div
        class="btn-toolbar justify-content-between"
        role="toolbar"
        aria-label="Toolbar with button groups"
      >
        <div class="btn-group" role="group" aria-label="First group">
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
          >
            D1
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
          >
            D2
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
          >
            D3
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
          >
            D4
          </button>
        </div>
      </div>
      <div style="padding-bottom: 10px">Current Balance: $</div>
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

    <div class="bottomContainer">
      <div class="selectText" id="myBtn">SELECT YOUR ITEM</div>
      <div class="itemList">
        <img
          alt="Vending Machine"
          src="../assets/chips.png"
          style="position: relative; top: 25px"
          class="vmIcon"
          id="chips"
          v-on:click.prevent="toggleContainer($event)"
        />

        <img
          alt="Vending Machine"
          src="../assets/candy.png"
          style="position: relative; top: 25px"
          id="candy"
          class="vmIcon"
          v-on:click.prevent="toggleContainer($event)"
        />
        <img
          alt="Vending Machine"
          src="../assets/drinks.png"
          style="position: relative; top: 25px"
          id="drinks"
          class="vmIcon"
          v-on:click.prevent="toggleContainer($event)"
        />
        <img
          alt="Vending Machine"
          src="../assets/gum.png"
          style="position: relative; top: 25px"
          id="gum"
          class="vmIcon"
          v-on:click.prevent="toggleContainer($event)"
        />
      </div>
    </div>

    <div class="popupContainer" v-if="visibleContainer">
      <table class="table table-primary table-hover table-curved">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">{{ inventoryList[startingPoint].slotLocation }}</th>
            <td>{{ inventoryList[startingPoint].name }}</td>
            <td>{{ inventoryList[startingPoint].price }}</td>
          </tr>
          <tr>
            <th scope="row">
              {{ inventoryList[startingPoint + 1].slotLocation }}
            </th>
            <td>{{ inventoryList[startingPoint + 1].name }}</td>
            <td>{{ inventoryList[startingPoint + 1].price }}</td>
          </tr>
          <tr>
            <th scope="row">
              {{ inventoryList[startingPoint + 2].slotLocation }}
            </th>
            <td>{{ inventoryList[startingPoint + 2].name }}</td>
            <td>{{ inventoryList[startingPoint + 2].price }}</td>
          </tr>
          <tr>
            <th scope="row">
              {{ inventoryList[startingPoint + 3].slotLocation }}
            </th>
            <td>{{ inventoryList[startingPoint + 3].name }}</td>
            <td>{{ inventoryList[startingPoint + 3].price }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </body>
</template>

<script>
// @ is an alias to /src
import vmService from "../services/vmServices";

export default {
  name: "Home",
  data() {
    return {
      slotLocation: "",
      visibleContainer: false,
      inventoryList: {},
      startingPoint: "",
    };
  },
  components: {},
  methods: {
    changeSlot(event) {
      this.slotLocation = event.target.innerText;
    },
    purchase() {
      this.slotLocation = "";
    },
    selectItem() {
      // this should be use on the table rows to select an item off there with a click.
      // use the #id or class name orsomething to fire off if conditions
      const elem = this.$refs.myBtn;
      elem.click();
      elem.classList.add("active");
      setTimeout(function () {
        elem.classList.remove("active");
      }, 90);
    },
    toggleContainer(event) {
      if (event.target.id == "chips") {
        this.$el.querySelector("#vmPicker").scrollIntoView();
        this.startingPoint = 0;

        // if the container is already visible and this element has been selected 
        if (
          this.visibleContainer == true &&
          (event.target.classList.contains("selected"))
        ) {
          this.visibleContainer = false;
          event.target.classList.remove("selected");
        }

      // if the container is already visible and this element has not been selected
        if (
          this.visibleContainer == true &&
          !(event.target.classList.contains("selected"))
        ) {
          event.target.classList.add("selected");
        }

      // if this container is not visible and this element has not been selected
        if (
          this.visibleContainer == false &&
          !(event.target.classList.contains("select"))
        ) {
          this.visibleContainer = true;
          event.target.classList.add("selected");
        }

        // if this container is not visible and this element has been selected (WE DON'T WANT THIS CONDITION)
        if (
          this.visibleContainer == false &&
          (event.target.classList.contains("select"))
        ) {
          this.visibleContainer = true;
          event.target.classList.add("selected");
        }
      }

      if (event.target.id == "candy") {
        this.$el.querySelector("#vmPicker").scrollIntoView();
        this.startingPoint = 4;
        if (
          this.visibleContainer == true &&
          (event.target.classList.contains("selected"))
        ) {
          this.visibleContainer = false;
          event.target.classList.remove("selected");
        }

        if (
          this.visibleContainer == true &&
          !(event.target.classList.contains("selected"))
        ) {
          event.target.classList.add("selected");
        }

        if (
          this.visibleContainer == false &&
          !(event.target.classList.contains("select"))
        ) {
          this.visibleContainer = true;
          event.target.classList.add("selected");
        }
      }

      if (event.target.id == "drinks") {
        this.$el.querySelector("#vmPicker").scrollIntoView();
        this.startingPoint = 8;
        if (
          this.visibleContainer == true &&
          event.target.classList.contains("selected")
        ) {
          this.visibleContainer = false;
          event.target.classList.remove("selected");
        }

        if (
          this.visibleContainer == true &&
          !event.target.classList.contains("selected")
        ) {
          event.target.classList.add("selected");
        }

        if (
          this.visibleContainer == false &&
          !event.target.classList.contains("select")
        ) {
          this.visibleContainer = true;
          event.target.classList.add("selected");
        }
      }

      if (event.target.id == "gum") {
        this.$el.querySelector("#vmPicker").scrollIntoView();
        this.startingPoint = 12;
        if (
          this.visibleContainer == true &&
          event.target.classList.contains("selected")
        ) {
          this.visibleContainer = false;
          event.target.classList.remove("selected");
        }

        if (
          this.visibleContainer == true &&
          !event.target.classList.contains("selected")
        ) {
          event.target.classList.add("selected");
        }

        if (
          this.visibleContainer == false &&
          !event.target.classList.contains("select")
        ) {
          this.visibleContainer = true;
          event.target.classList.add("selected");
        }
      }
    },
  },
  created() {
    vmService.getInventoryList().then((response) => {
      this.inventoryList = response.data;
    });
  },
};
</script>

<style>
.vmPicker {
  color: rgb(66, 135, 214);
  float: left;
  position: absolute;
  left: 40%;
  top: 170px;
  z-index: 1000;
  color: rgb(66, 135, 214);
  border-color: rgb(66, 135, 214);
  border-style: solid;
  border-radius: 60px;
  padding: 5px;
  height: 46%;
  width: 20%;
  font-weight: bold;
  background: #00050b;
  animation: fadeIn 6s;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.bottomContainer {
  color: rgb(66, 135, 214);
  float: left;
  position: absolute;
  left: 37%;
  top: 67%;
  z-index: 999;
  color: rgb(66, 135, 214);
  border-color: rgb(66, 135, 214);
  border-style: solid;
  border-radius: 60px;
  height: 17%;
  width: 25%;
  font-weight: bold;
  background: #00050b;
  animation: fadeIn 6s;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.selected {
  border: 3px solid rgb(66, 135, 214);
  padding-top: 5px;
}

.popupContainer {
  color: rgb(66, 135, 214);
  float: left;
  position: absolute;
  left: 32%;
  top: 87%;
  z-index: 1000;
  color: rgb(66, 135, 214);
  border-color: rgb(66, 135, 214);
  border-style: solid;
  border-radius: 60px;
  height: 30%;
  width: 35%;
  font-weight: bold;
  background: #00050b;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.table-curved {
  margin-top: 20px;
  width: 70%;

  border-collapse: separate;
  border: solid #ccc 1px;
  border-radius: 6px;
  border-left: 0px;
  border-top: 0px;
}
.table-curved > thead:first-child > tr:first-child > th {
  border-bottom: 0px;
  border-top: solid #ccc 1px;
}
.table-curved td,
.table-curved th {
  border-left: 1px solid #ccc;
  border-top: 1px solid #ccc;
}
.table-curved > :first-child > :first-child > :first-child {
  border-radius: 6px 0 0 0;
}
.table-curved > :first-child > :first-child > :last-child {
  border-radius: 0 6px 0 0;
}
.table-curved > :last-child > :last-child > :first-child {
  border-radius: 0 0 0 6px;
}
.table-curved > :last-child > :last-child > :last-child {
  border-radius: 0 0 6px 0;
}

.itemList {
  height: 100%;
  width: 80%;
  animation: fadeIn 6s;
  display: flex;
  flex-direction: row;
  align-items: start;
  justify-content: center;
}
.vmIcon {
  height: 70%;
  width: 27%;
  padding-left: 10px;
  padding-right: 10px;
  padding-bottom: 10px;
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
  color: #53a3f3;
  border-color: #53a3f3;
  border-style: solid;
  border-radius: 60px;
  width: 500px;
  display: flex;
  justify-content: center;
  margin: 0 auto;
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