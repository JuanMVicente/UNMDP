program G08E04;
Type
  ST10 = String[10];

Procedure InviertePalabra(Palabra:ST10;var Invertida:ST10;L:byte);
begin
  if L=1 then
      Invertida:= Palabra[L]
  else
     begin
      InviertePalabra(Palabra,Invertida,L-1);
      Invertida:= Palabra[L] + Invertida;
     end
end;

Function InvierteCaracteres(Palabra:ST10;L:byte): ST10;
begin
  if L=1 then
     InvierteCaracteres:= Palabra[1]
  else
     InvierteCaracteres:= Palabra[L] + InvierteCaracteres(Palabra,L-1);
end;

var
  Palabra,Invertida:ST10;
  Aux:byte;
begin
  Write('Escriba una palabra: '); Readln(Palabra);
  Writeln(Palabra);
  Aux:=length(palabra);
  InviertePalabra(Palabra,Invertida,Aux);
  Writeln('Funcion: ',InvierteCaracteres(Palabra,Aux));
  Writeln(length(InvierteCaracteres(Palabra,Aux)));
  Writeln('Procedimiento: ',Invertida);
  Writeln(length(Invertida));
  Readln();
end.

