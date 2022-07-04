program G01E03;
Var
 H: integer;
 Sueldo: real;
begin
  writeln('Cantidad de horas trabajadas: ');
  readln(H);
  Sueldo:= H*200*0.84;
  writeln('El sueldo neto es: $ ', Sueldo, '.');
  readln();
end.

