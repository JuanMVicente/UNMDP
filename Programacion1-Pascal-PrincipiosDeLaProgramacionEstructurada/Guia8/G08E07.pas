program G08E07;
Type
  TM = array[1..10,1..10] of integer;

Procedure LeeArchivo(var A:TM; var N,M:byte);
var
  i,j:byte;
  Arch:text;
begin
  Assign(Arch, 'G08E07.txt');
  Reset(Arch);
  Readln(Arch,N,M);
  For i:=1 to N do
    For j:=1 to M do
      Read(Arch,A[i,j]);
  Close(Arch);
end;

Procedure EscribeMatriz(A:TM;i,j,M:byte);
begin
  if i<1 then
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

Function Mini(A:TM;i,j,N:byte):integer;
var
  Aux:Integer;
begin
  if (i=1) and (j=1) then
    Mini:=A[1,1]
  else
    if j=1 then
      begin
        Aux:=Mini(A,i-1,N,N);
	if Aux > A[i,j] then
	  Aux:= A[i,j];
      end
    else
      begin
        Aux:=Mini(A,i,j-1,N);
	if Aux > A[i,j] then
	  Aux:= A[i,j]
      end;
  Mini:=Aux;
end;

var
  N,M:byte;
  A:TM;
begin
  LeeArchivo(A,N,M);
  EscribeMatriz(A,N,M,M);
  Writeln('Minimo: ',Minimo(A,N,M,M));
  Writeln('Minimo: ',Mini(A,N,M,M));
  readln();
end.

