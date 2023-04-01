PGDMP     
                    {            bdtiendafinal    14.6    14.6 1    A           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            B           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            C           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            D           1262    16528    bdtiendafinal    DATABASE     k   CREATE DATABASE bdtiendafinal WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Quechua_Bolivia.1252';
    DROP DATABASE bdtiendafinal;
                admin5    false            �            1259    17150    tb_categorias    TABLE     �   CREATE TABLE public.tb_categorias (
    id_categoria uuid NOT NULL,
    categoria character varying(255) NOT NULL,
    idproducto uuid
);
 !   DROP TABLE public.tb_categorias;
       public         heap    admin5    false            �            1259    17155    tb_clientes    TABLE     _  CREATE TABLE public.tb_clientes (
    id_cliente uuid NOT NULL,
    apellido character varying(255) NOT NULL,
    direccion character varying(255) NOT NULL,
    dni character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    nombre character varying(255) NOT NULL,
    telefono character varying(255) NOT NULL,
    idventa uuid
);
    DROP TABLE public.tb_clientes;
       public         heap    admin5    false            �            1259    17162    tb_detalle_venta    TABLE     �   CREATE TABLE public.tb_detalle_venta (
    id_detalle_venta uuid NOT NULL,
    cantidad integer NOT NULL,
    precio_unitario double precision NOT NULL,
    id_usuario uuid
);
 $   DROP TABLE public.tb_detalle_venta;
       public         heap    admin5    false            �            1259    16817    tb_empleados    TABLE     �  CREATE TABLE public.tb_empleados (
    id_empleado uuid NOT NULL,
    apellido character varying(255) NOT NULL,
    cargo character varying(255) NOT NULL,
    direccion character varying(255) NOT NULL,
    dni character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    id_usuario uuid,
    nombre character varying(255) NOT NULL,
    telefono character varying(255) NOT NULL
);
     DROP TABLE public.tb_empleados;
       public         heap    admin5    false            �            1259    17167    tb_facturacion    TABLE     �   CREATE TABLE public.tb_facturacion (
    id_factu uuid NOT NULL,
    facturacion character varying(255) NOT NULL,
    idventas uuid
);
 "   DROP TABLE public.tb_facturacion;
       public         heap    admin5    false            �            1259    17172 	   tb_marcas    TABLE     ~   CREATE TABLE public.tb_marcas (
    id_marca uuid NOT NULL,
    marca character varying(255) NOT NULL,
    idproducto uuid
);
    DROP TABLE public.tb_marcas;
       public         heap    admin5    false            �            1259    17208    tb_menus    TABLE     �   CREATE TABLE public.tb_menus (
    id_menu uuid NOT NULL,
    icono character varying(255) NOT NULL,
    menu_padre uuid NOT NULL,
    nombre character varying(255) NOT NULL,
    orden integer NOT NULL,
    url character varying(255) NOT NULL
);
    DROP TABLE public.tb_menus;
       public         heap    admin5    false            �            1259    17177    tb_procendencias    TABLE     �   CREATE TABLE public.tb_procendencias (
    id_procedencia uuid NOT NULL,
    procedencia character varying(255) NOT NULL,
    idproducto uuid
);
 $   DROP TABLE public.tb_procendencias;
       public         heap    admin5    false            �            1259    17182    tb_productos    TABLE     �  CREATE TABLE public.tb_productos (
    id_producto uuid NOT NULL,
    descripcion character varying(255) NOT NULL,
    nombre character varying(255) NOT NULL,
    peso double precision NOT NULL,
    precio_compra double precision NOT NULL,
    precio_unitario double precision NOT NULL,
    precio_venta double precision NOT NULL,
    procedencia character varying(255) NOT NULL,
    stock integer NOT NULL,
    stockmin integer NOT NULL,
    iddetalleventa uuid
);
     DROP TABLE public.tb_productos;
       public         heap    admin5    false            �            1259    17189    tb_proveedores    TABLE     :  CREATE TABLE public.tb_proveedores (
    id_proveedor uuid NOT NULL,
    direccion character varying(255) NOT NULL,
    dni character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    nombres character varying(255) NOT NULL,
    telefono character varying(255) NOT NULL,
    idproducto uuid
);
 "   DROP TABLE public.tb_proveedores;
       public         heap    admin5    false            �            1259    17196    tb_usuarios    TABLE     �   CREATE TABLE public.tb_usuarios (
    id_usuario uuid NOT NULL,
    nombre character varying(255) NOT NULL,
    clave character varying(255) NOT NULL,
    rol character varying(255) NOT NULL,
    usuario character varying(255) NOT NULL
);
    DROP TABLE public.tb_usuarios;
       public         heap    admin5    false            �            1259    17203 	   tb_ventas    TABLE     �   CREATE TABLE public.tb_ventas (
    id_venta uuid NOT NULL,
    fecha_venta timestamp without time zone NOT NULL,
    iddetalleventa uuid
);
    DROP TABLE public.tb_ventas;
       public         heap    admin5    false            4          0    17150    tb_categorias 
   TABLE DATA           L   COPY public.tb_categorias (id_categoria, categoria, idproducto) FROM stdin;
    public          admin5    false    210   c@       5          0    17155    tb_clientes 
   TABLE DATA           m   COPY public.tb_clientes (id_cliente, apellido, direccion, dni, email, nombre, telefono, idventa) FROM stdin;
    public          admin5    false    211   �@       6          0    17162    tb_detalle_venta 
   TABLE DATA           c   COPY public.tb_detalle_venta (id_detalle_venta, cantidad, precio_unitario, id_usuario) FROM stdin;
    public          admin5    false    212   �@       3          0    16817    tb_empleados 
   TABLE DATA           y   COPY public.tb_empleados (id_empleado, apellido, cargo, direccion, dni, email, id_usuario, nombre, telefono) FROM stdin;
    public          admin5    false    209   �@       7          0    17167    tb_facturacion 
   TABLE DATA           I   COPY public.tb_facturacion (id_factu, facturacion, idventas) FROM stdin;
    public          admin5    false    213   �@       8          0    17172 	   tb_marcas 
   TABLE DATA           @   COPY public.tb_marcas (id_marca, marca, idproducto) FROM stdin;
    public          admin5    false    214   �@       >          0    17208    tb_menus 
   TABLE DATA           R   COPY public.tb_menus (id_menu, icono, menu_padre, nombre, orden, url) FROM stdin;
    public          admin5    false    220   A       9          0    17177    tb_procendencias 
   TABLE DATA           S   COPY public.tb_procendencias (id_procedencia, procedencia, idproducto) FROM stdin;
    public          admin5    false    215   .A       :          0    17182    tb_productos 
   TABLE DATA           �   COPY public.tb_productos (id_producto, descripcion, nombre, peso, precio_compra, precio_unitario, precio_venta, procedencia, stock, stockmin, iddetalleventa) FROM stdin;
    public          admin5    false    216   KA       ;          0    17189    tb_proveedores 
   TABLE DATA           l   COPY public.tb_proveedores (id_proveedor, direccion, dni, email, nombres, telefono, idproducto) FROM stdin;
    public          admin5    false    217   hA       <          0    17196    tb_usuarios 
   TABLE DATA           N   COPY public.tb_usuarios (id_usuario, nombre, clave, rol, usuario) FROM stdin;
    public          admin5    false    218   �A       =          0    17203 	   tb_ventas 
   TABLE DATA           J   COPY public.tb_ventas (id_venta, fecha_venta, iddetalleventa) FROM stdin;
    public          admin5    false    219   �A       �           2606    17154     tb_categorias tb_categorias_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.tb_categorias
    ADD CONSTRAINT tb_categorias_pkey PRIMARY KEY (id_categoria);
 J   ALTER TABLE ONLY public.tb_categorias DROP CONSTRAINT tb_categorias_pkey;
       public            admin5    false    210            �           2606    17161    tb_clientes tb_clientes_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tb_clientes
    ADD CONSTRAINT tb_clientes_pkey PRIMARY KEY (id_cliente);
 F   ALTER TABLE ONLY public.tb_clientes DROP CONSTRAINT tb_clientes_pkey;
       public            admin5    false    211            �           2606    17166 &   tb_detalle_venta tb_detalle_venta_pkey 
   CONSTRAINT     r   ALTER TABLE ONLY public.tb_detalle_venta
    ADD CONSTRAINT tb_detalle_venta_pkey PRIMARY KEY (id_detalle_venta);
 P   ALTER TABLE ONLY public.tb_detalle_venta DROP CONSTRAINT tb_detalle_venta_pkey;
       public            admin5    false    212            �           2606    16823    tb_empleados tb_empleados_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.tb_empleados
    ADD CONSTRAINT tb_empleados_pkey PRIMARY KEY (id_empleado);
 H   ALTER TABLE ONLY public.tb_empleados DROP CONSTRAINT tb_empleados_pkey;
       public            admin5    false    209            �           2606    17171 "   tb_facturacion tb_facturacion_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.tb_facturacion
    ADD CONSTRAINT tb_facturacion_pkey PRIMARY KEY (id_factu);
 L   ALTER TABLE ONLY public.tb_facturacion DROP CONSTRAINT tb_facturacion_pkey;
       public            admin5    false    213            �           2606    17176    tb_marcas tb_marcas_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tb_marcas
    ADD CONSTRAINT tb_marcas_pkey PRIMARY KEY (id_marca);
 B   ALTER TABLE ONLY public.tb_marcas DROP CONSTRAINT tb_marcas_pkey;
       public            admin5    false    214            �           2606    17214    tb_menus tb_menus_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.tb_menus
    ADD CONSTRAINT tb_menus_pkey PRIMARY KEY (id_menu);
 @   ALTER TABLE ONLY public.tb_menus DROP CONSTRAINT tb_menus_pkey;
       public            admin5    false    220            �           2606    17181 &   tb_procendencias tb_procendencias_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.tb_procendencias
    ADD CONSTRAINT tb_procendencias_pkey PRIMARY KEY (id_procedencia);
 P   ALTER TABLE ONLY public.tb_procendencias DROP CONSTRAINT tb_procendencias_pkey;
       public            admin5    false    215            �           2606    17188    tb_productos tb_productos_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.tb_productos
    ADD CONSTRAINT tb_productos_pkey PRIMARY KEY (id_producto);
 H   ALTER TABLE ONLY public.tb_productos DROP CONSTRAINT tb_productos_pkey;
       public            admin5    false    216            �           2606    17195 "   tb_proveedores tb_proveedores_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.tb_proveedores
    ADD CONSTRAINT tb_proveedores_pkey PRIMARY KEY (id_proveedor);
 L   ALTER TABLE ONLY public.tb_proveedores DROP CONSTRAINT tb_proveedores_pkey;
       public            admin5    false    217            �           2606    17202    tb_usuarios tb_usuarios_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tb_usuarios
    ADD CONSTRAINT tb_usuarios_pkey PRIMARY KEY (id_usuario);
 F   ALTER TABLE ONLY public.tb_usuarios DROP CONSTRAINT tb_usuarios_pkey;
       public            admin5    false    218            �           2606    17207    tb_ventas tb_ventas_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tb_ventas
    ADD CONSTRAINT tb_ventas_pkey PRIMARY KEY (id_venta);
 B   ALTER TABLE ONLY public.tb_ventas DROP CONSTRAINT tb_ventas_pkey;
       public            admin5    false    219            �           2606    17240 ,   tb_procendencias fk4yb6ojiw3jjw8eh54xkwjmoc3    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_procendencias
    ADD CONSTRAINT fk4yb6ojiw3jjw8eh54xkwjmoc3 FOREIGN KEY (idproducto) REFERENCES public.tb_productos(id_producto);
 V   ALTER TABLE ONLY public.tb_procendencias DROP CONSTRAINT fk4yb6ojiw3jjw8eh54xkwjmoc3;
       public          admin5    false    3222    216    215            �           2606    17235 %   tb_marcas fkda1ixdwh2v4q5q9c612fhhts3    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_marcas
    ADD CONSTRAINT fkda1ixdwh2v4q5q9c612fhhts3 FOREIGN KEY (idproducto) REFERENCES public.tb_productos(id_producto);
 O   ALTER TABLE ONLY public.tb_marcas DROP CONSTRAINT fkda1ixdwh2v4q5q9c612fhhts3;
       public          admin5    false    216    214    3222            �           2606    17250 *   tb_proveedores fkdby2kem2ble7y86feh0i4xuvt    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_proveedores
    ADD CONSTRAINT fkdby2kem2ble7y86feh0i4xuvt FOREIGN KEY (idproducto) REFERENCES public.tb_productos(id_producto);
 T   ALTER TABLE ONLY public.tb_proveedores DROP CONSTRAINT fkdby2kem2ble7y86feh0i4xuvt;
       public          admin5    false    217    216    3222            �           2606    17255 %   tb_ventas fke1rxpxhuwo5aboyqmwqt5bry3    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_ventas
    ADD CONSTRAINT fke1rxpxhuwo5aboyqmwqt5bry3 FOREIGN KEY (iddetalleventa) REFERENCES public.tb_detalle_venta(id_detalle_venta);
 O   ALTER TABLE ONLY public.tb_ventas DROP CONSTRAINT fke1rxpxhuwo5aboyqmwqt5bry3;
       public          admin5    false    212    3214    219            �           2606    17230 *   tb_facturacion fkedi04u3psqvaf7s9fm5gssq0o    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_facturacion
    ADD CONSTRAINT fkedi04u3psqvaf7s9fm5gssq0o FOREIGN KEY (idventas) REFERENCES public.tb_ventas(id_venta);
 T   ALTER TABLE ONLY public.tb_facturacion DROP CONSTRAINT fkedi04u3psqvaf7s9fm5gssq0o;
       public          admin5    false    213    3228    219            �           2606    17245 (   tb_productos fkiu2bjlrw6jo3bm7pqy0xao8de    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_productos
    ADD CONSTRAINT fkiu2bjlrw6jo3bm7pqy0xao8de FOREIGN KEY (iddetalleventa) REFERENCES public.tb_detalle_venta(id_detalle_venta);
 R   ALTER TABLE ONLY public.tb_productos DROP CONSTRAINT fkiu2bjlrw6jo3bm7pqy0xao8de;
       public          admin5    false    212    216    3214            �           2606    17225 ,   tb_detalle_venta fkldk82pw3iiw2a4hf9emtqmxmg    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_detalle_venta
    ADD CONSTRAINT fkldk82pw3iiw2a4hf9emtqmxmg FOREIGN KEY (id_usuario) REFERENCES public.tb_usuarios(id_usuario);
 V   ALTER TABLE ONLY public.tb_detalle_venta DROP CONSTRAINT fkldk82pw3iiw2a4hf9emtqmxmg;
       public          admin5    false    218    3226    212            �           2606    17220 '   tb_clientes fkrpaualheqvcl1j5y9wf5kctb0    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_clientes
    ADD CONSTRAINT fkrpaualheqvcl1j5y9wf5kctb0 FOREIGN KEY (idventa) REFERENCES public.tb_ventas(id_venta);
 Q   ALTER TABLE ONLY public.tb_clientes DROP CONSTRAINT fkrpaualheqvcl1j5y9wf5kctb0;
       public          admin5    false    219    3228    211            �           2606    17215 )   tb_categorias fkt567nrk0ajwbdefhfebl811oj    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_categorias
    ADD CONSTRAINT fkt567nrk0ajwbdefhfebl811oj FOREIGN KEY (idproducto) REFERENCES public.tb_productos(id_producto);
 S   ALTER TABLE ONLY public.tb_categorias DROP CONSTRAINT fkt567nrk0ajwbdefhfebl811oj;
       public          admin5    false    210    216    3222            4      x������ � �      5      x������ � �      6      x������ � �      3      x������ � �      7      x������ � �      8      x������ � �      >      x������ � �      9      x������ � �      :      x������ � �      ;      x������ � �      <      x������ � �      =      x������ � �     