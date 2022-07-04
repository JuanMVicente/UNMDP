program G02E02a;
var
  n: boolean;
  a,b: integer;
begin
  writeln('a: '); readln(a);
  writeln('b: '); readln(b);
  n := (a < 0) and (b > 0);
  writeln('la afirmacion se cumple? ', n);
  readln();
end.

