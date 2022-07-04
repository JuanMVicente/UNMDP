program G02E11c;
var
  VO, VR, S: real;
  Aus: integer;
begin
  writeln('Cual es la venta objetivo?'); readln(VO);
  writeln('Cual fue la venta real del mes?'); readln(VR);
  writeln('Cuantas ausencias tuvo en el mes?'); readln(Aus);
  if VR<VO then S := 8000+VR*0.05
  else S := 8000+VR*0.08;
  case Aus of
  0: if VR*0.02<1000 then S:= S+1000
       else S:= S+VR*0.02;
  2..30: S:= S*0.93;
  end;
  writeln('Sueldo: $ ', S:6:2);
  readln();
end.

