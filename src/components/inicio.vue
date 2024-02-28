<template>
    <div class="contenedori">
        <div>
            <carousel :showCarousel="showCarousel" />
        </div>
        <div class="container">
            <b-modal id="modal-1" title="Registro de Libros" v-model="showModalRegistrar">
                <b-form @submit="onSubmitRegistrar" @reset="onReset">
                    <b-form-group id="input-group-1" label="Nombre del libro:" label-for="input-1"
                        description="Registra el nombre latinoamericano.">
                        <b-form-input id="input-1" v-model="form.name" type="text"
                            placeholder="Ingresa el nombre del libro." required></b-form-input>
                    </b-form-group>

                    <b-form-group id="input-group-2" label="Nombre del autor:" label-for="input-2"
                        description="Registra el nombre del autor.">
                        <b-form-input id="input-2" v-model="form.author" type="text"
                            placeholder="Ingresa el nombre del autor." required></b-form-input>
                    </b-form-group>

                    <b-form-group id="input-group-3" label="Fecha de publicación:" label-for="input-3"
                        description="Registra la fecha de publicación.">
                        <b-datepicker id="input-3" v-model="form.publishDate" class="mb-2" required
                            placeholder="Ingresa la fecha de publicación">
                        </b-datepicker>
                    </b-form-group>

                    <b-form-group id="input-group-4" label="Imagen" label-for="input-4">
                        <b-form-file id="input-4" v-model="form.image" accept="image/*"></b-form-file>
                    </b-form-group>

                    <b-button type="submit" variant="primary">Registrar</b-button>

                </b-form>
            </b-modal>

            <b-modal id="modal-2" title="Actualizar libro" v-model="showModalActualizar">
                <b-form @submit="onSubmitActualizar" @reset="onReset">
                    <b-form-group id="input-group-5" label="Nombre del libro:" label-for="input-5"
                        description="Ingresa el nombre del libro.">
                        <b-form-input id="input-5" v-model="form.name" type="text"
                            placeholder="Ingresa el nombre del libro." required></b-form-input>
                    </b-form-group>

                    <b-form-group id="input-group-6" label="Nombre del autor:" label-for="input-6"
                        description="Ingresa el nombre del autor.">
                        <b-form-input id="input-6" v-model="form.author" type="text"
                            placeholder="Ingresa el nombre del autor." required></b-form-input>
                    </b-form-group>

                    <b-form-group id="input-group-7" label="Fecha de publicación:" label-for="input-7"
                        description="Ingresa la fecha de publicación.">
                        <b-datepicker id="input-7" v-model="form.publishDate" class="mb-2" required
                            placeholder="Ingresa la fecha de publicación">
                        </b-datepicker>
                    </b-form-group>

                    <b-form-group id="input-group-8" label="Imagen" label-for="input-8">
                        <b-form-file id="input-8" v-model="form.image" accept="image/*"></b-form-file>
                    </b-form-group>

                    <b-button type="submit" variant="primary">Actualizar</b-button>

                </b-form>
            </b-modal>

            <b-modal id="modal-3" title="Eliminar libro" v-model="showModalEliminar">
                <b-form @submit="onDeleteSubmit" @reset="onReset">
                    <b-form-group id="input-group-9" label="ID del libro:" label-for="input-9"
                        description="Ingresa el ID del libro a eliminar.">
                        <b-form-input id="input-9" v-model="form.id" type="text"
                            placeholder="Ingresa el ID del libro." required></b-form-input>
                    </b-form-group>

                    <b-button type="submit" variant="danger">Eliminar</b-button>

                </b-form>
            </b-modal>

            <h1>Inicio vue</h1>

            <div class="contenedorC">
                <b-col @click="openModalRegistrar" lg="4" class="pb-2"><b-button size="sm">Registrar</b-button></b-col>
                <b-col @click="openModalEliminar" lg="4" class="pb-2"><b-button size="sm">Eliminar</b-button></b-col>
                <b-col @click="openModalActualizar" lg="4" class="pb-2"><b-button size="sm">Actualizar</b-button></b-col>

            </div>

            <pre>

                </pre>
            <div class="contenedor">
                <b-col lg="4" class="pb-2"><b-button size="lg">Ordenar por autor</b-button></b-col>
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
            showModalRegistrar: false,
            showModalActualizar: false,
            showModalEliminar: false,
            form: {
                name: '',
                author: '',
                publishDate: '',
                image: null,
                id: '' // Nuevo campo para el ID del libro a eliminar
            },
        }
    },
    mounted() {
        window.addEventListener('scroll', this.handleScroll);
    },
    destroyed() {
        window.removeEventListener('scroll', this.handleScroll);
    },


    methods: {
        async registerMovie() {
        try {
            const fileReader = new FileReader();
            fileReader.readAsDataURL(this.form.image);
            fileReader.onload = async () => {
                const base64Image = fileReader.result.split(',')[1];

                // Encuentra el género correspondiente al ID seleccionado
                this.form.genre = this.genresToSend.find(genre => genre.id === this.form.genre);

                // Realiza la solicitud POST al endpoint
                await axios.post('http://localhost:8080/api/movies/registermovie', {
                    description: this.form.description,
                    image: base64Image,
                    name: this.form.name,
                    year: this.form.year,
                    genre: this.form.genre,
                });

                // Reinicia los campos del formulario
                this.onReset();
            };
        } catch (error) {
            console.error('Error registrando la película:', error);
        }
    },
    onReset() {
        // Reinicia los campos del formulario y cierra el modal
        this.form.description = '';
        this.form.director = '';
        this.form.image = null;
        this.form.name = '';
        this.form.year = '';
        this.form.genre = '';
        this.showModalRegistrar = false;
    },
        handleScroll() {
            // Lógica para determinar si se debe mostrar u ocultar el carousel basado en el desplazamiento
            if (window.scrollY > 100) {
                this.showCarousel = false;
            } else {
                this.showCarousel = true;
            }
        },

        openModalRegistrar() {
            this.showModalRegistrar = true;
        },
        openModalActualizar() {
            this.showModalActualizar = true;
        },
        openModalEliminar() {
            this.showModalEliminar = true;
        },
        onSubmitRegistrar(evt) {
            evt.preventDefault();
            console.log(this.form);
            this.showModalRegistrar = false;
        },
        onSubmitActualizar(evt) {
            evt.preventDefault();
            console.log(this.form);
            this.showModalActualizar = false;
        },
        onDeleteSubmit(evt) {
            evt.preventDefault();
            console.log("Eliminar libro con ID:", this.form.id);
            // Lógica para eliminar el libro con el ID especificado
            this.showModalEliminar = false;
            this.form.id = ''; // Limpiar el campo ID después de eliminar
        },
        onReset(evt) {
            evt.preventDefault();

            this.form.name = '';
            this.form.author = '';
            this.form.publishDate = '';
            this.form.image = null;

            this.showModalRegistrar = false;
            this.showModalActualizar = false;
            this.showModalEliminar = false;
        },
    },
}
</script>

<style >
.contenedor {
    display: flex;
    justify-content: center;
    height: auto; /* Cambiado de un valor absoluto a auto */
    background-color: bisque;
}

.contenedorC {
    display: flex;
    background-color: azure;
}

.contenedori {
    background-color: #ababab;
    text-shadow: 1px 1px 2px #333;
    height: auto; /* Cambiado de un valor absoluto a auto */
    padding: 100px;
    margin: 20px;
}
</style>
