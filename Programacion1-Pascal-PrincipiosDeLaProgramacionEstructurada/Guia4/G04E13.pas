program G04E13;
procedure SumaHora(Hora,Min,Seg,SegT: Integer);
  Begin
    Hora:= (Hora+(Min+((Seg+SegT) Div 60)) Div 60) Mod 24;
    Min:= (Min+((Seg+SegT) Div 60)) Mod 60;
    Seg:= (Seg+SegT) Mod 60;
    Writeln(Hora:2,'/',Min:2,'/',Seg:2);
  end;
var
  Hora,Min,Seg,SegT:Integer;
begin
  write('Hora inicial: '); readln(Hora);
  write('Min inicial: '); readln(Min);
  write('Seg inicial: '); readln(Seg);
  write('Seg transcurridos: '); readln(SegT);
  Writeln(SegT Mod 60);
  Writeln(SegT Div 60);
  SumaHora(Hora,Min,Seg,SegT);
  readln();
end.

