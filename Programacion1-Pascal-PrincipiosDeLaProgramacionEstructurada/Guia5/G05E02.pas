program G05E02;
Type
 TV = array[1..50] of integer;
Procedure VPar(var V:TV; var N: byte);
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
        If (Num mod 2 = 0) and (Num<>0) Then
          Begin
            N:=N+1;
            V[N]:=Num;
          end;
      end;
  close(Arch);
end;
Procedure VImpar(var V:TV; var N: byte);
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
        If Num mod 2 = 1 Then
          Begin
            N:=N+1;
            V[N]:=Num;
          end;
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
  Arch:text;
  Par,Impar:TV;
  N,M:byte;
begin
  Vpar(Par,N);
  VImpar(Impar,M);
  write('Vector Par: ');
  EscribeVector(Par,N);
  writeln();
  write('Vector Impar: ');
  EscribeVector(Impar,M);
  readln();
end.

