program G01E02;
var
  K: integer;
begin
  writeln('Ingrese numero natural: ');
  readln(K);
  K := 1 + 3 * (K-1);
  writeln('El valor k-esimo es ', K);
  readln();
end.

