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
          v-model="displaySlotLocation"
          disabled="disabled"
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
      <div style="padding-bottom: 10px">
        #{{ selectedSlotLocation ? selectedSlotLocation : "None" }}
        {{ selectedItemName }} ${{
          selectedItemPrice ? selectedItemPrice : "0"
        }}
      </div>
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
            ref="a1Btn"
          >
            A1
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
            ref="a2Btn"
          >
            A2
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
            ref="a3Btn"
          >
            A3
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
            ref="a4Btn"
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
            ref="b1Btn"
          >
            B1
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
            ref="b2Btn"
          >
            B2
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
            ref="b3Btn"
          >
            B3
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
            ref="b4Btn"
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
            ref="c1Btn"
          >
            C1
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
            ref="c2Btn"
          >
            C2
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
            ref="c3Btn"
          >
            C3
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
            ref="c4Btn"
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
            ref="d1Btn"
          >
            D1
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
            ref="d2Btn"
          >
            D2
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
            ref="d3Btn"
          >
            D3
          </button>
          <button
            type="button"
            class="btn btn-outline-warning"
            v-on:click="changeSlot($event)"
            ref="d4Btn"
          >
            D4
          </button>
        </div>
      </div>
      <div style="padding-bottom: 10px">Current Balance: ${{ balance.toFixed(2) }}</div>
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
          <li v-on:click="addMoney(1)">
            <a class="dropdown-item" href="#">$1</a>
          </li>
          <li v-on:click="addMoney(5)">
            <a class="dropdown-item" href="#">$5</a>
          </li>
          <li v-on:click="addMoney(10)">
            <a class="dropdown-item" href="#">$10</a>
          </li>
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
            <th scope="col">
              {{ inventoryList[startingPoint].category }} Name
            </th>
            <th scope="col">Price</th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-on:click="
              selectItem(
                1,
                inventoryList[startingPoint].slotLocation,
                inventoryList[startingPoint].name,
                inventoryList[startingPoint].price,
                inventoryList[startingPoint].category,
                inventoryList[startingPoint].inventory
              )
            "
          >
            <th scope="row">{{ inventoryList[startingPoint].slotLocation }}</th>
            <td>{{ inventoryList[startingPoint].name }}</td>
            <td>{{ inventoryList[startingPoint].price }}</td>
          </tr>
          <tr
            v-on:click="
              selectItem(
                2,
                inventoryList[startingPoint + 1].slotLocation,
                inventoryList[startingPoint + 1].name,
                inventoryList[startingPoint + 1].price,
                inventoryList[startingPoint + 1].category,
                inventoryList[startingPoint + 1].inventory
              )
            "
          >
            <th scope="row">
              {{ inventoryList[startingPoint + 1].slotLocation }}
            </th>
            <td>{{ inventoryList[startingPoint + 1].name }}</td>
            <td>{{ inventoryList[startingPoint + 1].price }}</td>
          </tr>
          <tr
            v-on:click="
              selectItem(
                3,
                inventoryList[startingPoint + 2].slotLocation,
                inventoryList[startingPoint + 2].name,
                inventoryList[startingPoint + 2].price,
                inventoryList[startingPoint + 2].category,
                inventoryList[startingPoint + 2].inventory
              )
            "
          >
            <th scope="row">
              {{ inventoryList[startingPoint + 2].slotLocation }}
            </th>
            <td>{{ inventoryList[startingPoint + 2].name }}</td>
            <td>{{ inventoryList[startingPoint + 2].price }}</td>
          </tr>
          <tr
            v-on:click="
              selectItem(
                4,
                inventoryList[startingPoint + 3].slotLocation,
                inventoryList[startingPoint + 3].name,
                inventoryList[startingPoint + 3].price,
                inventoryList[startingPoint + 3].category,
                inventoryList[startingPoint + 3].inventory
              )
            "
          >
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
      displaySlotLocation: "",
      selectedSlotLocation: "",
      selectedItemName: "",
      selectedItemPrice: "",
      selectedItemCategory: "",
      selectedItemInventory: 0,
      visibleContainer: false,
      inventoryList: {},
      startingPoint: "",
      balance: 0,
    };
  },
  components: {},
  methods: {
    addMoney(int) {
      this.balance = this.balance + int;
    },
    changeSlot(event) {
      this.displaySlotLocation = event.target.innerText;
      for (let index = 0; index < this.inventoryList.length; index++) {
        if (
          this.inventoryList[index].slotLocation == this.displaySlotLocation
        ) {
          this.selectedSlotLocation = this.inventoryList[index].slotLocation;
          this.selectedItemName = this.inventoryList[index].name;
          this.selectedItemPrice = this.inventoryList[index].price;
          this.selectedItemCategory = this.inventoryList[index].catgory;
          this.selectedItemInventory = this.inventoryList[index].inventory;
        }
      }
    },
    purchase() {
      if (this.balance == 0) {
        alert("Please Feed Money Into The Machine");
      }
      if (this.balance > 0 && this.selectedSlotLocation == "") {
        alert("Please Select an Item");
      }
      if (
        this.balance > 0 &&
        this.selectedSlotLocation != "" &&
        this.balance - this.selectedItemPrice < 0
      ) {
        alert("Please Feed More Money To Buy Selected Item");
      }
      if (
        this.balance > 0 &&
        this.selectedSlotLocation != "" &&
        this.balance - this.selectedItemPrice > 0
      ) {
        // check inventory for updates
        for (let index = 0; index < this.inventoryList.length; index++) {
            if (this.selectedSlotLocation == this.inventoryList[index].slotLocation) {
              this.selectedItemInventory = this.inventoryList[index].inventory;
            }
          }
        if (this.selectedItemInventory > 0) {
          // subtracts from balance
          this.balance = this.balance - this.selectedItemPrice;
          // updates inventory
          for (let index = 0; index < this.inventoryList.length; index++) {
            if (this.selectedSlotLocation == this.inventoryList[index].slotLocation) {
              this.inventoryList[index].inventory = this.inventoryList[index].inventory - 1
              this.selectedItemInventory = this.inventoryList[index].inventory
            }
          }
          // does the alert
          alert("You got: " + this.selectedItemName +"\r\n" + "Quantity left of Item: " + this.selectedItemInventory);
        } else {
          alert("Item Out of Stock, please choose another item")
        }
      }
    },
    selectItem(id, location, name, price, category, inventory) {
      if (this.startingPoint == 0) {
        if (id == 1) {
          const elem = this.$refs.a1Btn;
          elem.click();
          elem.classList.add("active");
          setTimeout(function () {
            elem.classList.remove("active");
          }, 90);
        }
        if (id == 2) {
          const elem = this.$refs.a2Btn;
          elem.click();
          elem.classList.add("active");
          setTimeout(function () {
            elem.classList.remove("active");
          }, 90);
        }
        if (id == 3) {
          const elem = this.$refs.a3Btn;
          elem.click();
          elem.classList.add("active");
          setTimeout(function () {
            elem.classList.remove("active");
          }, 90);
        }
        if (id == 4) {
          const elem = this.$refs.a4Btn;
          elem.click();
          elem.classList.add("active");
          setTimeout(function () {
            elem.classList.remove("active");
          }, 90);
        }
      }

      if (this.startingPoint == 4) {
        if (id == 1) {
          const elem = this.$refs.b1Btn;
          elem.click();
          elem.classList.add("active");
          setTimeout(function () {
            elem.classList.remove("active");
          }, 90);
        }
        if (id == 2) {
          const elem = this.$refs.b2Btn;
          elem.click();
          elem.classList.add("active");
          setTimeout(function () {
            elem.classList.remove("active");
          }, 90);
        }
        if (id == 3) {
          const elem = this.$refs.b3Btn;
          elem.click();
          elem.classList.add("active");
          setTimeout(function () {
            elem.classList.remove("active");
          }, 90);
        }
        if (id == 4) {
          const elem = this.$refs.b4Btn;
          elem.click();
          elem.classList.add("active");
          setTimeout(function () {
            elem.classList.remove("active");
          }, 90);
        }
      }

      if (this.startingPoint == 8) {
        if (id == 1) {
          const elem = this.$refs.c1Btn;
          elem.click();
          elem.classList.add("active");
          setTimeout(function () {
            elem.classList.remove("active");
          }, 90);
        }
        if (id == 2) {
          const elem = this.$refs.c2Btn;
          elem.click();
          elem.classList.add("active");
          setTimeout(function () {
            elem.classList.remove("active");
          }, 90);
        }
        if (id == 3) {
          const elem = this.$refs.c3Btn;
          elem.click();
          elem.classList.add("active");
          setTimeout(function () {
            elem.classList.remove("active");
          }, 90);
        }
        if (id == 4) {
          const elem = this.$refs.c4Btn;
          elem.click();
          elem.classList.add("active");
          setTimeout(function () {
            elem.classList.remove("active");
          }, 90);
        }
      }

      if (this.startingPoint == 12) {
        if (id == 1) {
          const elem = this.$refs.d1Btn;
          elem.click();
          elem.classList.add("active");
          setTimeout(function () {
            elem.classList.remove("active");
          }, 90);
        }
        if (id == 2) {
          const elem = this.$refs.d2Btn;
          elem.click();
          elem.classList.add("active");
          setTimeout(function () {
            elem.classList.remove("active");
          }, 90);
        }
        if (id == 3) {
          const elem = this.$refs.d3Btn;
          elem.click();
          elem.classList.add("active");
          setTimeout(function () {
            elem.classList.remove("active");
          }, 90);
        }
        if (id == 4) {
          const elem = this.$refs.d4Btn;
          elem.click();
          elem.classList.add("active");
          setTimeout(function () {
            elem.classList.remove("active");
          }, 90);
        }
        this.selectedSlotLocation = location;
        this.selectedItemName = name;
        this.selectedItemPrice = price;
        this.selectedItemCategory = category;
        this.selectedItemInventory = inventory;
      }
    },
    toggleContainer(event) {
      if (event.target.id == "chips") {
        this.$el.querySelector("#vmPicker").scrollIntoView();
        this.startingPoint = 0;

        // if the container is already visible and this element is already selected(THIS SHOULD HIDE THE CONTAINER AND REMOVE THE "SELECTED" CLASS)
        if (
          this.visibleContainer == true &&
          event.target.classList.contains("selected")
        ) {
          this.visibleContainer = false;
          event.target.classList.remove("selected");
        }

        // if the container is already visible and this element has not been selected(WHEN YOU SWITCH FROM ONE SNACK TO ANOTHER)
        if (
          this.visibleContainer == true &&
          !event.target.classList.contains("selected")
        ) {
          event.target.classList.add("selected");
        }

        // if this container is not visible and this element has not been selected(HAPPY PATH)
        if (
          this.visibleContainer == false &&
          !event.target.classList.contains("select")
        ) {
          this.visibleContainer = true;
          event.target.classList.add("selected");
        }

        // if this container is not visible and this element is already seleced selected (WE DON'T WANT THIS CONDITION TO HAPPEN IN THE FIRST PLACE)
        if (
          this.visibleContainer == false &&
          event.target.classList.contains("select")
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