program G08E02;

function Recursiva(X: integer): integer;
begin
 if X=0 then
   Recursiva:=1
 else
   if X mod 2 = 0 then
     Recursiva:=1+Recursiva(X-1)
   else
     Recursiva:=Recursiva(X-1);

 end;


var
  A:integer;
begin
  Write('Escriba un Nro: '); Readln(A);
  Writeln(Recursiva(A));
  Readln();
end.

