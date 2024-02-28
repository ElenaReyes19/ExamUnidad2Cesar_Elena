<template>
  <div :class="{ 'hidden': !showCarousel }">
    <b-row @wheel.prevent="handleWheel">
      <b-carousel
        id="carousel-1"
        v-model="slide"
        :interval="4000"
        controls
        indicators
        background="#ababab"
        img-width="100%"
        img-height="400%"
        style="text-shadow: 1px 1px 2px #333"
        @sliding-start="onSlideStart"
        @sliding-end="onSlideEnd"
      >
        <!-- Tus slides aquí -->
        <b-carousel-slide
          caption="First slide"
          img-src="https://picsum.photos/1024/480/?image=52"
        ></b-carousel-slide>
        <b-carousel-slide
          caption="Second slide"
          img-src="https://picsum.photos/1024/480/?image=54"
        ></b-carousel-slide>
        
      </b-carousel>
    </b-row>
  </div>
</template>

<script>
export default {
  props: ['showCarousel'],
  data() {
    return {
      slide: 0,
      sliding: null,
    };
  },
  methods: {
    onSlideStart() {
      this.sliding = true;
    },
    onSlideEnd() {
      this.sliding = false;
    },
    handleWheel(event) {
      const delta = Math.sign(event.deltaY);
      if (delta === 1) {
        // Si el desplazamiento es hacia abajo, evita que el evento se propague más allá del carousel
        event.stopPropagation();
      }
    },
  },
};
</script>

<style scoped>
.hidden {
  display: none;
}
</style>
