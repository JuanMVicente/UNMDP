program G08E05;
type
  TV = array [1..10] of integer;

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

Function SumaVector(V:TV;N:byte): integer;
begin
  if N=1 then
    SumaVector:=V[1]
  else
    SumaVector:=V[N] + SumaVector(V,N-1);
end;

Procedure MostrarVector(V:TV;N:byte);
begin
  if N=1 then
    Writeln(1,': ',V[1])
  else
    begin
      MostrarVector(V,N-1);
      Writeln(N,': ',V[N]);
    end;
end;

Procedure MostrarInverso(V:TV;N:byte);
begin
  if N=1 then
    Writeln(1,': ',V[1])
  else
    begin
      Writeln(N,': ',V[N]);
      MostrarInverso(V,N-1);
    end;
end;

Function Maximo(V:TV;N:byte): integer;
var
  max:integer;
begin
  if N=1 then
      Maximo:=V[1]
  else
    begin
      Max:=Maximo(V,N-1);
      if V[N]>Max then
        Maximo:=V[N]
      else
        Maximo:=Max;
    end;
end;

Function Promedio(V:TV;N,M:byte): real;
begin
  if N=1 then
    Promedio:=V[N]/M
  else
    Promedio:=V[N]/M + Promedio(V,N-1,M);
end;

var
  Vector:TV;
  N:byte;
begin
  LeeVector(Vector,N);
  Writeln('Suma: ', SumaVector(Vector,N));
  Writeln('Vector:');
  MostrarVector(Vector,N);
  Writeln('Vector invertido:');
  MostrarInverso(Vector,N);
  Writeln('Maximo: ', Maximo(Vector,N));
  Writeln('Promedio: ', Promedio(Vector,N,N):5:2);
  Readln();
end.

