program G01E01b;
var
  Litros_Blanco, Litros_Negra: real;
begin
  Writeln('Ingrese cantidad de litros de pintura negra: ');
  Readln(Litros_Negra);
  Litros_Blanco := Litros_Negra * 4.5 / 9.5;
  Writeln('Debe comprar de pintura negra ', Litros_Blanco:4:2,' lts para hacer gris mara.');
  readln();
end.

