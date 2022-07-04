program G02E02b;
var
  n: boolean;
  a,b: integer;
begin
  writeln('a: ');
  readln(a);
  writeln('b: ');
  readln(b);
  n := (a < 0) or (b > 0);
  writeln('la afirmacion se cumple? ', n);
  readln();
end.

