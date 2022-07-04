program G03E19;
var
  Arch: text;
  Num_Lectura,Num_Control: integer;

begin
  Assign(Arch, 'G03E19.txt');
  Reset(Arch);
  While Num_Lectura>=0 do
    Read(Arch, Num_Lectura);
  while not eof(Arch) do
      Begin
        Num_Control:=0;
        Read(Arch, Num_Lectura);
        While Not ((Num_Lectura<0) or eof(Arch)) do
           Begin
             if Num_Lectura>Num_Control then
                 Num_Control:=Num_Lectura;
             Read(Arch, Num_Lectura);
           end;
         If Num_Lectura<0 then
             Write(Num_Control, ' ');
      end;
  Close(Arch);
  Readln();
end.

