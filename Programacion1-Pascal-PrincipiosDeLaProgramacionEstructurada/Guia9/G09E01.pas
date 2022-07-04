program G09E01;
const
  Max=30;
type
  ST15 = String[15];
  TReg1 = record
    CodigoPaquete:byte;
    Peso:Real;
    CodigoDestino: byte;
    MontoAsegurado: integer;
  end;
  TReg2 = record
    CodigoDestino: byte;
    Descripcion:ST15;
  end;
  TArch1 = file of TReg1;
  TArch2 = file of TReg2;
  TReg3 = record
    Descripcion:ST15;
    Cantidad:byte;
  end;
  TV = array[1..Max] of TReg3;

Procedure ListaDatos1(Var A: Tarch1);
Var
 R: TReg1;
Begin
Reset(A);
While Not Eof(A) do
   Begin
     Read(A, R);
     Writeln(R.CodigoPaquete:2,' - ', R.Peso:7:2,' - ', R.CodigoDestino,' - ', R.MontoAsegurado);
   End;
Close(A)
End;

Procedure ListaDatos2(Var A: Tarch2);
Var
 R: TReg2;
Begin
Reset(A);
While Not Eof(A) do
   Begin
     Read(A, R);
     Writeln(R.CodigoDestino,' - ', R.Descripcion);
   End;
Close(A)
End;

Procedure PesoPromedio(var A: Tarch1; var Prom:Real);
var
 R: TReg1;
 i: byte;
begin
  Reset(A);
  Prom:=0;
  i:=0;
  While Not Eof(A) do
     Begin
       Read(A, R);
       Prom:=Prom+R.Peso;
       i:=i+1;
     End;
  Prom:=Prom/i;
  Close(A)
end;

Procedure SumaMontoAsegurado(var A: Tarch1; var MontoAsegurado:Integer);
var
 R: TReg1;
begin
  Reset(A);
  MontoAsegurado:=0;
  While Not Eof(A) do
     Begin
       Read(A, R);
       MontoAsegurado:=MontoAsegurado+R.MontoAsegurado;
     End;
  Close(A)
end;


Procedure Listado(var A: Tarch1; var B: Tarch2; var C:TV; var N:byte);
var
 R: TReg1;
 S: TReg2;
begin
  Reset(B);
  N:=0;
  While not eof(B) do
     begin
       N:=N+1;
       Read(B,S);
       With C[S.CodigoDestino] do
         begin
           Descripcion:=S.Descripcion;
           Cantidad:=0;
          end;
     end;
  Close(B);
  Reset(A);
  While Not Eof(A) do
     Begin
       Read(A, R);
       C[R.CodigoDestino].Cantidad:=C[R.CodigoDestino].Cantidad+1;
     end;
  Close(A)
end;

Procedure MostrarVector(C:TV;N:byte);
var
  i:byte;
begin
  For i:=1 to N do
    With C[i] do
      Writeln(Descripcion, ' - ',Cantidad);
end;

var
 A1:TArch1;
 A2:TArch2;
 Promedio:Real;
 MontoAsegurado:integer;
 C:TV;
 N:byte;
begin
  Assign(A1,'G09E01a.Dat');
  ListaDatos1(A1);
  Assign(A2,'G09E01b.Dat');
  ListaDatos2(A2);
  PesoPromedio(A1,Promedio);
  Writeln('El peso Promedio es de: ',Promedio:5:2);
  SumaMontoAsegurado(A1,MontoAsegurado);
  Writeln('El monto asegurado es de: ',MontoAsegurado);
  Listado(A1,A2,C,N);
  MostrarVector(C,N);

  Readln();

end.

