program G08E06Repaso;
type
  TV = array [1..10] of real;

Procedure LeeVector(var V:TV; var N:byte);
var
  i:byte;
begin
  Write('Cuantos nros tiene el vector: ');Readln(N);
  For i:=1 to N do
    Begin
      write('Ingrese Nro: ');
      readln(V[i]);
    end;
end;

Procedure MostrarVector(V:TV;N:byte);
begin
  if N=1 then
    Writeln(N,': ',V[N]:5:2)
  else
    begin
      MostrarVector(V,N-1);
      Writeln(N,': ',V[N]:5:2);
    end;
end;

Function EncuentraXlineal(A:TV;i:byte;X:real):byte;
Begin
  if i=1 then
    If A[1]=X then
      EncuentraXlineal:=1
    else
      EncuentraXlineal:=0
  else
    begin
      if A[i]=X then
        EncuentraXlineal:=i
      else
        EncuentraXlineal:=EncuentraXlineal(A,i-1,X);
    end;
end;

Function BusquedaXBinaria(A:TV; Pri, Ult:byte; X:real):byte;
Var
  Aux:byte;
Begin
  Aux:=pri + (ult - pri) div 2;
  if A[Aux] = X then
    BusquedaXBinaria:= Aux
  else
    if A[Aux] > X then
      BusquedaXBinaria:=BusquedaXBinaria(A,Pri,Aux-1,X)
    else
      BusquedaXBinaria:=BusquedaXBinaria(A,Aux+1,Ult,X);
end;



var
  Vector:TV;
  N:byte;
  X:Real;
begin
  LeeVector(Vector,N);
  Writeln('Vector:');
  MostrarVector(Vector,N);
  Write('Que Nro desea buscar: '); Readln(X);
  Writeln('Esta en la posicion: ',EncuentraXlineal(Vector,N,X));
  Writeln('Esta en la posicion: ',BusquedaXBinaria(Vector,1,N,X));
  Readln();
end.

