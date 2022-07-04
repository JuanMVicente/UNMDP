program G04E05;
Function Determinante(A,D,B,E:real): real;
 Begin
   Determinante:=A*E-B*D;
 End;
Var
 A,B,C,D,E,F:real;
Begin
  Writeln('Ingrese valores de A, B, C, D, E y F siendo Ax+By=C y Dx+Ey=F :');
  Readln(A,B,C,D,E,F);
  if determinante(A,D,B,E)<>0 then
    Begin
      writeln('El valor de x es ', determinante(C,F,B,E)/determinante(A,D,B,E):9:2);
      writeln('El valor de y es ', determinante(A,D,C,F)/determinante(A,D,B,E):9:2);
    end
  Else writeln('No tiene Solucion.');
  Readln();
End.
