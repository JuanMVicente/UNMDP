program G02E10;
var
  Co:real;
  C,P, D, G: char;
  I: integer;
begin
  writeln('Cable S/N:');readln(C);
  if upcase(C)<>'N' then
     begin
     writeln('Peliculas S/N:');readln(P);
     writeln('Deportes S/N:');readln(D);
     writeln('Grabar programas S/N:');readln(G);
     Co:=1350;
     if upcase(P)<>'N' then Co:=Co+200;
     if upcase(D)<>'N' then Co:=Co+270;
     if upcase(G)<>'N' then Co:=Co+150;
     end;
  writeln('Internet ( 0(no)/6/10 ) MB:');readln(I);
  if I<>0 then
     if I=6 then Co:= Co+800
     else Co:= Co+800*1.2;
  if (i>0) and (upcase(C)<>'N') then Co:= Co*0.75;
  writeln('El costo total es de : $ ', Co:6:2);
  readln();
end.

