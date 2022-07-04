program G03E06;
var
  O:Char;
  Saldo, Mov:Real;
  i:byte;
begin
  writeln('D - Deposito');
  writeln('R - Retiro');
  writeln('F - Finalizar');
  Saldo:=0; i:=0;
  repeat
    write('Elija una opcion: '); readln(O);
    case upcase(O) of
    'D': begin
         write('Cuanto dinero depositar? '); readln(Mov);
         Saldo:= Saldo + Mov;
         end;
    'R': begin
         write('Cuanto dinero retirar? '); readln(Mov);
         if Mov<Saldo then
            Saldo:= Saldo - Mov
         else
             begin
              i:=i+1;
              writeln('Saldo insuficiente.');
             end;
         end;
    end;
  until upcase(O)='F';
  writeln('El saldo final es: ',Saldo:6:2, ' y las transacciones no validas fueron ',i);
  readln();
end.

