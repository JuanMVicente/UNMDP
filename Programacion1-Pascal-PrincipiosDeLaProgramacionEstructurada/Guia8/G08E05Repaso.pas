program G08E05Repaso;
type
  TV = array [1..10] of integer;

Procedure LeeVector(var A:TV;var N:byte);
var
  i:byte;
begin
  write('Cuantos Nros: ');Readln(N);
  for i:=1 to N do
    begin
      write(i:2,': ');
      Readln(A[i]);
    end;
end;

Function SumaVector(A:TV;N:byte):integer;
begin
  if N=1 then
    SumaVector:= A[1]
  else
    SumaVector:= A[N] + SumaVector(A,N-1);
end;

Procedure MostrarVector(A:TV;i:byte);
begin
  if i=1 then
    Writeln(' 1: ',A[1]:3)
  else
    begin
      MostrarVector(A,i-1);
      Writeln(' ',i,': ',A[i]:3);
    end;
end;

Procedure MostrarInverso(A:TV;i:byte);
begin
  if i=1 then
    Writeln(' 1: ',A[1]:3)
  else
    begin
      Writeln(' ',i,': ',A[i]:3);
      MostrarInverso(A,i-1);
    end;
end;

Function Maximo(A:TV;i:byte):integer;
var
  Aux:integer;
begin
  if i=1 then
      Maximo:=1
  else
    begin
      Aux:=Maximo(A,i-1);
      If A[Aux]<A[i] then
        Maximo:=i
      else
        Maximo:=Aux;
    end;
end;

Function Promedio(A:TV;i,N:byte):real;
begin
  if i=1 then
    Promedio:=A[1]/N
  else
    Promedio:=A[i]/N + Promedio(A,i-1,N);
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
  Writeln('Maximo: ', Vector[Maximo(Vector,N)]);
  Writeln('Promedio: ', Promedio(Vector,N,N):5:2);
  Readln();
end.

