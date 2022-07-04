program G08E02Repaso;

function Recursiva(i:integer):integer;
begin
  if i=0 then
    Recursiva:=1
  else
    If i mod 2 = 0 then
      Recursiva:= 1 + Recursiva(i-1)
    else
      Recursiva:=Recursiva(i-1);
end;


var
  A:integer;
begin
  Write('Escriba un Nro: '); Readln(A);
  Writeln(Recursiva(A));
  Readln();
end.

