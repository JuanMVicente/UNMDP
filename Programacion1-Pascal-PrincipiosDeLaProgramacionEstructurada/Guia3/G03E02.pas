program G03E02;
var
  N, Ant: word;
  Sue, Max,Sum: real;
  Nom,NomM: String;
  i:byte;
begin
  writeln('Cuantas personas desea ingresar?');readln(N);
  Sum:=0;
  for i:=1 to N do
      begin
        writeln('Nombre:');readln(Nom);
        writeln('Antiguedad:');readln(Ant);
        case Ant of
        0..5: Sue:= 15000 * 1.05 * 0.89 - 500;
        6..10: Sue:= 15000 * 1.08 * 0.89 - 500;
        11..15: Sue:= 15000 * 1.12 * 0.89 - 500;
        16..99: Sue:= 15000 * 1.20 * 0.89 - 500;
        end;
        Sum:= Sum + Sue;
        writeln(Nom,' cobra ', Sue:6:2);
        Max:=0;
        If Sue>Max then NomM:=Nom;
      end;
  writeln('La persona que mas cobra es: ',Nom,'.');
  writeln('El sueldo promedio es: ', Sum/N:6:2,'.');
  readln();
end.

