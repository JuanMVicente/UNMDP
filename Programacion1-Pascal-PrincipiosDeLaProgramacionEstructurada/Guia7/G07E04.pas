program G07E04;
Type
  ST10 = String[10];
  TReg = Record
    Club:ST10;
    Partidos,G,E,P,Puntos:byte;
  end;
  TVReg = array[1..20] of TReg;
  TVB = array[1..5] of byte;

Procedure Registra(var A:TVReg;var N:byte);
var
  i:byte;
  Arch:text;
  Car:Char;
  Nombre:ST10;
begin
  Assign(Arch, 'G07E04.txt');
  Reset(Arch);
  N:=0;
  While not eof(Arch) do
    begin
      N:=N+1;
      with A[N] do
        begin
          //Nombre del Club
          Nombre:='';
          Read(Arch,Car);
          While Car<>' ' do
            Begin
              Nombre:=Nombre+Car;
              Read(Arch,Car);
            end;
          Club:=Nombre;

          //Leo Cantidad de Partidos
          Read(Arch, Partidos);

          //Leo el vacío
          Read(Arch,Car);

          //Leo los resultados
          G:=0;
          E:=0;
          P:=0;
          Puntos:=0;
          For i:=1 to Partidos do
            Begin
              Read(Arch,Car);
              Case Car of
                'G': Begin
                       G:=G+1;
                       Puntos:=Puntos+3;
                     end;

                'E': begin
                       E:=E+1;
                       Puntos:=Puntos+1;
                     end;
                'P': P:=P+1;
              end;
            end;
        end;
    end;
  Close(Arch);
end;

Procedure MuestraRegistro(A:TVReg;N:byte);
var
  i:byte;
begin
  For i:=1 to N do
    with A[i] do
      Write(Club,' - Partidos: ',Partidos,' - Puntos: ',Puntos);
end;

Procedure PosPunteros(A:TVReg;N:Byte; var Punteros:TVB; var M:byte);
var
  i,Max:byte;
begin
  Max:= A[1].Puntos;
  Punteros[1]:=1;
  M:=1;
  For i:=2 to N do
    with A[i] do
      Begin
        If Puntos>Max then
          Begin
            Max:=Puntos;
            M:=1;
            Punteros[M]:=i;
          end
        Else
          If Puntos=Max then
            Begin
              M:=M+1;
              Punteros[M]:=i;
            end;
      end;
end;

Procedure MuestraPrimeros(RegClubes:TVReg;Punteros:TVB;M:Byte);
var
  i:byte;
Begin
  Writeln('Los punteros son: ');
  For i:=1 to M do
    with RegClubes[Punteros[i]] do
      Write(Club);
end;

Function CalcPorcentaje(RegClubes:TVReg;N:byte):Real;
var
  i,Cont:byte;
begin
  Cont:=0;
  For i:=1 to N do
    with RegClubes[i] do
      If P=0 then
        Cont:=Cont+1;
  CalcPorcentaje:=Cont*100/N;
end;

var
  RegClubes:TVReg;
  N,M:byte;
  Punteros:TVB;
  Aux:real;
begin
  Registra(RegClubes,N);
  MuestraRegistro(RegClubes,N);
  writeln();
  writeln();
  PosPunteros(RegClubes,N,Punteros,M);
  MuestraPrimeros(RegClubes,Punteros,M);
  writeln();
  writeln();
  Aux:= CalcPorcentaje(RegClubes,N);
  If Aux=0 then
    Writeln('No hay equipo que no haya perdido.')
  else
    Write('El porcentaje de equipos que no perdio es: ',Aux:5:2,' %');
  Readln();
end.

