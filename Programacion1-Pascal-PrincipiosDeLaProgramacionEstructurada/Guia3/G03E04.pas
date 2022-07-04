program G03E04;
var
  N,i,j: word;
  Num,NumA,Res:integer;
begin
  write('Cuantos numeros ingresa?');readln(N);
  write('Ingrese un numero: ');readln(NumA);
  Res:=0;
  for i:=2 to N do
  begin
    write('Ingrese un numero: ');readln(Num);
    if Res<NumA-Num then
    begin
      Res:= NumA-Num;
      j:=i-1;
    end;
    NumA:=Num;
  end;
  writeln('La maxima diferencia es ',Res,' y aparece al par ', j);
  readln();
end.

