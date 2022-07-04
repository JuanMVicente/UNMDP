program G02E03;
var
  temp: integer;
begin
 Readln(temp);
 if temp<0 then writeln('No salgo de casa...')
 Else      {temp<0}
   if temp<20 then writeln('Hace frio')
      Else     {temp<20}
        if temp<29 then writeln('Barbaro')
           Else     {temp<29 (no esta claro el limite en el algoritmo original)}
              writeln('Que calor!!');
 readln();
end.

