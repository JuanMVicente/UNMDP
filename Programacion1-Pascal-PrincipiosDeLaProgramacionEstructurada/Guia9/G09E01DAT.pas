program G09E01DAT;
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

procedure CargaArchivo1(var A:TArch1);
var
  R:TReg1;
  Arch:text;
begin
  Assign(Arch, 'G09E01a.txt');
  Reset(Arch);
  Rewrite(A);
  While not eof(Arch) do
    begin
      Readln(Arch, R.CodigoPaquete, R.Peso, R.CodigoDestino, R.MontoAsegurado);
      write(A,R);
    end;
  Close(Arch);
  Close(A)
end;

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

procedure CargaArchivo2(var B:TArch2);
var
  R:TReg2;
  Arch:text;
begin
  Assign(Arch, 'G09E01b.txt');
  Reset(Arch);
  Rewrite(B);
  While not eof(Arch) do
    begin
      Readln(Arch, R.CodigoDestino,R.Descripcion);
      write(B,R);
    end;
  Close(Arch);
  Close(B)
end;

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


var
 A1:TArch1;
 A2:TArch2;
begin
  Assign(A1,'G09E01a.Dat');
  {CargaArchivo1(A1); }
  ListaDatos1(A1);
  Assign(A2,'G09E01b.Dat');
  {CargaArchivo2(A2);           }
  ListaDatos2(A2);

  Readln();

end.

