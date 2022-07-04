program G05E05;
Type
 TV = array[1..50] of integer;
Procedure LeeVector(var V:TV; var N:byte;var Max:Integer);
var
  Num:integer;
  Arch:text;
begin
  Assign(Arch, 'G05E02.txt');
  Reset(Arch);
  N:=0;
  Max:=0;
    While not eof(Arch) do
      Begin
        Readln(Arch, Num);
        N:=N+1;
        V[N]:=Num;
        If Max<Num then
          Max:=Num;
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
function DivProm(V:TV; N:byte; Max:Integer):real;
var
  i,cont:byte;
Begin
  DivProm:=0;
  Cont:=0;
  For i:=1 to N do
      If v[i]<>0 then
        If Max mod V[i] = 0 then
          Begin
            Cont:=Cont+1;
            DivProm:=DivProm+V[i];
          End;
  DivProm:=DivProm/Cont;
End;
Procedure Divisores(A:TV; var B:TV; N:byte; var M:byte; Max:Integer);
var
  i:byte;
Begin
  M:=0;
  For i:=1 to N do
    If A[i]<>0 then
      If Max mod A[i] = 0 then
        Begin
          M:=M+1;
          B[M]:=A[i];
        End;
End;
var
  A,B:TV;
  N,M:byte;
  Max:Integer;
begin
  LeeVector(A,N,Max);
  write('Vector: ');
  EscribeVector(A,N);
  writeln();
  Writeln('El promedio de los divisores es: ',DivProm(A,N,Max):5:2);
  Divisores(A,B,N,M,Max);
  Writeln();
  Writeln('El promedio de los divisores es: ',DivProm(B,M,Max):5:2);
  write('Vector: ');
  EscribeVector(B,M);
  readln();
end.

