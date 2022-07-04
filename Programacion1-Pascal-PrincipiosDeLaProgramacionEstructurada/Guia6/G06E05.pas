program G06E05;
type
  TM = array[1..20,1..20] of real;
  TV = array[1..20] of integer;

Procedure LeeArchivo(var Clientes:TV;var Compras:TM;var N,M:byte);
var
  i,j,k:byte;
  Cliente:integer;
  Arch:text;
  Num:Real;
begin
  Assign(Arch, 'G06E05.txt');
  Reset(Arch);
  M:=4;
  N:=1;
  Read(Arch,Clientes[N]);
  Read(Arch,k);
  For j:=1 to M do
      if j=k then
        Read(Arch, Compras[N,k])
      else
        Compras[N,j]:=0;
  While Not eof(Arch) do
    begin
      i:=0;
      Read(Arch,Cliente);
      Repeat
        i:=i+1;
      until (i>N) or (Cliente=Clientes[i]);
      if i>N then
        Begin
          N:=N+1;
          Clientes[N]:= Cliente;
          Read(Arch,k);
          For j:=1 to M do
            if j=k then
              Read(Arch, Compras[N,k])
            else
              Compras[N,j]:=0;
        end
      else
        Begin
          Read(Arch,k);
          Read(Arch,Num);
          Compras[i,k]:=Compras[i,k]+Num;
        end;
    end;
end;
Procedure ComparaGastos(Compras:TM;Clientes:TV;N:Byte);
var
  i:byte;
begin
  Writeln('Quienes gastan mas en Supermercado que en Indumentaria son: ');
  For i:=1 to N do
    if Compras[i,1]>Compras[i,3] then
      Writeln(Clientes[i]);
end;
Function MasGasto(Compras:TM;Clientes:TV;N,M:byte): integer;
var
  i,j:byte;
  Max,Total:Real;
begin
  Max:=0;
  For j:=1 to M do
    Max:=Compras[1,j]+Max;
  MasGasto:=Clientes[1];
  For i:=2 to N do
    Begin
      Total:=0;
      For j:=1 to M do
        Total:=Total+Compras[i,j];
      If Total>Max then
        Begin
          MasGasto:=Clientes[i];
          Max:=Total;
        end;
    end;
end;
Function Compra0(Compras:TM;N,M:byte): byte;
var
  i,j:byte;
begin
  Compra0:=0;
  For i:=1 to N do
    Begin
      j:=1;
      while (j<=M) and (Compras[i,j]<>0) do
        j:=j+1;
      if j<=M then
        Compra0:=Compra0+1;
    end;
end;


Procedure MuestraMatriz(Matriz:TM; N,M:byte);
var
  i,j:byte;
begin
  for i:=1 to N do
    begin
      for j:=1 to M do
        write('-',Matriz[i,j]:6:2,'-');
      Writeln();
    end;
end;
Procedure MuestraVector(Vector:TV; N:byte);
var
  i:byte;
begin
  for i:=1 to N do
    write('-',Vector[i]);
end;

var
  Compras:TM;
  Clientes:TV;
  N,M:byte;
begin
  LeeArchivo(Clientes,Compras,N,M);
  MuestraVector(Clientes,N);
  writeln();
  MuestraMatriz(Compras,N,M);
  ComparaGastos(Compras,Clientes,N);
  Writeln('El cliente que mas gasto fue: ', MasGasto(Compras,Clientes,N,M));
  Writeln('La cantidad de clientes sin gastos en algun rubro es: ', Compra0(Compras,N,M));
  Readln();
end.

