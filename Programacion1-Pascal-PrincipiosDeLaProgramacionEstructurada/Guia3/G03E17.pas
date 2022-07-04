program G03E17;
const
  Desc=0.10;
var
  Nombre, Max_Nombre:String[10];
  Cantidad_Articulos, i, Max_Cant, Cont_Desc, Cont_Cliente: byte;
  Precio,Venta, Descuento: Real;
  Tiene_Descuento: Char;
 begin
  Write('Nombre del cliente ( " ***** " indica fin de datos ): ');
  Readln(Nombre);
  Max_Cant:=0;
  Cont_Cliente:=0;
  While Nombre<>'*****' do
        Begin
          Write('Cantidad de Articulos Comprados: ');
          Readln(Cantidad_Articulos);
          Descuento:=0;
          Cont_Desc:=0;
          Venta:=0;
          For i:=1 to Cantidad_Articulos do
              Begin
                Write('Precio base ');
                Readln(Precio);
                Write('Tiene Descuento? (S/N) ');
                Readln(Tiene_Descuento);
                Venta:= Venta + Precio;
                If upcase(Tiene_Descuento)='S' then
                   Begin
                     Descuento:= Descuento + Precio*Desc;
                     Cont_Desc:= Cont_Desc+1;
                   end;
              End;
          Writeln('Monto Total sin descuento es ',Venta:10:2,', se descuenta ',Descuento:10:2,', precio final es ',(Venta-Descuento):10:2);
          if Cont_Desc>Max_Cant then
             Begin
                Max_Cant:=Cont_Desc;
                Max_Nombre:=Nombre;
             end;
          if Cont_Desc=Cantidad_Articulos then
             Cont_Cliente:= Cont_Cliente + 1;
          Write('Nombre del cliente ( " ***** " indica fin de datos ): ');
          Readln(Nombre);
         end;
  Writeln('La mayor cantidad de articulos en oferta la compro: ',Max_Nombre);
  Writeln('Los clientes que compraron solo articulos en oferta fueron ', Cont_Cliente);
  Readln();
end.



