program G08E03Repaso;

function confuso(a,b:integer):integer;
begin
 if (b = 0) then
 confuso := 0
 else
 if (b mod 2 = 0) then
 confuso := confuso(a+a, b div 2)
 else
 confuso := confuso(a+a, b div 2) + a;
end;

{a- con las invocaciones propuestas multiplica ambos valores}
{b- define la multiplicacion}

var
  A,B:integer;
begin
  Write('Escriba un Nro: '); Readln(A);
  Write('Escriba un Nro: '); Readln(B);
  Writeln(Confuso(A,B));
  Readln();
end.

