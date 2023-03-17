<template>
    <div class="is-flex is-align-items-center is-justify-content-space-between">
        <!--CRONOMETRO-->
        <Cronometro :tempoEmSegundo="tempoEmSegundo"/>
        <button class="button" @click="iniciar" :disabled="cronometroRodando">
            <span class="icon">
                <i class="fas fa-play"></i>
            </span>
            <span>Play</span>
        </button>
        <button class="button" @click="finalizar" :disabled="!cronometroRodando">
            <span class="icon">
                <i class="fas fa-stop"></i>
            </span>
            <span>Stop</span>
        </button>
    </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import Cronometro from './Cronometro.vue';

export default defineComponent({
    name: 'Temporizador',
    emits:['aoTemporizadorFinalizado'],
    components: {
        Cronometro
    },
    data(){
        return{
            tempoEmSegundo: 0,
            cronometro: 0,
            cronometroRodando: false
        }
    },
    methods:{
        iniciar(): void {
            this.cronometroRodando = true;
            this.cronometro = setInterval(()=>{
                this.tempoEmSegundo += 1
            }, 1000);
        },
        finalizar() : void {
            this.cronometroRodando = false;
            clearInterval(this.cronometro);
            this.$emit('aoTemporizadorFinalizado', this.tempoEmSegundo);
            this.tempoEmSegundo = 0;
        }
    }
})
</script>