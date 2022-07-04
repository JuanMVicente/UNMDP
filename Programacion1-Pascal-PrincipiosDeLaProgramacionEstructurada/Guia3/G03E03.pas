program G03E03;
var
  N,Cont,i: word;
  Num,NumA:integer;
begin
  write('Cuantos numeros ingresa?');readln(N);
  write('Ingrese un Numero: ');readln(NumA);
  Cont:=0;
  for i:=2 to N do
  begin
    write('Ingrese un Numero: ');readln(Num);
    if NumA<Num then Cont:= Cont+1;
    NumA:=Num;
  end;
  writeln('El numero siguiente es mayor que el anterior la cantidad de: ',Cont);
  readln();
end.

