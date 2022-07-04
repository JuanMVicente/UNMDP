program G04E06;
Function Aleatorio(A,B:integer): real;
 Begin
   Randomize();
   Aleatorio:= int(Random(B-A)+A);
 End;
Var
 A,B: integer;
Begin
  Writeln('Ingrese valores de A (inf) y B (sup): ');
  Readln(A,B);
  writeln(Aleatorio(A,B):10:2);
  Readln();
End.
