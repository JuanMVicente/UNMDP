program G06E06;
type
  TM = array[1..25,1..25] of byte;

Procedure GeneraMatriz(var CM:TM; N:byte);
var
  i,j,k:byte;
begin
  i:=1;
  j:=N div 2 +1;
  CM[i,j]:=1;
  For k:=2 to sqr(N) do
    Begin
      if (k-1) mod N <> 0 then
        begin
          if j<N then
            j:=j+1
          else
            j:=1;
          if i>1 then
            i:=i-1
          else
            i:=N;
        end
      else
        i:=i+1;
      CM[i,j]:=k;
    end
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
  CuadradoMagico:TM;
  N:byte;
begin
  Write('Orden de la matriz: ');Readln(N);
  GeneraMatriz(CuadradoMagico,N);
  MuestraMatriz(CuadradoMagico,N,N);
  Readln();
end.

