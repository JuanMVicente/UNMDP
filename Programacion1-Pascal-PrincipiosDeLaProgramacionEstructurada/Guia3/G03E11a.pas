program G03E11a;
var
  Arch: text;
  Tipo:Char;
  Cantidad, Saldo:Real;
  i:byte;
begin
  i:=0;
  Assign(Arch, 'G03E11a.txt');
  Reset(Arch);
  Readln(Arch);Readln(Arch,Tipo,Saldo);
  While Not eof(Arch) do
    Begin
        readln(Arch, Tipo, Cantidad);
        case upcase(Tipo) of
        'D': Saldo:= Saldo + Cantidad;
        'R': begin
                  if Cantidad<=Saldo then
                  Saldo:= Saldo - Cantidad
                  else i:=i+1;
                  end;
        end;
    end;
  writeln('El saldo final es: ',Saldo:8:2, ' y las transacciones no validas fueron ',i);
  close(Arch);
  readln();
end.

