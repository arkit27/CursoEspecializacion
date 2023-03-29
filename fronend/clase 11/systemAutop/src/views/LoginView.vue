<template>
  <html lang="es">
    <head>
      <meta charset="utf-8" />
      <title> Formulario de Acceso </title>    
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta name="author" content="Videojuegos & Desarrollo">
      <meta name="description" content="Ejemplo de formulario de acceso basado en HTML5 y CSS">
      <meta name="keywords" content="login,formulariode acceso html">
      <link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet"> 
    
    </head>
    <body>
      <div id="contenedor2">
        <div id="contenedorcentrado2">
          <div id="login2">
            <form id="loginform">
              <label for="usuario">Usuario</label>
              <input id="usuario" type="text" name="usuario" v-model="user" placeholder="Usuario" required>
              <label for="password">Contraseña</label>
              <input id="password" type="password" placeholder="Contraseña" name="password" v-model="clave" required>
              <button type="submit" title="Ingresar" name="Ingresar" v-on:click="login()">Iniciar Sesion</button>
            </form>
          </div>
          <div id="derecho">
            <div class="titulo">
              Bienvenido
            </div>
            
            <hr>
            <div class="pie-form">
              <a href="#">¿Perdiste tu contraseña?</a>
              <hr>
              <a href="#">« Volver</a>
            </div>
          </div>
        </div>
      </div>
    </body>
  </html>
</template>

<script>
export default{
data() {
    return {
  id:null,
  nombre:"",
  user: null,
  clave:""		
    };
  },
methods: {
  login(){     
    var data = { 
      user: this.user,
      clave:this.clave				
    };			
    fetch("http://localhost:8081/v1/usuarios/login", {
    method: "POST", // or 'PUT'
    headers: {"Content-Type": "application/json",},
    body: JSON.stringify(data),
    }).then((response) => response.json())
    .then((data) => {

      if(data.codigo==200){
        let tocken=data.token;
        sessionStorage.setItem('user_token', data.tocken);
        var datadecode=atob(tocken)
        var datos=datadecode.split("!=!");
        datos.forEach(element => {
          var datovalor=element.split("=");
          sessionStorage.setItem('user_'+ datovalor[0], datovalor[1],datovalor[2]);
        });  
       
        window.location.href=window.location.origin;
      }else{
        Swal.fire(
          data.mensaje,
          '',
          'error'
        )
      }
    })
    .catch((error) => {
      console.error("Error:", error);
      return;
    });
  }		
}	
}
</script> 
<style type="text/css">

/* efectos por defecto */
body {
  font-family: 'Overpass', sans-serif;
  font-weight: normal;
  font-size: 100%;
  color: #1b262c;
  
  margin: 0;
  background-color: #427a88;
}

/* efectos para el contenedor de pantalla completa */
#contenedor2 {
  display: flex;
  align-items: center;
  justify-content: center;
  
  margin: 0;
  padding: 0;
  min-width: 100vw;
  min-height: 100vh;
  width: 100%;
  height: 100%;
  
  background-image: url("C:\Proyectoesp\fronend\clase 11\systemAutop\build\images\fond01.jpg");
  background-position: center;
  background-size: cover;
}

/* contenedor del login a la izquierda */
#contenedorcentrado2 {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction:row;
  
  min-width: 380px;
  max-width: 900px;
  width: 90%;
  
  background-color: #685fe0;
  
  /*opacity: 0.50;
  filter: alpha(opacity=50);*/
  
  border-radius: 10px 10px 10px 10px;
  -moz-border-radius: 10px 10px 10px 10px;
  -webkit-border-radius: 10px 10px 10px 10px;
  
  -webkit-box-shadow: 0px 0px 5px 5px rgba(0,0,0,0.15);
  -moz-box-shadow: 0px 0px 5px 5px rgba(0,0,0,0.15);
  box-shadow: 0px 0px 5px 5px rgba(0,0,0,0.15);
  
  padding: 30px;
  box-sizing: border-box;
}

