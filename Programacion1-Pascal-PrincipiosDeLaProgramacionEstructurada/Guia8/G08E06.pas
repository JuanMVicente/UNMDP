program G08E06;
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

function EncuentraXlineal(V:TV;N:byte;X:Real):byte;
begin
  if N>1 then
      If V[N]=X then
        EncuentraXlineal:=N
      else
        EncuentraXlineal:=EncuentraXlineal(V,N-1,X)
  else
      If V[N]=X then
        EncuentraXlineal:=N
      else
        EncuentraXlineal:=0;
end;




Function BusquedaBinariaRecursiva(V:TV;M,N:byte;x:real):byte;
Var
 Medio: byte;
Begin
  if M>N then
     BusquedaBinariaRecursiva:=0
  else
    begin
      Medio:=(M + N) DIV 2;
      if x=V[Medio] then
      BusquedaBinariaRecursiva:=Medio
      else
        if x<V[Medio] then
          BusquedaBinariaRecursiva:=BusquedaBinariaRecursiva(V,M,Medio-1,X)
        else
          BusquedaBinariaRecursiva:=BusquedaBinariaRecursiva(V,Medio+1,N,X);
    end;
End;


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
  Writeln('Esta en la posicion: ',BusquedaBinariaRecursiva(Vector,1,N,X));
  Readln();
end.

