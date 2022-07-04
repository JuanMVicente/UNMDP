program G04E02;
Function Factorial(Num:word): real;
 var
  i:word;
 Begin
   If Num=1 then
    Factorial:=0
   Else
    Begin
      Factorial:=1;
      For i:=2 to Num do
        Factorial:= Factorial*i;
    End;
 End;
Var
 Num:word;
Begin
  Write('ingrese un numero: ');
  Readln(Num);
  Writeln(Factorial(Num):50:2);
  Readln();
End.
