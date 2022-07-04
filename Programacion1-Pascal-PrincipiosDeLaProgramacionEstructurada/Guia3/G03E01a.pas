program G03E01a;
var
  N, Cont: word;
  Max,Num,Pos: integer;
  i:byte;
begin
  writeln('Cuantos numeros desea ingresar?');readln(N);
  writeln('Ingrese un nro:');readln(Max);
  Pos:=1;
  cont:= 1;
    for i:=2 to N do
        Begin
          writeln('Ingrese un nro:');readln(Num);
          if Num>Max then
             begin
               Max:=Num;
               Pos:=i;
             end
          else
              if Num=Max then cont := cont + 1;
        end;
  writeln('El maximo es ', Max:4, '.');
  writeln('Se repite ', Cont:3, ' veces.');
  writeln('Se encuenta en la posicion ', Pos, '.');
  readln();
end.

