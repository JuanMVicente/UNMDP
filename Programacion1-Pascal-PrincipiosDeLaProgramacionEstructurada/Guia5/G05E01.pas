program G05E01;
Type
 TV= array[1..12] of byte;
procedure LeeVector(Var A:TV; Var N:byte);
var
  i:byte;
Begin
  Write('Cantidad de datos: ');
  Readln(N);
  For i:=1 to N do
    Begin
      Write('Ingrese el elemento de ',i,': ');
      Readln(A[i]);
    end;
end;
Procedure EscribeVector(A:TV; N:byte);
var
  i:byte;
Begin
  For i:=1 to N do
      Write(A[i],' - ');
end;
function SumaVector(A:TV;N:byte):integer;
var
  i:byte;
Begin
SumaVector:=0;
For i:=1 to N do
    SumaVector:= SumaVector + A[i];
end;
function Maximo(A:TV;N:byte):byte;
var
  i:byte;
Begin
Maximo:=A[1];
For i:=2 to N do
    if Maximo<A[i] then
       Maximo:=A[i];
end;
function Minimo(A:TV;N:byte):byte;
var
  i:byte;
Begin
Minimo:=A[1];
For i:=2 to N do
    if Minimo>A[i] then
       Minimo:=A[i];
end;
Procedure CambiaVector(A:TV; var B:TV; N:byte);
var
  i:byte;
Begin
  For i:=1 to N do
      B[i]:=A[N+1-i];
end;

var
  A,B:TV;
  N: byte;
begin
  LeeVector(A,N);
  Writeln('Suma: ',SumaVector(A,N),' - Min: ',Minimo(A,N),' - Max: ',Maximo(A,N));
  CambiaVector(A,B,N);
  Write('El vector A es: ');
  EscribeVector(A,N);
  Writeln();
  Write('El vector inverso es: ');
  EscribeVector(B,N);
  Readln();

end.

