program G01E01a;
var
  Litros_Blanca, Litros_Negra: real;
begin
  Writeln('Ingrese cantidad de litros de pintura blanca: ');
  Readln(Litros_Blanca);
  Litros_Negra := Litros_Blanca * 9.5 / 4.5;
  Writeln('Debe comprar de pintura negra ', Litros_Negra:4:2,' lts para hacer gris mara.');
  Readln();
end.

