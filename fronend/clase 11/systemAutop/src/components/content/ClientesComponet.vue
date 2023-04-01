<template>
    <div class="right_col" role="main">
        <div class="row">
            <div class="col-md-12 col-sm-12 ">
				<div class="x_panel" id="tabladatosclientes">
					<div class="x_title">
						<h2>CLIENTES<small>listado</small></h2>
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
                          <th>Nombre</th>
                          <th>Apellidos</th>
                          <th>Dni</th>
                          <th>Correo</th>
                          <th>Telefono</th>
                          <th>Dirección</th>
						  <th>Acciones</th>
                        </tr>
                      </thead>

                      <tbody>
                        <tr v-for="itemCliente in listaclientes ">
                          <td>{{itemCliente.nombre}}</td>
                          <td>{{itemCliente.apellido }}</td>
                          <td>{{itemCliente.dni}}</td>
                          <td>{{itemCliente.email }}</td>
                          <td>{{itemCliente.telefono}}</td>
                          <td>{{itemCliente.direccion}}</td>
						  <td class="text-center">
							<i class="fa fa-pencil" v-on:click="editarCliente(itemCliente)" style="cursor:pointer; padding-right: 1ex; color: burlywood;"></i>
							<i class="fa fa-trash" v-on:click="eliminarCliente(itemCliente.id_cliente)"  style="cursor:pointer; color:red"></i>
						  </td>
                        </tr>                       
                      </tbody>
                    </table>
                  </div>
                </div>
                
              </div>
              <div class="ln_solid"></div>
			</div>
		</div>
                <div class="x_panel">
                    <div class="x_title" id="formularioclientes">
                        <h2>Formulario de Clientes<small>crear/editar</small></h2>
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
							<input type="hidden" id="id_cliente" name="id_cliente" v-model="id_cliente"/>
                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="text" id="nombre" name="nombre" v-model="nombre" class="form-control has-feedback-left" placeholder="Nombres">
                                <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                            </div>

                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="text" id="apellido" name="apellido" v-model="apellido" class="form-control has-feedback-left" placeholder="Apellidos">
                                <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                            </div>

                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="text" name="dni" id="dni" v-model="dni" class="form-control has-feedback-left" placeholder="N° de Documento">
								<span class="fa fa-table form-control-feedback left" aria-hidden="true"></span>
                            </div>

                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="text" name="direccion" id="direccion" v-model="direccion" class="form-control has-feedback-left" placeholder="Dirección">
                                <span class="fa fa-map-marker form-control-feedback left" aria-hidden="true"></span>
                            </div>

                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="text" name="telefono" id="telefono" v-model="telefono" class="form-control has-feedback-left" placeholder="Telefono">
                                <span class="fa fa-phone form-control-feedback left" aria-hidden="true"></span>
                            </div>
                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="text" name="email" id="email" v-model="email" class="form-control has-feedback-left" placeholder="Email">
                                <span class="fa fa-envelope form-control-feedback left" aria-hidden="true"></span>
                            </div>

                            
                            <div>
                              <div class="form-group row">
                                <div class="col-md-6 col-sm-6  offset-md-3">
                                    <button type="button" class="btn1 btn-primary">Cancelar</button>
                                    <button class="btn1 btn-primary" type="reset">Resetear</button>
                                    <button type="submit" class="btn1 btn-success">Guardar</button>
                                </div>
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
		id_cliente:null,
        dni:"",
		nombre:"",
        apellido:"",
        email:"",
        telefono:"",
        direccion:"",
		listaclientes:[]
      };
    },
	methods: {
		async iniciarCarga() {
			try {
			const response = await fetch("http://localhost:8081/v1/clientes/");
			this.listaclientes= this.listMenuItems = await response.json();   
			} catch (error) {
			//console.log(error);
			}
		},
		guardardatos(){
			var data = { 
				dni:this.dni,
                nombre:this.nombre,
                apellido:this.apellido,
                email:this.email,
                telefono:this.telefono,
                direccion:this.direccion
			};
			var metodo="POST";

			if(this.id_cliente!=null||this.id_cliente!=""){//guardar datos			
				data.id_cliente=this.id_cliente
				metodo="PUT";
			}
			fetch("http://localhost:8081/v1/clientes/", {
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
		editarCliente(datos){
			    this.id_cliente=datos.id_cliente;
                this.dni=datos.dni;
                this.nombre=datos.nombre;
                this.apellido=datos.apellido;
                this.email=datos.email;
                this.telefono=datos.telefono;
                this.direccion=datos.direccion;
		},
		async eliminarCliente(idtmp) {
			try{
				const response = await fetch("http://localhost:8081/v1/clientes/"+idtmp,{
					method: "DELETE",
				})
				if(response.status==200){
					this.id_cliente=null;
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