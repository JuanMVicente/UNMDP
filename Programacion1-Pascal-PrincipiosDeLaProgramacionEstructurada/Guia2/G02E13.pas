program G02E13;
var
P: real;
Mon: char;
begin
  writeln('Cuantos pesos tiene?'); readln(P);
  writeln('Elija Moneda (D/E/R):'); readln(Mon);
  case upcase(Mon) of
  'D': writeln('Puede comprar ', P/120.8:6:2 , ' Dolares');
  'E': writeln('Puede comprar ', P/150.10:6:2 , ' Euros');
  'R': writeln('Puede comprar ', P/26.5:6:2 , ' Reales');
  end;
  readln();
end.

