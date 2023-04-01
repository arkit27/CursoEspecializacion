<template>
  
  <div class="right_col" role="main">
    <div class="">
      <div class="page-title">
       
       
      </div>

      <div class="clearfix"></div>

      <div class="row">
        <div class="col-md-12">
          <div class="x_panel">
            <div class="x_title">
              <h1> <small>Estado del sistema</small></h1>
            
              <div class="clearfix"></div>
            </div>
            <div class="x_content">

              <section class="content invoice">
                <!-- fecha y hora-->
                <div>
                  <div class="row">
                    <div class="invoice-header1" style="float: left; margin-right: 10px;">
                      <h3>
                        <small class="reloj-digital">{{ currentDate }}</small>
                      </h3>
                    </div>
                  </div>
                  
                </div>
                <div class="ln_solid"></div>
                <!-- info row -->
                <div class="row invoice-info">
                  <div class="col-sm-4 invoice-col1 with-bar-right"> 
                    <address>
                      <br>Total de Menus: {{ numMenus }}
                    </address>
                  </div>
                  <!-- /.col -->
                  <div class="col-sm-4 invoice-col1 with-bar-left-right">
                  
                    <address>
                     
                        <br>Total de Empleados: {{ numMenus }}
                     
                    </address>
                  </div>
                  <!-- /.col -->
                  <div class="col-sm-4 invoice-col1 with-bar-left">
                    <address>
                      <br>Total de ventas: {{ numMenus }}
                    </address>
                  </div>
                  <!-- /.col -->
                </div>
                <div class="ln_solid"></div>
                
                <div class="row invoice-info">
                  <div class="col-sm-4 invoice-col1 with-bar-right"> 
                    <address>
                      <br>Clientes Registrados: {{ numMenus }}
                    </address>
                  </div>
                  <!-- /.col -->
                  <div class="col-sm-4 invoice-col1 with-bar-left-right">
                  
                    <address>
                     
                        <br>Total de Productos: {{ numMenus }}
                     
                    </address>
                  </div>
                  <!-- /.col -->
                  <div class="col-sm-4 invoice-col1 with-bar-left">
                    <address>
                      <br>Total de ventas: {{ numMenus }}
                    </address>
                  </div>
                  <!-- /.col -->
                </div>

                <div class="ln_solid"></div>

                <div class="row no-print1">
                  <div class=" ">
                    <button class="btn btn-default pull-left" onclick="window.print();"><i class="fa fa-print"></i>Generar informe</button>
                  </div>
                </div>

              </section>
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
      currentDate: null
    };
  },
  mounted() {
    // actualiza la fecha y hora cada segundo
    setInterval(() => {
      this.currentDate = new Date().toLocaleString();
    }, 1000);
  }
};

</script>
//reloj-digital
<style>
.reloj-digital {
  font-family: "Courier New", monospace;
  font-size: 3em;
  text-shadow: 2px 2px #111010;
  color: #ffffff;
}

.invoice-header1 {
  text-align: center;
  background-color: #a8a5a5;
  padding: 20px;
  border-radius: 10px;
  width: 100%; /* hace que el ancho sea igual al ancho del contenedor padre */
  height: 100%; /* hace que la altura sea igual a la altura del contenedor padre */
  box-sizing: border-box; /* incluye el padding y borde dentro del ancho y altura del elemento */
}

h3.small {
  margin: 0;
  padding: 0;
  font-size: 20px;
  font-weight: normal;
  margin: 0;
  padding: 0;
}

</style>
//celdas siguientes
<style>
.row.invoice-info {
  background-color: #bfbebe;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  padding: 20px;
}

.invoice-col1 {
  margin-bottom: 20px;
}

.invoice-col1 address {
  font-size: 16px;
  font-weight: 400;
  margin-bottom: 5px;
}

.invoice-col1 strong {
  font-weight: 600;
}

.invoice-col1 b {
  font-size: 16px;
  font-weight: 400;
  margin-bottom: 5px;
}

</style>

<style>
.no-print1 .btn-default.pull-left {
  background-color: #55acee;
  color: #fff;
  border-radius: 20px;
}

.no-print1 .btn-default.pull-left:hover, 
.no-print1 .btn-default.pull-left:focus, 
.no-print1 .btn-default.pull-left:active {
  background-color: #357ebd;
  color: #fff;

  
}





</style>


