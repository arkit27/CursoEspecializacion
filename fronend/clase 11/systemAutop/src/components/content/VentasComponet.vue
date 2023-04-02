<template>
	<div class="right_col" role="main">
		<div class="row">
			<div class="col-md-12 col-sm-12  ">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Control de Ventas</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                     
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>

				  <div class="x_content1">
					
					<div class="row">
						<div class="col-sm-12">
						  <div class="card-box table-responsive">
				  <table id="datatable-fixed-header" class="table table-striped table-bordered" style="width:100%">
					<thead>
					  <tr>
						<th>Producto</th>
						<th>Unidades</th>
						<th>Descripcion</th>
						<th>Cliente</th>
						<th>Tipo de Comprobante</th>
						
					  </tr>
					</thead>
					<tbody>
					  <tr v-for="itemVenta in listaventas">
						<td>{{itemProducto.nombre}}</td>
						<td>{{itemVenta.descripcion}}</td>
						<td>{{itemVenta.nombres}}</td>
						<td>{{itemVenta.descripcion}}</td>
						<td>{{itemVenta.stock}}</td>
						<td>{{itemVenta.stockmin}}</td>
						<td>{{itemVenta.marca}}</td>
						<td>{{itemVenta.categoria}}</td>
						<td>{{itemVenta.proveedor}}</td>
						
						<td class="text-center">
						  <i class="fa fa-pencil" v-on:click="editarVenta(itemVenta)" style="cursor:pointer; padding-right: 1ex; color: burlywood;"></i>
						  <i class="fa fa-trash" v-on:click="eliminarVenta(itemVenta.id_venta)"  style="cursor:pointer; padding-right: 1ex; color:red"></i>
						</td>
					  </tr>                       
					</tbody>
				  </table>
				</div>
			  </div>
			</div>

				  </div>
                </div>

				<div>
					<div class="x_panel">
								<div class="x_title">
									<h2>General Venta<small></small></h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
										</li>
										
										<li><a class="close-link"><i class="fa fa-close"></i></a>
										</li>
									</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<br />
									<form class="form-horizontal form-label-left">

										<div class="form-group row ">
											<label class="control-label col-md-3 col-sm-3 ">Escoge un producto</label>
											<div class="col-md-9 col-sm-9 ">
												<select v-model="selecProducto" class="select2_single form-control" tabindex="-1">
												  <option selected>selecionar</option>
												  <option v-for="itemProducto in listaproductos " :value="itemProducto.id_producto">{{
													itemProducto.nombre }}</option>
												</select>
											  </div>
										</div>

										<div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Precio</label>
											<div class="col-md-9 col-sm-9 ">
												<input type="text" class="form-control" disabled placeholder="Precio">
											</div>
										</div>
									
										<div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Descripcion<span class="required"></span>
											</label>
											<div class="col-md-9 col-sm-9 ">
												<textarea class="form-control" rows="3" placeholder="Date Of Birth"></textarea>
											</div>
										</div>
										
										<div class="form-group row ">
											<label class="control-label col-md-3 col-sm-3 ">Escoge un Cliente</label>
											<div class="col-md-9 col-sm-9 ">
												<select v-model="selecCliente" class="select2_single form-control" tabindex="-1">
												  <option selected>selecionar</option>
												  <option v-for="itemCliente in listaclientes " :value="itemCliente.id_cliente">{{
													itemCliente.nombre }}</option>
												</select>
											  </div>
										</div>
										<div class="form-group row ">
											<label class="control-label col-md-3 col-sm-3 ">Tipo de Comprobante</label>
											<div class="col-md-9 col-sm-9 ">
												<select v-model="selecFacturacion" class="select2_single form-control" tabindex="-1">
												  <option selected>Selecionar</option>
												  <option v-for="item in listafacturacion " :value="item.id_factu">{{
													item.facturacion }}</option>
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
		
			  
	</div>
	
  </template>

  <script>
  export default {
	data() {
	  return {
		id_producto: null,
		nombre: "",
		precio_unitario: "",
		precio_venta: "",
		precio_compra: "",
		descripcion: "",
		stock: "",
		stockmin: "",
		selecMarca: "",
		selecCategoria: "",
		selecProcedencia: "",
		selecProveedor: "",
		listaproductos: [],
	
		
	  };
	},
	methods: {
	  async iniciarCarga() {
			try {
			const response = await fetch("http://localhost:8081/v1/productos/");
			this.listaproductos= this.listMenuItems = await response.json();   
			} catch (error) {
			//console.log(error);
			}
		},
	  async iniciarProductos() {
		try {
		  var urltmp = "http://localhost:8081/v1/productos/";
		  const response = await fetch(urltmp);
		  this.listaproductos = this.listaproductos = await response.json();
		  //console.log("prueba");
		} catch (error) {
		  //console.log("error");
		}
	  },
	  async iniciarClientes() {
		try {
		  var urltmp = "http://localhost:8081/v1/clientes/";
		  const response = await fetch(urltmp);
		  this.listaclientes = this.listaclientes = await response.json();
		} catch (error) {
		  //console.log(error);
		}
	  },
	  async iniciarFacturacion() {
		try {
		  var urltmp = "http://localhost:8081/v1/facturacion/";
		  const response = await fetch(urltmp);
		  this.listafacturacion = this.listafacturacion = await response.json();
		} catch (error) {
		  //console.log(error);
		}
	  },
	  async iniciarProcedencia() {
		try {
		  var urltmp = "http://localhost:8081/v1/procedencias/";
		  const response = await fetch(urltmp);
		  this.listaprocedencias = this.listaprocedencias = await response.json();
		} catch (error) {
		  //console.log(error);
		}
	  },
	  guardardatos() {
		var data = {
		  nombre: this.nombre,
		  descripcion: this.descripcion,
		  precio_unitario: this.precio_unitario,
		  precio_compra: this.precio_compra,
		  precio_venta: this.precio_venta,
		  stock: this.stock,
		  stockmin: this.stockmin,
		  peso: this.peso,
		  id_marca: this.selecMarca,
		  id_categoria: this.selecCategoria,
		  id_proveedor: this.selecProveedor,
		  id_procedencia: this.selecProcedencia,
		};
		var metodo = "POST";
  
		console.log(this.id_producto)
  
		if (this.id_producto != null || this.id_producto != "") {//guardar datos			
		  data.id_producto = this.id_producto
		  metodo = "PUT";
		}
  
		fetch("http://localhost:8081/v1/productos/", {
		  method: metodo, // or 'PUT'
		  headers: { "Content-Type": "application/json", },
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
	  editarProducto(datos) {
		this.id_producto = datos.id_producto;
		this.nombre = datos.nombre;
		this.descripcion = datos.descripcion;
		this.stock = datos.stock;
		this.stockmin = datos.stockmin;
		this.peso = datos.peso;
		this.precio_compra = datos.precio_compra;
		this.precio_venta = datos.precio_venta;
		this.precio_unitario = datos.precio_unitario;
		
		this.selecCategoria = datos.selecCategoria;
		this.selecMarca = datos.selecMarca;
		this.selecProveedor = datos.selecProveedor;
		this.selecProcedencia = datos.selecProcedencia;
	  },
	  nuevoregistro() {
		this.mostrarformulario = true;
		this.id_producto = null;
	  },
	  cancelar() {
		this.mostrarformulario = false;
	  },
	  async eliminarProducto(idtmp) {
			try{
				const response = await fetch("http://localhost:8081/v1/productos/"+idtmp,{
					method: "DELETE",
				})
				if(response.status==200){
					this.id=null;
					this.iniciarCarga();
				}
			}catch (error){

			}

		},
	},
	created() {
	  this.iniciarCarga();
	  this.iniciarProductos();
	  this.iniciarClientes();
	  this.iniciarFacturacion();

	},
  }
  </script>


  <style>
/* Estilo para el formulario */
.x_panel {
	border: 1px solid #ddd;
	margin-bottom: 25px;
	background: #b4b2b6;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 1px rgba(0,0,0,.05);
	box-shadow: 0 1px 1px rgba(0,0,0,.05);
  }
  
  .x_title h2 {
	font-size: 24px;
	margin: 0;
	padding: 10px 15px;
  }
  
  .form-group {
	margin-bottom: 15px;
  }
  
  .form-horizontal .control-label {
	text-align: left;
  }
  
  .form-horizontal .col-sm-3 {
	width: auto;
	float: none;
	display: inline-block;
	margin-bottom: 15px;
	vertical-align: top;
  }
  
  .form-horizontal .col-sm-9 {
	width: auto;
	float: none;
	display: inline-block;
	vertical-align: top;
  }
  
  .form-horizontal .form-control {
	display: block;
	width: 100%;
	height: 34px;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.42857143;
	color: #555;
	background-color: #fff;
	background-image: none;
	border: 1px solid #ccc;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
	box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
	-webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
	transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
  }
  
  .form-horizontal .form-control:focus {
	border-color: #66afe9;
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
	box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
  }
  
  .form-horizontal .required:before {
	content: "*";
	color: red;
	font-size: 15px;
	margin-right: 5px;
  }
  
  .btn {
	display: inline-block;
	padding: 6px 12px;
	margin-bottom: 0;
	font-size: 14px;
	font-weight: 400;
	line-height: 1.42857143;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	cursor: pointer;
	background-image: none;
	border: 1px solid transparent;
	border-radius: 4px;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
  }
  
  .btn-default {
	color:#fff }
</style>
  
  
  
  