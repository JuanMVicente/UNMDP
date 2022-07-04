Program G03E09;
Var
 Arch: text;
 Numero_Anterior,Numero: integer;
 Cumple: boolean;
Begin
 Assign( Arch, 'G03E09.TXT');
 Reset ( Arch );
 Readln( Arch, Numero_Anterior);
 Cumple:=True;
 While NOT (eof (Arch) or (Cumple=False)) do
 Begin
 Readln( Arch, Numero );
 If Numero_Anterior <= Numero then Numero_Anterior:=Numero
 Else Cumple:= False;
 End;
 Close ( Arch );
 If Cumple<>False then writeln('Estan ordenados en forma ascendente.')
 Else writeln('No estan ordenados en forma ascendente.');
 readln();
End.

