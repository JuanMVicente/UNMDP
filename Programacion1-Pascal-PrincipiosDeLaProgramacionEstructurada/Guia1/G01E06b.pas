program G01E06b;
var
  N: integer;
begin
  writeln('Escribe nro N mayor a 999: ');
  readln(N);
  N := (N div 100) mod 10;
  writeln(N);
  readln();
end.

