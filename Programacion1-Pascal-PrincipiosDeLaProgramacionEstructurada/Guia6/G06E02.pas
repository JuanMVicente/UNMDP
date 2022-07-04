program G06E02;
type
  ST20 = string[20];
  TV = array[1..20] of ST20;
  TM = array[1..20,1..20] of byte;

Procedure LeeArchivo(var Nombres:TV; var Notas:TM; var N,M:byte);
var
  j:byte;
  Arch:text;
  Nombre:ST20;
  Car:Char;
begin
  Assign(Arch, 'G06E02.txt');
  Reset(Arch);
  Read(Arch,M);
  N:=0;
  While not eof(Arch) do
    begin
      N:=N+1;
      Nombre:='';
      Read(Arch,Car);
      While Car<>' ' do
        begin
          Nombre:=Nombre+Car;
          Read(Arch,Car);
        end;
      Nombres[N]:=Nombre;
      For j:=1 to M do
        Read(Arch, Notas[N,j]);
    end;
  Close(Arch);
end;

Procedure ListadoAprobados(Mat:TM; V:TV; N,M:byte);
var
  j,i:byte;
begin
  For j:=1 to N do
    begin
      i:=1;
      while (Mat[j,i]>=5) and (i<4) do
        i:=i+1;
      if i=4 then
        Write(V[j]);
    end;
end;

Procedure Situacion(Mat:TM; V:TV; N,M:byte;var Promocionan:TV; var O:byte);
var
  j,i:byte;
  prom:real;
begin
  O:=0;
  For i:=1 to N do
    Begin
      prom:=0;
      For j:=1 to M do
          prom:=prom+Mat[i,j];
      prom:=prom/M;
      If Prom>=7 then
        Begin
          O:=O+1;
          Promocionan[O]:=V[i];
          Writeln(V[i],' Promociona.');
        end
      Else
        If (Prom>=5) and (Mat[i,3]>=5) then
          Writeln(V[i],' Habilitado.')
        Else
          Writeln(V[i],' Desaprobado.');
    end;
end;

Procedure MuestraMatriz(Matriz:TM; N,M:byte);
var
  i,j:byte;
begin
  for i:=1 to N do
    begin
      for j:=1 to M do
        write('-',Matriz[i,j],'-');
      Writeln();
    end;
end;
Procedure MuestraVector(Vector:TV; N:byte);
var
  i:byte;
begin
  for i:=1 to N do
    write(Vector[i]);
end;

var
  Notas:TM;
  Nombres,Promocionan:TV;
  N,M,O:byte;
begin
  LeeArchivo(Nombres,Notas,N,M);
  MuestraVector(Nombres,N);
  writeln();
  MuestraMatriz(Notas,N,M);
  ListadoAprobados(Notas,Nombres,N,M);
  Situacion(Notas,Nombres,N,M,Promocionan,O);
  MuestraVector(Promocionan,O);
  Readln();
end.

