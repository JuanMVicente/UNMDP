Program G03E08; {toma los nros positivos y realiza el promedio}
Var
 Arch: text;
 A, Sum, Cont : integer;
Begin
 Assign( Arch, 'G03E08.TXT');
 Reset ( Arch );
 Sum:=0;
 Cont := 0;
 While NOT eof ( Arch ) do
 Begin
 Readln( Arch, A );
 If A > 0 then
 begin
 Sum := Sum + A ; Cont := Cont + 1;
 End;
End;
 Close ( Arch );
 If Cont <> 0 then
 Writeln( Sum / Cont:8:2 )
 Else
 Writeln ('no hay numeros positivos');
 readln();
End.

