program G07E01;
Type
  ST10 = String[10];
  TReg = Record
    Nombre:ST10;
    Dia,Mes:byte;
    Anio: word;
  end;
  TV = array [1..20] of TReg;

procedure LeeArchivo(var Registro:TV;var N:byte);
var
  Arch:text;
  i:byte;
  Car:Char;
  Nombre:ST10;
begin
  Assign(Arch,'G07E01.txt');
  Reset(Arch);
  N:=0;
  While Not eof(Arch) do
    begin
      N:=N+1;
      Nombre:='';

      Read(Arch,Car);
      While Car<>' ' do
          begin
            Nombre:=Nombre+car;
            Read(Arch,Car);
          end;
      Registro[N].Nombre:=Nombre;

      Read(Arch, Registro[N].Dia);

      Read(Arch, Registro[N].Mes);

      Read(Arch, Registro[N].Anio);
    end;
  Close(Arch);
end;

Procedure Estacion(Registro:TV; N:byte);
var
  verano,otono,invierno,primavera,i:byte;
begin
  verano:=0;
  otono:=0;
  invierno:=0;
  primavera:=0;
  For i:=1 to N do
      with Registro[i] do
        case Mes of
          1..2: verano:= verano+1;
          3: begin
               if Dia<21 then
                 verano:= verano+1
               else
                 otono:= otono+1;
             end;
          4..5: otono:= otono+1;
          6: begin
               if Dia<21 then
                 otono:= otono+1
               else
                 invierno:= invierno+1;
             end;
          7..8: invierno:= invierno+1;
          9: begin
               if Dia<21 then
                 invierno:= invierno+1
               else
                 primavera:= primavera+1;
             end;
          10..11: primavera:= primavera+1;
          12: begin
               if Dia<21 then
                 primavera:= primavera+1
               else
                 verano:= verano+1;
             end;
        end;

  Writeln('En verano: ',verano);
  Writeln('En otono: ',otono);
  Writeln('En invierno: ',invierno);
  Writeln('En primavera: ',primavera);
end;


Procedure MuestraVector(Registro:TV; N:byte);
var
  i:byte;
begin
  For i:=1 to N do
      Write(Registro[i].Nombre,'-',Registro[i].Dia,'/',Registro[i].Mes,'/',Registro[i].Anio);
end;

var
  Personal:TV;
  N:byte;
begin
  LeeArchivo(Personal,N);
  MuestraVector(Personal,N);
  writeln();
  Estacion(Personal,N);
  Readln();

end.
