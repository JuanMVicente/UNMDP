program G03E14b;
var
  Sum,x:integer;
begin
  Sum:=0;
  Readln( x );
  while not ((x = 0) or (Sum > 100))  do
    Begin
      Sum := Sum + x;
      Readln( x );
    end;
  Writeln('Resultado ', Sum );
  readln();
end.

