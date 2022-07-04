program G02E05a;
var
  a,b,c: integer;
begin
  readln(a,b,c);
  if (a > b) and (a > c) then writeln(a);
  if (b > a) and (b > c) then writeln(b);
  if (c > a) and (c > b) then writeln(c);
  readln();
end.

