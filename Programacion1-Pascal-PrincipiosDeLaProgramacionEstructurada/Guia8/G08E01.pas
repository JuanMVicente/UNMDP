program G08E01;

function PotenciaPositiva(X,n: integer): integer;
begin
 if N=1 then
   PotenciaPositiva:=X
 else
   PotenciaPositiva:=X*PotenciaPositiva(X,N-1);
 end;

function Potencia(X,N: integer): real;
begin
 if N>0 then
     Potencia:=X*Potencia(X,N-1)
 else
   if N=0 then
     Potencia:=1
   else
     Potencia:=(1/X)*Potencia(X, N+1);
end;

var
  A,N:integer;
begin
  Write('Escriba un Nro: '); Readln(A);
  Write('Potencia: '); Readln(N);
  Writeln(Potencia(A,N):10:4);
  Readln();
end.

