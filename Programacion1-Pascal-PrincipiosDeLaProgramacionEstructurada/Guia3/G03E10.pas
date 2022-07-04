Program G03E10;
Var
 Arch: text;
 Numero,Frecuencia: integer;
 i:byte;
 Begin
 Assign( Arch, 'G03E10.TXT');
 Reset ( Arch );
 Readln( Arch );
 Readln( Arch, Numero, Frecuencia );
 Write(Numero);
 For i:=2 to (Frecuencia) do
     Write(', ', Numero);
 While NOT eof (Arch) do
       Begin
            Readln( Arch, Numero, Frecuencia );
            For i:=1 to (Frecuencia) do
            Write(', ', Numero);
       end;
 Close ( Arch );
 Readln();
End.

