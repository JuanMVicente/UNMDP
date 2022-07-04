program G05E03;
Type
 TV = array[1..50] of integer;
Procedure Vector(var V:TV; var N: byte);
var
  Num:integer;
  Arch:text;
begin
  Assign(Arch, 'G05E02.txt');
  Reset(Arch);
  N:=0;
    While not eof(Arch) do
      Begin
        Readln(Arch, Num);
        N:=N+1;
        V[N]:=Num;
      end;
  close(Arch);
end;
Procedure EscribeVector(A:TV;N:byte);
var
  i:byte;
Begin
  For i:=1 to N do
    Write('-',A[i],'-');
end;
Procedure Cambiax0(var V:TV; N:byte; M:integer);
var
  i:byte;
Begin
  For i:=1 to N do
    If V[i]=M then V[i]:=0;
end;
var
  Arch:text;
  V:TV;
  N,M:byte;
begin
  Vector(V,N);
  write('Vector: ');
  EscribeVector(V,N);
  write('Nro que desea Cambiar: ');
  Readln(M);
  Cambiax0(V,N,M);
  writeln();
  write('Vector: ');
  EscribeVector(V,N);
  readln();
end.

