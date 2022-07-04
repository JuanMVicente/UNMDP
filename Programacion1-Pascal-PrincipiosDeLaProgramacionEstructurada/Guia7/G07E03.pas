program G07E03;
Type
  TReg = Record
    Cuadrante:byte;
    X,Y,Distancia: real;
  end;
  TV = array[1..20] of TReg;
  TCont = Record
    Cuad:String[3];
    Cont:byte;
    Prom:real;
  end;
  TVCont = array [1..5] of TCont;

Function BuscaCuadrante(X,Y:real): byte;
begin
  If X>0 then
    if Y>0 then
      BuscaCuadrante:=1
    else
      BuscaCuadrante:=4
  else
    if Y<0 then
      BuscaCuadrante:=3
    else
      BuscaCuadrante:=2;
  if (X=0) or (Y=0) then
    BuscaCuadrante:=0;       //sobre Eje
end;

Procedure Registra(var Puntos:TV; var N:byte);
var
  i:byte;
  Arch:text;
begin
  Assign(Arch, 'G07E03.txt');
  Reset(Arch);
  N:=0;
  While Not Eof(Arch) do
    begin
      N:=N+1;
      With Puntos[N] do
        Begin
          Readln(Arch, X,Y);
          Distancia:= sqrt( sqr(X) + sqr(Y) );
          Cuadrante:=BuscaCuadrante(X,Y);
        end;
    end;
  close(Arch);
end;



Function Distancia2puntos(Puntos:TV; A,B:byte): real;
Begin
  Distancia2puntos:= sqrt( sqr(Puntos[A].X - Puntos[B].X) + sqr(Puntos[A].Y - Puntos[B].Y) );
end;



Procedure MuestraVector(Puntos:TV; N:byte);
var
  i:byte;
begin
  For i:=1 to N do
    Begin
      with Puntos[i] do
        Writeln('X: ',X:5:2,' - Y: ',Y:5:2,' - Cuad: ',Cuadrante,' - Dist: ', Distancia:5:2);
    end;
end;

Procedure MuestraVector2(A:TVCont);
var
  i:byte;
begin
  For i:=1 to 5 do
    Begin
      with A[i] do
        Writeln('Cuadrante: ',Cuad,' - Cantidad: ',Cont,' - Promedio: ',Prom:5:2);
    end;
end;

Procedure MinMax(PuntosPlanos:TV;N:byte);
var
  i,PosMin,PosMax:byte;
  min,max:real;
begin
  min:= PuntosPlanos[1].Distancia;
  max:= PuntosPlanos[1].Distancia;
  For i:=2 to N do
      With PuntosPlanos[i] do
        begin
          if min>Distancia then
            begin
             min:=Distancia;
             PosMin:=i;
            end;
          if max<PuntosPlanos[i].Distancia then
            begin
              max:=Distancia;
              PosMax:=i;
            end;
        end;
  Writeln('El mas cercano al centro es: X=',PuntosPlanos[PosMin].X:5:2,' - Y=',PuntosPlanos[PosMin].Y:5:2);
  Writeln('El mas lejano al centro es: X=',PuntosPlanos[PosMax].X:5:2,' - Y=',PuntosPlanos[PosMax].Y:5:2);
end;

Procedure InicializoContador(var A:TVCont);
var
  i:byte;
begin
  For i:=1 to 5 do
    with A[i] do
      Cont:=0;
end;

Procedure CantxCuadrante(PuntosPlano:TV;N:byte; var CantCuadrante:TVCont);
var
  i,Suma:byte;
begin
  CantCuadrante[1].Cuad:='I';
  CantCuadrante[2].Cuad:='II';
  CantCuadrante[3].Cuad:='III';
  CantCuadrante[4].Cuad:='IV';
  CantCuadrante[5].Cuad:='Eje';
  For i:=1 to N do
    With PuntosPlano[i] do
      case Cuadrante of
        1: CantCuadrante[1].Cont:=CantCuadrante[1].Cont+1;
        2: CantCuadrante[2].Cont:=CantCuadrante[2].Cont+1;
        3: CantCuadrante[3].Cont:=CantCuadrante[3].Cont+1;
        4: CantCuadrante[4].Cont:=CantCuadrante[4].Cont+1;
        0: CantCuadrante[5].Cont:=CantCuadrante[5].Cont+1;
      end;
  Suma:=0;
  For i:=1 to 5 do
    with CantCuadrante[i] do
      Suma:=Suma+Cont;
  For i:=1 to 5 do
    with CantCuadrante[i] do
      Prom:= Cont*100/Suma;
end;

var
  PuntosPlano:TV;
  N,Min,Max,A,B:byte;
  CantCuadrante:TVCont;
begin
  Registra(PuntosPlano,N);
  MuestraVector(PuntosPlano,N);
  MinMax(PuntosPlano,N);
  InicializoContador(CantCuadrante);
  CantxCuadrante(PuntosPlano,N,CantCuadrante);
  MuestraVector2(CantCuadrante);
  Write('Elija uno (posicion) de los puntos: ');Readln(A);
  Write('Elija otro (posicion) de los puntos: ');Readln(B);
  Writeln('La distancia entre ellos es de: ', Distancia2puntos(PuntosPlano,A,B):5:2);
  Readln();
end.

