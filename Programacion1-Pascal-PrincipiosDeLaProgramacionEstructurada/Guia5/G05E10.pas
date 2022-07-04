program G05E10;
Const
  MAX=50;
Type
 TV = array[1..MAX] of integer;
Procedure LeeVector(var A:TV; var N:byte);
var
  Arch:text;
  Numero:String;
  Num,code:integer;
  Car:Char;
begin
  Assign(Arch, 'G05E10.txt');
  Reset(Arch);
  N:=0;
  While not eof(Arch) do
      Begin
        Numero:='';
        Car:='-';
        While not eof(Arch) and (Car<>',') do
          begin
            Read(Arch,Car);
            if Car<>',' then
              Numero:=Numero+Car;
          end;
        Val(Numero,Num,Code);
        N:=N+1;
        A[N]:=Num;
      end;
  close(Arch);
end;

Procedure GeneraByC(A:TV;N:byte; var B,C:TV; var M:byte);
var
  i,cont:byte;
  suma:integer;
begin
  i:=1;
  M:=0;
  While i<=N do
    Begin
      Suma:=0;
      cont:=0;
      if A[i]<0 then
        Begin
          i:=i+1;
          While (A[i]>=0) and (i<=N) do
            Begin
              Suma:=Suma+A[i];
              cont:=cont+1;
              i:=i+1;
            end;
          If i<=N then
            Begin
              M:=M+1;
              B[M]:=Suma;
              C[M]:=Cont;
            end;
        end
      else
        i:=i+1;
    end;
end;

Procedure EscribeVector(A:TV;N:byte);
var
  i:byte;
Begin
  write(A[1]);
  For i:=2 to N do
    Write(', ',A[i]);
end;
var
  A,B,C:TV;
  N,M:byte;
begin
  LeeVector(A,N);
  write('Vector A: ');
  EscribeVector(A,N);
  writeln();
  GeneraByC(A,N,B,C,M);
  write('Vector B: ');
  EscribeVector(B,M);
  writeln();
  write('Vector C: ');
  EscribeVector(C,M);
  writeln();
  readln();
end.

