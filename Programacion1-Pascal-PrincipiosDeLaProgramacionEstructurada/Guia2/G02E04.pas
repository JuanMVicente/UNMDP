program G02E04;
var
  d1,d2,m1,m2,a1,a2: integer;
  ant: byte;
begin
  writeln('Fecha 1 (separados dia, mes y anio): '); readln(d1,m1,a1);
  writeln('Fecha 2 (separados dia, mes y anio): '); readln(d2,m2,a2);
  if a1 <> a2 then
     if a1<a2 then
        begin
          writeln('La fecha 1 es mas antigua.');
          ant := 1;
        end
     else
         writeln('La fecha 2 es mas antigua.')
  else    {son de años iguales}
     if m1 <> m2 then
        if m1<m2 then
           begin
             writeln('La fecha 1 es mas antigua.');
             ant := 1;
           end
        else
           writeln('La fecha 2 es mas antigua.')
     else {mismo año y mes}
         if d1<d2 then
           begin
             writeln('La fecha 1 es mas antigua.');
             ant := 1;
           end
        else
           writeln('La fecha 2 es mas antigua.');
  if ant = 1 then
    if m1 <=3 then writeln('Primer trimestre.')
    else
      if m1 <=6 then writeln('Segundo trimestre.')
      else
        if m1 <=9 then writeln('Tercer trimestre.')
        else writeln('Cuarto trimestre.')
  else
    if m2 <=3 then writeln('Primer trimestre.')
    else
      if m2 <=6 then writeln('Segundo trimestre.')
      else
        if m2 <=9 then writeln('Tercer trimestre.')
        else writeln('Cuarto trimestre.');
  readln();
end.

