program G09E02;
const
  Max=100;
type
  ST15 = String[15];
  TTarjeta = record
    Numero_Tarjeta:word;
    Nombre_Propietario:ST15;
    Tope, Gasto_Mes: Real;
  end;
  TRechazados = record
    Numero_Tarjeta:word;
    Codigo_Operacion: byte;
    Monto:Real;
  end;
  TV = array[1..Max] of word;
  TArTarjetas = file of TTarjeta;
  TArRechazados = file of TRechazados;

Procedure ArmaTabla(var Tarjetas:TArTarjetas; var Tabla:TV);
var
  i:byte;
  R:TTarjeta;
begin
  Reset(Tarjetas);
  i:=0;
  while not eof(Tarjetas) do
    begin
      Read(Tarjetas, R);
      Tabla[i]:=R.Numero_Tarjeta;
      i:=i+1;
    end;
  Close(Tarjetas);
end;

Function BuscaTabla(Tabla:TV;X:word):word;
var
  i:byte;
begin
  i:=0;
  while X<>Tabla[i] do
    i:=i+1;
  BuscaTabla:=i;
end;

Procedure IngresoMovimientos(Tabla:TV;var Tarjetas:TArTarjetas;var Rechazados:TArRechazados);
var
  Arch:text;
  Numero_Tarjeta:word;
  Codigo_Operacion:byte;
  Monto:Real;
  R:TTarjeta;
  S:TRechazados;
begin
  Assign(Arch, 'Movimientos.txt');
  Reset(Tarjetas);
  Rewrite(Rechazados);
  while not eof(Arch) do
    begin
      Read(Numero_Tarjeta); Read(Monto); Readln(Codigo_Operacion);
      seek(Tarjetas,BuscaTabla(Tabla,Numero_Tarjeta));
      Read(Tarjetas,R);
      if Monto<=R.Tope-R.Gasto_Mes then
        R.Gasto_Mes:=R.Gasto_Mes+Monto
      else
        begin
          S.Numero_Tarjeta:=R.Numero_Tarjeta;
          S.Codigo_Operacion:=Codigo_Operacion;
          S.Monto:=Monto;
        end;
    end;
  close(Tarjetas);
  close(Rechazados);
end;

var
  Tarjetas:TArTarjetas;
  Rechazados:TArRechazados;
  Tabla:TV;
  N:byte;
begin
  Assign(Tarjetas,'Tarjetas.Dat');
  Assign(Rechazados,'Rechazados.Dat');
  ArmaTabla(Tarjetas,Tabla);
  IngresoMovimientos(Tabla,Tarjetas,Rechazados);
  Readln();

end.

