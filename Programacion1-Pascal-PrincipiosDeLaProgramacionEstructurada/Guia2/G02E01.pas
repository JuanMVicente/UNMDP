program G02E01;
var
  letra: char;
begin
  writeln('Escribe una letra: ');
  readln(letra);
  if letra = upcase(letra) then
      writeln('Es mayuscula.')
  else
      writeln('No es mayuscula.');
  readln();
end.

