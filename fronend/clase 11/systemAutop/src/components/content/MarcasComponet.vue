<template>
    <div class="right_col" role="main">
        <div class="row">
			<div class="col-md-12 col-sm-12 ">
				<div class="x_panel" id="tabladatosMarcas">
					<div class="x_title">
						<h2>MARCAS<small>listado</small></h2>
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
						  <th>Acciones</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr v-for="itemMarca in listamarcas">
                          <td>{{itemMarca.marca}}</td>
						  <td class="text-center">
							<i class="fa fa-pencil" v-on:click="editarMarca(itemMarca)" style="cursor:pointer; padding-right: 1ex; color: burlywood;"></i>
							<i class="fa fa-trash" v-on:click="eliminarMarca(itemMarca.id_marca)"  style="cursor:pointer; padding-right: 1ex; color:red"></i>
						  </td>
                        </tr>                       
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>

					</div>
				</div>
				<div class="x_panel" id="formularioMarcas">
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
						<form id="frmMarca" v-on:submit="guardardatos()"  data-parsley-validate class="form-horizontal form-label-left">
							<input type="hidden" id="id_marca" name="id_marca" v-model="id_marca"/>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Nombre de la Marca<span class="required"></span>
								</label>
								<div class="col-md-5 col-sm-4 ">
									<input type="text" id="marca" name="marca" v-model="marca" required class="form-control ">
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
		id_marca:null,
		marca:"",
		listamarcas:[]
      };
    },
	methods: {
		async iniciarCarga() {
			try {
			const response = await fetch("http://localhost:8081/v1/marcas/");
			this.listamarcas= this.listMenuItems = await response.json();   
			} catch (error) {
			//console.log(error);
			}
		},
		guardardatos(){
			var data = { 
				marca:this.marca
			};
			var metodo="POST";

			if(this.id_marca!=null||this.id_marca!=""){//guardar datos			
				data.id_marca=this.id_marca
				metodo="PUT";
			}
			fetch("http://localhost:8081/v1/marcas/", {
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
		editarMarca(datos){
			this.id_marca=datos.id_marca;
			this.marca=datos.marca;
		},
		async eliminarMarca(idtmp) {
			try{
				const response = await fetch("http://localhost:8081/v1/marcas/"+idtmp,{
					method: "DELETE",
				})
				if(response.status==200){
					this.id_categoria=null;
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
/* Estilos para la tabla */
#datatable-fixed-header {
	background-color: #ffffff;
	border: 1px solid #ccc;
	border-radius: 5px;
	font-size: 14px;
  }
  
  /* Estilos para las celdas de la cabecera */
  #datatable-fixed-header thead th {
	background-color: #161e20;

	color: #ffffff;
	font-weight: bold;
	padding: 10px;
	text-align: center;
  }
  
  /* Estilos para las celdas del cuerpo */
  #datatable-fixed-header tbody td {
	background-color: #aaa8a8;
	border: 1px solid #ccc;
	color: #555;
	padding: 10px;
	text-align: center;
  }
  
  /* Estilos para las celdas del cuerpo al pasar el cursor por encima */
  #datatable-fixed-header tbody tr:hover td {
	background-color: #000000;
  }
  
  /* Estilos para los bordes redondeados en la primera y última fila de la tabla */
  #datatable-fixed-header tbody tr:first-child td:first-child,
  #datatable-fixed-header tbody tr:last-child td:first-child,
  #datatable-fixed-header tbody tr:last-child td:last-child {
	border-radius: 0px;
  }
  

  
  
</style>