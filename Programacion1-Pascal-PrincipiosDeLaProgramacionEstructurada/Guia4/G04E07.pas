program G04E07;
Function Aleatorio(A,B:integer): real;
 Begin
   Aleatorio:= int((B-A)*Random()+A);
 End;
Var
 A,B: integer;
Begin
  Writeln('Ingrese valores de A (inf) y B (sup): ');
  Readln(A,B);
  writeln(Aleatorio(A,B):10:2);
  Readln();
End.
