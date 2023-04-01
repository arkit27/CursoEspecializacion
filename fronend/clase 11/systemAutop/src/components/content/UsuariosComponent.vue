<template>
    <div class="right_col" role="main">
        <div class="row">
            <div class="col-md-12 col-sm-12 ">
				<div class="x_panel" id="tabladatosUsuarios">
					<div class="x_title">
						<h2>USUARIOS<small>listado</small></h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a class="collapse-link">
								<i class="fa fa-chevron-up"></i></a>
							</li>
							
							<li><a class="close-link"><i class="fa fa-close"></i></a>
							</li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">

						<div class="row">
                          <div class="col-sm-12">
                            <div class="card-box table-responsive">
                    <table id="datatable-fixed-header" class="table table-striped table-bordered" style="width:100%">
                      <thead>
                        <tr>
                          <th>Usuario</th>
                          <th>Nombre</th>
                          <th>Rol</th>
                          <th>Acciones</th>
                          
                        </tr>
                      </thead>

                      <tbody>
                        <tr v-for="itemUsuario in listaUsuarios ">
                          <td>{{itemUsuario.user}}</td>
                          <td>{{itemUsuario.nombre }}</td>
                          <td>{{itemUsuario.rol}}</td>
                          
						  <td class="text-center">
							<i class="fa fa-pencil" v-on:click="editarUsuario(itemUsuario)" style="cursor:pointer; padding-right: 1ex; color: burlywood;"></i>
							<i class="fa fa-trash" v-on:click="eliminarUsuario(itemUsuario.id)"  style="cursor:pointer; color:red"></i>
						  </td>
                        </tr>                       
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>

			</div>
		</div>
                <div class="x_panel">
                    <div class="x_title" id="formulariousuarios">
                        <h2>Formulario de Usuarios<small>crear/editar</small></h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                            </li>
                           
                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                            </li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                
                        <form id="frmCliente" v-on:submit="guardardatos()"  data-parsley-validate class="form-label-left input_mask">
							<input type="hidden" id="id" name="id" v-model="id"/>
                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="text" id="user" name="user" v-model="user" class="form-control has-feedback-left" placeholder="usuario">
                                <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                            </div>

                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="text" id="password" name="password" v-model="password" class="form-control has-feedback-left" placeholder="password">
                                <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                            </div>

                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="text" name="nombre" id="nombre" v-model="nombre" class="form-control has-feedback-left" placeholder="Nombre del usuario">
								<span class="fa fa-table form-control-feedback left" aria-hidden="true"></span>
                            </div>

                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="text" name="rol" id="rol" v-model="rol" class="form-control has-feedback-left" placeholder="Rol">
                                <span class="fa fa-map-marker form-control-feedback left" aria-hidden="true"></span>
                            </div>


                            
								<div class="form-group row">
									<div class="col-md-6 col-sm-6  offset-md-3">
										<button type="button" class="btn1 btn-primary">Cancelar</button>
										<button class="btn1 btn-primary" type="reset">Resetear</button>
										<button type="submit" class="btn1 btn-success">Guardar</button>
									</div>
								</div>
							<div class="ln_solid"></div>

							
                        </form>
                    </div>
                </div>

               
			</div>
		</div>

            </div>
       
</template>
<script>
export default{
	data() {
      return {
		id:null,
        user:"",
		password:"",
        nombre:"",
        rol:"",
		listaUsuarios:[]
      };
    },
	methods: {
		async iniciarCarga() {
			try {
			const response = await fetch("http://localhost:8081/v1/usuarios/");
			this.listaUsuarios= this.listMenuItems = await response.json();   
			} catch (error) {
			//console.log(error);
			}
		},
		guardardatos(){
			var data = { 
				user:this.user,
                password:this.password,
                nombre:this.nombre,
                rol:this.rol,
                
			};
			var metodo="POST";

			if(this.id!=null||this.id!=""){//guardar datos			
				data.id=this.id
				metodo="PUT";
			}
			fetch("http://localhost:8081/v1/Usuarios/", {
			method: metodo, // or 'PUT'
			headers: {"Content-Type": "application/json",},
			body: JSON.stringify(data),
			}).then((response) => response.json())
			.then((data) => {
				this.iniciarCarga();
			})
			.catch((error) => {
				console.error("Error:", error);
				return;
			});
		},
		editarUsuario(datos){
			    this.id=datos.id;
                this.user=datos.user;
                this.password=datos.password;
                this.nombre=datos.nombre;
                this.rol=datos.rol;
                
		},
		async eliminarUsuario(idtmp) {
			try{
				const response = await fetch("http://localhost:8081/v1/Usuarios/"+idtmp,{
					method: "DELETE",
				})
				if(response.status==200){
					this.id=null;
					this.iniciarCarga();
				}
			}catch (error){

			}

		}
	},
	created() {
      this.iniciarCarga();
    },
}
</script>

<style>
/*3-botones */
.btn1 {
	border-radius: 10px; /* agregar bordes redondeados a los botones */
	display: inline-block; /* hacer que los botones estén en línea */
	margin: 10px; /* establecer un margen alrededor de los botones */
	padding: 10px 20px; /* establecer el relleno interno de los botones */
	width: 150px; /* establecer un ancho fijo para los botones */
	text-align: center; /* centrar el texto dentro de los botones */
	transition: background-color 0.0s ease, color 0.0s ease; /* establecer una transición para el cambio de color */
  }
  
  .btn1:hover {
	background-color: #ffffff; /* cambiar el color de fondo en el hover */
	color: #000000; /* cambiar el color de letra en el hover */
  }
</style>