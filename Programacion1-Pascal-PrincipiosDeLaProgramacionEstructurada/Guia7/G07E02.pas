program G07E02;
Type
  TReg = Record
    Tipo:char;
    Color: byte;
  end;
  TM = array[1..8,1..8] of TReg;

Procedure InicializaTablero(var Tablero:TM);
var
  i,j:byte;
begin
  For i:=1 to 8 do
    For j:=1 to 8 do
      with tablero[i,j] do
        begin
          Tipo:='V';
          Color:=0;
        end;
end;

Procedure LeeArchivo(var Tablero:TM);
var
  i,j:byte;
  Arch:text;
begin
  Assign(Arch, 'G07E02.txt');
  Reset(Arch);
  While Not Eof(Arch) do
    begin
      Read(Arch,i,j);
      with tablero[i,j] do
        Readln(Arch, Tipo, Tipo, Color);
    end;
  close(Arch);
end;

Procedure Defiende(Tablero);

Procedure AmenazaTablero(Tablero);

Procedure MuestraTablero(Tablero:TM);
var
  i,j:byte;
begin
  For i:=1 to 8 do
    Begin
      for j:=1 to 8 do
          with Tablero[i,j] do
            Write('-',Tipo,Color,'-');
      writeln();
    end;
end;

var
  Tablero:TM;
begin
  InicializaTablero(Tablero);
  LeeArchivo(Tablero);
  MuestraTablero(Tablero);

  Readln();
end.

