program G08E08;
Type
  TM = array[1..10,1..10] of integer;
  TV = array[1..10] of integer;

Procedure LeeArchivo(var A:TM; var N,M:byte);
var
  i,j:byte;
  Arch:text;
begin
  Assign(Arch, 'G08E08.txt');
  Reset(Arch);
  Readln(Arch,N,M);
  For i:=1 to N do
    For j:=1 to M do
      Read(Arch,A[i,j]);
  Close(Arch);
end;

Procedure EscribeMatriz(A:TM;i,j,M:byte);
begin
  if (j=1) and (i=1) then
     Write(' - ',A[1,1],' - ')
  else
     if j=1 then
       begin
          EscribeMatriz(A,i-1,M,M);
          Write(' - ',A[i,j],' - ');
       end
     else
       begin
          EscribeMatriz(A,i,j-1,M);
          if j=M then
            Writeln(' - ',A[i,j],' - ')
          else
            Write(' - ',A[i,j],' - ')
       end;
end;

Function Minimo(A:TM;i,j,M:byte):integer;
var
  min:integer;
begin
  if (j=1) and (i=1) then
     min:=A[i,j]
  else
     if j=1 then
       begin
          min:=Minimo(A,i-1,M,M);
          if min>A[i,j] then
            min:=A[i,j];
       end
     else
       begin
          min:=Minimo(A,i,j-1,M);
          if min>A[i,j] then
            min:=A[i,j];
       end;
  Minimo:=min;
end;

Function MaxFila(A:TM;i,j:byte):integer;
var
  Max:integer;
begin
  if j=1 then
    Max:=A[i,1]
  else
    begin
       Max:=MaxFila(A,i,j-1);
       if Max<A[i,j] then
         Max:=A[i,j];
    end;
  MaxFila:=Max;
end;

Procedure VectorMaximos(A:TM;i,M:byte; var V:TV);
begin
  if i=1 then
    V[1]:=MaxFila(A,1,M)
  else
    begin
      VectorMaximos(A,i-1,M,V);
      V[i]:=MaxFila(A,i,M);
    end;
end;

Procedure EscribeVector(V:TV;i:byte);
begin
  if i=1 then
    Write(' - ',V[i],' - ')
  else
    begin
       EscribeVector(V,i-1);
       Write(' - ',V[i],' - ');
    end;
end;

var
  N,M:byte;
  A:TM;
  V:TV;
begin
  LeeArchivo(A,N,M);
  EscribeMatriz(A,N,M,M);
  Writeln('Minimo: ',Minimo(A,N,M,M));
  VectorMaximos(A,N,M,V);
  EscribeVector(V,N);
  readln();
end.
