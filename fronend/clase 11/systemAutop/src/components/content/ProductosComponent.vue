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
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="#">Settings 1</a>
                            <a class="dropdown-item" href="#">Settings 2</a>
                          </div>
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
						<th>Proc.</th>
						<th>Categ.</th>
						<th>Provee.</th>
						<th>Proced..</th>
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

				<div>
					<div class="x_panel">
								<div class="x_title">
									<h2>Formulario Productos<small></small></h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
										</li>
										<li class="dropdown">
											<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
											<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
												<a class="dropdown-item" href="#">Settings 1</a>
												<a class="dropdown-item" href="#">Settings 2</a>
											</div>
										</li>
										<li><a class="close-link"><i class="fa fa-close"></i></a>
										</li>
									</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									
									<form class="form-horizontal form-label-left">

										<div class="form-group row ">
											<label class="control-label col-md-3 col-sm-3 ">Nombre el producto</label>
											<div class="col-md-9 col-sm-9 ">
												<input id="nombre" v-model="nombre" class="form-control" type="text" name="nombre" placeholder="Nombre del Prodcuto">
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Precio X Unidad</label>
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
											<label class="control-label col-md-3 col-sm-3 ">Descripcion<span class="required">*</span>
											</label>
											<div class="col-md-9 col-sm-9 ">
												<textarea class="form-control" rows="2" placeholder="Descripcion del producto...." id="descripcion" name="descripcion" v-model="descripcion"></textarea>
											</div>
										</div>
										
										<div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Stock</label>
											<div class="col-md-9 col-sm-9 ">
												<input type="number" name="stock" id="stock" class="form-control col-md-2" />
											</div>
                                            
										</div>
                                        <div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Stock Minimo</label>
											<div class="col-md-9 col-sm-9 ">
												<input type="number" name="stockmin" id="stockmin" class="form-control col-md-2" />
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Marca</label>
											<div class="col-md-9 col-sm-9 ">
												<select class="form-control">
													<option>Eliga</option>
													<option>Boleta</option>
													<option>Factura</option>
													
												</select>
											</div>
										</div>

                                        <div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Procedencia</label>
											<div class="col-md-9 col-sm-9 ">
												<select class="form-control">
													<option>Eliga</option>
													<option>Boleta</option>
													<option>Factura</option>
													
												</select>
											</div>
										</div>

                                        <div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Categoria</label>
											<div class="col-md-9 col-sm-9 ">
												<select class="form-control">
													<option>Eliga</option>
													<option>Boleta</option>
													<option>Factura</option>
													
												</select>
											</div>
										</div>

                                        <div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Proveedor</label>
											<div class="col-md-9 col-sm-9 ">
												<select class="form-control">
													<option>Eliga</option>
													<option>Boleta</option>
													<option>Factura</option>
													
												</select>
											</div>
										</div>
                                        <div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Procedencia</label>
											<div class="col-md-9 col-sm-9 ">
												<select class="form-control">
													<option>Eliga</option>
													<option>Boleta</option>
													<option>Factura</option>
													
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