/* formulario de login */
/* formulario de login */
#login2 {
  width: 100%;
  max-width: 320px;
  min-width: 320px;
  padding: 30px 30px 50px 30px;
  background-color: #3c9c9f;
  
  -webkit-box-shadow: 0px 0px 5px 5px rgba(0,0,0,0.15);
  -moz-box-shadow: 0px 0px 5px 5px rgba(0,0,0,0.15);
  box-shadow: 0px 0px 5px 5px rgba(0,0,0,0.15);
  
  border-radius: 3px 3px 3px 3px;
  -moz-border-radius: 3px 3px 3px 3px;
  -webkit-border-radius: 3px 3px 3px 3px;
  
  box-sizing: border-box;
  
  opacity: 1;
  filter: alpha(opacity=1);
}

#login2 label {
  display: block;
  font-family: 'Overpass', sans-serif;
  font-size: 120%;
  color:#3c4245;
  
  margin-top: 15px;
}

#login2 input {
  font-family: 'Overpass', sans-serif;
  font-size: 110%;
  color: #1b262c;
  
  display: block;
  width: 100%;
  height: 40px;
  
  margin-bottom: 10px;
  padding: 5px 5px 5px 10px;
  
  box-sizing: border-box;
  
  border: none;
  border-radius: 3px 3px 3px 3px;
  -moz-border-radius: 3px 3px 3px 3px;
  -webkit-border-radius: 3px 3px 3px 3px;
}

#login2 input::placeholder {
  font-family: 'Overpass', sans-serif;
  color: #E4E4E4;
}

#login2 button {
  font-family: 'Overpass', sans-serif;
  font-size: 110%;
  color:#1b262c;
  width: 100%;
  height: 40px;
  border: none;
  
  border-radius: 3px 3px 3px 3px;
  -moz-border-radius: 3px 3px 3px 3px;
  -webkit-border-radius: 3px 3px 3px 3px;
  
  background-color: #dfcdc3;
  
  margin-top: 10px;
}

#login2 button:hover {
  background-color: #3c4245;
  color:#dfcdc3;
}
/* formulario de login */
/* formulario de login */

/* seccion de la derecha */
/* seccion de la derecha */
/* por defecto */
#derecho {
  /*display: flex;
  align-items:center;
  justify-content:center;*/
  
  text-align: center;
  width: 100%;
  
  opacity: 0.70;
  filter: alpha(opacity=70);
  
  padding:20px 20px 20px 50px;
  box-sizing: border-box;
}

.titulo {
  font-size: 300%;
  color:#100e0e;
}

.logo-empresa img {
  width: 60%;
}

hr {
  border-top: 1px solid #8c8b8b;
border-bottom: 1px solid #f0c4ac;
  
}
.pie-form {
  font-size: 90%;
  text-align: center;    
  margin-top: 15px;
}

.pie-form a {
  display: block;
  text-decoration: none;
  color: #dfcdc3;
  margin-bottom: 3px;
}

.pie-form a:hover {
  color: #ffffff;
}
/* seccion de la derecha */
/* seccion de la derecha */

/* ajustar a pantallas con ancho menor o igual a 775px; */
/* ajustar a pantallas con ancho menor o igual a 775px; */
@media all and (max-width: 775px)
{
  #contenedorcentrado {
      flex-direction:column-reverse;

      min-width: 380px;
      max-width: 900px;
      width: 90%;
      background-color: #5f6769;

      /*opacity: 0.50;
      filter: alpha(opacity=50);*/

      border-radius: 10px 10px 10px 10px;
      -moz-border-radius: 10px 10px 10px 10px;
      -webkit-border-radius: 10px 10px 10px 10px;

      -webkit-box-shadow: 0px 0px 5px 5px rgba(0,0,0,0.15);
      -moz-box-shadow: 0px 0px 5px 5px rgba(0,0,0,0.15);
      box-shadow: 0px 0px 5px 5px rgba(0,0,0,0.15);

      padding: 30px;
      box-sizing: border-box;
  }
  
  #login2 {
      margin: 0 auto;
  }
  
  #derecho {
      padding:20px 20px 20px 20px;
  }
  
  #login2 label {
      text-align: left;
  }
}
/* ajustar a pantallas con ancho menor o igual a 775px; */
/* ajustar a pantallas con ancho menor o igual a 775px; */
</style>
     