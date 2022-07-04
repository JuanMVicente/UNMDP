program G04E04;
Function Potencia(Num,Pot:word): real;
 Var
  i:word;
 Begin
   Potencia:=1;
   For i:=1 to Pot do
     Potencia:=Potencia*Num;
 End;
Var
 Num, Pot:word;
Begin
  Write('ingrese un numero: ');
  Readln(Num);
  Write('ingrese la potencia: ');
  Readln(Pot);
  Writeln(Potencia(Num,Pot):50:2);
  Readln();
End.
