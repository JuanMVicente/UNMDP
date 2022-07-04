program G05E04;
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
Procedure CompactaVector(A:TV; var B:TV; N:byte; var M:byte);
var
  i,j:byte;
Begin
  j:=0;
  For i:=1 to N do
      if A[i]<>0 then
        Begin
          j:= j+1;
          B[j]:=A[i];
        end;
  M:=j;
end;
var
  Arch:text;
  A,B:TV;
  N,M:byte;
begin
  Vector(A,N);
  write('Vector: ');
  EscribeVector(A,N);
  CompactaVector(A,B,N,M);
  writeln();
  write('Vector: ');
  EscribeVector(B,M);
  readln();
end.

