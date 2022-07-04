program G02E05c;
var
  a,b,c: integer;
begin
  readln(a,b,c);
  if (a > b) then
     if (a > c) then writeln(a)
     else writeln(c)
  else
      if (b > c) then writeln(b)
      else writeln(c);
  readln();
end.

