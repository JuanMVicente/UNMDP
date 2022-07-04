program G04E11;
function Eje(A,B:Real): Real;
Begin
  Eje:=-B/(2*A);
End;
procedure Concavidad(A:Real);
  Begin
    If A<0 then
      writeln('La parabola es abierta hacia abajo')
    Else
      writeln('La parabola es abierta hacia arriba')
  end;
procedure Raices(A,B,C:Real);
  var
     X,X1,X2: Real;
  Begin
    X:= sqr(B)-4*A*C;
    if X>0 then
      Begin
        X1:= -B + sqrt(sqr(B)-4*A*C) / 2*A;
        X2:= -B - sqrt(sqr(B)-4*A*C) / 2*A;
        Writeln('Las raices son ',X1:5:2,' y ',X2:5:2,'.');
      end
    Else
      if X=0 then
        Writeln('La raiz es ',Eje(A,B):5:2,'.')
      else
        Writeln('No tiene raices reales');
  end;
procedure Imagen(A,B,C:Real);
  var
     X: Real;
  Begin
    Writeln('Escriba valor de X: ');
    Readln(X);
    X:= A*sqr(X)+B*X+C;
    Writeln('y = ',x:5:2);
  end;

var
  A,B,C:Real;
  X:Integer;
begin
  Write('Siendo (y = a.x2 + b.x + c) escriba valor de a: ');Readln(A);
  Write('Escriba valor de b: ');Readln(B);
  Write('Escriba valor de c: ');Readln(C);
  X:=1;
  While X<>0 do
      Begin
        Writeln('Elija opcion:');
        Writeln('1- Eje de Simetria');
        Writeln('2- Raices');
        Writeln('3- Concavidad');
        Writeln('4- Imagen');
        Writeln('0- Salir');
        Readln(X);
        Case X of
        1: Writeln('El eje de simetria es ',Eje(A,B):5:2,'.');
        2: Concavidad(A);
        3: Raices(A,B,C);
        4: Imagen(A,B,C);
        end;
      end;
  Readln();
end.

