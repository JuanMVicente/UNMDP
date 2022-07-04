program G08E09;


function DigitosCrecientes(N:word):boolean;
begin
  if N div 10 = 0 then
     DigitosCrecientes:=True
  else
    begin
      DigitosCrecientes:=DigitosCrecientes(N div 10);
      if (N div 10 mod 10)>(N mod 10) then
         DigitosCrecientes:=False;
    end;
end;

var
  N:word;
  Aux:boolean;
begin
  Write('Escribe un nro Natural: '); Readln(N);
  Writeln(DigitosCrecientes(N));
  if DigitosCrecientes(N) then
     Writeln('Es creciente.')
  else
     Writeln('No es creciente.');
  readln();
end.
