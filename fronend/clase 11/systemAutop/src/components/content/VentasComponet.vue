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
					  <tr v-for="itemProducto in listaventas">
						<td>{{itemProducto.nombre}}</td>
						<td>{{itemProducto.precio_unitario}}</td>
						<td>{{itemProducto.precio_compra}}</td>
						<td>{{itemProducto.precio_venta}}</td>
						<td>{{itemProducto.descripcion}}</td>
						<td>{{itemProducto.stock}}</td>
						<td>{{itemProducto.stockmin}}</td>
						<td>{{itemProducto.marca}}</td>
						<td>{{itemProducto.categoria}}</td>
						<td>{{itemProducto.proveedor}}</td>
						<td>{{itemProducto.procedencia}}</td>
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
											<label class="control-label col-md-3 col-sm-3 ">Nombre el producto</label>
											<div class="col-md-9 col-sm-9 ">
												<input type="text" class="form-control" placeholder="Buscar...">
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
										
										<div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Cliente</label>
											<div class="col-md-9 col-sm-9 ">
												<input type="text" name="country" id="autocomplete-custom-append" class="form-control col-md-10" />
											</div>
										</div>
										<div class="form-group row">
											<label class="control-label col-md-3 col-sm-3 ">Tipo de Factura</label>
											<div class="col-md-9 col-sm-9 ">
												<select class="form-control">
													<option>Eliga</option>
													<option>Boleta</option>
													<option>Factura</option>
													
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
  
  
  
  