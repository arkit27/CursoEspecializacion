<template>
  <div class="top_nav">
        <div class="nav_menu">
            <div class="nav toggle">
              <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>
            <nav class="nav navbar-nav">
            <ul class=" navbar-right">
              <li class="nav-item dropdown open" style="padding-left: 15px;">
                <a href="javascript:;" class="user-profile dropdown-toggle" aria-haspopup="true" id="navbarDropdown" data-toggle="dropdown" aria-expanded="false">
                  {{ user_usuario}}
                </a>
                <div class="dropdown-menu dropdown-usermenu pull-right" aria-labelledby="navbarDropdown">
                  <a class="dropdown-item"  href="javascript:;"> Profile</a>
                    <a class="dropdown-item"  href="javascript:;">
                      <span class="badge bg-red pull-right">50%</span>
                      <span>Configuraciones</span>
                    </a>
                <a class="dropdown-item"  href="javascript:;">Help</a>
                  <a class="dropdown-item"  href="#" v-on:click="cerrarSesion()" ><i class="fa fa-sign-out pull-right"></i> Cerrar Sesión</a>
                </div>
              </li>

            </ul>
          </nav>
        </div>
      </div>
</template>
<script>
export default {
data() {
  return {
    //listMenuItems: [],
    user_usuario: "sin Nombre",
  };
},
methods: {
 
  cerrarSesion(){
    sessionStorage.removeItem("user_usuario");
    sessionStorage.removeItem("user_token");
    sessionStorage.removeItem("user_id");
    sessionStorage.removeItem("user_password");
    sessionStorage.removeItem("user_nombre");
    sessionStorage.removeItem("user_fechayhora");
    window.location.href=window.location.origin+"/login";
  }
},
created() {
  this.user_usuario = sessionStorage.getItem("user_usuario");
  //this.getData();
},
}
</script>