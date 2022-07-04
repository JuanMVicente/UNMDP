program G02E05b;
var
  a,b,c: integer;
begin
  readln(a,b,c);
  if (a > b) and (a > c) then writeln(a)
     else
         if (b > a) and (b > c) then writeln(b)
         else writeln(c);
  readln();
end.

