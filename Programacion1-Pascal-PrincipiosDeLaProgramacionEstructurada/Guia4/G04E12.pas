program G04E12;
procedure Fibonacci(L,N:Integer);
  var
    X,Y,Z:integer;
  Begin
    X:=1;
    Y:=0;
    Repeat
      if (X>=L) and (X<=N) then
         Write(X,'  ');
      Z:=X+Y;
      Y:=X;
      X:=Z;
    until X>=N;
    Writeln();
  end;
var
  A,B:Integer;
begin
  Write('Escriba cota inferior ("0" para salir): ');Readln(A);
  Write('Escriba cota superior ("0" para salir): ');Readln(B);
  While (A<>0) and (B<>0) do
      Begin
        Fibonacci(A,B);
        Write('Escriba cota inferior ("0" para salir): ');Readln(A);
        Write('Escriba cota superior ("0" para salir): ');Readln(B);
      end;
  Readln();
end.

