program G04E07;

function Impuesto(Tipo:Char;Facturado:Real):real;
  Begin
    Case upcase(Tipo) of
      'S': Impuesto:=Facturado*0.21;
      'N': Impuesto:=Facturado*0.10;
    end;
  end;
var
  Nombre, Menos: String[20];
  Meses,i:Word;
  Min_Facturado, Facturado_Mes, Facturado_Total: Real;
  RI: Char;


begin
  Min_Facturado:= 99999999999;
  Writeln('Nombre Empresa (se sale con ***): ');
  Readln(Nombre);
  While Nombre<>'***' do
    Begin
      Facturado_Total := 0;
      Writeln('Responsable Inscripto (S/N): ');
      Readln(RI);
      Writeln('Meses Registrados: ');
      Readln(Meses);
      For i:=1 to Meses do
          Begin
            Write('Facturado en el mes ',i,': ');
            Readln(Facturado_Mes);
            Facturado_Total := Facturado_Total + Facturado_Mes;
          end;
      Writeln(Nombre,' pago de IVA ',Impuesto(RI,Facturado_Total):8:2,' pesos.');
      If Min_Facturado>Facturado_Total then
        Begin
          Min_Facturado:=Facturado_Total;
          Menos:= Nombre;
        end;
      Writeln('Nombre Empresa (se sale con ***): ');
      Readln(Nombre);
    end;
  Writeln('La empresa que menos facturo es: ', Menos);
  Readln();
end.

