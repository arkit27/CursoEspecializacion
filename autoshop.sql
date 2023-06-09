PGDMP         4                {            autoshop    14.6    14.6 3    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            @           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            A           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            B           1262    17260    autoshop    DATABASE     f   CREATE DATABASE autoshop WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Quechua_Bolivia.1252';
    DROP DATABASE autoshop;
                admin5    false            �            1259    17483    tb_categorias    TABLE     �   CREATE TABLE public.tb_categorias (
    id_categoria uuid NOT NULL,
    categoria character varying(255) NOT NULL,
    idproducto uuid
);
 !   DROP TABLE public.tb_categorias;
       public         heap    admin5    false            �            1259    17488    tb_clientes    TABLE     _  CREATE TABLE public.tb_clientes (
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
       public         heap    admin5    false            �            1259    17495    tb_detalle_venta    TABLE     �   CREATE TABLE public.tb_detalle_venta (
    id_detalle_venta uuid NOT NULL,
    cantidad integer NOT NULL,
    precio_unitario double precision NOT NULL,
    id_usuario uuid,
    id_producto uuid
);
 $   DROP TABLE public.tb_detalle_venta;
       public         heap    admin5    false            �            1259    17500    tb_facturacion    TABLE     �   CREATE TABLE public.tb_facturacion (
    id_factu uuid NOT NULL,
    facturacion character varying(255) NOT NULL,
    idventas uuid
);
 "   DROP TABLE public.tb_facturacion;
       public         heap    admin5    false            �            1259    17505 	   tb_marcas    TABLE     ~   CREATE TABLE public.tb_marcas (
    id_marca uuid NOT NULL,
    marca character varying(255) NOT NULL,
    idproducto uuid
);
    DROP TABLE public.tb_marcas;
       public         heap    admin5    false            �            1259    17541    tb_menus    TABLE     �   CREATE TABLE public.tb_menus (
    id_menu uuid NOT NULL,
    icono character varying(255) NOT NULL,
    menu_padre uuid,
    nombre character varying(255) NOT NULL,
    orden integer NOT NULL,
    url character varying(255) NOT NULL
);
    DROP TABLE public.tb_menus;
       public         heap    admin5    false            �            1259    17510    tb_procendencias    TABLE     �   CREATE TABLE public.tb_procendencias (
    id_procedencia uuid NOT NULL,
    procedencia character varying(255) NOT NULL,
    idproducto uuid
);
 $   DROP TABLE public.tb_procendencias;
       public         heap    admin5    false            �            1259    17515    tb_productos    TABLE     �  CREATE TABLE public.tb_productos (
    id_producto uuid NOT NULL,
    descripcion character varying(255) NOT NULL,
    nombre character varying(255) NOT NULL,
    peso double precision NOT NULL,
    precio_compra double precision NOT NULL,
    precio_unitario double precision NOT NULL,
    precio_venta double precision NOT NULL,
    stock integer NOT NULL,
    stockmin integer NOT NULL,
    iddetalleventa uuid,
    id_categoria uuid,
    id_marca uuid,
    id_procedencia uuid,
    id_proveedor uuid
);
     DROP TABLE public.tb_productos;
       public         heap    admin5    false            �            1259    17522    tb_proveedores    TABLE     :  CREATE TABLE public.tb_proveedores (
    id_proveedor uuid NOT NULL,
    direccion character varying(255) NOT NULL,
    dni character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    nombres character varying(255) NOT NULL,
    telefono character varying(255) NOT NULL,
    idproducto uuid
);
 "   DROP TABLE public.tb_proveedores;
       public         heap    admin5    false            �            1259    17529    tb_usuarios    TABLE     �   CREATE TABLE public.tb_usuarios (
    id_usuario uuid NOT NULL,
    nombre character varying(255) NOT NULL,
    clave character varying(255) NOT NULL,
    rol character varying(255) NOT NULL,
    usuario character varying(255) NOT NULL
);
    DROP TABLE public.tb_usuarios;
       public         heap    admin5    false            �            1259    17536 	   tb_ventas    TABLE     �   CREATE TABLE public.tb_ventas (
    id_venta uuid NOT NULL,
    id_detalle_venta uuid,
    fecha_venta character varying(255) NOT NULL
);
    DROP TABLE public.tb_ventas;
       public         heap    admin5    false            2          0    17483    tb_categorias 
   TABLE DATA           L   COPY public.tb_categorias (id_categoria, categoria, idproducto) FROM stdin;
    public          admin5    false    209   �D       3          0    17488    tb_clientes 
   TABLE DATA           m   COPY public.tb_clientes (id_cliente, apellido, direccion, dni, email, nombre, telefono, idventa) FROM stdin;
    public          admin5    false    210   �F       4          0    17495    tb_detalle_venta 
   TABLE DATA           p   COPY public.tb_detalle_venta (id_detalle_venta, cantidad, precio_unitario, id_usuario, id_producto) FROM stdin;
    public          admin5    false    211   NH       5          0    17500    tb_facturacion 
   TABLE DATA           I   COPY public.tb_facturacion (id_factu, facturacion, idventas) FROM stdin;
    public          admin5    false    212   kH       6          0    17505 	   tb_marcas 
   TABLE DATA           @   COPY public.tb_marcas (id_marca, marca, idproducto) FROM stdin;
    public          admin5    false    213   �H       <          0    17541    tb_menus 
   TABLE DATA           R   COPY public.tb_menus (id_menu, icono, menu_padre, nombre, orden, url) FROM stdin;
    public          admin5    false    219   �J       7          0    17510    tb_procendencias 
   TABLE DATA           S   COPY public.tb_procendencias (id_procedencia, procedencia, idproducto) FROM stdin;
    public          admin5    false    214   JL       8          0    17515    tb_productos 
   TABLE DATA           �   COPY public.tb_productos (id_producto, descripcion, nombre, peso, precio_compra, precio_unitario, precio_venta, stock, stockmin, iddetalleventa, id_categoria, id_marca, id_procedencia, id_proveedor) FROM stdin;
    public          admin5    false    215   }M       9          0    17522    tb_proveedores 
   TABLE DATA           l   COPY public.tb_proveedores (id_proveedor, direccion, dni, email, nombres, telefono, idproducto) FROM stdin;
    public          admin5    false    216   oR       :          0    17529    tb_usuarios 
   TABLE DATA           N   COPY public.tb_usuarios (id_usuario, nombre, clave, rol, usuario) FROM stdin;
    public          admin5    false    217   �S       ;          0    17536 	   tb_ventas 
   TABLE DATA           L   COPY public.tb_ventas (id_venta, id_detalle_venta, fecha_venta) FROM stdin;
    public          admin5    false    218   �T       �           2606    17487     tb_categorias tb_categorias_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.tb_categorias
    ADD CONSTRAINT tb_categorias_pkey PRIMARY KEY (id_categoria);
 J   ALTER TABLE ONLY public.tb_categorias DROP CONSTRAINT tb_categorias_pkey;
       public            admin5    false    209            �           2606    17494    tb_clientes tb_clientes_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tb_clientes
    ADD CONSTRAINT tb_clientes_pkey PRIMARY KEY (id_cliente);
 F   ALTER TABLE ONLY public.tb_clientes DROP CONSTRAINT tb_clientes_pkey;
       public            admin5    false    210            �           2606    17499 &   tb_detalle_venta tb_detalle_venta_pkey 
   CONSTRAINT     r   ALTER TABLE ONLY public.tb_detalle_venta
    ADD CONSTRAINT tb_detalle_venta_pkey PRIMARY KEY (id_detalle_venta);
 P   ALTER TABLE ONLY public.tb_detalle_venta DROP CONSTRAINT tb_detalle_venta_pkey;
       public            admin5    false    211            �           2606    17504 "   tb_facturacion tb_facturacion_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.tb_facturacion
    ADD CONSTRAINT tb_facturacion_pkey PRIMARY KEY (id_factu);
 L   ALTER TABLE ONLY public.tb_facturacion DROP CONSTRAINT tb_facturacion_pkey;
       public            admin5    false    212            �           2606    17509    tb_marcas tb_marcas_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tb_marcas
    ADD CONSTRAINT tb_marcas_pkey PRIMARY KEY (id_marca);
 B   ALTER TABLE ONLY public.tb_marcas DROP CONSTRAINT tb_marcas_pkey;
       public            admin5    false    213            �           2606    17547    tb_menus tb_menus_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.tb_menus
    ADD CONSTRAINT tb_menus_pkey PRIMARY KEY (id_menu);
 @   ALTER TABLE ONLY public.tb_menus DROP CONSTRAINT tb_menus_pkey;
       public            admin5    false    219            �           2606    17514 &   tb_procendencias tb_procendencias_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.tb_procendencias
    ADD CONSTRAINT tb_procendencias_pkey PRIMARY KEY (id_procedencia);
 P   ALTER TABLE ONLY public.tb_procendencias DROP CONSTRAINT tb_procendencias_pkey;
       public            admin5    false    214            �           2606    17521    tb_productos tb_productos_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.tb_productos
    ADD CONSTRAINT tb_productos_pkey PRIMARY KEY (id_producto);
 H   ALTER TABLE ONLY public.tb_productos DROP CONSTRAINT tb_productos_pkey;
       public            admin5    false    215            �           2606    17528 "   tb_proveedores tb_proveedores_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.tb_proveedores
    ADD CONSTRAINT tb_proveedores_pkey PRIMARY KEY (id_proveedor);
 L   ALTER TABLE ONLY public.tb_proveedores DROP CONSTRAINT tb_proveedores_pkey;
       public            admin5    false    216            �           2606    17535    tb_usuarios tb_usuarios_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.tb_usuarios
    ADD CONSTRAINT tb_usuarios_pkey PRIMARY KEY (id_usuario);
 F   ALTER TABLE ONLY public.tb_usuarios DROP CONSTRAINT tb_usuarios_pkey;
       public            admin5    false    217            �           2606    17540    tb_ventas tb_ventas_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tb_ventas
    ADD CONSTRAINT tb_ventas_pkey PRIMARY KEY (id_venta);
 B   ALTER TABLE ONLY public.tb_ventas DROP CONSTRAINT tb_ventas_pkey;
       public            admin5    false    218            �           2606    17573 ,   tb_procendencias fk4yb6ojiw3jjw8eh54xkwjmoc3    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_procendencias
    ADD CONSTRAINT fk4yb6ojiw3jjw8eh54xkwjmoc3 FOREIGN KEY (idproducto) REFERENCES public.tb_productos(id_producto);
 V   ALTER TABLE ONLY public.tb_procendencias DROP CONSTRAINT fk4yb6ojiw3jjw8eh54xkwjmoc3;
       public          admin5    false    215    3216    214            �           2606    17604 (   tb_productos fk54y9bojwwce1xl1dgsxfkllew    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_productos
    ADD CONSTRAINT fk54y9bojwwce1xl1dgsxfkllew FOREIGN KEY (id_procedencia) REFERENCES public.tb_procendencias(id_procedencia);
 R   ALTER TABLE ONLY public.tb_productos DROP CONSTRAINT fk54y9bojwwce1xl1dgsxfkllew;
       public          admin5    false    215    214    3214            �           2606    17594 (   tb_productos fk8pcohvsuotcmd1ygjkqpfs2ix    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_productos
    ADD CONSTRAINT fk8pcohvsuotcmd1ygjkqpfs2ix FOREIGN KEY (id_categoria) REFERENCES public.tb_categorias(id_categoria);
 R   ALTER TABLE ONLY public.tb_productos DROP CONSTRAINT fk8pcohvsuotcmd1ygjkqpfs2ix;
       public          admin5    false    209    215    3204            �           2606    17614 $   tb_ventas fkbyvgkaea60wxpkkl4xxnjf0w    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_ventas
    ADD CONSTRAINT fkbyvgkaea60wxpkkl4xxnjf0w FOREIGN KEY (id_detalle_venta) REFERENCES public.tb_detalle_venta(id_detalle_venta);
 N   ALTER TABLE ONLY public.tb_ventas DROP CONSTRAINT fkbyvgkaea60wxpkkl4xxnjf0w;
       public          admin5    false    218    3208    211            �           2606    17568 %   tb_marcas fkda1ixdwh2v4q5q9c612fhhts3    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_marcas
    ADD CONSTRAINT fkda1ixdwh2v4q5q9c612fhhts3 FOREIGN KEY (idproducto) REFERENCES public.tb_productos(id_producto);
 O   ALTER TABLE ONLY public.tb_marcas DROP CONSTRAINT fkda1ixdwh2v4q5q9c612fhhts3;
       public          admin5    false    213    3216    215            �           2606    17583 *   tb_proveedores fkdby2kem2ble7y86feh0i4xuvt    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_proveedores
    ADD CONSTRAINT fkdby2kem2ble7y86feh0i4xuvt FOREIGN KEY (idproducto) REFERENCES public.tb_productos(id_producto);
 T   ALTER TABLE ONLY public.tb_proveedores DROP CONSTRAINT fkdby2kem2ble7y86feh0i4xuvt;
       public          admin5    false    3216    216    215            �           2606    17563 *   tb_facturacion fkedi04u3psqvaf7s9fm5gssq0o    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_facturacion
    ADD CONSTRAINT fkedi04u3psqvaf7s9fm5gssq0o FOREIGN KEY (idventas) REFERENCES public.tb_ventas(id_venta);
 T   ALTER TABLE ONLY public.tb_facturacion DROP CONSTRAINT fkedi04u3psqvaf7s9fm5gssq0o;
       public          admin5    false    3222    218    212            �           2606    17599 (   tb_productos fkgebi81k8sljgr2sakmvg4my26    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_productos
    ADD CONSTRAINT fkgebi81k8sljgr2sakmvg4my26 FOREIGN KEY (id_marca) REFERENCES public.tb_marcas(id_marca);
 R   ALTER TABLE ONLY public.tb_productos DROP CONSTRAINT fkgebi81k8sljgr2sakmvg4my26;
       public          admin5    false    213    215    3212            �           2606    17578 (   tb_productos fkiu2bjlrw6jo3bm7pqy0xao8de    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_productos
    ADD CONSTRAINT fkiu2bjlrw6jo3bm7pqy0xao8de FOREIGN KEY (iddetalleventa) REFERENCES public.tb_detalle_venta(id_detalle_venta);
 R   ALTER TABLE ONLY public.tb_productos DROP CONSTRAINT fkiu2bjlrw6jo3bm7pqy0xao8de;
       public          admin5    false    215    211    3208            �           2606    17623 ,   tb_detalle_venta fkived4udo4hthemufo67lxesp3    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_detalle_venta
    ADD CONSTRAINT fkived4udo4hthemufo67lxesp3 FOREIGN KEY (id_producto) REFERENCES public.tb_usuarios(id_usuario);
 V   ALTER TABLE ONLY public.tb_detalle_venta DROP CONSTRAINT fkived4udo4hthemufo67lxesp3;
       public          admin5    false    217    211    3220            �           2606    17558 ,   tb_detalle_venta fkldk82pw3iiw2a4hf9emtqmxmg    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_detalle_venta
    ADD CONSTRAINT fkldk82pw3iiw2a4hf9emtqmxmg FOREIGN KEY (id_usuario) REFERENCES public.tb_usuarios(id_usuario);
 V   ALTER TABLE ONLY public.tb_detalle_venta DROP CONSTRAINT fkldk82pw3iiw2a4hf9emtqmxmg;
       public          admin5    false    3220    217    211            �           2606    17553 '   tb_clientes fkrpaualheqvcl1j5y9wf5kctb0    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_clientes
    ADD CONSTRAINT fkrpaualheqvcl1j5y9wf5kctb0 FOREIGN KEY (idventa) REFERENCES public.tb_ventas(id_venta);
 Q   ALTER TABLE ONLY public.tb_clientes DROP CONSTRAINT fkrpaualheqvcl1j5y9wf5kctb0;
       public          admin5    false    218    210    3222            �           2606    17548 )   tb_categorias fkt567nrk0ajwbdefhfebl811oj    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_categorias
    ADD CONSTRAINT fkt567nrk0ajwbdefhfebl811oj FOREIGN KEY (idproducto) REFERENCES public.tb_productos(id_producto);
 S   ALTER TABLE ONLY public.tb_categorias DROP CONSTRAINT fkt567nrk0ajwbdefhfebl811oj;
       public          admin5    false    209    215    3216            �           2606    17609 (   tb_productos fktfuipbfwejqrcl4e1j56enquh    FK CONSTRAINT     �   ALTER TABLE ONLY public.tb_productos
    ADD CONSTRAINT fktfuipbfwejqrcl4e1j56enquh FOREIGN KEY (id_proveedor) REFERENCES public.tb_proveedores(id_proveedor);
 R   ALTER TABLE ONLY public.tb_productos DROP CONSTRAINT fktfuipbfwejqrcl4e1j56enquh;
       public          admin5    false    3218    215    216            2   +  x�=�M�1���Sp�8?N��G#!B��8�#J���C��s1R�̬����=+�IS��H!I�P�"`����Q�7�D������P�����@�E@X�{�Ҍ����m�N���B��y [�Jq� ����zY��{8��i<�A�\��h��_y��{;�_���\=���*�)H����6rw����C,�s@�������:�z�s�w���6^"F��j�G���ՙ(f���磜.r�'%C�`8�ݹ��!�N�N����ŶE���[	�cާt@+�!� �p)�}��H_�]�s���ب!i`;䠖S��
�w�6	-��p7� �OI�3���sO�IB��~lr:?.�e=����)�0��L>:Hɳ@�fw�t�5�x��9��'���"��&�2JG)�����l���!B_�	�&6�+G�B�C
���������e[t��b��ou�g��ҩA3�;����^�����؞Η�m���r�@tݜd����Q��� ۶�m���.=RB�H<�M�H���U�J���i/��D��1��      3   `  x����N#1���S���'qn,{GH�O�T�I5S�x{��Ҟٱ���0dNc��5�BM]�#�*�W"�~��mn��l�@D*"Y�����~3m�ʾ����(�˳,ym*��g�y�t���-WХΌ�����=�.��m}|S�6̲g/p���E���V�d�9e����%�+p텖�/��jb�4��Hc9��s{�*�v�湩��%����-�~i/Re=�����S���1�x!�4���i�>h6k@I�2���Cfr�ƪ�U�e����]���Og��P3��D}�c�4:,5�<��i�;��+F�_�2���ȯ�5��#:�i���> �3�*      4      x������ � �      5   ]   x�ʹ�0 �:����wKA�i�
		�� �>�(�q��E�]34�*Z	�5���������,8}�e����� �[�����>y�_=�B      6   �  x�%��n[1�g�]X�E�c�����P�H��m�>}u��#�90�娠EpS��D0Kbw�)���~����%���̍�2: �,.�kx8��O�h.��٩����J6����ë��l;NJn�Wp�lq��#�&�J�?^�_m��Qd����-/Y���Uj��h���s�o�m�5H��\`��M0�L-���9�p���f/;�#����Z�au�h�9'����ٮ;�*&�k��D�����Ǣ)q	���v��v��HqJ�P
5��KCK�V���&ːp����jOBdN��t���	�L����b8�������c�I'0���ML�WMf5���y�}�-��2sI�S��w���1K�z���(y��u��"A�y�Tk�^÷����/���z�\'(-<\���;h�ٱr3	�/��ӗ���į��      <   �  x�E�͎� ���.����7�%9��i�Yk'������悪$����ܲ�"аE�%[��*��K�!�I5��ުl���z��ؕ5���T:��V|�L5�ǂ�+�1ɋ�� �l�	�����P]��֥!�(���}s��
�1:��hN
̷zR��fY���.���'B
"�]P� ���]������c����
L�����iWI]�C��Y1Bϓ���
�5��V��s�~n�S��[�Q]���vA�0O�c|�(�@��` ��N�Bϙ�e���\�m�B���t�"si}�O.'���r���T�A��6�ߧ5���-���$���Q��2��]�q�������V~�Q��N���Gp8��Ce�$� ,F6uD��|qX�,|֚����oZ�IA��      7   #  x�%��NA��˻y��.C:
����xm/�.(����vf���F�2�4�d�Тf��9Ռu�/�����WY�χ&��V!RfH���bnEzh�
����^|W�(��nI*B/c�Y�wZ�^��v�b�)C�fr!`�H��hU��<��{����AYђ 5d�>��qx,͖��ݷ�u����)�D`.2P����R�P�)�./~����X�@�!g|�0Y��c��)��=۳T� S�ّ0�mM��:e�埤��ObBHn8�S�*�R3Z��������p�w�q      8   �  x��V͎[5^;Oqw�Ne��w9tf�bZ�v*���>�"M�*I�X����PQ!��@Qr�k'����1�v�4W
}d�&��~��[g^n����,C��w��;�Y��|��$�˃���[�w��������n~�2�8�g�Ɵ��h޾0��S�L)�H�%i���MͻPL�)jrB^6�0��w�}�ƥpŸ�{-$=
?�t:���ک��0���3�\0��I�L���mc�\6�֜X�z��4T��{+9Wm�$�����-޺���z��`�~��ۏ�!-/��ao��������i���?�ObI9��Ɇ/�Ŋ+��wuR�!Q-Ӓe��&�|�BS�� �RK�1��ڣhk�dIC�J��ˎ�r$����Mq�c�dh�EJ��3�(�S�b�M�u���6_�I�&���뛻��h���ٔgM=���M��C�f=�ͣUc�k�5S��(�t*36�2Z�|�r���-*�zJ�iu�%(_���<�������gw����t8G@�nO����B忬�xneP���԰C�}��� ��2MgN�j�ĵ9
1y������s������Ӂ����S��Ks�3bS��X'Ra�=���������nƥe������Y� �c�=��ʃ�N�j~8�0�fvl���z��2XBQKW�Q�ƹ�c&�:�$�9���-�����$��hʠl P���+a �F�e�$P+
F�,p߬B��F���r�vY~���}u\R�p��AN�~�;D��d9dw|�=n��J��}��������9,lх�@��x�"�G����b;U�$kEK.�SL�/�;����z��e9m�lw�APbk�����3�,��9�������(��|n�N�S�5�E�ˈ`����TS��ř�m�s5�t� �Y�M���_��f�g*�lkL/aV�1��b�N�ś�/�/�e����՛�_�^��_������mR�n�P^���+D�Y�e��\����w�$�b���
㕴A=�X_����G%sX�Z����5z᾽������ի�/�3v���'�"?�"̫�Z�eR�gNph��j�QS��]�jW�9���b�2�%��u(J��j (3O_#lP7Y�yuKL�',��Ǚ�yY�i����{��c�1�q�<8*�U���Ӥ4�]\�a��= �I��5���Z#Ny��B��?6��'���O�Ӂ�      9   }  x�}��n�0�5��|�8�v��l��PU#��l�߇r�����<����[)�Gm,7��2<�Rz�]2�p��X���Cg�a�(e��l�^k��i^�=�u?;����TBh�,{��CS��s���&p����)-Z�Y�ZDx`��J#k���6���� p=n�$����`!���)S�i��w��&zV*�V߰�rBP��?�0�S=��a�b��^�w��Pz�=��(w)nzn38.���X����]0n�l������ZG��=wX/��w����Mޢ5ME���̩�m5s����*�s������q�ǎu��T�9��J�{�>Qڤ����G�!���ģei�s=�X �ɾ�w����\      :   �   x�e̻
1��:y
_`$�L�M)h'���L.��U��U�?��0'[�!8���	d����{o�S�Ͳ_m����8��u�z��QG/[`p�����"$+�.4	I�o�eֳp۫6���)���&]�:�&�@.<����Hq��������n��~ 8�B�      ;   x   x�u˻�0�ښ"����L�Cd7��?B���݅>�,[0%̆&�g�2��?�P40�D/�#�h+�fD�+a�z�;N�?W��ܒ\m.q��fب�0�ڥtY�<����R���)R     