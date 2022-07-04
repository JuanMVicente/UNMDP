program G05E12;
Const
  MAX=20;
Type
  ST20 = String[20];
  TVS = array [1..MAX] of ST20;
  TVR = array [1..MAX] of Real;
  TVC = array [1..MAX] of Char;

Procedure ProcesaArchivo(var Claves:TVS; var Prom:TVR; var Char:TVC; var N:byte);
var
  Arch:Text;
  Clave:ST20;
  Car,Ult:Char;
  Cont,i:Byte;
  Num:Integer;
  Promedio:Real;
begin
  Assign(Arch,'G05E12.txt');
  Reset(Arch);
  N:=0;

  While Not eof(Arch) do
    begin
      Clave:='';
      Cont:=0;

      Read(Arch,Car);
      While Car<>' ' do
        begin
          If (Car<'0') or (('9'<Car) and (Car<'A')) or (('Z'<Car) and (Car<'a')) or ('z'<Car) then
            Begin
              Cont:=Cont+1;
              Read(Arch,Car);
            end
          Else
            Begin
              Ult:=Car;
              Clave:=Clave+Car;
              Read(Arch,Car);
            end;
        end;

        if Cont<=3 then
          begin

            Promedio:=0;
            For i:=1 to 3 do
              begin
                Read(Arch, Num);
                Promedio:=Promedio+Num;
              end;

            While Car=' ' do
              Read(Arch,Car);

            If upcase(Car)<>upcase(Ult) then
              Begin
                N:=N+1;
                Claves[N]:=Clave;
                Prom[N]:=Promedio/3;
                Char[N]:=Car;
              end;

            end;

        Readln(Arch);
    end;

  Close(Arch);
end;

Procedure MuestraVectores(Claves:TVS;Prom:TVR;Char:TVC;N:byte);
var
  i:byte;
begin
  For i:=1 to N do
    Writeln(Claves[i],'...',Prom[i]:7:2,'...',Char[i]);
end;

var
  Claves:TVS;
  Prom:TVR;
  Char:TVC;
  N:byte;
begin
  ProcesaArchivo(Claves,Prom,Char,N);
  MuestraVectores(Claves,Prom,Char,N);
  Readln();
end.

