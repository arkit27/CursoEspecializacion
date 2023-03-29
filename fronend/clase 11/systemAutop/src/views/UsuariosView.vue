<script setup lang="ts">
import MenuComponent from '../components/menu/MenuComponent.vue'
import TopComponent from '../components/top/TopComponent.vue'
import ContentComponent from '../components/content/UsuariosComponent.vue'
import FooterComponent from '../components/footer/FooterComponent.vue'
if(sessionStorage.getItem("user_token")==null||sessionStorage.getItem("user_id")==null){
    window.location.href=window.location.origin+"/login"
    
}else{
    if(sessionStorage.getItem("user_rol")!=="administrador"){
        alert("Usted no tiene permisos para este menu");
        window.location.href=window.location.origin
    }alert("Bienvenido administrador");
}
</script>
<template>
    <MenuComponent />
    <TopComponent />
    <ContentComponent />
    <FooterComponent />
</template>