program G05E08;
Type
 TV = array[1..50] of integer;
Procedure LeeVector(var A,B:TV; var N,M:byte);
var
  Arch:text;
  Num,Aux,Cont:byte;
begin
  Assign(Arch, 'G05E08.txt');
  Reset(Arch);
  N:=0;
  M:=0;
    While not eof(Arch) do
      Begin
        Readln(Arch, Num);
        N:=N+1;
        A[N]:=Num;
        If Aux=Num then
          Cont:=Cont+1
        Else
          Begin
            M:=M+1;
            Cont:=1;
          end;
        B[M]:=Cont;
        Aux:=Num;
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
var
  A,B:TV;
  N,M:byte;
begin
  LeeVector(A,B,N,M);
  write('Vector: ');
  EscribeVector(A,N);
  writeln();
  write('Vector: ');
  EscribeVector(B,M);
  readln();
end.

