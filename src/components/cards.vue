<template>
    <div>
        <h4>cards</h4>
        <b-card
    
      v-for="(movie, index) in movies"
      :key="index"
      :title="movie.name"
      :img-src="getImgSrc()"
      img-alt="Image"
      img-top
      tag="article"
      style="max-width: 20rem; margin-bottom: 1rem;"
    >
    </b-card>
    </div>
</template>

<script>
export default {
    
        

}
</script>

<style>

</style>