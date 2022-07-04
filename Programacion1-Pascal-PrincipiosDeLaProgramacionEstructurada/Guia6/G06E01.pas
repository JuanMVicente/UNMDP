program G06E01;
type
  TV = array[1..20] of byte;
  TM = array[1..20,1..20] of byte;

Procedure LeeArchivo(var Matriz:TM; var N,M:byte);
var
  i,j:byte;
  Arch:text;
begin
  Assign(Arch, 'G06E01.txt');
  Reset(Arch);
  Read(Arch,N);Read(Arch,M);
  for i:=1 to N do
    for j:=1 to M do
      Read(Arch,Matriz[i,j]);
  Close(Arch);
end;

Procedure MaximoFila(Matriz:TM; N,M:Byte; var MaxFila:TV);
var
  i,j:byte;
begin
  For i:=1 to N do
    begin
      MaxFila[i]:=Matriz[i,1];
      for j:=2 to M do
        if Matriz[i,j]>MaxFila[i] then
          MaxFila[i]:=Matriz[i,j];
    end;
end;
Procedure SumaImpares(Matriz:TM; N,M:Byte; var SumImp:TV; var O:byte);
var
i,j,Suma:byte;
begin
  O:=0;
  For j:=1 to M do
    begin
      Suma:=0;
      for i:=1 to N do
        if Matriz[i,j] mod 2 = 1 then
          Suma:=Suma+Matriz[i,j];
      If Suma<>0 then
        begin
          O:=O+1;
          SumImp[O]:=Suma;
        end;
    end;
end;
Function PromColumna(Matriz:TM; N,P:Byte): real;
var
  i:byte;
  prom:real;
begin
  Prom:=0;
  For i:=1 to N do
    Prom:= Prom+Matriz[i,P];
  PromColumna:=Prom/N;
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
    write('-',Vector[i],'-');
end;

var
  Matriz:TM;
  MaxFila,SumImp:TV;
  N,M,O,P:byte;
begin
  LeeArchivo(Matriz,N,M);
  MuestraMatriz(Matriz,N,M);

  MaximoFila(Matriz,N,M,MaxFila);
  MuestraVector(MaxFila,N);
  writeln();
  SumaImpares(Matriz,N,M,SumImp,O);
  MuestraVector(SumImp,O);
  writeln();
  Write('Elija una columna: ');
  Readln(P);
  Writeln('El Promedio de esa Columna es: ',PromColumna(Matriz,N,P):8:2);

  Readln();
end.

