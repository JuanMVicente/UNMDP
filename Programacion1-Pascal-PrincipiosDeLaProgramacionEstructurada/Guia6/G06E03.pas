program G06E03;
type
  TM = array[1..20,1..20] of byte;

Procedure LeeArchivo(var Matriz:TM; var N,M:byte);
var
  i,j:byte;
  Arch:text;
begin
  Assign(Arch, 'G06E03.txt');
  Reset(Arch);
  Readln(Arch,M);
  N:=0;
  i:=0;
  While not eof(Arch) do
    begin
      i:=N+1;
      For j:=1 to M do
        Read(Arch,Matriz[i,j]);
      If Matriz[i,M] mod Matriz[i,1] = 0 then
        N:=N+1;
    end;
  Close(Arch);
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

var
  Matriz:TM;
  N,M:byte;
begin
  LeeArchivo(Matriz,N,M);
  Writeln('N: ',N);
  Writeln('M: ',M);
  MuestraMatriz(Matriz,N,M);
  Readln();
end.

