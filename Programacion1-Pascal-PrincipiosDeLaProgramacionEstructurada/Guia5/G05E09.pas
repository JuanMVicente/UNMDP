program G05E09;
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
  Assign(Arch, 'G05E09.txt');
  Reset(Arch);
  N:=0;
  While not eof(Arch) do
      Begin
        Numero:='';
        While not eof(Arch) and (Car<>',') do
          begin
            Read(Arch,Car);
            if Car<>',' then
              Numero:=Numero+Car;
          end;
        Val(Numero,Num,Code);
        if N=0 then
          Begin
            N:=N+1;
            A[N]:=Num;
          end
        else
          if Num>A[N] then
            begin
              N:=N+1;
              A[N]:=Num;
            end;
        Read(Arch,Car);
      end;
  close(Arch);
end;

Procedure GeneraB(A:TV;N:byte; var B:TV);
var
  i,j,k,l:byte;
begin
  j:= N div 2;
  l:= N mod 2;
  For i:=1 to j do
    Begin
      k:= A[N+1-i] mod A[i];
      If k=0 then
        begin
        B[i]:=A[i];
        B[N+1-i]:=A[N+1-i];
        end
    else
      begin
        B[i]:=0;
        B[N+1-i]:=0;
      end;
    end;
  if l = 1 then
    B[j+1]:=A[j+1];
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
  N:byte;
begin
  LeeVector(A,N);
  write('Vector A: ');
  EscribeVector(A,N);
  writeln();
  GeneraB(A,N,B);
  write('Vector B: ');
  EscribeVector(B,N);
  writeln();
  readln();
end.

