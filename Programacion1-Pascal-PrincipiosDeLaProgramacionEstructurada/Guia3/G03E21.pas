program G03E21;
var
  Max, Num, Cont, SubConjunto, Sub_Max, Cont_Max:Word;
begin
  Write('Escribe Nros: ');
  Subconjunto:=0;
  Cont_Max:=0;
  Readln(Num);
  If Num=0 then
     Readln(Num);
  While Num<>0 do
        Begin
          Max:=0;
          Cont:=0;
          While Num<>0 do
            Begin
                Cont:= Cont + 1;
                if Num>Max then
                   Max:=Num;
                Readln(Num);
            end;
          Subconjunto:=Subconjunto+1;
          If Cont>Cont_Max then
             Begin
               Cont_Max:=Cont;
               Sub_Max:=Subconjunto;
             end;
          Writeln('Subconjunto: ',Subconjunto,' - Maximo: ',Max);
          Readln(Num);
        end;
  writeln('El subconjunto con mas elementos es: ',Sub_Max);
  readln();
end.

