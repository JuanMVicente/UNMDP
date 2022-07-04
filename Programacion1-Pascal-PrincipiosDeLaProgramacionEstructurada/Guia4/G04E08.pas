program G04E08;

function Descuento(Tipo:Char;Monto:Real;dia:word):real;
  Begin
    Descuento:=0;
    Case upcase(Tipo) of
      'S': If dia<=15 then Descuento:=Monto*0.15;
      'C': If dia>=15 then Descuento:=Monto*0.10;
      'O': If (dia=10) or (dia=20) or (dia=30) then Descuento:=Monto*0.05;
    end;
  end;
var
  Arch: text;
  Tipo:Char;
  Dia, Cliente:Integer;
  Monto, Total,Desc: Real;
  i,j,k,l:word;
begin
  Assign(Arch,'G04E08.txt');
  Reset(Arch);
  l:=0;
  While not eof(Arch) do
        Begin
          Readln(Arch, Cliente);
          Read(Arch, tipo);
          Total:=0;
          Desc:=0;
          i:=0;
          j:=0;
          k:=0;
          While Tipo<>'F' do
              Begin
                Read(Arch, Dia);
                Readln(Arch, Monto);
                Desc:=Desc+Descuento(Tipo,Monto,Dia);
                Case upcase(Tipo) of
                  'S': if Descuento(Tipo,Monto,Dia)>0 then i:=i+1;
                  'C': if Descuento(Tipo,Monto,Dia)>0 then j:=j+1;
                  'O': if Descuento(Tipo,Monto,Dia)>0 then k:=k+1;
                end;
                Total:=Total+Monto;
                Read(Arch, tipo);
              end;
          If Desc=0 then
             Writeln(Cliente,' no recibio ningun descuento y abono ',Total:8:2,' pesos.')
          Else
             Writeln(Cliente,' ahorro ',Desc:8:2,'pesos .');
          If (i>0) and (j>0) and (k>0) then
             l:=l+1;
        end;
  Writeln('Los clientes que obtuvieron descuento en los tres rubros son: ',l);
  Close(Arch);
  Readln();
end.

