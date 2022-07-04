program G04E03;
Function Sumatoria(Num:word): real;
 Var
  i:word;
 Begin
   For i:=1 to Num do
     Sumatoria:=Sumatoria + i;
 End;
Var
 Num:word;
Begin
  Write('ingrese un numero natural: ');
  Readln(Num);
  Writeln(Sumatoria(Num):50:2);
  Readln();
End.
