program G02E11a;
var
  talle, genero: char;
  q, costo: real;
begin
  writeln('Camisa de hombre (H) o mujer (M): '); readln(genero);
  writeln('Que talle (S/M/L/X)?: '); readln(talle);
  writeln('Cuantas camisas quiere?: '); readln(q);
  case upcase(genero) of
  'M': case upcase(talle) of
       'S','M','L': costo := 1200;
       'X': costo := 1200 * 0.95;
       end;
  'H': case upcase(talle) of
       'X','M','L': costo := 1000;
       'S': costo := 1000*0.95;
       end;
  end;
  if q<12 then costo := costo * q * 1.21
  else costo := costo * q * 0.93 * 1.21;
  writeln('El costo total es : ', costo:6:2);
  readln();
end.

