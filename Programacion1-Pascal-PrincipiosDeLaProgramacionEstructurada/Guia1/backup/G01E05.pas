program G01E05;
var
  Ancho,Largo, sup, baldosas: real;
begin
  writeln('Escriba Ancho a embadolsar');
  readln(Ancho);
  writeln('Escriba Largo a embadolsar');
  readln(Largo);
  sup := Ancho * Largo / 300 * 100;
  writeln('La superficie a cubrir es del ',sup:4:2,' %.');
  baldosas := (Ancho div 0.25 + 1 ) * (Largo div 0.25 +1);
  writeln('De comprar ', baldosas,' baldosas.');
  readln();
end.

