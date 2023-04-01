<template>
    <div class="right_col" role="main">
        <div class="row">
			<div class="col-md-12 col-sm-12 ">
				<div class="x_panel" id="tabladatosProcedencias">
					<div class="x_title">
						<h2>PROCEDENCIAS<small>listado</small></h2>
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
                          <th>Pais/Cuidad</th>
						  <th>Acciones</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr v-for="itemProcedencia in listaprocedencias">
                          <td>{{itemProcedencia.procedencia}}</td>
						  <td class="text-center">
							<i class="fa fa-pencil" v-on:click="editarProcedencia(itemProcedencia)" style="cursor:pointer; padding-right: 1ex; color: burlywood;"></i>
							<i class="fa fa-trash" v-on:click="eliminarProcedencia(itemProcedencia.id_procedencia)"  style="cursor:pointer; padding-right: 1ex; color:red"></i>
						  </td>
                        </tr>                       
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>

					</div>
				</div>
				<div class="x_panel" id="formularioProcedencias">
					<div class="x_title">
						<h2>Menus de Opciones<small>editar/crear</small></h2>
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
						<br />
						<form id="frmProcedencia" v-on:submit="guardardatos()"  data-parsley-validate class="form-horizontal form-label-left">
							<input type="hidden" id="id_procedencia" name="id_procedencia" v-model="id_procedencia"/>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Nombre de la Procedencia<span class="required"></span>
								</label>
								<div class="col-md-5 col-sm-4 ">
									<input type="text" id="procedencia" name="procedencia" v-model="procedencia" required class="form-control ">
								</div>
								<div class="item form-group">
								<div class="col-md-12 col-sm-6">
									<button class="btn btn-primary" type="button">Cancelar</button>
									<button class="btn btn-primary" type="reset">Limpiar</button>
									<button type="submit" class="btn btn-success">Guardar</button>
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
		id_procedencia:null,
		procedencia:"",
		listaprocedencias:[]
      };
    },
	methods: {
		async iniciarCarga() {
			try {
			const response = await fetch("http://localhost:8081/v1/procedencias/");
			this.listaprocedencias= this.listMenuItems = await response.json();   
			} catch (error) {
			//console.log(error);
			}
		},
		guardardatos(){
			var data = { 
				procedencia:this.procedencia
			};
			var metodo="POST";

			if(this.id_procedencia!=null||this.id_procedencia!=""){//guardar datos			
				data.id_procedencia=this.id_procedencia
				metodo="PUT";
			}
			fetch("http://localhost:8081/v1/procedencias/", {
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
		editarProcedencia(datos){
			this.id_procedencia=datos.id_procedencia;
			this.procedencia=datos.procedencia;
		},
		async eliminarProcedencia(idtmp) {
			try{
				const response = await fetch("http://localhost:8081/v1/procedencias/"+idtmp,{
					method: "DELETE",
				})
				if(response.status==200){
					this.id_procedencia=null;
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