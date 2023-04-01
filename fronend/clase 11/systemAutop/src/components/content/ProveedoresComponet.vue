<template>
    <div class="right_col" role="main">
        <div class="row">
            <div class="col-md-12 col-sm-12 ">
				<div class="x_panel" id="tabladatosProveedores">
					<div class="x_title">
						<h2>PROVEEDORES<small>listado</small></h2>
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
                          <th>Nombres</th>	
                          <th>Dni</th>
                          <th>Correo</th>
                          <th>Telefono</th>
                          <th>Dirección</th>
						  <th>Acciones</th>
                        </tr>
                      </thead>

                      <tbody>
                        <tr v-for="itemProveedor in listaproveedor ">
                          <td>{{itemProveedor.nombres}}</td>
                          <td>{{itemProveedor.dni}}</td>
                          <td>{{itemProveedor.email }}</td>
                          <td>{{itemProveedor.telefono}}</td>
                          <td>{{itemProveedor.direccion}}</td>
						  <td class="text-center">
							<i class="fa fa-pencil" v-on:click="editarCliente(itemProveedor)" style="cursor:pointer; padding-right: 1ex; color: burlywood;"></i>
							<i class="fa fa-trash" v-on:click="eliminarCliente(itemProveedor.id_proveedor)"  style="cursor:pointer; color:red"></i>
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
                    <div class="x_title" id="formularioProveedores">
                        <h2>Formulario de Proveedores<small>crear/editar</small></h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                            </li>
                           
                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                            </li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                
                        <form id="frmProveedor" v-on:submit="guardardatos()"  data-parsley-validate class="form-label-left input_mask">
							<input type="hidden" id="id_proveedor" name="id_proveedor" v-model="id_proveedor"/>
                            <div class="col-md-6 col-sm-6  form-group has-feedback">
                                <input type="text" id="nombres" name="nombres" v-model="nombres" class="form-control has-feedback-left" placeholder="Nombres">
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

                            
                            <div class="form-group row">
                                <div class="col-md-12 col-sm-9 offset-md-5">
                                    <button type="button" class="btn btn-primary">Cancelar</button>
                                    <button class="btn btn-primary" type="reset">Limpiar</button>
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
		    id_proveedor:null,
        dni:"",
		    nombres:"",
        email:"",
        telefono:"",
        direccion:"",
		    listaproveedor:[]
      };
    },
	methods: {
		async iniciarCarga() {
			try {
			const response = await fetch("http://localhost:8081/v1/proveedores/");
			this.listaproveedor= this.listMenuItems = await response.json();   
			} catch (error) {
			//console.log(error);
			}
		},
		guardardatos(){
			var data = { 
				dni:this.dni,
                nombres:this.nombres,
                email:this.email,
                telefono:this.telefono,
                direccion:this.direccion
			};
			var metodo="POST";

			if(this.id_proveedor!=null||this.id_proveedor!=""){//guardar datos			
				data.id_proveedor=this.id_proveedor
				metodo="PUT";
			}
			fetch("http://localhost:8081/v1/proveedores/", {
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
				const response = await fetch("http://localhost:8081/v1/proveedores/"+idtmp,{
					method: "DELETE",
				})
				if(response.status==200){
					this.id_proveedor=null;
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
.table-custom {
	background-color: #ffffff;
	border-radius: 10px;
	border: 1px solid #dddddd;
  }
  
  .table-custom th,
  .table-custom td {
	border: 1px solid #dddddd;
  }
  
  .table-custom th {
	background-color: #f7f7f7;
	text-align: center;
	vertical-align: middle;
  }
  
  .table-custom td {
	text-align: left;
	vertical-align: middle;
  }
  
  .table-custom td > button {
	margin-right: 5px;
	margin-bottom: 5px;
  }
  
</style>
