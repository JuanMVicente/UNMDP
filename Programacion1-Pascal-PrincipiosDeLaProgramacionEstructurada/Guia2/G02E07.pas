program G02E07;
var
  talle, genero: char;
  q, costo: real;
begin
  writeln('Camisa de hombre (H) o mujer (M): '); readln(genero);
  writeln('Que talle (S/M/L/X)?: '); readln(talle);
  writeln('Cuantas camisas quiere?: '); readln(q);
  if upcase(genero) = 'M' then
       if upcase(talle) <> 'X' then costo := 1200
       else costo := 1200 * 0.95
  else
       if upcase(talle) <> 'S' then costo := 1000
       else costo:= 1000*0.95;
  if q<12 then costo := costo * q * 1.21
  else costo := costo * q * 0.93 * 1.21;
  writeln('El costo total es : ', costo:6:2);
  readln();
end.

