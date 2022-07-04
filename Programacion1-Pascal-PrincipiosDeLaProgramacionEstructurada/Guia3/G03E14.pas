program G03E14;
var
  Sum,x:integer;
  bool: boolean;
begin
  bool:=false ;
  Sum:=0;
  Readln( x );
  If x <>0 then
  Repeat
  Sum := Sum + x;
  If Sum > 100 then
  Bool :=true;
  Readln( x );
  Until ( x=0) or Bool;
  Writeln('Resultado', Sum );
  readln();
end.

