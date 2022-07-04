program G03E01b;
var
  N, Cont, Ant: word;
  Sue, Max: real;
  Nom: String;
  i:byte;
begin
  writeln('Cuantas personas desea ingresar?');readln(N);
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
        writeln(Nom);writeln('Cobra ', Sue:6:2);
      end;
  readln();
end.

