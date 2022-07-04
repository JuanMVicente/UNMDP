program G08E01Repaso;

function PotenciaPos(A,N:integer):integer;
begin
  if N=1 then
    PotenciaPos:=A
  else
      PotenciaPos:= A * PotenciaPos(A,N-1);
end;

function Potencia(A,N:integer):real;
begin
  if N=0 then
    Potencia:=1
  else
    if N>0 then
      Potencia:= A * Potencia(A,N-1)
    else
      Potencia:= 1/A * Potencia(A,N+1);
end;


var
  A,N:integer;
begin
  Write('Escriba un Nro: '); Readln(A);
  Write('Potencia: '); Readln(N);
  Writeln(Potencia(A,N):10:4);
  Readln();
end.

