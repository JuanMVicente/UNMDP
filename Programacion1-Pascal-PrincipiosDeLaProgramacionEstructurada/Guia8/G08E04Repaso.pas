program G08E04Repaso;
Type
  ST10 = String[10];

Procedure InvierteP(Palabra:ST10; i:byte; var invertida:ST10);
begin
  If i=1 then
    Invertida:=Palabra[i]
  else
    begin
      InvierteP(Palabra,i-1,Invertida);
      Invertida:=Palabra[i] + Invertida;
    end;
end;

Function InvierteF(Palabra:ST10; i:byte):ST10;
begin
  if i=1 then
    InvierteF:=Palabra[i]
  else
    InvierteF:= Palabra[i] + InvierteF(Palabra,i-1);
end;

var
  Palabra,Invertida:ST10;
  Aux:byte;
begin
  Write('Escriba una palabra: '); Readln(Palabra);
  Writeln(Palabra);
  Aux:=length(palabra);
  InvierteP(Palabra,Aux,Invertida);
  Writeln('Funcion: ',InvierteF(Palabra,Aux));
  Writeln(length(InvierteF(Palabra,Aux)));
  Writeln('Procedimiento: ',Invertida);
  Writeln(length(Invertida));
  Readln();
end.

