program G03E07;
var
  N1,N2,N3,i,j,S: byte;
  Name: string;
  Prom:real;
begin
  i:=0;j:=0;
  write('Nombre: ');readln(Name);
  while Name<>'' do
  begin
    writeln('Ingrese 3 Notas: ');readln(N1,N2,N3);
    prom := (N1+N2+N3)/3;
    i:=i+1;
    if prom>=4 then
       begin
         writeln('Aprobado y su promedio es: ', prom:2:2);
         j:=j+1;
       end
    else writeln('Desaprobado y su promedio es: ', prom:2:2);
    write('Nombre: ');readln(Name);
  end;
  writeln('El porcentaje de alumnos desaprobados es ', j/i*100:3:2);
  readln();
end.

