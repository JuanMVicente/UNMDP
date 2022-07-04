program G04E01;
Function EsLetra(Car:Char) : boolean;
 Begin
   Car:= upcase(Car);
   EsLetra:= (ord(Car)>64) and (ord(Car)<91);
 End;
Var
 Car:char;
Begin
  Write('ingrese un caracter');
  Readln(Car);
  If EsLetra(Car) Then
   Writeln(Car, ' es una vocal')
  Else
   Writeln(Car, ' no es una vocal');
  Readln();
End.
