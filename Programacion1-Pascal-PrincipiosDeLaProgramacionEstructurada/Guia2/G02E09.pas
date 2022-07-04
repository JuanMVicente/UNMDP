program G02E09;
var
  VO, VR, S: real;
  Aus: integer;
begin
  writeln('Cual es la venta objetivo?'); readln(VO);
  writeln('Cual fue la venta real del mes?'); readln(VR);
  writeln('Cuantas ausencias tuvo en el mes?'); readln(Aus);
  if VR<VO then S := 8000+VR*0.05
  else S := 8000+VR*0.08;
  if Aus = 0 then
       if VR*0.02<1000 then S:= S+1000
       else S:= S+VR*0.02
  else
       if Aus>1 then S:= S*0.93;
  writeln('Sueldo: $ ', S:6:2);
  readln();
end.

