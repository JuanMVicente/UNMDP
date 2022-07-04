program G07E05;
Type
  TReg = Record
    i,j,valor:byte;
  end;
  TVReg = array[1..20] of TReg;

Procedure Elimina ( Var V: TVReg; Var N : Byte; Pos:Byte);
Var
 i: Byte;
Begin
 For i:= Pos to N-1 do
 V[ i ] := V[ i+1 ];
 N:=N-1;
End;

Procedure Registra(var A:TVReg;var N,M,P:byte);
var
  Arch:text;
begin
  Assign(Arch, 'G07E05.txt');
  Reset(Arch);
  Readln(Arch,N,M);
  While not eof(Arch) do
    begin
      P:=P+1;
      with A[P] do
          Readln(Arch,i,j,valor);
    end;
  Close(Arch);
end;

Procedure MuestraLectura(A:TVReg;N,M,P:byte);
var
  i:byte;
begin
  Writeln(N,'-',M);
  For i:=1 to P do
    With A[i] do
        Writeln(i,'-',j,'-' ,valor);
end;

Procedure MuestraRegistro(A:TVReg;N,M,P:byte);
var
  h,k,l,x:byte;
begin
  x:=1;
  For k:=1 to N do
    begin
      Writeln();
        For l:=1 to M do
          begin
            h:=x;
            while ((A[h].i<>k) or (A[h].j<>l)) and (h<=P) do
              h:=h+1;
            If h>P then
              Write(' - 0')
            Else
              begin
                Write(' - ',A[h].valor);
                x:=x+1;
              end;
        end;
    end;
end;


Procedure MuestraTranspuesta(A:TVReg;N,M,P:byte);
var
  h,k,l,x:byte;
begin
  For k:=1 to M do
    begin
      Writeln();
        For l:=1 to N do
          begin
            h:=1;
            while ((A[h].i<>l) or (A[h].j<>k)) and (h<=P) do
              h:=h+1;
            If h>P then
              Write(' - 0')
            Else
              begin
                Write(' - ',A[h].valor);
                Elimina(A,P,h);
              end;
        end;
    end;
end;



var
  MRala:TVReg;
  N,M,P:byte;

begin
  Registra(MRala,N,M,P);
  MuestraLectura(MRala,N,M,P);
  MuestraRegistro(MRala,N,M,P);
  writeln();
  If N=M then
    MuestraTranspuesta(MRala,N,M,P);
  Readln();
end.

