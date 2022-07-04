program G03E18;
const
  Desc=0.10;
var
  Nombre, Max_Nombre:String[10];
  i, Max_Cant, Cont_Desc, Cantidad_Articulos, Cont_Cliente: integer;
  Precio,Venta, Descuento: Real;
  Tiene_Descuento, espacio_txt: Char;
  Arch: text;
 begin
  Assign(Arch,'G03E18.txt');
  Reset(Arch);
  Read(Arch, Nombre);
  Max_Cant:=0;
  Cont_Cliente:=0;
  While Not eof(Arch) do
        Begin
          Readln(Arch, Cantidad_Articulos);
          Descuento:=0;
          Cont_Desc:=0;
          Venta:=0;
          For i:=1 to Cantidad_Articulos do
              Begin
                Readln(Arch, Precio);
                Readln(Arch, Tiene_Descuento);
                Venta:= Venta + Precio;
                If upcase(Tiene_Descuento)='S' then
                   Begin
                     Descuento:= Descuento + Precio*Desc;
                     Cont_Desc:= Cont_Desc+1;
                   end;
               End;
          Writeln(Nombre, ': Monto Total sin descuento es ',Venta:10:2,', se descuenta ',Descuento:10:2,', precio final es ',(Venta-Descuento):10:2);
          if Cont_Desc>Max_Cant then
             Begin
                Max_Cant:=Cont_Desc;
                Max_Nombre:=Nombre;
             end;
          if Cont_Desc=Cantidad_Articulos then
             Cont_Cliente:= Cont_Cliente + 1;
          Read(Arch, Nombre);
         end;
  Close(Arch);
  Writeln('La mayor cantidad de articulos en oferta la compro: ',Max_Nombre);
  Writeln('Los clientes que compraron solo articulos en oferta fueron ', Cont_Cliente);
  Readln();
end.



