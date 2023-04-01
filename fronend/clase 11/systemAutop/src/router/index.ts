import { createRouter, createWebHistory } from 'vue-router'
import IndexView from '../views/IndexView.vue'
import ProductosView from '../views/ProductosView.vue'
import UsuariosView from '../views/UsuariosView.vue'
import MenusView from '../views/MenusView.vue'
import CategoriasView from '../views/CategoriasView.vue'
import ClientesView from '../views/ClientesView.vue'
import ProcedenciasView from '../views/ProcedenciasView.vue'
import VentasView from '../views/VentasView.vue'
import ProveedoresView from '../views/ProveedoresView.vue'
import MarcasView from '../views/MarcasView.vue'
import LoginView from '../views/LoginView.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: IndexView
    },
    
    {
      path: '/productos',
      name: 'productos',
      component: ProductosView
    },
    {
      path: '/usuarios',
      name: 'usuarios',
      component: UsuariosView
    },
    {
      path: '/menus',
      name: 'menus',
      component: MenusView
    },
    {
      path: '/categorias',
      name: 'categorias',
      component: CategoriasView
    },
   
    {
      path: '/clientes',
      name: 'clientes',
      component: ClientesView
    },
    {
      path: '/procedencias',
      name: 'procedencias',
      component: ProcedenciasView
    },
    {
      path: '/ventas',
      name: 'ventas',
      component: VentasView
    },
    {
      path: '/proveedores',
      name: 'proveedores',
      component: ProveedoresView
    },
    {
      path: '/marcas',
      name: 'marcas',
      component: MarcasView
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView
    },
    
  ]
})

export default router