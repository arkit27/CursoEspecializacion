<template>
    <div class="right_col" role="main">
        <div class="row">
			<div class="col-md-12 col-sm-12 ">
				<div class="x_panel" id="tabladatosmenus">
					<div class="x_title">
						<h2>MENUS<small>listado</small></h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a class="collapse-link">
								<i class="fa fa-chevron-up"></i></a>
							</li>
							<li><a class="close-link"><i class="fa fa-close"></i></a>
							</li>
						</ul>
						<div>

						</div>

						<div class="clearfix"></div>
					</div>
					<div class="x_content">
							<div class="row">
								<div class="input-group rounded col-sm-12" >
									<input type="text" id="searchnombre" name="searchnombre" v-model="searchnombre" v-on:blur="iniciarCarga();" required class="form-control rounded" placeholder="Buscar por nombre de Menú" aria-label="Search" aria-describedby="search-addon" />
									<button type="button" class="btn btn-default pastel-button">
										<i class="fa fa-search"></i>
									  </button>
								  </div>
                          <div class="col-sm-12">
                            <div class="card-box table-responsive">
                    <table id="datatable-fixed-header" class="table table-striped table-bordered" style="width:100%">
                      <thead>
                        <tr>
                          <th>Nombre</th>
                          <th>Icono</th>
                          <th>Url</th>
                          <th>Menu Padre</th>
                          <th>Orden</th>
						  <th>Acciones</th>
                        </tr>
                      </thead>


                      <tbody>
                        <tr v-for="itemMenu in listamenus ">
                          <td>{{itemMenu.nombre}}</td>
                          <td><i v-bind:class="'fa ' + itemMenu.icono" ></i> {{ itemMenu.icono }}</td>
                          <td>{{ itemMenu.url }}</td>
                          <td>{{itemMenu.nombrePadre}}</td>
                          <td>{{itemMenu.orden}}</td>
						  <td class="text-center">
							<i class="fa fa-pencil" v-on:click="editarMenu(itemMenu)" style="cursor:pointer; padding-right: 1ex; color: burlywood;"></i>
							<i class="fa fa-trash" v-on:click="eliminarMenu(itemMenu.id)"  style="cursor:pointer; padding-right: 1ex; color:red"></i>
						  </td>
                        </tr>                       
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>



					</div>
				</div>
				<div class="x_panel" id="formulariomenus">
					<div class="x_title">
						<h2>Menus de Opciones <small>editar/crear</small></h2>
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
						<form id="frmMenu" v-on:submit="guardardatos()"  data-parsley-validate class="form-horizontal form-label-left">
							<input type="hidden" id="id" name="id" v-model="id"/>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombre">Nombre de Menu<span class="required"></span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<input type="text" id="nombre" name="nombre" v-model="nombre" required class="form-control ">
								</div>
							</div>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align" for="des">Icono <span class="required"></span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<input type="text" id="icono" name="icono" v-model="icono"  required class="form-control">
								</div>
							</div>
							<div class="item form-group">
								<label for="url" class="col-form-label col-md-3 col-sm-3 label-align">Enlace -> URL</label>
								<div class="col-md-6 col-sm-6 ">
									<input id="url" v-model="url" class="form-control" type="text" name="url">
								</div>
							</div>

							<div class="item form-group">
								<label for="orden" class="col-form-label col-md-3 col-sm-3 label-align">Orden</label>
								<div class="col-md-6 col-sm-6 ">
									<input id="orden" v-model="orden" class="form-control" type="text" name="orden">
								</div>
							</div>
						
							
							<div class="form-group row">
								<label class="col-form-label col-md-3 col-sm-3 label-align">Menu Padre</label>
								<div class="col-md-6 col-sm-6 ">
									<select v-model="menuPadre" class="select2_single form-control" tabindex="-1">
										<option>Sin Menu Padre</option>										
										<option v-for="itemMenu in listamenus " :value="itemMenu.id">{{ itemMenu.nombre }}</option>
									</select>
								</div>
							</div>
							


							<div class="ln_solid"></div>
							<div class="item form-group">
								<div class="col-md-6 col-sm-6 offset-md-3">
									<button class="btn1 btn-primary" type="button">Cancelar</button>
									<button class="btn1 btn-primary" type="reset">Limpiar</button>
									<button type="submit" class="btn1 btn-success">Guardar</button>
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
		id:null,
		nombre:"",
        url: null,
		icono:"",
		orden:"",
		menuPadre:null,
		listamenus:[],
		searchnombre:""
      };
    },
	methods: {
		async iniciarCarga() {
			try {
				var urltmp="http://localhost:8081/v1/menu/buscar/"+this.searchnombre;
				if(this.searchnombre=="") urltmp=urltmp="http://localhost:8081/v1/menu/menupadres";

			const response = await fetch(urltmp);
			this.listamenus= this.listMenuItems = await response.json();   
			} catch (error) {
			//console.log(error);
			}
		},
		guardardatos(){
			var data = { 
				nombre: this.nombre,
				url:this.url,
				icono:this.icono,
				orden:this.orden,
				menuPadre:this.menuPadre
			};
			var metodo="POST";

			console.log(this.id)
			
			if(this.id!=null||this.id!=""){//guardar datos			
				data.id=this.id
				metodo="PUT";
			}

			fetch("http://localhost:8081/v1/menu/", {
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
		editarMenu(datos){
			this.id=datos.id;
			this.nombre=datos.nombre;
			this.url=datos.url;
			this.orden=datos.orden;
			this.menuPadre=datos.menuPadre;
			this.icono=datos.icono;
		},
		async eliminarMenu(idtmp) {
			try{
				const response = await fetch("http://localhost:8081/v1/menu/"+idtmp,{
					method: "DELETE",
				})
				if(response.status==200){
					this.id=null;
					this.iniciarCarga();
				}
			}catch (error){

			}

		},

		async iniciarCarga2() {
    try {
        const response = await fetch('http://localhost:8081/v1/menu/getOrden?orden=asc&nombre=asc');
        const data = await response.json();
        console.log(data);
    } catch (error) {
        console.error(error);
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

<style>
/*btn lupa*/
.pastel-button {
	background-color: #85eef2; /* Cambia el color de fondo a un tono pastel */
	color: #000000; /* Cambia el color del texto a blanco */
	border-color: #ffffff; /* Cambia el color del borde a tono pastel */
  }
  
  .pastel-button:hover {
	background-color: #4a6adf; /* Cambia el color de fondo en el hover */
	color: #000000;
	border-color: #000000;
  }
</style>
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

