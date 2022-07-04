program G08E11;

Procedure FilaPiramide(i:byte);
begin
  if i=1 then
    writeln(1:2)
  else
    begin
      write(i:2);
      FilaPiramide(i-1);
    end;
end;

Procedure MediaPiramide(i:byte);
begin
  if i=1 then
    FilaPiramide(1)
  else
    begin
      MediaPiramide(i-1);
      FilaPiramide(i);
    end;
end;

Procedure Recursivo (a,b,c:word);
Begin
  If a=1 then
    begin
      Writeln(1:2);
      Recursivo(b+1,b+1,c);
    end
  else
    if a<=c then
    begin
      Write(a:2);
      Recursivo(a-1,b,c);
    end;
end;

var
  N:byte;
begin
  Write('Escriba Nro de la base de la media piramide: ');
  Readln(N);
  MediaPiramide(N);
  writeln;
  Recursivo(1,1,N);
  readln();
end.

