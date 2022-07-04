program G03E11b;
var
  Arch: text;
  N1,N2,N3,i,j,S: byte;
  Nombre: string[15];
  Prom:real;
begin
  i:=0;j:=0;
  Assign( Arch, 'G03E11b.TXT' );
  Reset ( Arch );
  while not eof(Arch) do
        begin
        readln(Arch,Nombre,N1,N2,N3);
        prom := (N1+N2+N3)/3;
        i:=i+1;
        if prom>=4 then
           begin
            writeln(Nombre, ' usted esta aprobado y su promedio es: ', prom:6:2);
            j:=j+1;
           end
        else writeln(Nombre, ' usted esta desaprobado y su promedio es: ', prom:6:2);
        end;
  writeln('El porcentaje de alumnos aprobados es ', j/i*100:3:2);
  close(Arch);
  readln();
end.

