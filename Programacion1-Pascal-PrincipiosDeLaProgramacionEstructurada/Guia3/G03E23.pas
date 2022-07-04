program G03E23;
var
  ArchE,ArchS:Text;
  Car: Char;
  Contrasena: String[20];
  ContNum,ContMin,ContMay,ContVal,ContCon,MaxInv:Word;
begin
  ContVal:=0;
  ContCon:=0;
  MaxInv:=0;
  Assign (ArchE, 'G03E23.txt');
  Reset (ArchE);
  Assign (ArchS,'G03E23S.txt');
  Rewrite(ArchS);
  Car:='%';
  While Not Eof(ArchE) do
    Begin
      ContMin:=0;
      ContMay:=0;
      ContNum:=0;
      Contrasena:='';
      Car:='%';
      While ((Car<>' ') and not(Eof(ArchE))) do
            Begin
                Read(ArchE,Car);
                if Car<>' ' then
                  Begin
                   Contrasena := Contrasena + Car;
                   Case Car of
                   'A'..'Z': ContMay:= ContMay+1;
                   'a'..'z': ContMin:= ContMin+1;
                   '0'..'9': ContNum:= ContNum+1;
                   end;
                  end;
            end;
      if Length(contrasena)>0 then
            ContCon:= ContCon+1;
      If (Length(Contrasena)>7) and (ContMay>0) and (ContMin>0) and (ContNum=4) and (ContMay+ContMin+ContNum=Length(Contrasena)) then
        Begin
          Writeln(ArchS, Contrasena);
          ContVal:= ContVal+1;
        end
      Else
        if Length(Contrasena)>MaxInv then
            MaxInv:= Length(Contrasena);
    end;
  Close(ArchE);
  Close(ArchS);
  Writeln('El % de contrasenas invalidas es ',(1-(ContVal/ContCon))*100:5:2);
  Writeln('La longitud de la contrasena invalida mas larga es de ',MaxInv:2,' caracteres.');
  Readln();
end.

