<script setup lang="ts">
import MenuComponent from '../components/menu/MenuComponent.vue'
import TopComponent from '../components/top/TopComponent.vue'
import ContentComponent from '../components/content/ContentComponent.vue'
import FooterComponent from '../components/footer/FooterComponent.vue'
if(sessionStorage.getItem("user_token")==null||sessionStorage.getItem("user_id")==null){
    window.location.href=window.location.origin+"/login"
}
</script>
<template>
    <MenuComponent />
    <TopComponent />
    <ContentComponent />
    <FooterComponent />
</template>