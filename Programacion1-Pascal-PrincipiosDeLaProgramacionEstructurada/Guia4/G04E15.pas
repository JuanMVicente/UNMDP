program G04E15;

function Pot2(N:integer):integer;
var
  i:integer;
Begin
  Pot2:=1;
  For i:=1 to N-1 do
      Pot2:=Pot2 * 2;
end;
function Factorial(N:integer): integer;
var
  i:integer;
Begin
  Factorial:=1;
  For i:=1 to N do
      Factorial:= Factorial * i;
end;

procedure RES(E:byte; N:integer);
var
  RES:real;
  i:integer;
Begin
  Case E of
    1: For i:=1 to N do RES:= RES + 1/sqr(i);
    2: For i:=1 to N do RES:= RES + 1/Pot2(i);
    3: For i:=1 to N do RES:= RES + 1/Factorial(i);
  end;
  Writeln('RES: ',RES:10:8);
End;

var
  N:Integer;
  E:Byte;
Begin
  Writeln('Ingrese valor de N: ');
  Readln(N);
  Writeln('Ingrese Eleccion (1, 2 o 3): ');
  Readln(E);
  RES(E,N);
  readln();
end.


