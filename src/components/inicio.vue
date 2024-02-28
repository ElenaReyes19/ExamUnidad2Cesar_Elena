<template>
    <div class="contenedori">
        <carousel :showCarousel="showCarousel" />

        <div class="container">
            <b-modal id="modal-1" title="Registro de Libros" v-model="showModal">
                <b-form @submit="onSubmit" @reset="onReset">
                    <b-form-group id="input-group-1" label="Nombre del libro:" label-for="input-1"
                        description="Registra el nombre latinoamericano.">
                        <b-form-input id="input-1" v-model="form.name" type="text"
                            placeholder="Ingresa el nombre del libro." required></b-form-input>
                    </b-form-group>

                    <b-form-group id="input-group-2" label="Nombre del autor:" label-for="input-1"
                        description="Registra el nombre del director.">
                        <b-form-input id="input-1" v-model="form.name" type="text"
                            placeholder="Ingresa el nombre del libro." required></b-form-input>
                    </b-form-group>


                    <b-datepicker id="input-3" v-model="form.publishDate" class="mb-2" required
                        placeholder="Ingresa la fecha de publicacion">
                    </b-datepicker>



                    <b-form-group id="input-group-4" label="Imagen" label-for="input-4">
                        <b-form-file id="input-4" v-model="form.image" accept="image/*"></b-form-file>
                    </b-form-group>

                    <b-button type="submit" variant="primary">Registrar</b-button>

                </b-form>
            </b-modal>

            <b-modal id="modal-2" title="Re" v-model="showModal">
                <b-form @submit="onSubmit" @reset="onReset">
                    <b-form-group id="input-group-1" label="Nombre del libro:" label-for="input-1"
                        description="Registra el nombre latinoamericano.">
                        <b-form-input id="input-1" v-model="form.name" type="text"
                            placeholder="Ingresa el nombre del libro." required></b-form-input>
                    </b-form-group>

                    <b-form-group id="input-group-2" label="Nombre del autor:" label-for="input-1"
                        description="Registra el nombre del director.">
                        <b-form-input id="input-1" v-model="form.name" type="text"
                            placeholder="Ingresa el nombre del libro." required></b-form-input>
                    </b-form-group>


                    <b-datepicker id="input-3" v-model="form.publishDate" class="mb-2" required
                        placeholder="Ingresa la fecha de publicacion">
                    </b-datepicker>



                    <b-form-group id="input-group-4" label="Imagen" label-for="input-4">
                        <b-form-file id="input-4" v-model="form.image" accept="image/*"></b-form-file>
                    </b-form-group>

                    <b-button type="submit" variant="primary">Registrar</b-button>

                </b-form>
            </b-modal>


            <h1>Inicio vue</h1>

            <div class="contenedorC">
                <b-col @click="openModal" lg="4" class="pb-2"><b-button size="sm">Registrar</b-button></b-col>
                <b-col lg="4" class="pb-2"><b-button size="sm">Eliminar</b-button></b-col>
                <b-col lg="4" class="pb-2"><b-button size="sm">Actualizar</b-button></b-col>

            </div>

            <pre>

                </pre>
            <div class="contenedor">
                <b-col lg="4" class="pb-2"><b-button size="lg">Ordebar por autor</b-button></b-col>
                <b-col lg="4" class="pb-2"><b-button size="lg">Ordenar por fecha</b-button></b-col>
                <b-col lg="4" class="pb-2"><b-button size="lg">Mostrar por fecha</b-button></b-col>
            </div>
        </div>


        <cards />
    </div>
</template>

<script>
import registrar from './registrar.vue';
import carousel from './carousel.vue'
import cards from './cards.vue'
export default {
    components: { carousel, cards, registrar },



    data() {
        return {
            showCarousel: true,
            showModal: false,
            form: {
                name: '',
                year: '',
                genre: '',
                image: null
            },
            genres: [],
            movies: []
        }
    },
    mounted() {
        window.addEventListener('scroll', this.handleScroll);
    },
    destroyed() {
        window.removeEventListener('scroll', this.handleScroll);
    },


    methods: {
        handleScroll() {
            // Lógica para determinar si se debe mostrar u ocultar el carousel basado en el desplazamiento
            if (window.scrollY > 100) {
                this.showCarousel = false;
            } else {
                this.showCarousel = true;
            }
        },

        openModal() {
            this.showModal = true
        },
        onSubmit(evt) {
            evt.preventDefault()
            console.log(this.form)
            this.showModal = false
        },
        onReset(evt) {
            evt.preventDefault()
            this.form.name = ''
            this.form.year = ''
            this.form.genre = ''
            this.form.image = null
            this.showModal = false
        },



    },




}
</script>




<style >
.contenedor {
    display: flex;
    justify-content: center;
    height: absolute;
    background-color: bisque;
}

.contenedorC {
    display: flex;
    background-color: azure;
}

.contenedori {
    background-color: #ababab;

    text-shadow: 1px 1px 2px #333;
    height: ;
    padding: 100px;
    margin: 20px;
}
</style>