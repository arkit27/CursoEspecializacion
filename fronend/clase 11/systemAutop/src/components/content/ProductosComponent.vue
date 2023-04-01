<template>
	<div class="right_col" role="main">
		<div class="row">
		<div class="col-md-12 col-sm-12  ">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Control de Productos<small>listado</small></h2>
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
						<th>Nombre</th>
						<th>Precio U.</th>
						<th>Precio Com.</th>
						<th>Precio Ven.</th>
						<th>Descrip.</th>
						<th>Stock</th>
						<th>Stock Min</th>
						<th>Marca</th>
						<th>Categ..</th>
						<th>Provee.</th>
						<th>Proced..</th>
						<th>Acciones</th>
					  </tr>
					</thead>
					<tbody>
					  <tr v-for="itemProducto in listaproductos">
						<td>{{itemProducto.nombre}}</td>
						<td>{{itemProducto.precio_unitario}}</td>
						<td>{{itemProducto.precio_compra}}</td>
						<td>{{itemProducto.precio_venta}}</td>
						<td>{{itemProducto.descripcion}}</td>
						<td>{{itemProducto.stock}}</td>
						<td>{{itemProducto.stockmin}}</td>
						<td>{{itemProducto.Nombremarca}}</td>
						<td>{{itemProducto.Nombrecategoria}}</td>
						<td>{{itemProducto.Nombreproveedor}}</td>
						<td>{{itemProducto.Nombreprocedencia}}</td>
						<td class="text-center">
						  <i class="fa fa-pencil" v-on:click="editarProducto(itemProducto)" style="cursor:pointer; padding-right: 1ex; color: burlywood;"></i>
						  <i class="fa fa-trash" v-on:click="eliminarProducto(itemProducto.id_producto)"  style="cursor:pointer; padding-right: 1ex; color:red"></i>
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
									<h2>Formulario Productos<small></small></h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
										</li>
										
										<li><a class="close-link"><i class="fa fa-close"></i></a>
										</li>
									</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									
									<form id="frmProducto" v-on:submit="guardardatos()" data-parsley-validate class="form-horizontal form-label-left">

										<div class="form-group row ">
											<label class="control-label col-md-3 col-sm-3 ">Nombre el producto</label>
											<input type="hidden" id="id_producto" name="id" v-model="id_producto" />
											<div class="col-md-9 col-sm-9 ">
												<input id="nombre" v-model="nombre" class="form-control" type="text" name="nombre" placeholder="Nombre del Producto">
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Precio por Unidad</label>
											<div class="col-md-9 col-sm-9 ">
												<input id="precio_unitario" v-model="precio_unitario" class="form-control" type="text" name="precio_unitario" placeholder="Precio Unitario">
											</div>
										</div>
                                        <div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Precio de Compra</label>
											<div class="col-md-9 col-sm-9 ">
												<input id="precio_compra" v-model="precio_compra" class="form-control" type="text" name="precio_compra" placeholder="Precio Compra">
											</div>
										</div>
                                        <div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Precio de Venta</label>
											<div class="col-md-9 col-sm-9 ">
												<input id="precio_venta" v-model="precio_venta" class="form-control" type="text" name="precio_venta" placeholder="Precio Venta">
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Descripcion
											</label>
											<div class="col-md-9 col-sm-9 ">
												<textarea class="form-control" rows="2" placeholder="Descripcion del producto...." id="descripcion" name="descripcion" v-model="descripcion"></textarea>
											</div>
										</div>
										
										<div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Stock</label>
											<div class="col-md-9 col-sm-9 ">
												<input type="number" name="stock" id="stock"  v-model="stock" class="form-control col-md-2" />
											</div>
                                            
										</div>
                                        <div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Stock Minimo</label>
											<div class="col-md-9 col-sm-9 ">
												<input type="number" name="stockmin" id="stockmin"  v-model="stockmin" class="form-control col-md-2" />
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Procedencias</label>
											<div class="col-md-9 col-sm-9 ">
												<select v-model="selecProcedencia" class="select2_single form-control" tabindex="-1">
												  <option  selected>Sin Procedencia</option>
												  <option v-for="itemProcedencia in listaprocedencias " :value="itemProcedencia.id_procedencia">{{
													itemProcedencia.procedencia }}</option>
												</select>
											  </div>
										</div>

										<div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">categoria</label>
											<div class="col-md-9 col-sm-9 ">
												<select v-model="selecCategoria" class="select2_single form-control" tabindex="-1">
												  <option selected>Sin Categoria</option>
												  <option v-for="itemCategoria in listacategorias " :value="itemCategoria.id_categoria">{{
													itemCategoria.categoria }}</option>
												</select>
											  </div>
										</div>
										
                                        <div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Marca</label>
											<div class="col-md-9 col-sm-9 ">
												<select v-model="selecMarca" class="select2_single form-control" tabindex="-1">
												  <option selected>Sin Marca</option>
												  <option v-for="itemMarca in listamarcas " :value="itemMarca.id_marca">{{
													itemMarca.marca }}</option>
												</select>
											  </div>
										</div>
										
										<div class="form-group row">
											<label class="control-label col-md-3 col-sm-3">Proveedor</label>
											<div class="col-md-9 col-sm-9 ">
											  <select v-model="selectProveedor" class="select2_single form-control" tabindex="-1">
												<option selected>Sin Proveedor</option>
												<option v-for="itemProveedor in listaproveedores " :value="itemProveedor.id_proveedor">{{
												  itemProveedor.nombres }}</option>
											  </select>
											</div>
										  </div>
                                      
										<div class="ln_solid"></div>
										<div class="form-group">
											<div class="col-md-9 col-sm-9  offset-md-3">
												<button type="button" class="btn btn-primary">Cancelar</button>
												<button type="reset" class="btn btn-primary">Limpiar</button>
												<button type="submit" class="btn btn-success">Guardar</button>
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
	  async iniciarMarca() {
		try {
		  var urltmp = "http://localhost:8081/v1/marcas/";
		  const response = await fetch(urltmp);
		  this.listamarcas = this.listamarcas = await response.json();
		  //console.log("prueba");
		} catch (error) {
		  //console.log("error");
		}
	  },
	  async iniciarCategoria() {
		try {
		  var urltmp = "http://localhost:8081/v1/categorias/";
		  const response = await fetch(urltmp);
		  this.listacategorias = this.listacategorias = await response.json();
		} catch (error) {
		  //console.log(error);
		}
	  },
	  async iniciarProveedor() {
		try {
		  var urltmp = "http://localhost:8081/v1/proveedores/";
		  const response = await fetch(urltmp);
		  this.listaproveedores = this.listaproveedores = await response.json();
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
		this.stock = datos.stock;
		this.stockmin = datos.stockmin;
		this.precioCompra = datos.precioCompra;
		this.precioVenta = datos.precioVenta;
		this.nombreMarca = datos.nombreMarca;
		this.nombreCategoria = datos.nombreCategoria;
		this.nombreProveedor = datos.nombreProveedor;
		this.nombrePresentacion = datos.nombrePresentacion;
	  },
	  nuevoregistro() {
		this.mostrarformulario = true;
		this.id_producto = null;
	  },
	  cancelar() {
		this.mostrarformulario = false;
	  },
	  eliminarProducto(idtmp) {
		Swal.fire({
		  title: 'Esta Seguro de Eliminar el registro Seleccionado?',
		  showDenyButton: true,
		  showCancelButton: true,
		  confirmButtonText: 'Si, Borrar',
		  denyButtonText: `No, Cancelar`,
		}).then((result) => {
		  /* Read more about isConfirmed, isDenied below */
		  if (result.isConfirmed) {
			fetch("http://localhost:8081/v1/productos/" + idtmp, {
			  method: 'DELETE', // or 'PUT'
			  headers: { "Content-Type": "application/json", },
			}).then((response) => response.text())
			  .then((data) => {
				Swal.fire(data, '', 'success')
				this.iniciarCarga();
			  })
			  .catch((error) => {
				Swal.fire('Error: ' + error, '', 'error')
				return;
			  });
		  } else if (result.isDenied) {
			Swal.fire('Operación Cancelada', '', 'info')
		  }
		})
	  }
	},
	created() {
	  this.iniciarCarga();
	  this.iniciarMarca();
	  this.iniciarCategoria();
	  this.iniciarProveedor();
	  this.iniciarProcedencia();
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

