program G07E06;
Type
  TReg = Record
    i,j,valor:byte;
  end;
  TVReg = array[1..20] of TReg;

Procedure Elimina( Var V: TVReg; Var N : Byte; Pos:Byte);
Var
 i: Byte;
Begin
 For i:= Pos to N-1 do
 V[ i ] := V[ i+1 ];
 N:=N-1;
End;

Procedure Registra1(var A:TVReg;var P:byte);
var
  Arch:text;
begin
  Assign(Arch, 'G07E06a.txt');
  Reset(Arch);
  While not eof(Arch) do
    begin
      P:=P+1;
      with A[P] do
          Readln(Arch,i,j,valor);
    end;
  Close(Arch);
end;

Procedure Registra2(var A:TVReg;var P:byte);
var
  Arch:text;
begin
  Assign(Arch, 'G07E06b.txt');
  Reset(Arch);
  While not eof(Arch) do
    begin
      P:=P+1;
      with A[P] do
          Readln(Arch,i,j,valor);
    end;
  Close(Arch);
end;

Procedure SumaVectores(A,B:TVReg;N,M:byte;var SUMA:TVReg; var P:byte);
var
  k,l:byte;
begin
  P:=0;
  For k:=1 to N do
    begin
      l:=1;
      P:=P+1;
      while ((A[k].i<>B[l].i) or (A[k].j<>B[l].j)) and (l<=M) do
        l:=l+1;
      if l>M then
        with SUMA[P] do
            begin
              i:=A[k].i;
              j:=A[k].j;
              valor:=A[k].valor;
            end
      else
        begin
          with SUMA[P] do
              begin
                i:=A[k].i;
                j:=A[k].j;
                valor:=A[k].valor+B[l].valor;
              end;
          B[l].valor:=0;
        end;
    end;
  For k:=1 to M do
    begin
      if B[k].valor<>0 then
        Begin
            P:=P+1;
            with SUMA[P] do
              begin
                i:=B[k].i;
                j:=B[k].j;
                valor:=B[k].valor;
              end;
        end;
    end;
end;

Procedure MuestraLectura(A:TVReg;P:byte);
var
  i:byte;
begin
  For i:=1 to P do
    With A[i] do
        Writeln(i,'-',j,'-' ,valor);
end;

Procedure MuestraMatriz(A:TVReg;N,P:byte);
var
  h,k,l:byte;
begin
  For k:=1 to N do
    begin
      Writeln();
        For l:=1 to N do
          begin
            h:=1;
            while ((A[h].i<>k) or (A[h].j<>l)) and (h<=P) do
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

Procedure MuestraTranspuesta(A:TVReg;N,P:byte);
var
  h,k,l:byte;
begin
  For k:=1 to N do
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
  M1,M2,SUMA:TVReg;
  N,M,P,Q:byte;
begin
  Write('Escriba dimensiones de la Matriz (NxN): ');
  Readln(N);
  Registra1(M1,M);
  writeln('V1: ');
  MuestraLectura(M1,M);
  Registra2(M2,P);
  writeln('V2: ');
  MuestraLectura(M2,P);
  SumaVectores(M1,M2,M,P,SUMA,Q);
  writeln('Suma: ');
  MuestraLectura(SUMA,Q);
  MuestraMatriz(SUMA,N,Q);
  writeln();
  If N=M then
    MuestraTranspuesta(SUMA,N,Q);
  Readln();
end.

