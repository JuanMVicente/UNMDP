program G03E24;
var
  ArchE,ArchS:Text;
  Car1,Car2:Char;
  Cadena: String[20];
  i:byte;

begin
 Assign (ArchE,'G03E24.txt');
 Reset (ArchE);
 Assign (ArchS,'G03E24S.txt');
 Rewrite(ArchS);
 Car1:='a';
 While not (Car1='.') do
   Begin
     Read(ArchE, Car1);
     Cadena:='';
     While not ((Car1=' ') or (Car1='.')) do
       Begin
          Read(ArchE, Car2);
          If ((upcase(Car1)<>Car1) and (ord(Car2)>=49) and (ord(Car2)<=57)) then
              Begin
                 For i:=49 to (ord(car2)) do
                  Cadena:= Cadena + Car1;
                 Read(ArchE, Car2);
              end
          Else
             If Car2<>'0' then Cadena:= Cadena + Car1
             Else Read(ArchE, Car2);
          Car1:= Car2;
       end;
     Writeln(ArchS,Cadena);
     Writeln(Cadena);
   end;
 Close(ArchE);
 Close(ArchS);
 readln();
 end.

