program G09E05;
const
  Max=50;
type
  ST15 = String[15];
  TExcursion = record
    Codigo_Excursion:byte;
    Descripcion:ST15;
    Precio_Base: Real;
    Precio_Comida: Real;
  end;
  TBoleteria = record
    Codigo_Excursion:byte;
    Numero_Boleto: word;
    Incluye_Comida: Char;
  end;
  TListado = Record
    Descripcion:ST15;
    Cantidad_Boletos:word;
    Cantidad_Comidas:word;
    Monto:Real;
  end;
  TV1 = array[1..Max] of TExcursion;
  TV2 = array[1..Max] of TListado;
  {TArExcursiones = file of TExcursion; tomo que lo genero vector}
  TArBoleteria = file of TBoleteria;

Procedure InicializaVector(A:TV2);
var
  i:byte;
begin
  For i:=1 to Max do
    with A[i] do
      begin
        Cantidad_Boletos:=0;
        Cantidad_Comidas:=0;
        Monto:=0;
      end;
end;

Procedure Listado(var Boleteria:TArBoleteria;Excursiones:TV1;N:byte);
var
  R:TBoleteria;
  TListado:TV2;
  i:byte;
begin
  Reset(Boleteria);
  InicializaVector(TListado);
  while not eof(Boleteria) do
    begin
      Read(Boleteria,R);
      If TListado[Codigo_Excursion].Cantidad_Boletos=0 then
        with TListado[Codigo_Excursion] do
          begin
            Descripcion:=R.Descripcion;
            Cantidad_Boletos:=1;
            if R.Incluye_Comida='S' then
              Cantidad_Comidas:=1;
            Monto:=TListado[Codigo_Excursion].PrecioBase+TListado[Codigo_Excursion].Precio_Comida*Cantidad_Comidas;
          end
      else
        with TListado[Codigo_Excursion] do
          begin
            Cantidad_Boletos:=Cantidad_Boletos+1;
            if R.Incluye_Comida='S' then
              begin
                Cantidad_Comidas:=Cantidad_Comidas+1;
                Monto:=Monto+TListado[Codigo_Excursion].PrecioBase+TListado[Codigo_Excursion].Precio_Comida;
              end
            else
              Monto:=Monto+TListado[Codigo_Excursion].PrecioBase;
          end;
    end;
  For i:=1 to N do
    with TListado[i] do
      Writeln(Descripcion:15,Cantidad_Boletos:6,Cantidad_Comidas:6,Monto:9:2);
end;


var
  Excursiones:TV1;
  Boleteria:TArBoleteria;
  N:byte;
begin
  Assign(Boleteria,'Boleteria.Dat');
  Listado(Boleteria,Excursiones,N);
  Readln();
end.

