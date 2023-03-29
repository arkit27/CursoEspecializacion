<template>
    <div class="right_col" role="main">
        <div class="row">
            <div class="col-md-12 col-sm-12 ">
				<div class="x_panel" id="tabladatosempleados">
					<div class="x_title">
						<h2>EMPLEADOS<small>listado</small></h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a class="collapse-link">
								<i class="fa fa-chevron-up"></i></a>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-wrench"></i></a>
								<ul class="dropdown-menu" role="menu">
									<li><a class="dropdown-item" href="#">Settings 1</a>
									</li>
									<li><a class="dropdown-item" href="#">Settings 2</a>
									</li>
								</ul>
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
                          <th>Cargo</th>
						  <th>Acciones</th>
                        </tr>
                      </thead>

                      <tbody>
                        <tr v-for="itemEmpleado in listaempleados ">
                          <td>{{itemEmpleado.nombre}}</td>
                          <td>{{itemEmpleado.apellido }}</td>
                          <td>{{itemEmpleado.dni}}</td>
                          <td>{{itemEmpleado.email }}</td>
                          <td>{{itemEmpleado.telefono}}</td>
                          <td>{{itemEmpleado.direccion}}</td>
                          <td>{{itemEmpleado.cargo}}</td>
						  <td class="text-center">
							<i class="fa fa-pencil" v-on:click="editarEmpleado(itemEmpleado)" style="cursor:pointer; padding-right: 1ex; color: burlywood;"></i>
							<i class="fa fa-trash" v-on:click="eliminarEmpleado(itemEmpleado.id_empleado)"  style="cursor:pointer; color:red"></i>
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
                    <div class="x_title" id="formularioEmpleados">
                        <h2>Formulario de empleados<small>crear/editar</small></h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                            </li>
                           
                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                            </li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        
                        <form id="frmEmpleados" v-on:submit="guardardatos()"  data-parsley-validate class="form-label-left input_mask">
							<input type="hidden" id="id_empleado" name="id_empleado" v-model="id_empleado"/>
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
                                <span class="fa fa-phone form-control-feedback left " aria-hidden="true"></span>
                            </div>
                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="text" name="email" id="email" v-model="email" class="form-control has-feedback-left" placeholder="Email">
                                <span class="fa fa-envelope form-control-feedback left" aria-hidden="true"></span>
                            </div>
                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="text" name="cargo" id="cargo" v-model="cargo" class="form-control has-feedback-left" placeholder="Cargo">
                                <span class="fa fa-envelope form-control-feedback left" aria-hidden="true"></span>
                            </div>

                            <div class="ln_solid">
                                 
                            </div>
                            <div class="form-group row">
                               <div class="col-md-9 offset-md-5">
                                    <button type="button" class="btn btn-primary">Cancelar</button>
                                    <button class="btn btn-primary" type="reset">Resetear</button>
                                    <button type="submit" class="btn btn-success">Guardar</button>
                                </div>
                            </div>

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
		id_empleado:null,
        dni:"",
		nombre:"",
        apellido:"",
        email:"",
        telefono:"",
        direccion:"",
        cargo:"",
		listaempleados:[]
      };
    },
	methods: {
		async iniciarCarga() {
			try {
			const response = await fetch("http://localhost:8081/v1/empleados/");
			this.listaempleados= this.listMenuItems = await response.json();   
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
                direccion:this.direccion,
                cargo:this.cargo
			};
			var metodo="POST";

			if(this.id_empleado!=null||this.id_empleado!=""){//guardar datos			
				data.id_empleado=this.id_empleado
				metodo="PUT";
			}
			fetch("http://localhost:8081/v1/empleados/", {
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
		editarEmpleado(datos){
			    this.id_empleado=datos.id_empleado;
                this.dni=datos.dni;
                this.nombre=datos.nombre;
                this.apellido=datos.apellido;
                this.email=datos.email;
                this.telefono=datos.telefono;
                this.direccion=datos.direccion;
                this.cargo=datos.cargo;
		},
		async eliminarEmpleado(idtmp) {
			try{
				const response = await fetch("http://localhost:8081/v1/empleados/"+idtmp,{
					method: "DELETE",
				})
				if(response.status==200){
					this.id_empleado=null;
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