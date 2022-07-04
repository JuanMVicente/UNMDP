program G02E11b;
var
  edad,adic, dia: integer;
  cuota: real;
  pil:char;
begin
  writeln('Edad: '); readln(edad);
  writeln('Cuantos deportes adicionales realiza? (sin pileta) '); readln(adic);
  writeln('Realiza pileta (S/N)? '); readln(pil);
  writeln('Que dia del mes paga? '); readln(dia);
  case edad of
  18..100: cuota := 1800 + adic * 250;
  13..17: cuota := 1200 + adic * 250;
  5..12: cuota := 750 + adic * 250;
  0..4: cuota := 0 + adic * 250;
  end;
  if upcase(pil) <> 'N' then cuota := cuota +800;
  if dia > 15 then cuota := cuota * 1.05;
  writeln('Su cuota es de: $ ', cuota:6:2);
  readln();
end.

