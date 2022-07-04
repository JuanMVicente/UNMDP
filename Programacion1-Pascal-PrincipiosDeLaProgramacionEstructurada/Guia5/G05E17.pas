program G05E17;
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
  Readln(Arch, Num);
    While not eof(Arch) do
      Begin
        N:=N+1;
        V[N]:=Num;
        Readln(Arch, Num);
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
Procedure CompactaVector(var A:TV; var N:byte);
var
  i,j:byte;
Begin
  For i:=1 to N do
        if A[i]=0 then
          Begin
            For j:=i to N-1 do
              A[j]:=A[j+1];
            N:=N-1;
          end;
end;

var
  Arch:text;
  A,B:TV;
  N,M:byte;
begin
  Vector(A,N);
  writeln('(N: ',N ,')');
  write('Vector: ');
  EscribeVector(A,N);
  CompactaVector(A,N);
  writeln();
  writeln('(N: ',N ,')');
  write('Vector: ');
  EscribeVector(A,N);
  readln();
end.

