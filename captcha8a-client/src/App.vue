<template>
  <form @submit.prevent="submitForm">
    <label for="name">Nombre:</label><br />
    <input type="text" id="name" v-model="formData.name" required />
    <br />
    <hr />
    <div
      ref="container"
      class="frc-captcha"
      data-sitekey="FCMJUJQR4VOJVA4H"
      data-lang="es"
    ></div>
    <button type="submit">Enviar</button>
  </form>
</template>

<script>
import { WidgetInstance } from "friendly-challenge";
import { ref } from "vue";
export default {
  data() {
    return {
      container: ref(),
      widget: ref(),
      formData: {
        name: "",
      },
    };
  },
  methods: {
    doneCallback(solution) {
      console.log("CAPTCHA completed succesfully, solution:", solution);
      // ... Do something with the solution, maybe use it in a request
    },
    errorCallback(err) {
      console.log("There was an error when trying to solve the Captcha.");
      console.log(err);
    },
    submitForm() {
      console.log(this.formData);
    },
  },
  mounted() {
    if (this.$refs.container) {
      this.widget = new WidgetInstance(this.$refs.container, {
        startMode: "auto",
        doneCallback: this.doneCallback,
        errorCallback: this.errorCallback,
      });
    }
  },
  beforeDestroy() {
    if (this.widget) {
      this.widget.destroy();
    }
  },
};
</script>